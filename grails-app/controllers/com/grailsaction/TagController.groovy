package com.grailsaction

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
@Secured(['permitAll'])
@Transactional
class TagController {

    def index() {

     /*   def user = new User(loginId: 'anilkumar', password: 'password',homepage: "https://www.google.co.in/").save(failOnError: true)
        Tag tagGroovy= new Tag(name: "groovy", createdBy: user).save(failOnError: true)
        Tag tagGrails = new Tag(name: "grails", createdBy: user).save(failOnError: true)


        Post groovyPost = new Post(content: "A groovy post")
        user.addToPosts(groovyPost)
        tagGrails.addToPosts(groovyPost)
        tagGroovy.addToPosts(groovyPost)
//        groovyPost.addToTags(tagGroovy)
//        groovyPost.addToTags(tagGrails)
        groovyPost.save(failOnError: true)

        Post bothPost = new Post(content: "A groovy and grails post")
        user.addToPosts(bothPost)
        tagGrails.addToPosts(bothPost)
        tagGroovy.addToPosts(bothPost)
        println("Thanks")
        bothPost.save(failOnError: true)
        user.save(failOnError: true)
        render(controllerUri:'/user/index')*/

        def u=User.get(1);
        def posts=Post.findByUser(u).list()
        [post:posts]












    }
}
