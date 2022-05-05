package com.mualimsyahrido.spring.config.springbootmessageresource

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.MessageSource
import org.springframework.context.MessageSourceAware
import org.springframework.stereotype.Component
import java.util.*

@SpringBootTest(classes = [SpringBootMessageResourceTest.Companion.ApplicationTest::class])
class SpringBootMessageResourceTest(@Autowired val sampleResource: ApplicationTest.SampleResource) {

    @Test
    fun testHello() {
        Assertions.assertEquals("Hello Mu'alim", sampleResource.printHello("Mu'alim", Locale.ENGLISH))
        Assertions.assertEquals("Halo Mu'alim", sampleResource.printHello("Mu'alim", Locale("in_ID")))

    }

    companion object {

        @SpringBootApplication
        class ApplicationTest {

            @Component
            class SampleResource : MessageSourceAware {

                private lateinit var messageSource: MessageSource

                override fun setMessageSource(messageSource: MessageSource) {
                    this.messageSource = messageSource
                }

                fun printHello(message: String, locale: Locale): String {
                    return messageSource.getMessage("hello", arrayOf(message), locale)
                }
            }

        }
    }

}