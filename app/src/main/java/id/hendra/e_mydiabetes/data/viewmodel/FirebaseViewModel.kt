package id.hendra.e_mydiabetes.data.viewmodel

import android.util.Patterns
import androidx.lifecycle.*
import com.google.firebase.auth.AuthResult
import id.hendra.e_mydiabetes.data.repository.FirebaseRepository
import id.hendra.e_mydiabetes.helper.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirebaseViewModel : ViewModel() {

    private val _userRegistrationStatus = MutableLiveData<Resource<AuthResult>>()
    val userRegistrationStatus: LiveData<Resource<AuthResult>> = _userRegistrationStatus

    private val _userLoginStatus = MutableLiveData<Resource<AuthResult>>()
    val userLoginStatus: LiveData<Resource<AuthResult>> = _userLoginStatus

    private val firebaseRepo = FirebaseRepository()

    fun register(name: String, email: String, password: String) {
        val error =
            if (email.isEmpty() || name.isEmpty() || password.isEmpty()) {
                "Masih Ada Kolom Kosong"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                "Email Tidak Valid"
            } else null

        error?.let {
            _userRegistrationStatus.postValue(Resource.Error(it))
            return
        }
        _userRegistrationStatus.postValue(Resource.Loading())

        viewModelScope.launch(Dispatchers.Main) {
            val registerResult = firebaseRepo.register(name = name, email = email, password = password)
            _userRegistrationStatus.postValue(registerResult)
        }
    }

    fun login(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _userLoginStatus.postValue(Resource.Error("Email dan Password Harus Diisi"))
        } else {
            _userLoginStatus.postValue(Resource.Loading())
            viewModelScope.launch(Dispatchers.Main) {
                val loginResult = firebaseRepo.login(email, password)
                _userLoginStatus.postValue(loginResult)
            }
        }
    }
}