package com.gmail.maystruks08.data.remote

import com.gmail.maystruks08.data.remote.pojo.DefaultPojo
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot

interface DefaultApi{

    suspend fun getDefaultEntityPojo(): List<DefaultPojo>

}