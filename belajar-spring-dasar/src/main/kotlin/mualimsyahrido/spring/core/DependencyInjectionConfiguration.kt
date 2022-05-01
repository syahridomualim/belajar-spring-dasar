package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Bar
import mualimsyahrido.spring.core.data.Foo
import mualimsyahrido.spring.core.data.FooBar
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class DependencyInjectionConfiguration {

    @Primary
    @Bean
    fun fooFirst(): Foo {
        return Foo()
    }

    @Bean
    fun fooSecond(): Foo {
        return Foo()
    }

    @Bean
    fun bar(): Bar {
        return Bar()
    }

    @Bean
    fun fooBar(@Qualifier("fooSecond") foo: Foo, bar: Bar): FooBar {
        return FooBar(foo, bar)
    }
}