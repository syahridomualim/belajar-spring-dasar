package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Bar
import mualimsyahrido.spring.core.data.Foo
import mualimsyahrido.spring.core.data.FooBar
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext


class DependencyInjectionTest {

    private lateinit var applicationContext: ApplicationContext

    @BeforeEach
    fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(DependencyInjectionConfiguration::class.java)
    }

    @Test
    fun testDI() {
        val foo = applicationContext.getBean("fooSecond",Foo::class.java)
        val bar = applicationContext.getBean(Bar::class.java)
        val fooBar = applicationContext.getBean(FooBar::class.java)

        Assertions.assertSame(foo, fooBar.foo)
        Assertions.assertSame(bar, fooBar.bar)
    }

    @Test
    fun testNoDI() {
        val foo = Foo()
        val bar = Bar()

        val fooBar = FooBar(foo, bar)

        Assertions.assertSame(foo, fooBar.foo)
        Assertions.assertSame(bar, fooBar.bar)
    }
}