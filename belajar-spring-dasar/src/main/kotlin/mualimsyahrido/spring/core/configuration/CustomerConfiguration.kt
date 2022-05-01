package mualimsyahrido.spring.core.configuration

import mualimsyahrido.spring.core.repository.CustomerRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class CustomerConfiguration {

    @Primary
    @Bean
    fun normalCustomerRepository(): CustomerRepository {
        return CustomerRepository()
    }

    @Bean
    fun premiumCustomerRepository(): CustomerRepository {
        return CustomerRepository()
    }
}