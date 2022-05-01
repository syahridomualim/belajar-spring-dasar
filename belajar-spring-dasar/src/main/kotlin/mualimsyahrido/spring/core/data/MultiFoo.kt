package mualimsyahrido.spring.core.data

import org.springframework.beans.factory.ObjectProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class MultiFoo @Autowired constructor(val foos: List<Foo>) {


    constructor(objectProvider: ObjectProvider<Foo>) : this(
        foos = objectProvider.stream().collect(Collectors.toList())
    )
}