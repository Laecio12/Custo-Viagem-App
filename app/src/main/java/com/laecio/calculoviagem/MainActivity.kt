package com.laecio.calculoviagem

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.laecio.calculoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fun clearForm() {
            binding.distance.setText("")
            binding.price.setText("")
            binding.autonomy.setText("")
        }

        fun showToast() {
            val text = R.string.txt_all_fields
            val duration = Toast.LENGTH_SHORT

            Toast.makeText(applicationContext, text, duration).show()

        }

        binding.btnCalc.setOnClickListener {
            val distance = binding.distance.text.toString()
            val price = binding.price.text.toString()
            val autonomy =  binding.autonomy.text.toString()

            if(distance.isEmpty() || price.isEmpty() || autonomy.isEmpty()) {
                showToast()
            } else{
                val total = (distance.toFloat() / autonomy.toFloat()) * price.toFloat()
                binding.total.text = "R$ ${String.format("%.2f", total).replace(".", ",")}"
                clearForm()
            }

        }


    }

}