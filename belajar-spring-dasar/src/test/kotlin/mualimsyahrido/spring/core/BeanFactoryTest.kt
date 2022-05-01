package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Foo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import java.util.stream.Collectors

class BeanFactoryTest {

    private lateinit var applicationContext: ConfigurableApplicationContext

    @BeforeEach
    fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(ScanConfiguration::class.java)
        applicationContext.registerShutdownHook()
    }

    @Test
    fun testBeanFactory() {
        val fooObjectProvider = applicationContext.getBeanProvider(Foo::class.java)
        val fooList = fooObjectProvider.stream().collect(Collectors.toList())

        println(fooList)

        val beans = applicationContext.getBeansOfType(Foo::class.java)
        println(beans)
    }
}