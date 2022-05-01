package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Bar
import mualimsyahrido.spring.core.data.Foo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.Lazy

class LazyConfiguration {

    @Lazy
    @Bean
    @DependsOn(value = ["bar"])
    fun foo(): Foo {
        Log.log.info("create new Foo")
        return Foo()
    }

    @Bean
    fun bar(): Bar {
        Log.log.info("create new Bar")
        return Bar();
    }
}