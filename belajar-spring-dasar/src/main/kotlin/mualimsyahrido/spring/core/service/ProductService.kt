package mualimsyahrido.spring.core.service

import mualimsyahrido.spring.core.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductService @Autowired constructor(val productRepository: ProductRepository) {
    constructor(productRepository: ProductRepository, name: String) : this(productRepository)
}