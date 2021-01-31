package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.assignment1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val countSave = "CountSave"
    private var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.txtCount.text = count.toString()

        binding.btnToast.setOnClickListener{
            toast()
        }
        binding.btnCoundDown.setOnClickListener{
            countDown()
        }
        binding.btnCountUp.setOnClickListener{
            countUp()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("MyTag", "onSaveInstanceState")

        outState.putInt(countSave, binding.txtCount.text.toString().toInt())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("MyTag", "onRestoreInstanceState")

        val cnt = savedInstanceState.getInt(countSave)
        binding.txtCount.text = cnt.toString()
    }


    private fun toast(){
        Toast.makeText(applicationContext, binding.txtCount.text.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun countUp()
    {
        binding.txtCount.text = (binding.txtCount.text.toString().toInt() + 1).toString()
    }

    private fun countDown(){
        binding.txtCount.text = (binding.txtCount.text.toString().toInt() - 1).toString()
    }

}