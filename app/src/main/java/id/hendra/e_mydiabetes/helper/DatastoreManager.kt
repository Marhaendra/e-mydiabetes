package id.hendra.e_mydiabetes.helper

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DatastoreManager(private val context: Context) {

    companion object{
        private const val DATA_STORE_NAME = "datastore_preference"
        private val LOGINSTATE_KEY = booleanPreferencesKey("loginstate_key")
        private val Context.dataStore by preferencesDataStore(name = DATA_STORE_NAME)

        private val NAME = stringPreferencesKey("name")
    }

    suspend fun saveLoginStateToDataStore(value: Boolean) {
        context.dataStore.edit { pref ->
            pref[LOGINSTATE_KEY] = value
        }
    }

    fun readLoginStateFromDataStore(): Flow<Boolean> {
        return context.dataStore.data.map { pref ->
            pref[LOGINSTATE_KEY] ?: false
        }
    }

    suspend fun saveNameToDataStore(value: String) {
        context.dataStore.edit { pref ->
            pref[NAME] = value
        }
    }

    fun readNameFromDataStore(): Flow<String> {
        return context.dataStore.data.map { pref ->
            pref[NAME] ?: "default value"
        }
    }

}