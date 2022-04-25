package mualimsyahrido.spring.core.data

import mualimsyahrido.spring.core.Log
import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean

class Connection : InitializingBean, DisposableBean {
    override fun afterPropertiesSet() {
        Log.log.info("Connection is ready to be used")
    }

    override fun destroy() {
        Log.log.info("Connection is closed")
    }
}