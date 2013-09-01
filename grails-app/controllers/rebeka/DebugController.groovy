package rebeka

import org.apache.shiro.SecurityUtils
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager
import rebeka.security.User

class DebugController {
    def shiroSecurityManager
    def sessionManager

    def nativesession() {
        assert shiroSecurityManager.sessionManager instanceof DefaultWebSessionManager
        render "shiroSecurityManager.sessionManager instanceof DefaultWebSessionManager"
    }

    def index() {
        String username = SecurityUtils.subject.principal
        User user = User.findByUsername(username)
        render """
<b>subject</b>=${SecurityUtils.subject.properties}
<br/>
<b>user</b>=${user?.properties}
<br/>
<b>role</b>=${user?.roles*.properties}
<br/>
<b>shiroSecurityManager</b>=${shiroSecurityManager.properties}
<br/>
<b>sessionManager</b>=${shiroSecurityManager.sessionManager.properties}
<br/>
sessionManager=${sessionManager}
        """
    }

    def permission(String p) {
        boolean isPermitted = SecurityUtils.subject.isPermitted(p)
        User user = User.findByUsername(SecurityUtils.subject.principal)

        render """
User <b>${user.username}</b> isPermitted(${p})=<i>${isPermitted}</i><br/>
            """
    }
}
