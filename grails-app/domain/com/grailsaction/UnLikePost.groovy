package com.grailsaction

class UnLikePost {
    User user
    static belongsTo = [post:Post]
    static constraints = {
    }
}
