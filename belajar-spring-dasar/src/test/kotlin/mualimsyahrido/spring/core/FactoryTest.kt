package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.client.PaymentGatewayClient
import mualimsyahrido.spring.core.factory.PaymentGatewayClientFactoryBean
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class FactoryTest {

    private lateinit var applicationContext: ConfigurableApplicationContext

    @BeforeEach
    fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(PaymentGatewayClientFactoryBean::class.java)
        applicationContext.registerShutdownHook()
    }

    @Test
    fun testFactory() {
        val gatewayClient = applicationContext.getBean(PaymentGatewayClient::class.java)

        Assertions.assertEquals("https://www.example.com", gatewayClient.endPoint)
        Assertions.assertEquals("PRIVATE", gatewayClient.privateKey)
        Assertions.assertEquals("PUBLIC", gatewayClient.publicKey)
    }
}