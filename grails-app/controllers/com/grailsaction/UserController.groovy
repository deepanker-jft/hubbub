package com.grailsaction

import grails.plugin.springsecurity.annotation.Secured
import pk.PasswordCommand
import pk.UserCommand
@Secured(['permitAll'])
class UserController {
    def springSecurityService
    def userService
    def index() {

    }
    def employeeRegister(UserCommand urc) {

        if (urc.hasErrors()) {
            return [user: urc]
        } else{
            def exist=userService.existUser(params.loginId)
            if(exist==1)
            {
                def user=userService.serviceMethod(urc.loginId,urc.passwordHash)
                println "User In Controller : "+user.loginId
                println "User In Controller : "+user.id
                sendMain(user)
 //                       println "User In Controller : "+user.loginId

                //redirect(controller: 'login',action: 'auth')
            }
            else {
                redirect(controller: 'user',action: 'existUser')
            }
        }
    }
    def userForgetVerify(PasswordCommand urc){
            if(urc.hasErrors()  )
            {
             return [user:urc]
            }
            else
            {
                println("--------"+params.id)
                println(""+params.passwordHash)
               User user=User.findByUuid(params.id)
                if(user==null)
                {
                    render "<h1>No Users</h1>"
                }
                else {
                    if(user.counter=='false'.toBoolean()){
                        println("parms "+params)
                                user.properties['passwordHash','counter']=params
                        user.save(failOnError: true,flush: true)
                                    render "Password Changed!!!"

                    }
                    else{
                            render "<h1>Link Expire</h1>"
                    }

                    println("User enale +"+user.enabled)
                    println("User enale +"+user.counter)
                }



            }

    }
    def grailsLinkGenerator
    def mailService
    def sendMain(user) {
        println("User id mail Service +"+user.loginId+"id : "+user.id)
        if(user!=null)
        {
            mailService.sendMail {

                to user.loginId
                subject "Welcome to Mail!!!"
                String url=grailsLinkGenerator.serverBaseURL
                //String url="localhost:9090"
                html g.render(template:'/user/sendMain', model:[name:user.uuid,contact:url])


            }
        }
        else{
            render 'Please try for registration'
        }

        redirect(controller: 'login',action: 'auth')

    }
    def forgetPassword(){


    }
    def resetPassword(){
        User user=User.findByUuid(params.uid)
        if(user==null)
        {
            render "Does not Exit in Database"
        }
        else if(user.counter=='false'.toBoolean()){
            [userId:params.uid]
        }
        else if (user.counter=='true'.toBoolean())
        {
            render "Link Expired"

        }
    }
    def resetPasswordMail(){
        User user=User.findByLoginId(params.loginId)
        if(user!=null) {
            user.properties['counter']='false'.toBoolean()
            user.save(failOnError: true,flush: true)
            mailService.sendMail {

                to params.loginId
                subject "Welcome to Mail!!!"
                String url = grailsLinkGenerator.serverBaseURL
                //String url="localhost:9090"
                html g.render(template: '/user/sendForgetmail', model: [name: user.uuid, contact: url])
            }
        }
        else{
            render "<h1>User Does not Exist</h1>"
        }


    }
    def accountVerify(){

        User user=User.findByUuid(params.uid)
        if(user?.enabled=='true'.toBoolean())
        {
            println("inrender")
            render "Link Is expired"
        }
        else if (user?.enabled=='false'.toBoolean()){
            user.properties['enabled']="true"
            user.save(failOnError: true,flush: true)
            redirect(controller: 'login',action: 'auth')
        }
        else
        {
            render "<h1>Invalid User</h1>"
        }





    }

    /* def insert(){
         println("Inser lo g id : "+params.loginId)
         def exist=userService.existUser(params.loginId)
         if(exist==1)
         {
             def user=userService.serviceMethod(params.loginId,params.password)
             redirect(controller: 'login',action: 'auth')
         }
         else {
                redirect(controller: 'user',action: 'existUser')
         }

     }*/

    def existUser(){

    }
    def users(){
            def u=springSecurityService.currentUser
        if(u!=null) {
            println "order " + u.loginId
            def user = userService.servicMethodUser(u.loginId)
            println("-----------------------------" + user)
            println("user s : " + user)
            [user: user]
        }
        else
        {
            redirect( controller:'login',action:'auth')
        }


    }
    def followUser(){

        User currentUser=springSecurityService.currentUser
        if(currentUser!=null) {
            List list = params.list("myCheckbox")
            println("list+++" + list)


            def folloeCreated = userService.createdFollowUser(currentUser, list)
            redirect(controller: 'home', action: 'index')
        }
        else{
            redirect(controller: 'login',action: 'auth')
        }

    }




}