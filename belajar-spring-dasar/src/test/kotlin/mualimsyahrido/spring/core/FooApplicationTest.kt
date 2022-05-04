package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.application.FooApplication
import mualimsyahrido.spring.core.data.Foo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [FooApplication::class])
class FooApplicationTest(@Autowired val foo: Foo) {

    @Test
    fun testFoo() {
        Assertions.assertNotNull(foo)
    }
}