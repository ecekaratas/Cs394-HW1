package com.example.recyclerviewexinclass

//package com.example.firebaseauth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var mAuthStateListener : FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initAuthStateListener()

        val tvKayitOl: TextView = findViewById(R.id.tvKayitOl)
        val et_Mail: TextView = findViewById(R.id.et_Mail)
        val et_Sifre: TextView = findViewById(R.id.et_Sifre)
        val  btn_Giris : Button = findViewById(R.id.btn_Giris)
        val progress_Login : ProgressBar = findViewById(R.id.progress_Login)


        //val signInEmail: EditText = findViewById(R.id.signInEmail)
        //Kayıt ol butonunun işlevi için fonksiyon tanımlıyoruz.

        tvKayitOl.setOnClickListener{

            var intent=Intent(this,RegisterActivity::class.java)
            startActivity(intent)
            /*var intent=Intent(this,ItemLayoutFragment::class.java)
            startActivity(intent)*/
        }
        //Giriş butonunun işlevi için fonksiyon tanımlıyoruz.

        btn_Giris.setOnClickListener {

            var intent=Intent(this,BlankActivity2::class.java)
            startActivity(intent)

            /*val navController = findNavController(R.id.loginActivity)
            navController.navigateUp() // to clear previous navigation history
            navController.navigate(R.id.itemLayoutFragment)
*/
            if (et_Mail.text.isNotEmpty() && et_Sifre.text.isNotEmpty()){

                progressBarGoster()

                // Firebase kütüphanesinden email ve password parametrelerine tanımladığımız edit textleri Stringe çeviriyoruz.

                FirebaseAuth.getInstance().signInWithEmailAndPassword(et_Mail.text.toString(),et_Sifre.text.toString())

                    .addOnCompleteListener(object:OnCompleteListener<AuthResult>{


                        // Kullanıcı başarılı giriş yaptığında bildirim oluşturuyoruz.

                        override fun onComplete(p0: Task<AuthResult>) {

                            if(p0.isSuccessful){

                                progressBarGizle()

                                Toast.makeText(this@LoginActivity,"Başarılı Giriş: "+FirebaseAuth.getInstance().currentUser?.email, Toast.LENGTH_SHORT).show()

                                fun alert(context: Context, text: String) {
                                    val intent = Intent(context, ItemLayoutFragment::class.java)
                                    intent.putExtra("text", text)
                                    context.startActivity(intent)
                                }
/*
                                val navController = findNavController(R.id.loginPageFragment)
                                navController.navigateUp() // to clear previous navigation history
                                navController.navigate(R.id.itemLayoutFragment)*/

                                FirebaseAuth.getInstance().signOut()


                                /*var intent=Intent(this,ItemLayoutFragment::class.java)
                                startActivity(intent)*/

                            }else{

                                // Kullanıcı hatalı giriş yaptığında bildirim oluşturuyoruz.

                                progressBarGizle()
                                Toast.makeText(this@LoginActivity,"Hatalı Giriş: "+p0.exception?.message, Toast.LENGTH_SHORT).show()
                            }
                        }

                    })

            }else{
                // Kullanıcı alanı boş bıraktığında bildirim oluşturuyoruz.

                Toast.makeText(this@LoginActivity,"Boş alanları doldurunuz", Toast.LENGTH_SHORT).show()
            }

        }
    }

    //Progress bar/yükleme ikonunu fonksiyonlar ile tanımlıyoruz
    //Buton işlemine bağlı goster/gizle şeklinde iki fonksiyon tanımluyoruz.

    private fun progressBarGoster(){
        //progress_Login.visibility = View.VISIBLE
    }
    private fun progressBarGizle(){
       //progress_Login.visibility = View.INVISIBLE
    }

    // Mail onaylama işlemlerinin bildirimlerini ve kontrolünü sağlıyoruz.

    private fun initAuthStateListener(){

        mAuthStateListener=object : FirebaseAuth.AuthStateListener{
            override fun onAuthStateChanged(p0: FirebaseAuth) {
                var kullanici=p0.currentUser

                /*if (kullanici != null){

                   if(kullanici.isEmailVerified){
                        Toast.makeText(this@LoginActivity,"Mail onaylandı giriş yapabilirsiniz", Toast.LENGTH_SHORT).show()
                        var intent=Intent(this@LoginActivity,MainActivity::class.java)
                        startActivity(intent)
                        finish()

                    }else{
                      Toast.makeText(this@LoginActivity,"Mail adresinizi onaylamadan giriş yapamazsınız", Toast.LENGTH_SHORT).show()


                    }
                }*/
            }
        }
    }

    override fun onStart() {
        super.onStart()
        FirebaseAuth.getInstance().addAuthStateListener(mAuthStateListener)
    }

    override fun onStop() {
        super.onStop()
        FirebaseAuth.getInstance().removeAuthStateListener {mAuthStateListener}
    }
}