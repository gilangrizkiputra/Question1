package com.example.question1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.question1.databinding.ActivitySecondScreenBinding

class SecondScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_second_screen)
        initUI()

        binding.btnChooseUser.setOnClickListener {
            val intent = Intent(this, ThirdScreenActivity::class.java)
            startActivity(intent)
        }
    }


    private fun initUI() {
        binding.customToolbar.ivBack.setOnClickListener {
            // Kembali ke halaman sebelumnya
            onBackPressed()
        }
//        binding.customToolbar.ivBack.setOnClickListener{
//            Toast.makeText(this, "back button clicked", Toast.LENGTH_SHORT).show()
//        }
    }
}
