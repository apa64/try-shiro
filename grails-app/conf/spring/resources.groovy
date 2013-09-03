import org.apache.shiro.authc.pam.ModularRealmAuthenticator
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager
import com.apa.security.MyAuthcListener
import com.apa.security.MySessionListener

// Place your Spring DSL code here
beans = {
    mySessionListener(MySessionListener)

    mySessionManager(DefaultWebSessionManager) {
        sessionListeners = [ ref ("mySessionListener") ]
    }

    authListener(MyAuthcListener)
    shiroAuthenticator(ModularRealmAuthenticator) {
        authenticationStrategy = ref("shiroAuthenticationStrategy")
        authenticationListeners = [ ref("authListener") ]
    }
}
