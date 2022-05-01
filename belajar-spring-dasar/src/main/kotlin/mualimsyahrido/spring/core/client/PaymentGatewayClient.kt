package mualimsyahrido.spring.core.client

data class PaymentGatewayClient(
    val endPoint: String,
    val privateKey: String,
    val publicKey: String
)