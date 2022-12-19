package com.example.recyclerviewexinclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.recyclerviewexinclass.data.model.Users
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val emailPattern = "[a-zA-Z0-9._-]+[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val signInEmail: EditText = findViewById(R.id.signInEmail)
        val signInPassword: EditText = findViewById(R.id.signInPassword)
        val signInPasswordLayout: TextInputLayout = findViewById(R.id.signInPasswordLayout)
        val signInBtn : Button = findViewById(R.id.signInBtn)

        /*
        val signUpText TextView findViewById(R.id.signUp Text)
        signUpText.setOnClickListener { it: View!
            val intent Intent( packageContext: this, SignUpActivity::class.java)
            startActivity (intent)
        }*/
        /*signInBtn.setOnClickListener{
            val intent = Intent(this,ItemLayoutFragment::class.java)
            startActivity(intent)
        }*/

        signInBtn.setOnClickListener {

            signInPasswordLayout.isPasswordVisibilityToggleEnabled = true

            val email = signInEmail.text.toString()
            val password = signInPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                if (email.isEmpty()) {
                    signInEmail.error = "Enter your email address"
                }
                if (password.isEmpty()) {
                    signInPassword.error = "Enter your password"
                    signInPasswordLayout.isPasswordVisibilityToggleEnabled = false
                }

                Toast.makeText(this, "Enter valid details", Toast.LENGTH_SHORT).show()
            }/*else if(email.matches (emailPattern.toRegex())){
                signUpEmail.error="Enter valid email address"
                Toast.makeText(this, "Enter valid email address", Toast.LENGTH_SHORT).show()
            }*/
            else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "Something went wrong1", Toast.LENGTH_SHORT).show()

                    }

        }}}}
}