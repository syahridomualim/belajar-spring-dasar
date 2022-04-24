package mualimsyahrido.spring.core

import mualimsyahrido.spring.core.data.cyclic.CyclicA
import mualimsyahrido.spring.core.data.cyclic.CyclicB
import mualimsyahrido.spring.core.data.cyclic.CyclicC
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CyclicConfiguration {

    @Bean
    fun cyclicA(cyclicB: CyclicB): CyclicA{
        return CyclicA(cyclicB)
    }

    @Bean
    fun cyclicB(cyclicC: CyclicC): CyclicB{
        return CyclicB(cyclicC)
    }

    @Bean
    fun cyclicC(cyclicA: CyclicA): CyclicC{
        return CyclicC(cyclicA)
    }
}