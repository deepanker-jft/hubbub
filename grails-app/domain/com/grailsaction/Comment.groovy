package com.grailsaction

class Comment {
    static belongsTo = [post:Post]
    String content
    Date dateCreated
    User user
    static hasMany = [replyComments: ReplyComment]
    static mapping = {
        replyComments cascade: 'all-delete-orphan'
    }
    static constraints = {
        content blank: false
    }
}
