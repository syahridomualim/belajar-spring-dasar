package com.mualimsyahrido.spring.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "application")
data class ApplicationProperties(
    val name: String,
    val version: Int,
    val isProductionMode: Boolean
)
