package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.configuration.BarConfiguration
import mualimsyahrido.spring.core.configuration.FooConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
    value = [FooConfiguration::class, BarConfiguration::class]
)
class MainConfiguration {
}