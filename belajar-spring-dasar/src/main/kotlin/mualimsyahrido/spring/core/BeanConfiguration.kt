package mualimsyahrido.spring.core

import lombok.extern.slf4j.Slf4j
import mualimsyahrido.spring.core.data.Foo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Slf4j
@Configuration
class BeanConfiguration {

    @Bean
    fun foo(): Foo {
        val foo = Foo()
        Log.log.info("create new foo")
        return foo
    }
}