package mualimsyahrido.spring.core.factory

import mualimsyahrido.spring.core.client.PaymentGatewayClient
import org.springframework.beans.factory.FactoryBean
import org.springframework.stereotype.Component

@Component("paymentGatewayClient")
class PaymentGatewayClientFactoryBean : FactoryBean<PaymentGatewayClient> {
    override fun getObject(): PaymentGatewayClient? {
        return PaymentGatewayClient(
            endPoint = "https://www.example.com",
            privateKey = "PRIVATE",
            publicKey = "PUBLIC"
        )
    }

    override fun getObjectType(): Class<*>? {
        return PaymentGatewayClient::class.java
    }
}