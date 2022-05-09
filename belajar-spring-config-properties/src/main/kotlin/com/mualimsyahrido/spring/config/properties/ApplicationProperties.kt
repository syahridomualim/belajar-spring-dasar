package com.mualimsyahrido.spring.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding


@ConfigurationProperties(prefix = "application")
data class ApplicationProperties @ConstructorBinding constructor(
    val name: String,
    val version: Int,
    val productionMode: Boolean,
    val databaseProperties: DatabaseProperties,
    val defaultRoles: List<Role>,
    val roles: Map<String, Role>
) {
    data class DatabaseProperties @ConstructorBinding constructor(
        val username: String,
        val password: String,
        val name: String,
        val url: String,
        val whiteListTables: List<String>,
        val maxTableSize: Map<String, Int>
    )

    data class Role(
        val id: String,
        val name: String
    )
}
