package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Car
import mualimsyahrido.spring.core.processor.IdGeneratorBeanPostProcessor
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Import

class BeanPostProcessorTest {

    companion object {
        @org.springframework.context.annotation.Configuration
        @Import(value = [Car::class, IdGeneratorBeanPostProcessor::class])
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
    fun testCar() {
        val car = applicationContext.getBean(Car::class.java)

        println(car.getUserId())
        Assertions.assertNotNull(car.getUserId())
    }
}