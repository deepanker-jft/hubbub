package com.grailsaction

class Profile {

    User user
    byte[] photo
    String fullName
    String bio
    String email
    String country
    String address

    static constraints = {
        fullName blank: false
        bio nullable: true, maxSize: 500
        email email: true,blank: false
        photo nullable: true,maxSize: 2*1024*1024
        country nullable: true
        address nullable: true
    }
}
