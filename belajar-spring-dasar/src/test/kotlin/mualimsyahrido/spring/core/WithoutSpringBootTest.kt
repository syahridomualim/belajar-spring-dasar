package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.application.FooApplication
import mualimsyahrido.spring.core.data.Foo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class WithoutSpringBootTest {

    private lateinit var applicationContext: ConfigurableApplicationContext

    @BeforeEach
    fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(FooApplication::class.java)
        applicationContext.registerShutdownHook()
    }

    @Test
    fun test() {
        val foo = applicationContext.getBean(Foo::class.java)

    }
}