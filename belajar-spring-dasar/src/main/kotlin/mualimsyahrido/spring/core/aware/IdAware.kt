package mualimsyahrido.spring.core.aware

interface IdAware {

    fun setUserId(id: String)

    fun getUserId() : String
}