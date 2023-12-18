package njit.rocky.airlinereviews

data class User(
    val username: String,
    val hashedPassword: Long,
    var email: String?,
    var phone: String?
)