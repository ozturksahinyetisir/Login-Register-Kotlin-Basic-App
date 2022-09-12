package com.dag.odev2fmss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dag.odev2fmss.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegisterBinding
    private lateinit var MainIntent: Intent
    private lateinit var LoginIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MainIntent = Intent(this,MainActivity::class.java)
        LoginIntent = Intent(this,LoginActivity::class.java)

        /**
         * emailveri &usernameveri & passwordveri parameters get texts and to string for possibility get integer
         * @param editor edit userdata.xml with using empty blanks writing new texts and apply it.
         */

        binding.backImageButton2.setOnClickListener{
            startActivity(MainIntent)
        }
        binding.SignUpButton.setOnClickListener{
            var emailveri = binding.editEmail.text.toString()
            var usernameveri = binding.editName.text.toString()
            var passwordveri = binding.editPassword.text.toString()
            
            var SharedPreferences = this.getSharedPreferences("userdata", MODE_PRIVATE)
            var editor = SharedPreferences.edit()


            
            editor.putString("emailid","$emailveri").apply()
            editor.putString("usernameid","$usernameveri").apply()
            editor.putString("pword","$passwordveri").apply()
            Toast.makeText(applicationContext, "Register Successful", Toast.LENGTH_LONG).show()
            startActivity(LoginIntent)
            /**
             * .clear cleans all blanks after login or register
             */

            binding.editName.text.clear()
            binding.editEmail.text.clear()
            binding.editPassword.text.clear()


        }
    }
}