package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Bar
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BarConfiguration {

    @Bean
    fun bar(): Bar {
        return Bar()
    }
}