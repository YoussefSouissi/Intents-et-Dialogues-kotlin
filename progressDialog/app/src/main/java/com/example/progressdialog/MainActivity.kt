package com.example.progressdialog

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var btn: Button
    lateinit var nom: EditText
    lateinit var prenom: EditText
    lateinit var mail: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn = findViewById(R.id.myButton)
        nom = findViewById(R.id.nom)
        prenom = findViewById(R.id.prenom)
        mail = findViewById(R.id.email)

        btn.setOnClickListener {
            if (nom.text.isEmpty() || prenom.text.isEmpty() || mail.text.isEmpty()) {
                val snack = Snackbar.make(it, "Connexion impossible ", Snackbar.LENGTH_LONG)

                snack.show()
            }
                else{
                    valider()
                }

        }
    }

    private fun valider() {


            val progressDialog = ProgressDialog(this@MainActivity)
            progressDialog.setTitle("Kotlin Progress Dialog")
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
            progressDialog.setMessage("Downloading music, please wait")
            progressDialog.setIndeterminate(true)
            progressDialog.setProgress(0)
            progressDialog.show()
            Toast.makeText(this, "La tâche est accomplie", Toast.LENGTH_SHORT).show()
        }
    }


