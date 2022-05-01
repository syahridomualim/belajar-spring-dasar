package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.service.MerchantServiceImpl
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(value = [MerchantServiceImpl::class])
class InheritanceConfiguration {
}