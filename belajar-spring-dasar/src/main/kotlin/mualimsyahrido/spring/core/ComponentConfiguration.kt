package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.MultiFoo
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@ComponentScan(
    basePackages = ["mualimsyahrido.spring.core.service", "mualimsyahrido.spring.core.repository", "mualimsyahrido.spring.core.configuration"]
)
@Import(value = [MultiFoo::class])
class ComponentConfiguration {

}