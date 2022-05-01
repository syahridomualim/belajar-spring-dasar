package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Connection
import mualimsyahrido.spring.core.data.Server
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class LifeCycleTest {

    private lateinit var applicationContext: ConfigurableApplicationContext

    @BeforeEach
    fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(LifeCycleConfiguration::class.java)
        applicationContext.registerShutdownHook()
    }

    @Test
    fun testConnection() {
        applicationContext.getBean(Connection::class.java)
    }

    @Test
    fun testServer() {
        applicationContext.getBean(Server::class.java)
    }

}