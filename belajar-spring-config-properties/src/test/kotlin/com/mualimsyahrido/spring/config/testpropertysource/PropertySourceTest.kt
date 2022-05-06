package com.mualimsyahrido.spring.config.propertysource

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@SpringBootTest(classes = [PropertySourceTest.Companion.TestApplication::class])
class PropertySourceTest(@Autowired val sampleProperties: TestApplication.SampleProperties) {

    @Test
    fun testPropertySource() {
        Assertions.assertEquals("Sample Project", sampleProperties.name)
        Assertions.assertEquals(1, sampleProperties.version)
    }

    companion object {
        @SpringBootApplication
        @PropertySource(value = ["classpath:/sample.properties"])
        class TestApplication {

            @Component
            data class SampleProperties(
                @Value("\${sample.name}") val name: String, @Value("\${sample.version}") val version: Int
            )
        }
    }
}