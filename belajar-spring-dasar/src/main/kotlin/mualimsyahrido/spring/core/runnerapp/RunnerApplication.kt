package mualimsyahrido.spring.core.runnerapp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RunnerApplication {
}

fun main(args: Array<String>) {
    runApplication<RunnerApplication>(*args)
}