package com.example.laboratorio3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.laboratorio3.databinding.ActivityMainBinding

const val EXTRA_MESSAGE = "com.example.laboratorio3.MESSAGE"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.initialText="Nombre"//Da el texto al text y edit text
        binding.editText="Ingrese su nombre"

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN) //Mueve la pantalla si el teclado tapa el edit text


        val comment:String? = intent.getStringExtra(SEND_BACK_MESSAGE)
        showToast(comment)//Muestra el toast




    }

    fun showName(view: View) {
    /*
    Si esta el TextView del nombre, lo esconde y esconde el editText y muestra el nuevo textView con el nombre ingresado y viceversa
    */
        if(binding.nameText.getVisibility() == View.VISIBLE){
            binding.nameInput = binding.nameInsert.getText().toString()
            binding.nameText.setVisibility(View.INVISIBLE)
            binding.nameInsert.setVisibility(View.INVISIBLE)
            binding.nameShown.setVisibility(View.VISIBLE)
        }else{
            binding.nameText.setVisibility(View.VISIBLE)
            binding.nameInsert.setVisibility(View.VISIBLE)
            binding.nameShown.setVisibility(View.INVISIBLE)
        }

        
    }
    /*
    Los tres botones abren la otra actividad, pero envian el lugar al que corresponden para mostrar la info correcta
     */
    fun changeTikal(view: View){

        val int= Intent(this, Main2Activity::class.java).apply {
            putExtra(EXTRA_MESSAGE, "Tikal")
        }


        startActivity(int)
        finish()
    }
    fun changeAtitlan(view: View){

        val int= Intent(this, Main2Activity::class.java).apply {
            putExtra(EXTRA_MESSAGE, "Atitlan")
        }


        startActivity(int)
        finish()
    }
    fun changeIzabal(view: View){
        val int= Intent(this, Main2Activity::class.java).apply {
            putExtra(EXTRA_MESSAGE, "Izabal")
        }


        startActivity(int)
        finish()
    }
    /*
    Muestra el Toast que regreso de la otra actividad
     */
    fun showToast(comment:String?){
        Toast.makeText(this, comment, Toast.LENGTH_LONG).show()


    }
}
