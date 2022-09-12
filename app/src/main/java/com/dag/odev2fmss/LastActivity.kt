package com.dag.odev2fmss

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dag.odev2fmss.databinding.ActivityLastBinding

class LastActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLastBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /**
         * Change TextView with usernameveri who logged in and set it all done.
         */
        preferences = getSharedPreferences("userdata", MODE_PRIVATE)
        var usernameveri = preferences.getString("usernameid","")

        binding.kullanicitext.text = usernameveri.toString()

    }
}