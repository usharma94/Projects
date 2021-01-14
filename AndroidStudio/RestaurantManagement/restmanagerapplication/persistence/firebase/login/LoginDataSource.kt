package sheridan.sharmupm.restmanagerapplication.persistence.firebase.login

import com.google.firebase.auth.FirebaseAuth
import sheridan.sharmupm.restmanagerapplication.application.login.LoggedInUser
import sheridan.sharmupm.restmanagerapplication.application.login.Result
import java.io.IOException
import java.util.*

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {
    private var mAuth: FirebaseAuth? = null

    init {
        mAuth = FirebaseAuth.getInstance()
    }

    fun login(username: String, password: String, callback: (Result<LoggedInUser>) -> Unit) {
        try {
            mAuth!!.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        println("signInWithEmail:success")
                        val authUser = mAuth!!.currentUser
                        val user = LoggedInUser(UUID.randomUUID().toString(), authUser?.email.toString())
                        callback(Result.Success(user));
                    } else {
                        // If sign in fails, display a message to the user.
                        println("signInWithEmail:failure, " + task.exception)
                        callback(Result.Error(IOException("Error logging in", task.exception)));
                    }
                }
        } catch (e: Throwable) {
            return callback(Result.Error(IOException("Error logging in", e)));
        }
    }

    fun logout() {
        mAuth!!.signOut()
        println("signing user out of firebase...")
    }
}