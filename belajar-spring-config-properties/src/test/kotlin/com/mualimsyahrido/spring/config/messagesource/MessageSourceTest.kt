package com.mualimsyahrido.spring.config.messagesource

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.MessageSource
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.support.ResourceBundleMessageSource
import java.util.*

class MessageSourceTest {

    private lateinit var applicationContext: ConfigurableApplicationContext
    private lateinit var messageSource: MessageSource

    @BeforeEach
    fun setUp() {
        applicationContext = AnnotationConfigApplicationContext(TestApplication::class.java)
        messageSource = applicationContext.getBean(MessageSource::class.java)
    }

    @Test
    fun testDefaultLocale() {
        val message = messageSource.getMessage("hello", arrayOf("Mu'alim"), Locale.ENGLISH)
        Assertions.assertEquals("Hello Mu'alim", message)
    }

    @Test
    fun testIndonesianLocale() {
        val message = messageSource.getMessage("hello", arrayOf("Mu'alim"), Locale("in_ID"))
        Assertions.assertEquals("Halo Mu'alim", message)
    }

    companion object {

        @SpringBootApplication
        class TestApplication {

            @Bean
            fun messageSource(): MessageSource {
                val messageSource = ResourceBundleMessageSource()
                messageSource.setBasename("my")
                return messageSource
            }
        }
    }

}