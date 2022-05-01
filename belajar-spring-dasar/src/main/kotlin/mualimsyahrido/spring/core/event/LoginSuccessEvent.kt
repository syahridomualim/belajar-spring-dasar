package mualimsyahrido.spring.core.event

import mualimsyahrido.spring.core.data.User
import org.springframework.context.ApplicationEvent

data class LoginSuccessEvent(val user: User) : ApplicationEvent(user)