package mualimsyahrido.spring.core.data

import mualimsyahrido.spring.core.Log
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

class Server {

    @PostConstruct
    fun start() {
        Log.log.info("start server")
    }

    @PreDestroy
    fun stop() {
        Log.log.info("stop server")
    }
}