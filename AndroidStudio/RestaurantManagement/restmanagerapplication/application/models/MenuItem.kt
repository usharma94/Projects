package sheridan.sharmupm.restmanagerapplication.application.models

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class MenuItem(
        var archived: Boolean = false,
        var itemDescription: String? = null,
        var itemName: String? = null,
        var itemPrice: Double = 0.00,
        var onSpecial: Boolean = false,
) {
    companion object {
        const val FIELD_ARCHIVED = "archived"
        const val FIELD_ITEMDESCRIPTION = "itemDescription"
        const val FIELD_ITEMNAME = "itemName"
        const val FIELD_ITEMPRICE = "itemPrice"
        const val FIELD_ONSPECIAL = "onSpecial"
    }
}