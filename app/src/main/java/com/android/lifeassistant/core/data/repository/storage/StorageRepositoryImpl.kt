package com.android.lifeassistant.core.data.repository.storage

import android.graphics.Bitmap
import android.net.Uri
import com.android.lifeassistant.core.domain.remote.storage.StorageRemoteService
import com.android.lifeassistant.core.domain.repostitory.storage.StorageRepository
import com.android.lifeassistant.core.util.event.ResponseState
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(
    private val storageRemoteService: StorageRemoteService,
) : StorageRepository {

    override fun uploadProfileImageFromGallery(uri: Uri): Flow<ResponseState<StorageReference>> =
        storageRemoteService.uploadProfileImageFromGallery(uri)


    override fun downloadProfileImageFromRemote(): Flow<ResponseState<Bitmap>> =
        storageRemoteService.downloadProfileImageFromRemote()

}