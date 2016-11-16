package pk

/**
 * Created by amit on 10/11/16.
 */
@grails.validation.Validateable
class PasswordCommand {

        String passwordHash
        String passwordHashRepeat

        static constraints = {
            passwordHashRepeat (validator: {passwd,urc->
                return passwd.equals(urc.passwordHash)
            })
        }
}
