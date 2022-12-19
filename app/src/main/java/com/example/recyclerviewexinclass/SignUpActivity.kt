package com.example.recyclerviewexinclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.recyclerviewexinclass.data.model.Users
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var database : FirebaseDatabase

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = Firebase.auth
        //auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        //Firebase.auth.signOut()

        val signUpName: EditText = findViewById(R.id.signUpName)
        val signUpEmail: EditText = findViewById(R.id.signUpEmail)
        val signUpPassword: EditText = findViewById(R.id.signUpPassword)

        val signUpPasswordLayout: TextInputLayout = findViewById(R.id.signUpPasswordLayout)
        val signUpBtn: Button = findViewById(R.id.signUpBtn)
        //val signUpProgressBar = findViewById(R.id.signUpProgressbar)




        signUpBtn.setOnClickListener {
            val name = signUpName.text.toString()
            val email = signUpEmail.text.toString()
            val password = signUpPassword.text.toString()

            /*val signUpText: TextView = findViewById(R.id.signUpText)

        signUpText.setOnClickListener{
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }*/
            signUpBtn.setOnClickListener{
                val intent = Intent(this,SignInActivity::class.java)
                startActivity(intent)
            }

            signUpPasswordLayout.isPasswordVisibilityToggleEnabled = true

            //signUpProgressBar.visibility = View.VISIBLE

            if(name.isEmpty() || email.isEmpty() || password.isEmpty() ) {
                if(name.isEmpty()) {
                    signUpName.error = "Enter your name"
                }
                if(email.isEmpty()) {
                    signUpEmail.error = "Enter your email address"
                }
                if(password.isEmpty()){
                    signUpPassword.error = "Enter your password"
                    signUpPasswordLayout.isPasswordVisibilityToggleEnabled = false
                }

                Toast.makeText(this, "Enter valid details", Toast.LENGTH_SHORT).show()

            }/*else if(email.matches (emailPattern.toRegex())){
                signUpEmail.error="Enter valid email address"
                Toast.makeText(this, "Enter valid email address", Toast.LENGTH_SHORT).show()
            }*/else{
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        val databaseRef = database.reference.child("users").child(auth.currentUser!!.uid) //todo
                        val users : Users = Users(name, email, auth.currentUser!!.uid)

                        databaseRef.setValue(users).addOnCompleteListener {
                            if(it.isSuccessful){
                                print("Something went wrong")
                                val intent = Intent(this, SignInActivity::class.java)
                                startActivity(intent)
                            }else{
                                print("Something went wrong1")
                                Toast.makeText(this, "Something went wrong1", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }else{
                        print("Something went wrong2")
                        Toast.makeText(this, "Something went wrong2", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }


    }
}