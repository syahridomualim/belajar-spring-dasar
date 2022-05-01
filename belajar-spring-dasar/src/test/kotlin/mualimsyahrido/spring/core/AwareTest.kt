package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.service.AuthService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

class AwareTest {

    companion object {

        @Configuration
        @Import(value = [AuthService::class])
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
    fun testAware() {
        val authService = applicationContext.getBean(AuthService::class.java)

        Assertions.assertEquals("mualimsyahrido.spring.core.service.AuthService", authService.getBeanName())
        Assertions.assertNotNull(authService.getApplicationContext())
        Assertions.assertSame(applicationContext, authService.getApplicationContext())

    }
}