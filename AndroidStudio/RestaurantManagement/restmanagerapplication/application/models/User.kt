package sheridan.sharmupm.restmanagerapplication.application.models

import com.google.firebase.firestore.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class User(
    val id: String? = null,
    var accessType: String? = null,
    var username: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var phone: String? = null,
    var email: String? = null,
    var password: String? = null,
    var street1: String? = null,
    var street2: String? = null,
    var city: String? = null,
    var province: String? = null,
    var postal: String? = null,
    var country: String? = null,
) : Serializable {
    companion object {
        const val FIELD_ACCESSTYPE = "accessType"
        const val FIELD_USERNAME = "username"
        const val FIELD_FIRSTNAME = "firstName"
        const val FIELD_LASTNAME = "lastName"
        const val FIELD_PHONE = "phone"
        const val FIELD_EMAIL = "email"
        const val FIELD_STREET1 = "street1"
        const val FIELD_STREET2 = "street2"
        const val FIELD_CITY = "city"
        const val FIELD_POSTAL = "postal"
        const val FIELD_PROVINCE = "province"
        const val FIELD_COUNTRY = "country"
    }
}