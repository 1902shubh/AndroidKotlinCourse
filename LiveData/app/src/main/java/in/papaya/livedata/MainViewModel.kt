package `in`.papaya.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var text = MutableLiveData<String>()
    var btnText = MutableLiveData<String>()

    init {
        text.value = "Hey, Subscribe our channel \n Papaya Coders"
        btnText.value = "Subscribe"
    }

    fun updateText() {
        text.value = "Welcome, to our Community \nPapaya Coders"
        btnText.value = "Subscribed"
    }
}