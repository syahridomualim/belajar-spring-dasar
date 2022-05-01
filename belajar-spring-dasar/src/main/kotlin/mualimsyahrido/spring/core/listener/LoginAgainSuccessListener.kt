package mualimsyahrido.spring.core.listener

import mualimsyahrido.spring.core.Log
import mualimsyahrido.spring.core.event.LoginSuccessEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class LoginSuccessListener : ApplicationListener<LoginSuccessEvent>{
    override fun onApplicationEvent(event: LoginSuccessEvent) {
        Log.log.info("Success login for user ${event.user}")
    }
}