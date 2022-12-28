package com.example.chatroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


class signup : AppCompatActivity() {
    private lateinit var edtname: EditText;
    private lateinit var edtEmail: EditText;
    private lateinit var edtpassword: EditText;
    private lateinit var btnsignup: Button;

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        mAuth = FirebaseAuth.getInstance()
        edtEmail =findViewById(R.id.email)
        edtEmail =findViewById(R.id.email)
        edtname = findViewById(R.id.name)
        edtpassword =findViewById(R.id.password)
       btnsignup = findViewById(R.id.signup)


        btnsignup.setOnClickListener{
            val emails = edtEmail.text.toString()
            val password = edtpassword.text.toString()
      signups(emails,password)
        }
    }
    private fun signups(email:String, password:String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this@signup,MainActivity::class.java )
                    startActivity(intent)
                } else {
                    Toast.makeText(this@signup, "go home kid", Toast.LENGTH_SHORT).show()
                }
            }
    }

}