package com.grailsaction

import grails.transaction.Transactional

@Transactional
class ProfileService {

    def viewProfile(userid)
    {
        def profileView=Profile.findByUser(userid)
       return (profileView)
    }
}
