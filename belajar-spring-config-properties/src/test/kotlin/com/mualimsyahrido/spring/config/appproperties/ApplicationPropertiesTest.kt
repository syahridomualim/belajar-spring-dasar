package com.mualimsyahrido.spring.config.appproperties

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment

@SpringBootTest(classes = [ApplicationPropertiesTest.Companion.TestApplication::class])
class ApplicationPropertiesTest (@Autowired val environment: Environment){

    @Test
    fun testApplicationProperties() {
        val message = environment.getProperty("application.name")
        Assertions.assertEquals("Belajar Spring Boot", message)
    }

    companion object {

        @SpringBootApplication
        class TestApplication {
        }
    }
}