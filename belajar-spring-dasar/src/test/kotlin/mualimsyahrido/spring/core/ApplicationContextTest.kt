package mualimsyahrido.spring.core

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextTest {

    @Test
    fun testApplicationContext() {
        val context : ApplicationContext = AnnotationConfigApplicationContext(HelloWorldConfiguration::class.java)

        Assertions.assertNotNull(context)
    }
}