package mualimsyahrido.spring.core.runnerapp

import mualimsyahrido.spring.core.Log
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class SimpleRunner : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        if (args != null) {
            val profiles = args.getOptionValues("profiles")
            Log.log.info("profiles: $profiles")
        }
    }
}