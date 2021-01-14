package sheridan.sharmupm.restmanagerapplication.application.models

import com.google.firebase.firestore.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class KitchenTicket(
    var itemComplete: Boolean = false,
    var itemOrder: Int? = null,
    var orderCount: Int? = null,
    var stationType: String? = null,
    var dateTimeStamp: Date? = null,
) {
    companion object {
        const val FIELD_ITEMCOMPLETE = "itemComplete"
        const val FIELD_ITEMORDER = "itemOrder"
        const val FIELD_ORDERCOUNT = "orderCount"
        const val FIELD_STATIONTYPE = "stationType"
        const val FIELD_DATETIMESTAMP = "dateTimeStamp"
    }
}