package com.grailsaction

class LikePost {
    User user
    static belongsTo = [post:Post]
    static constraints = {
    }
}
