package mualimsyahrido.spring.core.data

import mualimsyahrido.spring.core.aware.IdAware
import org.springframework.stereotype.Component

@Component
class Car : IdAware {

    private var id = String()

    override fun setUserId(id: String) {
        this.id = id
    }

    override fun getUserId(): String {
        return id
    }

}