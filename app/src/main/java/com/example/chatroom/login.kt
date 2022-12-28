package com.example.chatroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.mbms.MbmsErrors.StreamingErrors
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.ktx.Firebase

class login : AppCompatActivity() {
    private lateinit var edtEmail:EditText;
    private lateinit var edtpassword:EditText;
    private lateinit var btnlogin:Button;
    private lateinit var btnsignup:Button;

     private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        edtEmail =findViewById(R.id.email)
        edtpassword =findViewById(R.id.password)
        btnlogin =findViewById(R.id.login)
        btnsignup=findViewById(R.id.signin)

        btnsignup.setOnClickListener{
            val intent= Intent(this, signup::class.java)
            startActivity(intent)
        }
        btnlogin.setOnClickListener{
          val emails = edtEmail.text.toString()
            val passwords = edtpassword.text.toString()
            logins(emails, passwords)
        }

      }
       private fun logins(emails : String ,passwords : String){
           mAuth.signInWithEmailAndPassword(emails, passwords)
               .addOnCompleteListener(this) { task ->
                   if (task.isSuccessful) {
                       val intent = Intent(this@login,MainActivity::class.java )
                       startActivity(intent)
                   } else {
                       Toast.makeText(this@login, "invalid cradentials boii", Toast.LENGTH_SHORT).show()

                   }
               }
       }






}
