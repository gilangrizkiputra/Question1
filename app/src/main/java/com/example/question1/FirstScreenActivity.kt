package com.example.question1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class FirstScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)

        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextSentence: EditText = findViewById(R.id.editTextSentence)
        val btnCheck: Button = findViewById(R.id.btnCheck)
        val btnNext: Button = findViewById(R.id.btnNext)

        btnCheck.setOnClickListener {
            val name = editTextName.text.toString()
            val sentence = editTextSentence.text.toString()

            val isPalindrome = isPalindrome(sentence)

            val message = if (isPalindrome) "IsPalindrome" else "Not Palindrome"
            showMessageDialog(message)
        }

        btnNext.setOnClickListener {
            val name = editTextName.text.toString()
            val intent = Intent(this, SecondScreenActivity::class.java)
            intent.putExtra("FIRST_NAME", name)
            startActivity(intent)
        }
    }

    private fun isPalindrome(text: String): Boolean {
        val cleanText = text.replace("\\s".toRegex(), "")
        val reversedText = cleanText.reversed()
        return cleanText.equals(reversedText, ignoreCase = true)
    }

    private fun showMessageDialog(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
        val alertDialog = builder.create()
        alertDialog.show()
    }
}
