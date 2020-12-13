package com.srirahayuningsih.obajushop.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val name : String,
    val age : String,
    val email : String
    ) : Parcelable
