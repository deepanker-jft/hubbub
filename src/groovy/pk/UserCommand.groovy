package pk
/**
 * Created by amit on 27/10/16.
 */

@grails.validation.Validateable
class UserCommand {

    String loginId
    String passwordHash
    String passwordHashRepeat

    static constraints = {
        loginId email: true
        passwordHashRepeat (validator: {passwd,urc->
            return passwd.equals(urc.passwordHash)
        })
    }
}
