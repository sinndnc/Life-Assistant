package com.android.lifeassistant.core.domain.repostitory.storage

import android.graphics.Bitmap
import android.net.Uri
import com.android.lifeassistant.core.util.event.ResponseState
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.flow.Flow

interface StorageRepository {

    fun downloadProfileImageFromRemote(): Flow<ResponseState<Bitmap>>

    fun uploadProfileImageFromGallery(uri: Uri): Flow<ResponseState<StorageReference>>
}