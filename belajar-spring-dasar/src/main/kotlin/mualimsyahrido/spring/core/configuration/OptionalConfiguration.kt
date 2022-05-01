package mualimsyahrido.spring.core.configuration

import mualimsyahrido.spring.core.data.Bar
import mualimsyahrido.spring.core.data.Foo
import mualimsyahrido.spring.core.data.FooBar
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Scope
import java.util.*

@Configuration
class OptionalConfiguration {

    @Bean
    fun fooBar(foo: Optional<Foo>, bar: Optional<Bar>): FooBar {
        return FooBar(foo.orElse(null), bar.orElse(null))
    }
}