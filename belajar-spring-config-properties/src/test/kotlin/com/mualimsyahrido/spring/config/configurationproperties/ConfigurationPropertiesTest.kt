package com.mualimsyahrido.spring.config.configurationproperties

import com.mualimsyahrido.spring.config.properties.ApplicationProperties
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [ConfigurationPropertiesTest.Companion.TestApplication::class])
class ConfigurationPropertiesTest(@Autowired val applicationProperties: ApplicationProperties) {

    @Test
    fun testConfigurationProperties() {
        Assertions.assertEquals("Belajar Spring Boot", applicationProperties.name)
        Assertions.assertEquals(1, applicationProperties.version)
        Assertions.assertEquals(false, applicationProperties.productionMode)
    }

    @Test
    fun testDatabaseProperties() {
        Assertions.assertEquals("mualim", applicationProperties.databaseProperties.username)
        Assertions.assertEquals("rahasia", applicationProperties.databaseProperties.password)
        Assertions.assertEquals("database", applicationProperties.databaseProperties.name)
        Assertions.assertEquals("jdbc://url", applicationProperties.databaseProperties.url)
    }



    companion object {
        @SpringBootApplication
        @EnableConfigurationProperties(value = [ApplicationProperties::class])
        class TestApplication {
        }
    }
}