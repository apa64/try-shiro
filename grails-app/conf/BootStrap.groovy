import org.apache.shiro.grails.ShiroSecurityService

import com.apa.security.Role
import com.apa.security.User

class BootStrap {
    ShiroSecurityService shiroSecurityService
    def shiroSecurityManager
    def mySessionManager

    def initShiro() {
        // DefaultWebSessionManager with MySessionListener
        shiroSecurityManager.sessionManager = mySessionManager
    }

    def init = { servletContext ->
        initShiro()

        def adminRole = Role.findByName('ROLE_ADMIN') ?:
                new Role(name: 'ROLE_ADMIN').save(flush: true, failOnError: true)
        adminRole.addToPermissions("user:*:*")
        adminRole.addToPermissions("role:*:*")
        adminRole.save(flush: true, failOnError: true)
        // Create the user role
        def userRole = Role.findByName('ROLE_USER') ?:
                new Role(name: 'ROLE_USER').save(flush: true, failOnError: true)
        userRole.addToPermissions("user:read:*")
        userRole.addToPermissions("role:read:*")
        userRole.save(flush: true, failOnError: true)

        // Create an admin user
        def adminUser = User.findByUsername('admin') ?:
                new User(username: "admin", passwordHash: shiroSecurityService.encodePassword('password')).save(flush: true, failOnError: true)
        // Add roles to the admin user
        assert adminUser.addToRoles(adminRole).addToRoles(userRole).save(flush: true, failOnError: true)

        // Create an standard user
        def standardUser = User.findByUsername('joe') ?:
                new User(username: "joe", passwordHash: shiroSecurityService.encodePassword('password')).save(flush: true, failOnError: true)
        // Add role to the standard user
        assert standardUser.addToRoles(userRole).save(flush: true, failOnError: true)
    }

    def destroy = {
    }
}
