package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.listener.LoginAgainSuccessListener
import mualimsyahrido.spring.core.listener.LoginSuccessListener
import mualimsyahrido.spring.core.listener.UserListener
import mualimsyahrido.spring.core.service.UserService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Import
import org.springframework.stereotype.Component

class EventListenerTest {

    companion object {
        @Component
        @Import(
            value = [
                LoginSuccessListener::class, LoginAgainSuccessListener::class, UserService::class, UserListener::class
            ]
        )
        class TestConfiguration {
        }
    }

    private lateinit var applicationContext: ConfigurableApplicationContext

    @BeforeEach
    fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(TestConfiguration::class.java)
        applicationContext.registerShutdownHook()
    }

    @Test
    fun testEventListener() {
        val userService = applicationContext.getBean(UserService::class.java)
        userService.loginSuccess("mualim", "syahrido")
        userService.loginSuccess("salah", "syahrido")
        userService.loginSuccess("mualim", "salah")
    }
}