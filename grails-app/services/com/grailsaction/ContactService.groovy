package com.grailsaction

import grails.transaction.Transactional

@Transactional
class ContactService {

    def serviceMethod() {

    }
    public List<Post> readAllPost() {
        return Post.getAll()
    }
}
