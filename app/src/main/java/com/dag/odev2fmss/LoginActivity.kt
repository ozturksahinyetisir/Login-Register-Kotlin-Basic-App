package com.dag.odev2fmss

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dag.odev2fmss.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {


    private lateinit var binding:ActivityLoginBinding
    private lateinit var MainIntent: Intent
    private lateinit var RegisterIntent: Intent
    private lateinit var LastIntent: Intent
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /**
         * @param LastIntent for LastActivity intent
         * @param MainIntent for MainActivity intent
         * @param RegisterIntent for RegisterActivity intent
         */
        LastIntent = Intent(this,LastActivity::class.java)
        MainIntent = Intent(this,MainActivity::class.java)
        RegisterIntent = Intent(this,RegisterActivity::class.java)
        /**
         * @param regPage create new account textview to direct RegisterActivity
         */
        val regPage = findViewById(R.id.orCreateNewText) as TextView
        /**
         * @param preferences create sharedPreferences name of userdata.xml at local data
         * @param usernameveri get strings to usernameid inside of userdata.xml
         * @param passwordveri get strings to pword
         */
        preferences = getSharedPreferences("userdata", MODE_PRIVATE)

        regPage.setOnClickListener{
            startActivity(RegisterIntent)
        }
        binding.loginImageButton.setOnClickListener {
            var usernameveri = preferences.getString("usernameid","")
            var passwordveri = preferences.getString("pword","")

            var loginUsername = binding.usernameLayout.text.toString()
            var loginPw = binding.passwordLayout.text.toString()

            /**
             * if username or password empty at first time and userdata.xml not created yet get toast message " Go Register Page.
             * else if loginUsername variables are empty creates toast message " username & password cannot be left blank. "
             * else if username & passwords match with userdata.xml login is successful and open LastIntent activity. "
             * else id & password not matchs with userdata.xml get toast message "incorrect id or password."
             */

            if((loginUsername == "") && (loginPw == "")){
                Toast.makeText(this, "Go Register Page", Toast.LENGTH_SHORT).show()
            }else if((loginUsername.isEmpty()) || loginPw.isEmpty()) {
                Toast.makeText(this, "username & password cannot be left blank ", Toast.LENGTH_SHORT).show()
            }else if((usernameveri == loginUsername) && (passwordveri == loginPw)){
                startActivity(LastIntent)
            }else{
                Toast.makeText(this, "Incorrect id or password", Toast.LENGTH_SHORT).show()
            }
            binding.backButton.setOnClickListener {
                startActivity(MainIntent)
            }


        }
        }
        }

