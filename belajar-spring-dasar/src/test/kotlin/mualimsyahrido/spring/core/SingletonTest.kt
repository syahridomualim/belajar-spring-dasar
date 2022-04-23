package mualimsyahrido.spring.core

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SingletonTest {
    @Test
    fun testSingleton() {
        val database1 = Database
        val database2 = Database

        Assertions.assertSame(database1, database2)
    }
}