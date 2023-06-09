package com.android.lifeassistant.core.util.resources

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.android.lifeassistant.core.data.local.dataStore.dataStore

suspend fun <T> Context.baseWriteFlowResource(key: Preferences.Key<T>, data: T) {
    dataStore.edit { preferences ->
        preferences[key] = data
    }
}