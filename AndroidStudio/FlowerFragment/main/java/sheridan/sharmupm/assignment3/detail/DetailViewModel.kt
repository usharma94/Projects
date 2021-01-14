package sheridan.sharmupm.assignment3.detail

import android.app.Application
import androidx.lifecycle.*
import sheridan.sharmupm.assignment3.domain.Flower
import sheridan.sharmupm.assignment3.network.FlowerJson

class DetailViewModel( flowerProperty: Flower,
                       app: Application
) : AndroidViewModel(app) {

    // The internal MutableLiveData for the selected property
    private val _selectedProperty = MutableLiveData<Flower>()

    // The external LiveData for the SelectedProperty
    val selectedProperty: LiveData<Flower>
        get() = _selectedProperty

    // Initialize the _selectedProperty MutableLiveData
    init {
        _selectedProperty.value = flowerProperty
    }

}