package sheridan.sharmupm.assignment3.domain

import android.os.Parcelable
import java.io.Serializable
data class Flower(
    val label: String,
    val price: String,
    val text: String,
    val picture: String,
    val pictureSmall: String,
    val id: Long = 0L
):Serializable