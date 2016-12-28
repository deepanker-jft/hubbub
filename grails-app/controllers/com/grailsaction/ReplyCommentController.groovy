package com.grailsaction

import grails.plugin.springsecurity.annotation.Secured
import pk.UserReplyComment


@Secured(['ROLE_ADMIN'])
class ReplyCommentController {

    def springSecurityService
    def index() {

        println("comment id :"+params.id)
        return [id:params.id]
    }
    def addReplyComment(UserReplyComment urc){
        if(urc.hasErrors()){
            render template:"/home/savedError",model: [user:urc]
            return
        }
        else{
            User user=springSecurityService.currentUser
            println("Comment id : "+params.id)
            Comment comment=Comment.get(params.id)
            ReplyComment rc=new ReplyComment(content: urc.content,dateCreated: new Date(),user: user)
            comment.addToReplyComments(rc)
            if(rc.validate()){
                rc.save(flush: true,failOnError: true)
                println("Saved!!!!!")
                redirect(controller: "home",action: 'timeline')
            }
        }

    }
    def viewReply(){
        println("Comment id : "+params.id)
        Comment comment=Comment.get(params.id)
        println("++++++"+comment)
        def rc=ReplyComment.findAllByComment(comment)
        return [rc:rc]
    }
}
