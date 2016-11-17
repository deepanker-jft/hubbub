package com.grailsaction

class Post {

    String content
    Date dateCreated
   // User user

    static hasMany = [like:LikePost,unlike:UnLikePost ,comments: Comment]
    static belongsTo = [user:User]
    //static hasMany = [tags:Tag]
    static mapping = {
        comments cascade: 'all-delete-orphan'
        sort dateCreated:"desc"
    }
    static constraints = {
        content blank: false
        like nullable: true
        unlike nullable: true
        comments nullable: true
    }
}