package com.grailsaction

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='loginId')
@ToString(includes='loginId', includeNames=true, includePackage=false)
class User implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String loginId
	String passwordHash
	boolean counter = false
	String uuid
	boolean enabled = false
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	//Date  dateCreated
	static hasOne = [profile:Profile]
	static hasMany = [posts:Post,following:User,comments:Comment]
	static constraints = {
		loginId email: true, blank: false, nullable: false, unique: true
		passwordHash blank: false
		profile nullable: true
		uuid nullable: false,unique: true
	}
	/*User(String username, String password) {
		this()
		this.username = username
		this.password = password
	}
*/
	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('passwordHash')) {
			encodePassword()
		}
	}
	protected void encodePassword() {
		passwordHash = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(passwordHash) : passwordHash
	}

	static transients = ['springSecurityService']


	String toString() { return "User $loginId (id: $id)" }
	String getDisplayString() { return loginId }


	static mapping = {
		passwordHash column: '`passwordHash`'
	}
}
