package sheridan.sharmupm.restmanagerapplication.application.login

import sheridan.sharmupm.restmanagerapplication.presentation.login.LoggedInUserView

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
        val success: LoggedInUserView? = null,
        val error: Int? = null
)