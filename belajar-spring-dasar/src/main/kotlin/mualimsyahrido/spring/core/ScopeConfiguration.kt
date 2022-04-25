package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.Bar
import mualimsyahrido.spring.core.data.Foo
import mualimsyahrido.spring.core.scope.DoubletonScope
import org.springframework.beans.factory.config.CustomScopeConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
class ScopeConfiguration {

    @Bean
    @Scope(value = "prototype")
    fun foo1(): Foo {
        Log.log.info("create new Foo")
        return Foo()
    }

    @Bean
    @Scope(value = "prototype")
    fun foo2(): Foo {
        Log.log.info("create new Foo")
        return Foo()
    }

    @Bean
    fun customScopeConfiguration(): CustomScopeConfigurer {
        val configurer = CustomScopeConfigurer()
        configurer.addScope("doubleton", DoubletonScope())
        return configurer
    }

    @Bean
    @Scope("doubleton")
    fun bar(): Bar {
        Log.log.info("create new Bar")
        return Bar()
    }
}