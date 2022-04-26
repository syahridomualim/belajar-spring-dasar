package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Foo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FooConfiguration {

    @Bean
    fun foo(): Foo {
        return Foo()
    }
}