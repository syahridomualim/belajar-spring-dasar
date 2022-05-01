package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Foo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class BeanNameConfiguration {

    @Primary
    @Bean(value = ["fooFirst"])
    fun foo1(): Foo {
        return Foo()
    }

    @Bean(value = ["fooSecond"])
    fun foo2(): Foo {
        return Foo()
    }
}