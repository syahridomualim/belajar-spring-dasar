package mualimsyahrido.spring.core.processor

import mualimsyahrido.spring.core.Log
import mualimsyahrido.spring.core.aware.IdAware
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.core.Ordered
import org.springframework.stereotype.Component
import java.util.*

@Component
class IdGeneratorBeanPostProcessor : BeanPostProcessor, Ordered {
    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any {
        Log.log.info("Id Generator Processor for Bean $beanName")
        if (bean is IdAware) {
            Log.log.info("Set Id Generator Processor for Bean $beanName")
            val idAware: IdAware = bean
            idAware.setUserId("PZN- ${UUID.randomUUID().toString()}")
        }
        return bean
    }

    override fun getOrder(): Int {
        return 1
    }
}