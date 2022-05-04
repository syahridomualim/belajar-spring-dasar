package mualimsyahrido.spring.core.listener

import mualimsyahrido.spring.core.Log
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.boot.context.event.ApplicationStartingEvent
import org.springframework.context.ApplicationListener

class AppListener() : ApplicationListener<ApplicationStartedEvent> {
    override fun onApplicationEvent(event: ApplicationStartedEvent) {
        Log.log.info("Application Starting")
    }
}