package com.grailsaction

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class ProfileController {

    def profileService
    def springSecurityService
    def index() {

    }

    def viewprofile() {

            def user_id=springSecurityService.currentUserId
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
            out.close()

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
    def create()
    {
        def user1=springSecurityService.currentUser
       // println(params)
      //  User user = User.get(params.user_id)
        println("new Files : "+params)
        def profile=profileService.createProfile(user1,params)
        if (profile=="notsuccess")
        {
            redirect(controller: 'profile',action: 'index')
        }
        else {
            redirect(controller: 'home',action: 'index')
        }
       // def profile=new Profile(params)
        /*profile.user = user
        println("-----------------------------------")
        profile.save(failOnError: true)
        println("------------------------------------")
        redirect(action: 'index')
        println("------------------------------------")*/

    }

    def userList(){

    }

}
