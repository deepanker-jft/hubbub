package com.grailsaction

import grails.transaction.Transactional
import groovy.beans.Bindable
import org.grails.databinding.DataBinder

@Transactional
class PostService{


    def postCreatedMethod(params,user){

//        println("------------"+params)
//        println("------------------"+user)
        println("-----------------"+params.user)
        if(params.user==[]) {
            Post crePost = new Post(content: params.content, dateCreated: new Date())
            crePost.user = user
            crePost.save()
            return "success"
            //List listUsers=params.user
            // List<Long> listUsers=new ArrayList<Long>()
        }
        else {
            Post crePost = new Post(content: params.content, dateCreated: new Date())
            crePost.user = user
            crePost.save()

            def userArray = params.user
            Tag tag = new Tag()
            Set<User> userSet = new HashSet<User>()
            //List<User> lst=new ArrayList<>();
            userArray.each { id ->
                println("id : " + id)
                User u = User.get(id)
                println("ss----------" + u.loginId)
                // userSet.add(u)
                //  println("Size..... "+userSet)
                userSet.add(u)

            }
            println("======================" + userSet.size())
/*
        def users= User.createCriteria().list {
            'in'( "id" , listUsers )
        }
        users.each {
            println "=======fvsfsffvsfsf==============="+it
        }*/
            // userSet.add(lst)
            tag.posts = crePost
            tag.users = userSet
            tag.save(flush: true, failOnError: true)

            /*for(int i=0;i<listUsers.size();i++)
        {
            int j=listUsers[i]
            println("My ids : "+j)
            User u=User.get(j)
            println("users : "+u)
            userSet.add(u)

        }*/
            /*println("user Classs"+userSet)

        tag.posts=crePost
        println("tag.post : "+tag.posts)

        tag.users=userSet
        println("tag.users +  +"+tag.users)
        crePost.save(flush: true,failOnError: true)
        tag.save(flush: true,failOnError: true)

*/
            /* println("------tag.post : "+tag.posts)
         List userList=params.user



         println "List of users"+userList
         int j=userList.size()
         println("user lengrh : "+j)
         List listUser=[]
         for(int i=0;i<userList.size();i++)
         {
             listUser[i]=userList[i]
         }
         tag.setUsers(listUser)
 */
            //println("Total value"+listUser)
            //tag.users=params.user

//         if(crePost.validate() && tag.validate()) {
            return "success"
        }
//         }
    }


}
