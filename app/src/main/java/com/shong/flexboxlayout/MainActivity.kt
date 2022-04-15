package com.shong.flexboxlayout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.shong.flexboxlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val flexboxAdapter = FlexboxAdapter()
        binding.flexboxRV.run {
            adapter = flexboxAdapter
            layoutManager = FlexboxLayoutManager(this@MainActivity).apply {
                flexDirection = FlexDirection.ROW
                justifyContent = JustifyContent.FLEX_START
            }
        }

        binding.createButton.setOnClickListener {
            val str = binding.createEditText.text.toString()
            if (str.isEmpty()) {
                Appbase.toastShow(this, "Add Name to EditText!", Toast.LENGTH_SHORT)
                return@setOnClickListener
            }
            binding.createEditText.setText("")
            flexboxAdapter.addList(str)
        }
    }
}