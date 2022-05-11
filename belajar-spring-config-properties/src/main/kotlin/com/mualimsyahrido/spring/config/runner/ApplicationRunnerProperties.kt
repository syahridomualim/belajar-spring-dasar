package com.mualimsyahrido.spring.config.runner

import com.mualimsyahrido.spring.config.logger.Log
import com.mualimsyahrido.spring.config.properties.ApplicationProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ApplicationRunnerProperties(@Autowired val applicationProperties: ApplicationProperties) :  ApplicationRunner{
    override fun run(args: ApplicationArguments?) {
        Log.log.info(applicationProperties.name)
        Log.log.info(applicationProperties.version.toString())
        Log.log.info(applicationProperties.productionMode.toString())
    }

}