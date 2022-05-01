package mualimsyahrido.spring.core.service

import mualimsyahrido.spring.core.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class CustomerService(
    @Autowired @Qualifier("normalCustomerRepository") val normalCustomerRepository: CustomerRepository,
    @Autowired @Qualifier("premiumCustomerRepository") val premiumCustomerRepository: CustomerRepository,
) {

}