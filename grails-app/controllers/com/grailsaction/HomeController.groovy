package com.grailsaction

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class HomeController {

    def springSecurityService
    def index() {
        User user=springSecurityService.currentUser
        [userName:user]
    }

    def timeline(Integer max,Integer offset)
    {
        println params
        params.max=Math.min(max?:3,100)
        params.offset=Math.min(offset?:0,100)
        println params.max
        println params.offset
        User user=springSecurityService.currentUser
        Set<User> userSet = new HashSet();
        userSet.add(user)
        println(user.id+"===============ss==============="+userSet)
        List<Tag> tags = Tag.createCriteria().list {
            users{
                eq('id',user.id)
                //distinct('id')
            }
          //  or distinct(['fn', 'ln'])
   /*         createAlias('users', 'u')
            eq('u.id', user.id)*/
        }

        println("===============ss==555============="+tags.size())
        def longs = tags.posts.id
        println("================="+longs)
        if (tags.size()!=0) {
            List<Post> posts = Post.createCriteria().list(max: params.max, offset: params.offset) {
                'in'('id', longs)
            }
            println "=======================" + posts.size()

            render view: "timeline", model: [postUsers: posts, numberOfPost: Post.count()]
        }
        else    {
            println("------------------------Error")
            render controller:'post',view:'noPost'
        }
    }
}
