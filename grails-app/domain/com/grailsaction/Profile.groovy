package com.grailsaction

class Profile {

    User user
    String fullName
    String bio
    String email
    String country
    String address

    static constraints = {
        fullName blank: false
        bio nullable: true, maxSize: 500
        email email: true,blank: false
        country nullable: true
        address nullable: true
    }
}
