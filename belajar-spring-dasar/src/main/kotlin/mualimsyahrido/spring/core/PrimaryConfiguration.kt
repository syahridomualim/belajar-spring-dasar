package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Foo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class PrimaryConfiguration {

    @Primary
    @Bean
    fun foo1(): Foo {
        return Foo()
    }

    @Bean
    fun foo2(): Foo {
        return Foo()
    }
}