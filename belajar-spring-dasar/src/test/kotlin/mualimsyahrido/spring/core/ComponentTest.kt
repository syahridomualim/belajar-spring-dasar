package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.MultiFoo
import mualimsyahrido.spring.core.repository.CustomerRepository
import mualimsyahrido.spring.core.repository.ProductRepository
import mualimsyahrido.spring.core.service.CustomerService
import mualimsyahrido.spring.core.service.ProductService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ComponentTest {

    private lateinit var applicationContext: ConfigurableApplicationContext

    @BeforeEach
    fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(ComponentConfiguration::class.java)
        applicationContext.registerShutdownHook()
    }

    @Test
    fun testService() {
        val productService1 = applicationContext.getBean("productService")
        val productService2 = applicationContext.getBean(ProductService::class.java)

        Assertions.assertSame(productService1, productService2)
    }

    @Test
    fun testConstructorDependencyInjection() {
        val productService = applicationContext.getBean(ProductService::class.java)
        val productRepository = applicationContext.getBean(ProductRepository::class.java)

        Assertions.assertSame(productService.productRepository, productRepository)
    }

    @Test
    fun testFieldDependencyInjection() {
        val normalCustomerRepository =
            applicationContext.getBean("normalCustomerRepository", CustomerRepository::class.java)
        val premiumCustomerRepository =
            applicationContext.getBean("premiumCustomerRepository", CustomerRepository::class.java)
        val customerService = applicationContext.getBean(CustomerService::class.java)

        Assertions.assertSame(customerService.normalCustomerRepository, normalCustomerRepository)
        Assertions.assertSame(customerService.premiumCustomerRepository, premiumCustomerRepository)
    }

    @Test
    fun testObjectProvide() {
        val multiFoo = applicationContext.getBean(MultiFoo::class.java)
        Assertions.assertEquals(3, multiFoo.foos.size)
    }
}