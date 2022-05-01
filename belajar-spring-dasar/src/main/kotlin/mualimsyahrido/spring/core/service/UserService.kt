package mualimsyahrido.spring.core.service

import mualimsyahrido.spring.core.data.User
import mualimsyahrido.spring.core.event.LoginSuccessEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.ApplicationEventPublisherAware

class UserService : ApplicationEventPublisherAware {

    private lateinit var applicationEventPublisher: ApplicationEventPublisher

    override fun setApplicationEventPublisher(applicationEventPublisher: ApplicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher
    }

    fun loginSuccess(username: String, password: String): Boolean {
        return if (isLoginSuccess(username, password)) {
            applicationEventPublisher.publishEvent(LoginSuccessEvent(User(username)))
            true
        } else {
            false
        }
    }

    private fun isLoginSuccess(username: String, password: String): Boolean {
        return "mualim" == username && "syahrido" == password
    }
}