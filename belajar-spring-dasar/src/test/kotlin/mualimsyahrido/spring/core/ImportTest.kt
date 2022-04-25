package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Bar
import mualimsyahrido.spring.core.data.Foo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ImportTest {

    private lateinit var applicationContext: ConfigurableApplicationContext

    @BeforeEach
    fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(MainConfiguration::class.java)
        applicationContext.registerShutdownHook()
    }

    @Test
    fun testImport() {
        applicationContext.getBean(Foo::class.java)
        applicationContext.getBean(Bar::class.java)
    }
}