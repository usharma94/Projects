package sheridan.sharmupm.restmanagerapplication.application.login

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val userId: String,
    val username: String
)