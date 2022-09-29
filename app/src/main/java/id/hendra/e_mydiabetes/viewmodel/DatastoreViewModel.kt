package id.hendra.e_mydiabetes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import id.hendra.e_mydiabetes.helper.DatastoreManager
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DatastoreViewModel @Inject constructor(private val pref: DatastoreManager) : ViewModel() {
    fun saveLoginState(value: Boolean) {
        viewModelScope.launch {
            pref.saveLoginStateToDataStore(value)
        }
    }

    fun getLoginState(): LiveData<Boolean> {
        return pref.readLoginStateFromDataStore().asLiveData()
    }

    fun saveName(value: String){
        viewModelScope.launch {
            pref.saveNameToDataStore(value)
        }
    }
}