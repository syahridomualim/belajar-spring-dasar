package mualimsyahrido.spring.core.listener

import mualimsyahrido.spring.core.Log
import mualimsyahrido.spring.core.event.LoginSuccessEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class LoginAgainSuccessListener : ApplicationListener<LoginSuccessEvent> {
    override fun onApplicationEvent(event: LoginSuccessEvent) {
        Log.log.info("login success again for user ${event.user}")
    }
}