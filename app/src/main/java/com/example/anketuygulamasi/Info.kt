package com.example.anketuygulamasi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info(val personalInfo : KisiselBilgiler, val firstHobby : String, val secondHobby : String,
                    val thirdHobby : String) : Parcelable {
}