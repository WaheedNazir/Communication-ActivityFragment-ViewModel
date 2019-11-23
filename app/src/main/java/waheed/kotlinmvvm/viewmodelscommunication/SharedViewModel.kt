package waheed.kotlinmvvm.viewmodelscommunication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val data: MutableLiveData<String> = MutableLiveData()
    fun data(): LiveData<String> = data

    fun updateData(message: String) {
        data.value = message
    }

    init {
        // Setting default value
        data.value = "There should be your updated message."
    }
}
