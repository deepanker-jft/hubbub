package pk

/**
 * Created by amit on 17/11/16.
 */
@grails.validation.Validateable
class CommentUser {
    String content
    static constraints = {
    content blank: false
    }
}
