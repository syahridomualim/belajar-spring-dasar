package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.event.LoginSuccessEvent
import org.springframework.context.event.EventListener

@EventListener(classes = [LoginSuccessEvent::class])
    fun onLoginSuccessEvent(event: LoginSuccessEvent) {
        Log.log.info("login success for ${event.user}")
    }