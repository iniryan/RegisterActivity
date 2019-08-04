package com.example.registeractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var edtName : EditText? = null
    var spnnnerGender : Spinner? = null
    var edtEmail : EditText? = null
    var edtTelp : EditText? = null
    var edtAddress : EditText? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.editName)
        spnnnerGender = findViewById(R.id.spinnerGender)
        edtEmail = findViewById(R.id.editEmail)
        edtTelp = findViewById(R.id.editTelp)
        edtAddress = findViewById(R.id.editAddress)

        buttonSave.setOnClickListener { validasiInput() }
        getDataSpinner()
    }

    fun getDataSpinner(){

        val adapter = ArrayAdapter.createFromResource(this, R.array.gender_list, android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinnerGender?.adapter = adapter

    }



    fun validasiInput(){


        val namaInput = edtName?.text.toString()
        val emailInput = edtEmail?.text.toString()
        val telpInput= edtTelp?.text.toString()
        val addressInput = edtAddress?.text.toString()
        val genderInput = spnnnerGender?.selectedItem.toString()

        when{
            genderInput.equals("Pilih gender") ->
                Toast.makeText( this,"Harap isi gender", Toast.LENGTH_SHORT).show()
            namaInput.isEmpty() -> edtName?.error = "Nama tidak boleh kosong"
            emailInput.isEmpty() -> edtEmail?.error = "Email tidak boleh kosong"
            telpInput.isEmpty() -> edtTelp?.error = "Telepon tidak boleh kosong"
            addressInput.isEmpty() -> edtAddress?.error = "Alamat tidak boleh kosong"

            else -> {
                Toast.makeText( this,"Data berhasil terkirim", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

