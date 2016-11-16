package com.grailsaction

import grails.transaction.Transactional

@Transactional
class ProfileService {

    def createProfile(user1,params)
    {
        Profile profile=new Profile(params)
        println("--------------User ID : --------------"+user1)
        profile.user=user1
        if(profile.validate()) {
            profile.save(failOnError: true)
            return "success"
        }
        else
        {
            return "notsuccess"
        }
    }

    def viewProfile(userid)
    {
        def profileView=Profile.findByUser(userid)
       return (profileView)
    }
}
