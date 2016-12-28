package com.grailsaction

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class ProfileController {

    def profileService
    def springSecurityService
    def index() {
        User userid=springSecurityService.currentUser
        Profile profile=Profile.findByUser(userid)
        println "Users : "+profile
        if(profile!=null){
            return [profile:profile]
        }
        else{

        }
    }
    def createprofile(){

    }
    def viewprofile() {

        /* def user_id=springSecurityService.currentUserId
         def validKeyInstance = Profile.get(user_id)
         if(!user_id)
         {
             response.sendError(404)
         }
         else if(validKeyInstance==null)
         {
             render(controller: 'profile',view: 'noProfile')
         }
         response.setContentType("image/jpeg")
         response.contentLength=validKeyInstance.photo.size()
         OutputStream out = response.outputStream
         out.write(validKeyInstance.photo)
         out.close()*/

    }
    def userprofile()
    {
        def userid=springSecurityService.currentUser
        def profileView=profileService.viewProfile(userid)
        println("profile ++++++"+profileView)
        if(profileView==null) {
            render view: 'noProfile'
        }
        else{
            [profileView: profileView, userid: userid.loginId]
        }

    }
    def updateprofile(){
        def user1=springSecurityService.currentUser
        Profile profile=Profile.findByUser(user1)
        println "Println "+profile.fullName
        println "parms create: "+params
        println "Profile Old : "+profile
        profile.properties['fullName', 'address','bio','email','country'] = params
        profile.save(failOnError: true,flush: true)
        redirect(action: 'userprofile')
    }
    def create()
    {
        def user1=springSecurityService.currentUser

        def profile=new Profile(fullName:params.fullName,address: params.address,bio: params.bio,email: params.email,country: params.country,user: user1)
        if(profile.validate())
        {       println "Validate!!!"
            profile.save(failOnError: true, flush: true)
            def pic = request.getFile('photo')
            if (!pic?.empty && pic.size < 1024 * 200) {
                def abc = servletContext.getRealPath("/") + "usersImage/" + user1.loginId + ".jpg"
                println("------------------" + abc)
                pic.transferTo(new File(abc))
                println("saved!!!!!!!!!")
            }
            redirect(action: 'userprofile')
        }
        else{
            println "----------------"+profile.errors.errorCount
        }

    }


    def userList(){

    }

}