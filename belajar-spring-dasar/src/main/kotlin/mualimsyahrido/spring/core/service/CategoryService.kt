package mualimsyahrido.spring.core.service

import mualimsyahrido.spring.core.repository.CategoryRepository
import org.springframework.stereotype.Component

@Component
class CategoryService(val categoryRepository: CategoryRepository) {
    
}