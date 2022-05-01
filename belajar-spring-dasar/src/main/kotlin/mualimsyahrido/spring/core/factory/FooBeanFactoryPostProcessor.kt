package mualimsyahrido.spring.core.factory

import mualimsyahrido.spring.core.data.Foo
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor
import org.springframework.beans.factory.support.GenericBeanDefinition
import org.springframework.stereotype.Component

@Component
class FooBeanFactoryPostProcessor : BeanDefinitionRegistryPostProcessor {
    override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) {

    }

    override fun postProcessBeanDefinitionRegistry(registry: BeanDefinitionRegistry) {
        val definition = GenericBeanDefinition()
        definition.setBeanClass(Foo::class.java)
        definition.scope = "singleton"

        registry.registerBeanDefinition("foo", definition)
    }

}