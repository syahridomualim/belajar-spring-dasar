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

    @Test
    fun testCollection() {
        Assertions.assertEquals(listOf("customers", "products", "categories"), applicationProperties.databaseProperties.whiteListTables)
        Assertions.assertEquals(100, applicationProperties.databaseProperties.maxTableSize["products"])
        Assertions.assertEquals(100, applicationProperties.databaseProperties.maxTableSize["customers"])
        Assertions.assertEquals(100, applicationProperties.databaseProperties.maxTableSize["categories"])
    }

    @Test
    fun testEmbeddedCollection() {
        Assertions.assertEquals("default", applicationProperties.defaultRoles[0].id)
        Assertions.assertEquals("Default Role", applicationProperties.defaultRoles[0].name)
        Assertions.assertEquals("guest", applicationProperties.defaultRoles[1].id)
        Assertions.assertEquals("Guest Role", applicationProperties.defaultRoles[1].name)

        Assertions.assertEquals("admin", applicationProperties.roles["admin"]?.id)
        Assertions.assertEquals("Admin Role", applicationProperties.roles["Admin Role"]?.name)
        Assertions.assertEquals("finance", applicationProperties.roles["finance"]?.id)
        Assertions.assertEquals("Finance Role", applicationProperties.roles["Finance Role"]?.name)

    }

    companion object {
        @SpringBootApplication
        @EnableConfigurationProperties(value = [ApplicationProperties::class])
        class TestApplication {
        }
    }
}