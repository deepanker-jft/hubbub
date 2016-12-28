package com.grailsaction

import com.CustomException.DomainNotFoundException
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path('/api/post')
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

class PostResource {
    def contactService
    def springSecurityService
    @GET
    String getPostRepresentation() {
        'Post'
    }


    /**
     * This endpoint requires a different role to access than the base one set on the class.
     *
     * If ROLE_READONLY is a less privileged role than ROLE_USER, this endpoint is a privileged one.
     */
    @Path('/readall')
    @POST
    @Secured(["ROLE_ADMIN"])
    JSON readAll() {
        List<Post> posts =  contactService.readAllPost()
        println("USers "+posts)
        return posts as JSON
    }



    /**
     * This endpoint will allow any user to access it, regardless of whether the client has authenticated or not.
     */

    @GET

    @Path("/anonymous")
    @Secured(["IS_AUTHENTICATED_ANONYMOUSLY"])
    String anonymous() {
        return "Hello, guest."
    }
    @Path('/read/{loginId}')
    @POST
    @Secured(["ROLE_ADMIN"])
    JSON read(@PathParam('loginId') String loginId) {
        try {
            User contact =  contactService.readContact(loginId)
            return contact as JSON
        } catch (DomainNotFoundException e) {
                e.printStackTrace()
        }

    }

    /**
     * This endpoint will inherit the ROLE_READONLY requirement since it does not define its own @Secured annotation.
     */
    @GET
    @Path("/inherit")
    String inherit() {
        return "Hello, read only user."
    }
}
