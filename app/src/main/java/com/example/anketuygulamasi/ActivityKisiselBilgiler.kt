package com.example.anketuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.anketuygulamasi.databinding.ActivityKisiselBilgilerBinding

class ActivityKisiselBilgiler : AppCompatActivity() {

    private lateinit var binding: ActivityKisiselBilgilerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKisiselBilgilerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adSoyad = intent.getStringExtra("name")
        binding.nameTextView.text = Editable.Factory.getInstance().newEditable("Adınız-Soyadınız: $adSoyad")

        binding.nextButton.setOnClickListener {
            val adSoyad = binding.nameTextView.text.toString()
            val email = binding.emailEditText.text.toString()
            val phone = binding.phoneEditText.text.toString()

            val kisiselBilgiler = KisiselBilgiler(adSoyad, email, phone)

            val intent = Intent(this, ActivityCustom::class.java)
            intent.putExtra("kisiselBilgilerKey", kisiselBilgiler)
            startActivity(intent)
        }
    }

    }
