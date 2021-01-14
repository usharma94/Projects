package sheridan.sharmupm.restmanagerapplication.application.models

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class Table(
    var numOfSeats: Int? = null,
    var tableOrders: List<String>? = null,
    var available : Boolean = true,
) {
    companion object {
        const val FIELD_NUMOFSEATS = "numOfSeats"
        const val FIELD_TABLEORDERS = "tableOrders"
    }
}