package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Connection
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class LifeCycleTest {

    private lateinit var applicationContext: ConfigurableApplicationContext

    @BeforeEach
    internal fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(LifeCycleConfiguration::class.java)
        applicationContext.registerShutdownHook()
    }

    @Test
    internal fun testConnection() {
        applicationContext.getBean(Connection::class.java)
    }

//    @AfterEach
//    internal fun tearDown() {
////        applicationContext.close()
//    }
}