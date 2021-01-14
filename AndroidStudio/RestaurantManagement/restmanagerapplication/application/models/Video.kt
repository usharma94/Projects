package sheridan.sharmupm.restmanagerapplication.application.models

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class Video(
    var videoDescription: String? = null,
) {
    companion object {
        const val FIELD_VIDEODESCRIPTION = "videoDescription"
    }
}