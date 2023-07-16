package com.example.anketuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.anketuygulamasi.databinding.ActivityCustomBinding
import com.example.anketuygulamasi.databinding.ActivitySonuclarBinding

class ActivityCustom : AppCompatActivity() {

    private lateinit var binding : ActivityCustomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCustomBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val kisiselBilgiler = intent.getParcelableExtra<KisiselBilgiler>("kisiselBilgilerKey")
        val adSoyad = kisiselBilgiler?.adSoyad

        if (adSoyad.isNullOrBlank()) {
            binding.nameTextView.text = "Ad-Soyad Bulunamadı"
        } else {
            binding.nameTextView.text = adSoyad
        }

        binding.buttonNext.setOnClickListener {

            val personalInfos = kisiselBilgiler
            val hobby1 = binding.editTextHobby1.text.toString()
            val hobby2 = binding.editTextHobby2.text.toString()
            val hobby3 = binding.editTextHobby3.text.toString()

            val infos = Info(personalInfos!!, hobby1, hobby2, hobby3)

            val intent = Intent(this, ActivitySonuclar::class.java)

            intent.putExtra("allInfos", infos)

            startActivity(intent)
        }

    }
}