package sheridan.sharmupm.assignment3.network

import java.io.Serializable

data class FlowerJson(
        val label: String,
        val price: String,
        val text: String,
        val pictures: PicturesJson):Serializable