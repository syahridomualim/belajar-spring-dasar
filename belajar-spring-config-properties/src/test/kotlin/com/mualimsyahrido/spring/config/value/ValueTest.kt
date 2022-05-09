package com.mualimsyahrido.spring.config.value

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Component

@SpringBootTest(classes = [ValueTest.Companion.TestApplication::class])
class ValueTest(
    @Autowired val properties: ValueTest.Companion.TestApplication.ApplicationProperties,
    @Autowired val systemProperties: ValueTest.Companion.TestApplication.SystemProperties
) {

    @Test
    fun testValue() {
        Assertions.assertEquals("Belajar Spring Boot", properties.name)
        Assertions.assertEquals(1, properties.version)
        Assertions.assertEquals(false, properties.isProductionMode)
    }

    @Test
    fun testSystemProperties() {
        Assertions.assertEquals("C:\\Program Files\\Java\\jdk-11.0.13", systemProperties.javaHome)
    }

    companion object {
        @SpringBootApplication
        class TestApplication {

            @Component
            data class ApplicationProperties(
                @Value(value = "\${application.name}")
                val name: String?,
                @Value(value = "\${application.version}")
                val version: Int?,
                @Value(value = "\${application.production-mode}")
                val isProductionMode: Boolean?
            )

            @Component
            data class SystemProperties(
                @Value("\${JAVA_HOME}")
                val javaHome: String
            )
        }
    }

}