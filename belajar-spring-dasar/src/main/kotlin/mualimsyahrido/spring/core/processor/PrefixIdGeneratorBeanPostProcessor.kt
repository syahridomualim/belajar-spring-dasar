package mualimsyahrido.spring.core.processor

import mualimsyahrido.spring.core.Log
import mualimsyahrido.spring.core.aware.IdAware
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.core.Ordered
import org.springframework.stereotype.Component

@Component
class PrefixIdGeneratorBeanPostProcessor : BeanPostProcessor, Ordered {
    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any {
        Log.log.info("Prefix Id Generator Processor for Bean $beanName")
        if (bean is IdAware) {
            Log.log.info("Prefix Set Id Generator Processor for Bean $beanName")
            val idAware: IdAware = bean
            idAware.setUserId("PZN-" + idAware.getUserId())
        }
        return bean
    }

    override fun getOrder(): Int {
        return 2
    }
}