package com.example.app2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttondark= findViewById<Button>(R.id.btndark)
        val buttonlight= findViewById<Button>(R.id.btnlight)
        val layout= findViewById<LinearLayout>(R.id.linearLayout)
        val opencamera= findViewById<Button>(R.id.btncamera)
        val openbrowser= findViewById<Button>(R.id.btnbrowser)

        buttondark.setOnClickListener{
            layout.setBackgroundResource(R.color.black)

        }
         buttonlight.setOnClickListener{
            layout.setBackgroundResource(R.color.yellow)

        }
        opencamera.setOnClickListener {
            val intent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
        openbrowser.setOnClickListener {
            val intent= Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse("https://www.youtube.com/playlist?list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ")
            startActivity(intent)
        }
        val openWhatsAppButton: Button = findViewById(R.id.btnwhatsapp)

        openWhatsAppButton.setOnClickListener {
            val phoneNumber = "9373864689" // Replace with the desired phone number
            val uri = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.whatsapp")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "WhatsApp is not installed.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}