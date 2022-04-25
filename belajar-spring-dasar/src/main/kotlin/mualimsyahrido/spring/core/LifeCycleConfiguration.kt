package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Connection
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LifeCycleConfiguration {

    @Bean
    fun connection(): Connection {
        return Connection()
    }
}