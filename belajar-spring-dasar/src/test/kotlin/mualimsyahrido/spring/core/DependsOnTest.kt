package mualimsyahrido.spring.core

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class DependsOnTest {

    private lateinit var applicationContext: ApplicationContext

    @BeforeEach
    fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(DependOnConfiguration::class.java)
    }

    @Test
    fun testDependOn() {
    }
}