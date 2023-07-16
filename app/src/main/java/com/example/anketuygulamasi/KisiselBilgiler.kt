package com.example.anketuygulamasi


import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize

@Parcelize
data class KisiselBilgiler(
    val adSoyad: String,
    val email: String,
    val phone: String
) : Parcelable