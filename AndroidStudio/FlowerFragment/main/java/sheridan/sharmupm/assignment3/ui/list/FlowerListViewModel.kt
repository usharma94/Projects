package sheridan.sharmupm.assignment3.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import sheridan.sharmupm.assignment3.domain.Flower
import sheridan.sharmupm.assignment3.network.FlowerDataApi
import sheridan.sharmupm.assignment3.network.FlowerJson

class FlowerListViewModel : ViewModel() {

    private var flowerListData: LiveData<List<Flower>>? = null
    // LiveData to handle navigation to the selected property
    private val _navigateToSelectedProperty = MutableLiveData<Flower>()
    val navigateToSelectedProperty: MutableLiveData<Flower>
        get() = _navigateToSelectedProperty

    fun getFlowers(): LiveData<List<Flower>> {
        return flowerListData ?: liveData {
            val catalog = FlowerDataApi.retrofitService.getCatalog()
            val flowers = catalog.flowers.mapIndexed { index, flowerJson ->
                flowerJson.asFlower(index)
            }
            emit(flowers)
            println(flowers)
        }.also {
            flowerListData = it
        }
    }

    fun displayPropertyDetails(marsProperty: Flower) {
        _navigateToSelectedProperty.value = marsProperty
    }
    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }

}

fun FlowerJson.asFlower(index: Int): Flower{
    return Flower(label, price, text, pictures.small, pictures.large, index.toLong())
}