package mualimsyahrido.spring.core.scope

import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.config.Scope

class DoubletonScope : Scope {

    private var objects = ArrayList<Any>(2)

    private var counter = -1L

    override fun get(name: String, objectFactory: ObjectFactory<*>): Any {
        counter++
        return if (objects.size == 2) {
            val index = counter % 2
            objects[index.toInt()]
        } else {
            val obj = objectFactory.`object`
            objects.add(obj)
            obj
        }
    }

    override fun remove(name: String): Any? {
        if (objects.isNotEmpty()) {
            return objects.remove(0)
        }
        return null
    }

    override fun registerDestructionCallback(name: String, callback: Runnable) {
        TODO("Not yet implemented")
    }

    override fun resolveContextualObject(key: String): Any? {
        TODO("Not yet implemented")
    }

    override fun getConversationId(): String? {
        TODO("Not yet implemented")
    }
}