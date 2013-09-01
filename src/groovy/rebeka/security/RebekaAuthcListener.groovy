package rebeka.security

import org.apache.commons.logging.LogFactory
import org.apache.shiro.authc.AuthenticationException
import org.apache.shiro.authc.AuthenticationInfo
import org.apache.shiro.authc.AuthenticationListener
import org.apache.shiro.authc.AuthenticationToken
import org.apache.shiro.subject.PrincipalCollection

class RebekaAuthcListener implements AuthenticationListener {
    private static final log = LogFactory.getLog(this)
    @Override
    public void onSuccess(AuthenticationToken token, AuthenticationInfo info) {
        log.debug("onSuccess() +, info.principal=${info.principals}")
    }

    @Override
    public void onFailure(AuthenticationToken token, AuthenticationException ae) {
        log.debug("onFailure() +")
    }

    @Override
    public void onLogout(PrincipalCollection principals) {
        log.debug("onLogout() +")
    }
}
