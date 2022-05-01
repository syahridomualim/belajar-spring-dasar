package mualimsyahrido.spring.core.listener

import mualimsyahrido.spring.core.Log
import mualimsyahrido.spring.core.event.LoginSuccessEvent
import org.springframework.context.ApplicationListener

class LoginSuccessListener : ApplicationListener<LoginSuccessEvent> {

    override fun onApplicationEvent(event: LoginSuccessEvent) {
        Log.log.info("login success for ${event.user}")
    }
}