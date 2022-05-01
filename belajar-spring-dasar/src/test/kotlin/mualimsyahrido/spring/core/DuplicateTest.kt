package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Foo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class DuplicateTest {
    @Test
    fun testDuplicate() {
        val context = AnnotationConfigApplicationContext(DuplicateConfiguration::class.java)

        Assertions.assertThrows(NoUniqueBeanDefinitionException::class.java) {
            context.getBean(Foo::class.java)
        }
    }

    @Test
    fun getBean() {
        val context = AnnotationConfigApplicationContext(DuplicateConfiguration::class.java)

        val foo1 = context.getBean("foo1", Foo::class.java)
        val foo2 = context.getBean("foo2", Foo::class.java)

        Assertions.assertNotSame(foo1, foo2)
    }
}