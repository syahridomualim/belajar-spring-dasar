package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Foo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext


class PrimaryTest {

    private lateinit var applicationContext: ApplicationContext

    @BeforeEach
    fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(PrimaryConfiguration::class.java)
    }

    @Test
    fun tesGetPrimary() {
        val foo = applicationContext.getBean(Foo::class.java)
        val foo1 = applicationContext.getBean("foo1", Foo::class.java)
        val foo2 = applicationContext.getBean("foo2", Foo::class.java)

        Assertions.assertSame(foo, foo1)
        Assertions.assertNotSame(foo, foo2)
        Assertions.assertNotSame(foo, foo2)

    }
}