package com.grailsaction

import grails.plugin.springsecurity.annotation.Secured
import pk.CommentUser

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

    //View Post with Pagination
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

    //Dis Likes User
    def unlikeSave(){
        Post post = Post.get(params.id)
        User user = springSecurityService.currentUser
        Integer count = UnLikePost.countByUserLikeAndPost(user,post)
        if (count == 0) {
            UnLikePost unLike = new UnLikePost(user: user, post: post).save(flush: true)
            post.addToUnlike(unLike)
            post.save(flush: true)
            LikePost like=LikePost.findByUserAndPost(user,post)
            if(like!=null)
            {
                like.delete(flush: true)
            }
            redirect controller: 'home', action: 'timeline', params: [id: post.user.id]
        }
        /*else if(count==1)
        {

            LikePost like = LikePost.findByUserAndPost(user, post)
            UnLikePost dislike=UnLikePost.findByUserAndPost(user, post)
            if (like==null||dislike==null)
            {
                redirect controller: 'home', action: 'timeline', params: [id: post.user.id]
            }
            else {
                like.delete(flush: true)
                dislike.delete(flush: true)
            }
        }*/
        else{
            redirect controller: 'home', action: 'timeline', params: [id: post.user.id]
        }
    }

//like Post

    def likeSave(){
        Post post=Post.get(params.id)
        User user=springSecurityService.currentUser
        Integer count=LikePost.countByUserAndPost(user,post)
        if (count==0){
            LikePost like=new LikePost(user: user,post: post).save(flush: true,failOnError: true)
            post.addToLike(like)
            post.save(failOnError: true,flush: true)
            UnLikePost dislike=UnLikePost.findByUserAndPost(user,post)
            if(dislike!=null)
            {
                dislike.delete(flush: true)
            }
            redirect(controller: 'home',action: 'timeline',params: [id:post.user.id])
        }
        /*else if (count==1)
        {
            LikePost like = LikePost.findByUserAndPost(user, post)
            UnLikePost dislike=UnLikePost.findByUserAndPost(user, post)
            if(dislike==null || dislike==null)
            {
                redirect controller: 'home', action: 'timeline', params: [id: post.user.id]
            }
            else {
                like.delete(flush: true)
                dislike.delete(flush: true)
            }
        }*/
        else {
            redirect(controller: 'home',action: 'timeline',params: [id:post.user.id])
        }
    }
    //show likes user
    def viewLikeUser(){

        println("----------------------------------")
        def likeUser=LikePost.getAll()
        if(likeUser!=null)
        {
            println("------UserLike : "+likeUser)
           [likeUser:likeUser]

        }else{
            render "<h1> No likes Like</h1>"
        }


    }
    //View Dislike Uaers
    def ViewDisLikeUser(){
        println("----------------------------------")
        def dislikeUser=UnLikePost.getAll()
        if(dislikeUser!=null)
        {
            println("------UserLike : "+dislikeUser)
            [dislikeUser:dislikeUser]

        }else{
            render "<h1> No dislikes Like</h1>"
        }


    }
//Comment for the post
    def addComment(){

        println "psot : id : "+params.id
       return  [pid:params.id]
    }
    def commentSaved(CommentUser urc){
        if(urc.hasErrors()  )
        {
            println("error")
            render template:"/home/savedError",model: [user:urc]
            return
        }
        else{
            User user=springSecurityService.currentUser
            println("Post id :"+params.id)
            Post post=Post.get(params.id)
            println("+++"+urc.content)
             println("post list : "+post.content)
             Comment comment=new Comment(user: user,dateCreated: new Date(), content: urc.content)
             post.addToComments(comment)
           if(comment.validate()){
               comment.save(failOnError: true,flush: true)
               redirect(controller: 'home',action: 'timeline')
           }


        }

    }
    def viewComments(){
        print(params.id)
        Post post=Post.get(params.id)
        println "-------------"+post
        def comment=Comment.findAllByPost(post)
        return [comments:comment]


    }
}