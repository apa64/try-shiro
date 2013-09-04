import org.apache.shiro.authc.pam.ModularRealmAuthenticator
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager
import com.apa.security.MyAuthcListener
import com.apa.security.MySessionListener

// Place your Spring DSL code here
beans = {
    // my session listener
    mySessionListener(MySessionListener)
    // a session manager, assigned to shiroSecurityManager in Bootstrap
    mySessionManager(DefaultWebSessionManager) {
        sessionListeners = [ ref ("mySessionListener") ]
    }

    myAuthcListener(MyAuthcListener)
    // override shiroAuthenticator bean from plugin
    shiroAuthenticator(ModularRealmAuthenticator) {
        // default auth strategy from plugin
        authenticationStrategy = ref("shiroAuthenticationStrategy")
        // my authentication listener
        authenticationListeners = [ ref("myAuthcListener") ]
    }
}
