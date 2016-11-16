package com.grailsaction

class Tag {

    static hasMany = [users:User]
    static belongsTo = [posts:Post]

}
