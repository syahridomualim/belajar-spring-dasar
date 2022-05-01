package mualimsyahrido.spring.core.service

import org.springframework.beans.factory.BeanNameAware
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

@Component
class AuthService :
    ApplicationContextAware, BeanNameAware {
    private var beanName = String()
    private var applicationContext: ApplicationContext? = null

    fun getBeanName(): String = beanName
    fun getApplicationContext(): ApplicationContext = applicationContext!!
    override fun setApplicationContext(applicationContext: ApplicationContext) {
        this.applicationContext = applicationContext
    }

    override fun setBeanName(name: String) {
        this.beanName = name
    }
}