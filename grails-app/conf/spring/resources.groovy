import org.apache.shiro.authc.pam.ModularRealmAuthenticator
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager
import rebeka.security.RebekaAuthcListener
import rebeka.security.RebekaSessionListener

// Place your Spring DSL code here
beans = {
    mySessionListener(RebekaSessionListener)

    mySessionManager(DefaultWebSessionManager) {
        sessionListeners = [ ref ("mySessionListener") ]
    }
    /*
     shiroSecurityManager {
     sessionManager = ref("mySessionManager")
     }
     */

    authListener(RebekaAuthcListener)
    shiroAuthenticator(ModularRealmAuthenticator) {
        authenticationStrategy = ref("shiroAuthenticationStrategy")
        authenticationListeners = [ ref("authListener") ]
    }
}
