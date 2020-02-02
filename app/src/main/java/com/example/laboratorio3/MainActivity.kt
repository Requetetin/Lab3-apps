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

        binding.initialText="Nombre"
        binding.editText="Ingrese su nombre"

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        var comment:String? = " "
        comment = intent.getStringExtra(SEND_BACK_MESSAGE)
        if(comment!= " "){
            showToast(comment)
        }




    }

    fun showName(view: View) {
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
    fun showToast(comment:String?){
        Toast.makeText(this, comment, Toast.LENGTH_LONG).show()


    }
}
