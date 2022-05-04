package mualimsyahrido.spring.core.application

import mualimsyahrido.spring.core.data.Foo
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class FooApplication {

    @Bean
    fun foo(): Foo {
        return Foo()
    }
}

//fun main(args: Array<String>) {

//    val applicationContext = SpringApplication.run(FooApplication::class.java)
//    val foo = applicationContext.getBean(Foo::class.java)
//
//    println(foo)
//
//    val application = SpringApplication(FooApplication::class.java)
//    application.setBannerMode(Banner.Mode.OFF)
//    application.setListeners(listOf(AppListener()))
//
//    val applicationContext = application.run("$args")
//    val foo = applicationContext.getBean(Foo::class.java)
//
//    println(foo)
//}