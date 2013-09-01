package rebeka.security

import org.apache.commons.logging.LogFactory
import org.apache.shiro.session.Session
import org.apache.shiro.session.SessionListenerAdapter

class RebekaSessionListener extends SessionListenerAdapter {
    private static final log = LogFactory.getLog(this)
    @Override
    public void onStart(Session session) {
        super.onStart(session)
        log.debug("onStart() +, session=${session.id}")
    }
}
