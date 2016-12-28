package com.grailsaction

import grails.plugin.springsecurity.annotation.Secured

@Secured('permitAll')
class SqlInjectionController {


    def index() {

    }

    def search(){


        def loginId = "deepankersharma555@gmail.com' or 'test' = 'test"
        def user =  User.find("from User as p where p.loginId = '${loginId}' ")
        println("User : "+user)
    }
    def search1SqlInjection(){

        def loginId = "params.users' or '1' = '1"
       // def loginId = "test' = ' test"
        println("user======")
        println(loginId)
        def user = User.find("from User as p where p.loginId = '${loginId}'")
       //' or ' test' = ' test
        println("Users : "+user)

    }
}
