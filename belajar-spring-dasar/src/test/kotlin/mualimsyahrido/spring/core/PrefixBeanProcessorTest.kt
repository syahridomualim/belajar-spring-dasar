package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Car
import mualimsyahrido.spring.core.processor.IdGeneratorBeanPostProcessor
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.stereotype.Component

class PrefixBeanProcessorTest {

    companion object {
        @Configuration
        @Import(value = [Car::class, PrefixBeanProcessorTest::class, IdGeneratorBeanPostProcessor::class])
        public class TestConfiguration {

        }
    }

    private lateinit var applicationContext: ConfigurableApplicationContext

    @BeforeEach
    fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(TestConfiguration::class.java)
        applicationContext.registerShutdownHook()
    }

    @Test
    fun testIdAware() {
        val car = applicationContext.getBean(Car::class.java)
        val carId = car.getUserId()

        Assertions.assertNotNull(carId)
        Assertions.assertTrue(carId.startsWith(""))
    }
}