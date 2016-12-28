package com.grailsaction

class ReplyComment {
    static belongsTo = [comment:Comment]
    String content
    Date dateCreated
    User user
    static constraints = {
        content blank: false
    }
}
