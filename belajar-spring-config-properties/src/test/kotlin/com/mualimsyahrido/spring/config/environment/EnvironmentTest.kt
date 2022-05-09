package com.mualimsyahrido.spring.config.environment

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment

@SpringBootTest(classes = [EnvironmentTest.Companion.TestApplication::class])
class EnvironmentTest(@Autowired val environment: Environment) {

    @Test
    fun testEnvironment() {
        val property = environment.getProperty("JAVA_HOME")
        Assertions.assertEquals("C:\\Program Files\\Java\\jdk-11.0.13", property)
    }

    companion object {
        @SpringBootApplication
        class TestApplication {
        }
    }

}