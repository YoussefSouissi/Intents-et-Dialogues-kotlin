package com.example.travailafaire_ex1

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.Calendar
import android.widget.DatePicker

class MainActivity : AppCompatActivity() {
    lateinit var nametxt: EditText
    lateinit var datenaisstxt: TextView
    lateinit var mailtxt: EditText
    lateinit var classeSpinner: Spinner
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nametxt = findViewById(R.id.name)
        datenaisstxt = findViewById(R.id.datenaiss)
        mailtxt = findViewById(R.id.email)
        classeSpinner = findViewById(R.id.classeSpinner)
        btn = findViewById(R.id.myButton)
        val classesArray = resources.getStringArray(R.array.classe)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, classesArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        classeSpinner.adapter = adapter
    }

    fun AddPerson(v: View) {
        val selectedClass = classeSpinner.selectedItem.toString()
        if (nametxt.text.toString().isEmpty() || datenaisstxt.text.toString().isEmpty() ||
            selectedClass.isEmpty() || mailtxt.text.toString().isEmpty()
        ) {
            val ad: AlertDialog.Builder = AlertDialog.Builder(this)
            ad.setMessage("Les champs ne doivent pas être vides")
            ad.setTitle("Error")
            ad.setIcon(android.R.drawable.ic_dialog_alert)
            ad.setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int -> dialogInterface.dismiss() }
            val dialog = ad.create()
            dialog.show()
            Toast.makeText(this, "Les champs ne doivent pas être vides", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name", nametxt.text.toString())
            intent.putExtra("date", datenaisstxt.text.toString())
            intent.putExtra("email", mailtxt.text.toString())
            intent.putExtra("class", selectedClass.toString())
            startActivity(intent)
        }
    }
    fun Calendrier(view: View) {
        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            // Update the selected date in the TextView
            val selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDay"
            datenaisstxt.text = selectedDate
        }, year, month, day)

        // Show the DatePickerDialog
        datePickerDialog.show()
    }
}
