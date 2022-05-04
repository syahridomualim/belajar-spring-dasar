package mualimsyahrido.spring.core.commandapp

import mualimsyahrido.spring.core.Log
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class LogCommandLineRunner : CommandLineRunner {
    override fun run(vararg args: String?) {
        Log.log.info("Log Command Line Runner ${args.contentToString()}")
    }
}