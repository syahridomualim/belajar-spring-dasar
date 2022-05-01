package mualimsyahrido.spring.core.factory

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(value = [PaymentGatewayClientFactoryBean::class])
class FactoryConfiguration {
}