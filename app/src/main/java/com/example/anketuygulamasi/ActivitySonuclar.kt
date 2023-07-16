package com.example.anketuygulamasi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.anketuygulamasi.databinding.ActivityKisiselBilgilerBinding
import com.example.anketuygulamasi.databinding.ActivitySonuclarBinding

class ActivitySonuclar : AppCompatActivity() {

    private lateinit var binding: ActivitySonuclarBinding

    private var clickCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySonuclarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // tüm bilgiler bastırılsın
        getAllInfos()

        // Back Stack temizlenerek ilk sayfaya geri dönülsün
        binding.backToHome.setOnClickListener {
            goBackToHomePage()
        }
    }

    fun getAllInfos(){

        var allInfos = intent.getParcelableExtra<Info>("allInfos") as Info

        var personalInfos = "${allInfos.personalInfo.adSoyad}\n${allInfos.personalInfo.email}\n${allInfos.personalInfo.phone}"
        binding.personalInfos.text = personalInfos

        var hobbies = "${allInfos.firstHobby}\n${allInfos.secondHobby}\n${allInfos.thirdHobby}"
        binding.hobbies.text = hobbies
    }

    fun goBackToHomePage(){

        clickCounter++

        if(clickCounter == 1)
            toast("Ana Sayfaya dönmek için tekrar basınız.")
        else{
            // back stack tamamen temizlensin
            finishAffinity()

            // back stack temizlenince ilk ve tek aktivite olarak ilk sayfaya gidiş yaratılsın
            // bu sayede geri gidilince tek stack o olduğu için uygulamadan çıkılır
            var intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

    }

    fun Context.toast(message : CharSequence)
                    = Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}