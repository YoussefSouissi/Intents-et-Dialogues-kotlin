package com.example.travailafaire_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var name: TextView
    lateinit var datenaiss: TextView
    lateinit var mail: TextView
    lateinit var classe: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        name = findViewById(R.id.nameview)
        datenaiss = findViewById(R.id.dateview)
        mail = findViewById(R.id.emailview)
        classe = findViewById(R.id.classview)

        val intent = intent
        if (intent.hasExtra("name") && intent.hasExtra("date") && intent.hasExtra("email") && intent.hasExtra("class")) {
            name.text = "Name: " + intent.getStringExtra("name")
            datenaiss.text = "Date of Birth: " + intent.getStringExtra("date")
            mail.text = "Email: " + intent.getStringExtra("email")
            classe.text = "Class: " + intent.getStringExtra("class")
        }
    }
    fun shareData(view: View) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"

        val shareBody = """
            Name: ${intent.getStringExtra("name")}
            Date of Birth: ${intent.getStringExtra("date")}
            Email: ${intent.getStringExtra("email")}
            Class: ${intent.getStringExtra("class")}
        """.trimIndent()

        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "Partager via"))
    }
}
