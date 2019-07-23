package com.harman.vsimakov2.aboutme

import android.content.Context
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager

import com.harman.vsimakov2.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val name: MyName = MyName("Ed Newton")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = name
        binding.done.setOnClickListener{
            addNickname(it)
        }
    }

    private fun addNickname(view : View){
        binding.apply {
            binding.nicknameText.text = binding.nameId.text

            //myName?nickName = nicknameText.text.toString()
            invalidateAll()
            binding.nameId.visibility = View.GONE
            binding.done.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
