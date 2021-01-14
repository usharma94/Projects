package sheridan.sharmupm.restmanagerapplication.application.models

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class Order(
    var allergens: List<String>? = null,
    var menuItems: List<String>? = null,
    var preferences: List<String>? = null,
    var substitutions: String? = null,
    var tableNo: Int? = null,
) {
    companion object {
        const val FIELD_allergens = "allergens"
        const val FIELD_MENUITEMS = "menuItems"
        const val FIELD_PREFERENCES = "preferences"
        const val FIELD_SUBSTITUTIONS = "substitutions"
        const val FIELD_TABLENO = "tableNo"
    }
}