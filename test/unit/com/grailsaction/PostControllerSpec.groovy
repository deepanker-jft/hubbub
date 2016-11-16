package com.grailsaction

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PostController)
class PostControllerSpec extends Specification {



    def "create"(){
        given:"deepanksr"

        def post=controller.postnewCreted()

        when:"Saved"
        println("Post : "+post)
        then:"Check"
        println 'sddsds'

    }
    /*def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }*/
}
