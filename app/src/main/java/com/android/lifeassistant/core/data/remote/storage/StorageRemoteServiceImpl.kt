package com.android.lifeassistant.core.data.remote.storage

import android.graphics.Bitmap
import android.net.Uri
import com.android.lifeassistant.core.domain.remote.storage.StorageRemoteService
import com.android.lifeassistant.core.util.event.ResponseState
import com.android.lifeassistant.feature.util.extension.toBitmap
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class StorageRemoteServiceImpl @Inject constructor(
    private val storageReference: StorageReference,
) : StorageRemoteService {

    override fun downloadProfileImageFromRemote(): Flow<ResponseState<Bitmap>> = callbackFlow {
        send(ResponseState.Loading)
        val ONE_MEGABYTE: Long = 1024 * 1024
        val storageRef = storageReference.storage.reference
        val pathRef = storageRef.child("users/cNlzvAprEuXSLNHgE7C1Y9u0iC22/profileImage.jpg")
        pathRef.getBytes(ONE_MEGABYTE)
            .addOnSuccessListener { image ->
                val bitmap = image.toBitmap()
                trySend(ResponseState.Success(bitmap))
            }.addOnFailureListener {
                trySend(ResponseState.Error(it))
            }
        awaitClose { }
    }

    override fun uploadProfileImageFromGallery(uri: Uri): Flow<ResponseState<StorageReference>> = callbackFlow {
        send(ResponseState.Loading)
        val storageRef = storageReference.storage.reference
        val pathRef = storageRef.child("users/cNlzvAprEuXSLNHgE7C1Y9u0iC22/profileImage.jpg")
        val uploadTask = pathRef.putFile(uri)
        uploadTask.addOnFailureListener {
            trySend(ResponseState.Error(it))
        }.addOnSuccessListener { snapShot ->
            trySend(ResponseState.Success(snapShot.storage))
        }
        awaitClose {}
    }


}