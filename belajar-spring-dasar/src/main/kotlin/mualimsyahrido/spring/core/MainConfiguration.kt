package mualimsyahrido.spring.core

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
    value = [FooConfiguration::class, BarConfiguration::class]
)
class MainConfiguration {
}