package com.example.registeractivity

import android.content.Intent
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

        buttonSave.setOnClickListener {
            navigasiProfil()
        }

        edtName = findViewById(R.id.editName)
        spnnnerGender = findViewById(R.id.spinnerGender)
        edtEmail = findViewById(R.id.editEmail)
        edtTelp = findViewById(R.id.editTelp)
        edtAddress = findViewById(R.id.editAddress)

        getDataSpinner()
    }

    fun navigasiProfil(){
        val namaInput = editName.text
        val emailInput = editEmail.text
        val telpInput = editTelp.text
        val alamatInput= editAddress.text
        val genderInput = spinnerGender.selectedItem.toString()

        when {
            namaInput.isEmpty() -> editName.error = "Nama tidak boleh kosong"
            emailInput.isEmpty() -> editEmail.error = "Email tidak boleh kosong"
            telpInput.isEmpty() -> editTelp.error = "Telepon tidak boleh kosong"
            alamatInput.isEmpty() -> editAddress.error = "Alamat tidak boleh kosong"
            genderInput.equals("Pilih gender : ") -> Toast.makeText(this, "Jenis kelamin harus dipilih", Toast.LENGTH_SHORT).show()

            else -> {
                Toast.makeText(this, "Navigasi ke halaman profil", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, MyProfileActivity::class.java)
                val bundle = Bundle()

                bundle.putString("nama", namaInput.toString())
                bundle.putString("gender", genderInput)
                bundle.putString("alamat", alamatInput.toString())
                bundle.putString("email", emailInput.toString())
                bundle.putString("telp", telpInput.toString())

                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    fun getDataSpinner(){

        val adapter = ArrayAdapter.createFromResource(this, R.array.gender_list, android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinnerGender?.adapter = adapter

    }

}

