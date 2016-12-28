package pk

/**
 * Created by amit on 18/11/16.
 */
@grails.validation.Validateable
class UserReplyComment {
    String content
    static constraints = {
        content blank: false
    }
}
