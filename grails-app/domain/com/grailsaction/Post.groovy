package com.grailsaction

class Post {

    String content
    Date dateCreated
   // User user
    static constraints = {
        content blank: false
    }
    static belongsTo = [user:User]
    //static hasMany = [tags:Tag]
    static mapping = {
        sort dateCreated:"desc"
    }
}
