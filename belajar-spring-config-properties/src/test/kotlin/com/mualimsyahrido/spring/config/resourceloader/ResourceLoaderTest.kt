package com.mualimsyahrido.spring.config.resourceloader

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ResourceLoaderAware
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component

@SpringBootTest(classes = [ResourceLoaderTest.Companion.TestApplication::class])
class ResourceLoaderTest(@Autowired val sampleResource: TestApplication.SampleResource) {

    @Test
    fun testResource() {
        Assertions.assertEquals("Mu'alim Syahrido", sampleResource.getText())
    }

    companion object {

        @SpringBootApplication
        class TestApplication {

            @Component
            class SampleResource : ResourceLoaderAware {
                private lateinit var resourceLoader: ResourceLoader
                override fun setResourceLoader(resourceLoader: ResourceLoader) {
                    this.resourceLoader = resourceLoader
                }

                fun getText(): String {
                    val resource = resourceLoader.getResource("classpath:/text/resource.txt")

                    return try {
                        val inputStream = resource.inputStream
                        String(inputStream.readAllBytes())
                    } catch (e: Exception) {
                        return e.message.toString()
                    }
                }
            }
        }
    }

}