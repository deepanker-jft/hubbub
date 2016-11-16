package com.grailsaction

import grails.transaction.Transactional

@Transactional
class UserService {

    Set<User> userFollow=new HashSet<User>()
            def existUser(String loginId)
            {
                def user=User.findByLoginId(loginId)
                if (user==null){

                return 1
            }
            else{
                return 2
            }
        }
    def serviceMethod(String loginId,String password) {
        if (!Role.findByAuthority("ROLE_ADMIN")){
            new Role(authority: "ROLE_ADMIN").save(flush: true)
            //new Role(authority: "ROLE_USER").save(false:true)
        }
        println("in service login ID : "+loginId+"Pass : "+password)

        println"--------loginId---------"+loginId
        println"--------password---------"+password
        String uuid=UUID.randomUUID()
        User user=new User(loginId:loginId,passwordHash: password,uuid: uuid)
        if(user.validate()) {
            println("Saved!!!!!!!!!!!!")
            user.save(failOnError: true, flush: true)
            UserRole userRole= new UserRole(user:user,role: Role.findByAuthority("ROLE_ADMIN"))
            userRole.save(failOnError: true,flush: true)
            User userSaved=User.findByLoginId(loginId)
            println("User Serveice------user : "+userSaved.loginId+"id : + "+userSaved.id)
            return userSaved
        }
        else
        {
            println("Not Saved !!!!!!!!!")
            return null
        }
    }
    def servicMethodUser(loginId){
        def user=Profile.list()
       /* def results=user.list {
            not {'in'("loginId",loginId)}
        }
*/



        /*def c = A.createCriteria()
        def results = c.list {
            not { 'in'("id",b*.aaa.id) }
        }*/
       // println(user)
        return user

    }
    def createdFollowUser(currentUser,list)
    {

        userFollow=User.findAllByIdInList(list)
        currentUser.setFollowing(userFollow)
        currentUser.save(failOnError: true,flush: true)
        return 'success'

    }
}






