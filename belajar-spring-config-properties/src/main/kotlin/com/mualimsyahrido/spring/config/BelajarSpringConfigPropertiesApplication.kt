package com.mualimsyahrido.spring.config

import com.mualimsyahrido.spring.config.converter.StringToDateConverter
import com.mualimsyahrido.spring.config.properties.ApplicationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.convert.ApplicationConversionService
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.convert.ConversionService

@SpringBootApplication
@EnableConfigurationProperties(
    value = [ApplicationProperties::class]
)
class BelajarSpringConfigPropertiesApplication {

    @Bean
    fun conversionService(stringToDateConverter: StringToDateConverter): ConversionService {
        val applicationConversionService = ApplicationConversionService()
        applicationConversionService.addConverter(stringToDateConverter)
        return applicationConversionService
    }
}

fun main(args: Array<String>) {
    runApplication<BelajarSpringConfigPropertiesApplication>(*args)
}
