package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.configuration.OptionalConfiguration
import mualimsyahrido.spring.core.data.Foo
import mualimsyahrido.spring.core.data.FooBar
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class OptionalTest {

    private lateinit var applicationContext: ConfigurableApplicationContext

    @BeforeEach
    fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(OptionalConfiguration::class.java)
        applicationContext.registerShutdownHook()
    }

    @Test
    fun testOptional() {
        val foo = applicationContext.getBean(Foo::class.java)
        val fooBar = applicationContext.getBean(FooBar::class.java)

        Assertions.assertNull(fooBar.bar)
        Assertions.assertSame(fooBar.foo, foo)
    }
}