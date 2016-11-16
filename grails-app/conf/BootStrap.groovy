import com.grailsaction.Role
import com.grailsaction.User
import com.grailsaction.UserRole

class BootStrap {

    def init = { servletContext ->
       /* if (!Role.findByAuthority("ROLE_ADMIN")){
            new Role(authority: "ROLE_ADMIN").save(flush: true)
            //new Role(authority: "ROLE_USER").save(false:true)
        }

        if (User.list().size() == 0){
            User user=new User(loginId: "deepanker" , passwordHash: "12345")
            user.save(flush: true)
            UserRole userRole= new UserRole(user:user,role: Role.findByAuthority("ROLE_ADMIN"))
            userRole.save(flush: true)
        }*/
    }
    def destroy = {
    }
}
