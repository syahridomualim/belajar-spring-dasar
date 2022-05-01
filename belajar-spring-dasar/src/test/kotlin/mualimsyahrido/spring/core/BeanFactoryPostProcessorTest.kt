package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Foo
import mualimsyahrido.spring.core.factory.FooBeanFactoryPostProcessor
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Import
import org.springframework.stereotype.Component

class BeanFactoryPostProcessorTest {
    companion object {
        @Component
        @Import(FooBeanFactoryPostProcessor::class)
        class TestConfiguration {

        }
    }

    private lateinit var applicationContext: ConfigurableApplicationContext

    @BeforeEach
    internal fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(TestConfiguration::class.java)
        applicationContext.registerShutdownHook()
    }

    @Test
    fun testBeanFactoryPostProcessor() {
        val foo = applicationContext.getBean("foo", Foo::class.java)

        Assertions.assertNotNull(foo)
    }
}