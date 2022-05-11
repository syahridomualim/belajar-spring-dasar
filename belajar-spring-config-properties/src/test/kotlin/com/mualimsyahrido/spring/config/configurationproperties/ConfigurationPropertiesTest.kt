package com.mualimsyahrido.spring.config.configurationproperties

import com.mualimsyahrido.spring.config.converter.StringToDateConverter
import com.mualimsyahrido.spring.config.properties.ApplicationProperties
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.convert.ApplicationConversionService
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.core.convert.ConversionService
import java.text.SimpleDateFormat
import java.time.Duration

@SpringBootTest(classes = [ConfigurationPropertiesTest.Companion.TestApplication::class])
class ConfigurationPropertiesTest(
    @Autowired val applicationProperties: ApplicationProperties,
    @Autowired val conversionService: ConversionService
) {

    @Test
    fun testConfigurationProperties() {
        Assertions.assertEquals("Belajar Spring Boot", applicationProperties.name)
        Assertions.assertEquals(1, applicationProperties.version)
        Assertions.assertEquals(false, applicationProperties.productionMode)
    }

    @Test
    fun testDatabaseProperties() {
        Assertions.assertEquals("mualim", applicationProperties.databaseProperties?.username)
        Assertions.assertEquals("rahasia", applicationProperties.databaseProperties?.password)
        Assertions.assertEquals("database", applicationProperties.databaseProperties?.name)
        Assertions.assertEquals("jdbc://url", applicationProperties.databaseProperties?.url)
    }

    @Test
    fun testCollection() {
        Assertions.assertEquals(
            listOf("customers", "products", "categories"),
            applicationProperties.databaseProperties?.whiteListTables
        )
        Assertions.assertEquals(100, applicationProperties.databaseProperties?.maxTableSize?.get("products"))
        Assertions.assertEquals(100, applicationProperties.databaseProperties?.maxTableSize?.get("customers"))
        Assertions.assertEquals(100, applicationProperties.databaseProperties?.maxTableSize?.get("categories"))
    }

    @Test
    fun testEmbeddedCollection() {
        Assertions.assertEquals("default", applicationProperties.defaultRoles?.get(0)?.id)
        Assertions.assertEquals("Default Role", applicationProperties.defaultRoles?.get(0)?.name)
        Assertions.assertEquals("guest", applicationProperties.defaultRoles?.get(1)?.id)
        Assertions.assertEquals("Guest Role", applicationProperties.defaultRoles?.get(1)?.name)

        Assertions.assertEquals("admin", applicationProperties.roles?.get("admin")?.id)
        Assertions.assertEquals("Admin Role", applicationProperties.roles?.get("admin")?.name)
        Assertions.assertEquals("finance", applicationProperties.roles?.get("finance")?.id)
        Assertions.assertEquals("Finance Role", applicationProperties.roles?.get("finance")?.name)
    }

    @Test
    fun testDuration() {
        Assertions.assertEquals(Duration.ofSeconds(10), applicationProperties.defaultTimeOut)
    }

    @Test
    fun testCustomConverter() {
        val expireDate = applicationProperties.expireDate

        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        Assertions.assertEquals("2022-05-10", dateFormat.format(expireDate))
    }

    @Test
    fun testConversionService() {
        Assertions.assertTrue(conversionService.canConvert(String::class.java, Duration::class.java))
        val result = conversionService.convert("10s", Duration::class.java)
        Assertions.assertEquals(Duration.ofSeconds(10), result)
    }

    companion object {
        @SpringBootApplication
        @EnableConfigurationProperties(value = [ApplicationProperties::class])
        @Import(StringToDateConverter::class)
        class TestApplication {

            @Bean
            fun conversionService(stringToDateConverter: StringToDateConverter): ConversionService {
                val applicationConversionService = ApplicationConversionService()
                applicationConversionService.addConverter(stringToDateConverter)
                return applicationConversionService
            }
        }
    }
}