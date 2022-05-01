package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.service.MerchantService
import mualimsyahrido.spring.core.service.MerchantServiceImpl
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class InheritanceTest {

    private lateinit var applicationContext: ConfigurableApplicationContext

    @BeforeEach
    fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(InheritanceConfiguration::class.java)
        applicationContext.registerShutdownHook()
    }

    @Test
    fun testInheritance() {
        val merchantService = applicationContext.getBean(MerchantService::class.java)
        val merchantServiceImpl = applicationContext.getBean(MerchantServiceImpl::class.java)

        Assertions.assertSame(merchantService, merchantServiceImpl)
    }
}