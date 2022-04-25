package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Connection
import mualimsyahrido.spring.core.data.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LifeCycleConfiguration {

    @Bean
    fun connection(): Connection {
        return Connection()
    }

    //    @Bean(initMethod = "start", destroyMethod = "stop")
    @Bean
    fun server(): Server {
        return Server()
    }
}