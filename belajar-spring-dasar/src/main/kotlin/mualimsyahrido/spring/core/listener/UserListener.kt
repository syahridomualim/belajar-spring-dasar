package mualimsyahrido.spring.core.listener

import mualimsyahrido.spring.core.Log
import mualimsyahrido.spring.core.event.LoginSuccessEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class UserListener {

    @EventListener(classes = [LoginSuccessEvent::class])
    fun onLoginSuccessEvent1(event: LoginSuccessEvent) {
        Log.log.info("login success for ${event.user}")
    }

    @EventListener(classes = [LoginSuccessEvent::class])
    fun onLoginSuccessEvent2(event: LoginSuccessEvent) {
        Log.log.info("login success for ${event.user}")
    }

    @EventListener(classes = [LoginSuccessEvent::class])
    fun onLoginSuccessEvent3(event: LoginSuccessEvent) {
        Log.log.info("login success for ${event.user}")
    }
}