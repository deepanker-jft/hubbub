package com.grailsaction

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class PostController {

    def postService
    def springSecurityService
    def index() {

        User userlist=springSecurityService.currentUser

        [userlist:userlist.following]
    }

    def postCreated()
    {
        println("Helloe : '"+params)
        def user=springSecurityService.currentUser
        println "----------------"+user
        def post=postService.postCreatedMethod(params,user)
        redirect(controller: 'post',action: 'viewPost')

    }
    def postnewCreted(){
        println("-----------------------------------")
        def user=User.findById(6)
        Post posts=new Post(content: "sddsdsds",dateCreated: new Date())
        posts.user=user
    }
    def viewPost(Integer max,Integer offset){
        params.max=Math.min(max?:5,100)
        params.offset=Math.min(offset?:0,100)
        def user=springSecurityService.currentUser
        // Profile profile=Profile.findByUser(user)
        def post=Post.findAllByUser(user,[max:params.max,offset:params.offset])
        println("Post Size : "+post.size())
        if(post==[]){
            render view: 'noPost'
        }
        else {
            [viewPost:post,postCount:Post.count()]
        }
    }
}