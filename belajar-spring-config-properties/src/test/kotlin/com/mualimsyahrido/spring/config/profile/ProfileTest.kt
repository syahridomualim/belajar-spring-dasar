package com.mualimsyahrido.spring.config.profile

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(classes = [ProfileTest.Companion.ApplicationTest::class])
@ActiveProfiles(profiles = ["local"])
class ProfileTest(@Autowired val sayHello: ApplicationTest.SayHello) {

    @Test
    fun testProfile() {
        Assertions.assertEquals("Hello Mu'alim from local", sayHello.say("Mu'alim"))
    }

    companion object {
        @SpringBootApplication
        class ApplicationTest {

            interface SayHello {
                fun say(name: String): String
            }

            @Component
            @Profile(value = ["local"])
            class SayHelloLocal : SayHello {
                override fun say(name: String): String {
                    return "Hello $name from local"
                }
            }

            @Component
            @Profile(value = ["production"])
            class SayHelloProduction : SayHello {
                override fun say(name: String): String {
                    return "Hello $name from production"
                }
            }
        }
    }
}