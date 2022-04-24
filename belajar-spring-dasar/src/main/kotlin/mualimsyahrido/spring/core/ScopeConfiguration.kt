package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Bar
import mualimsyahrido.spring.core.data.Foo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
class ScopeConfiguration {

    @Bean
    @Scope(value = "prototype")
    fun foo(): Foo {
        Log.log.info("create new Foo")
        return Foo()
    }

    @Bean
    @Scope(value = "singleton")
    fun bar(): Bar {
        Log.log.info("create new Bar")
        return Bar()
    }
}