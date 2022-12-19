package com.example.recyclerviewexinclass

//package com.example.firebaseauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

//import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var database : FirebaseDatabase


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //val tvKayitOl: TextView = findViewById(R.id.tvKayitOl)
        val et_Mail: TextView = findViewById(R.id.et_Mail)
        val et_Sifre: TextView = findViewById(R.id.et_Sifre)
        val et_Sifre_Tekrar: TextView = findViewById(R.id.et_Sifre_Tekrar)
        val btn_Kayit : Button = findViewById(R.id.btn_Kayit)
        val progressBar : ProgressBar = findViewById(R.id.progressBar)

        // Initialize Firebase Auth
        auth = Firebase.auth

        //Şifrenin aynı olduğunu kontrol için fonksiyon tanımlıyoruz.

        btn_Kayit.setOnClickListener {
            if(et_Mail.text.isNotEmpty() && et_Sifre.text.isNotEmpty() && et_Sifre_Tekrar.text.isNotEmpty()){
                if (et_Sifre.text.toString().equals(et_Sifre_Tekrar.text.toString())){

                    kullaniciKayit(et_Mail.text.toString(), et_Sifre.text.toString())

                }else{
                    Toast.makeText(this,"Şifreler aynı değil", Toast.LENGTH_SHORT).show()
                }

            }else{

                Toast.makeText(this,"Boş alanları doldurunuz", Toast.LENGTH_SHORT).show()
            }
        }
    }
    //Yeni kullanıcı kayıt konrolü için fonksiyon tanımlıyoruz.

    private fun kullaniciKayit(mail: String, sifre: String) {
        progressBarGoster()

        /*auth.createUserWithEmailAndPassword(mail, sifre)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                   // Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }*/

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail,sifre)
            .addOnCompleteListener(object:OnCompleteListener<AuthResult>{
                override fun onComplete(p0: Task<AuthResult>) {

                    if(p0.isSuccessful){

                        Toast.makeText(this@RegisterActivity,"Üye kaydedildi:"+FirebaseAuth.getInstance().currentUser?.email, Toast.LENGTH_SHORT).show()
                        mailGonder()
                        FirebaseAuth.getInstance().signOut()
                    }else{

                        Toast.makeText(this@RegisterActivity,"Üye kaydedilirken sorun oluştu:"+p0.exception?.message, Toast.LENGTH_SHORT).show()
                    }

                }

            })
        progressBarGizle()

    }

    //Mail onaylama işlemleri için bildirimleri/onaylama sürecini oluşturuyoruz.

    private fun mailGonder(){

        var kullanici=FirebaseAuth.getInstance().currentUser
        if (kullanici != null){

            kullanici.sendEmailVerification()
                .addOnCompleteListener(object : OnCompleteListener<Void>{
                    override fun onComplete(p0: Task<Void>) {
                        if(p0.isSuccessful){
                            Toast.makeText(this@RegisterActivity,"Mailinizi kontrol edin, mailinizi onaylayın", Toast.LENGTH_SHORT).show()

                        }else{

                            Toast.makeText(this@RegisterActivity,"Mail gönderilirken sorun oluştu "+p0.exception?.message, Toast.LENGTH_SHORT).show()

                        }
                    }

                })
        }
    }

    private fun progressBarGoster(){

        //progressBar.visibility = View.VISIBLE
    }
    private fun progressBarGizle(){
        //progressBar.visibility = View.INVISIBLE
    }
}