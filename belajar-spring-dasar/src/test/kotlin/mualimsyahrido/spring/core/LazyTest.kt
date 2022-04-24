package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Foo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class LazyTest {

    private lateinit var applicationContext: ApplicationContext

    @BeforeEach
    fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(LazyConfiguration::class.java)
    }

    @Test
    fun testDependOn() {
       applicationContext.getBean(Foo::class.java)
    }
}