package sheridan.sharmupm.restmanagerapplication.application.models

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class Report(
    var reportDescription: String? = null,
    var itemOrderCount: Int? = null,
    var totalEarnings: Float? = null,
) {
    companion object {
        const val FIELD_REPORTDESCRIPTION = "reportDescription"
        const val FIELD_ORDERCOUNT = "orderCount"
        const val FIELD_TOTALEARNINGS = "totalEarnings"
    }
}