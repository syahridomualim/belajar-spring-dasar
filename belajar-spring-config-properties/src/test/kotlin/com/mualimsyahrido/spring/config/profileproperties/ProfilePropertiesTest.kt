package com.mualimsyahrido.spring.config.profileproperties

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Component
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(classes = [ProfilePropertiesTest.Companion.TestApplication::class])
@ActiveProfiles(profiles = ["production", "test"])
class ProfilePropertiesTest(@Autowired val profileProperties: TestApplication.ProfileProperties) {

    @Test
    fun testProfileFiles() {
        Assertions.assertEquals("Production", profileProperties.productionFile)
        Assertions.assertEquals("Test", profileProperties.testFile)
        Assertions.assertEquals("Default", profileProperties.defaultFile)
    }

    companion object {
        @SpringBootApplication
        class TestApplication {

            @Component
            data class ProfileProperties(
                @Value("\${profile.default}")
                val defaultFile: String,

                @Value("\${profile.production}")
                val productionFile: String,

                @Value("\${profile.test}")
                val testFile: String
            )
        }
    }

}