package com.mualimsyahrido.spring.config.profileenvironment

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.EnvironmentAware
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(classes = [ProfileEnvironmentTest.Companion.TestApplication::class])
@ActiveProfiles(profiles = ["local", "production"])
class ProfileEnvironmentTest (@Autowired val sampleProfile: TestApplication.SampleProfile){

    @Test
    fun testActiveProfiles() {
        Assertions.assertArrayEquals(arrayOf("local", "production"), sampleProfile.activeProfiles())
    }

    companion object {

        @SpringBootApplication
        class TestApplication {

            @Component
            class SampleProfile : EnvironmentAware {

                private lateinit var environment: Environment

                override fun setEnvironment(environment: Environment) {
                    this.environment = environment
                }

                fun activeProfiles(): Array<String> {
                    return environment.activeProfiles
                }
            }
        }
    }
}