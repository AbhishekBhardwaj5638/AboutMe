package com.mobdeveloper.abhishek.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mobdeveloper.abhishek.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding

    private val myName : MyName = MyName("Abhishek Bhardwaj")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName


        binding.done.setOnClickListener{
            addNickName(it)
        }
    }

    private fun addNickName(view: View){


        binding.apply {
            //newNickName.text = binding.editNickName.text
            myName?.nickName  = newNickName.text.toString()
            invalidateAll()
            editNickName.visibility = View.GONE
            view.visibility = View.GONE
            newNickName.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)

    }
}
