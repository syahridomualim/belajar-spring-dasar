package com.mualimsyahrido.spring.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.stereotype.Component


@ConfigurationProperties(prefix = "application")
data class ApplicationProperties @ConstructorBinding constructor(
    val name: String, val version: Int, val productionMode: Boolean, val databaseProperties: DatabaseProperties
) {
    data class DatabaseProperties @ConstructorBinding constructor(
        val username: String, val password: String, val name: String, val url: String
    )
}
