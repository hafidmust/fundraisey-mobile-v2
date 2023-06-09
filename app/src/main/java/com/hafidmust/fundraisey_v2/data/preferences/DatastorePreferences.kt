package com.hafidmust.fundraisey_v2.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")
class DatastorePreferences (private val dataStore : DataStore<Preferences>){

    private val TOKEN_KEY = stringPreferencesKey("token_key")

    fun getToken() : Flow<String>{
        return dataStore.data.map {pref ->
            pref[TOKEN_KEY] ?: ""
        }
    }

    suspend fun saveToken(token : String) {
        dataStore.edit { pref ->
            pref[TOKEN_KEY] = token
        }
    }
    companion object {
        @Volatile
        private var INSTANCE: DatastorePreferences? = null

        fun getInstance(dataStore: DataStore<Preferences>): DatastorePreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = DatastorePreferences(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }

}