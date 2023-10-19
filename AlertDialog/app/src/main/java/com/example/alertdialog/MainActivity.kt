package com.example.alertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var nomtxt: EditText
    lateinit var prenomtxt: EditText
    lateinit var mailtxt: EditText
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nomtxt = findViewById(R.id.nom)
        prenomtxt = findViewById(R.id.prenom)
        mailtxt = findViewById(R.id.email)
        btn = findViewById(R.id.myButton)

        btn.setOnClickListener {
            valider()
        }
    }

    private fun valider() {
        if (nomtxt.text.toString().isEmpty() || prenomtxt.text.toString().isEmpty() || mailtxt.text.toString().isEmpty()) {
            val ad: AlertDialog.Builder = AlertDialog.Builder(this)
            ad.setMessage("Les champs ne doivent pas être vides")
            ad.setTitle("Error")
            ad.setIcon(android.R.drawable.ic_dialog_alert)
            ad.setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int -> dialogInterface.dismiss() }
            val dialog = ad.create()
            dialog.show()
        } else {
            Toast.makeText(this, "Les champs sont tous remplis", Toast.LENGTH_SHORT).show()
        }
    }

}
