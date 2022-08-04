package com.example.qr_code

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder

class MainActivity : AppCompatActivity() {
    var im: ImageView? = null
    var bGenerate: Button? = null
    var bScanner: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        im = findViewById(R.id.imageView)
        val edT: EditText = findViewById(R.id.editText)
        bScanner = findViewById(R.id.bScan)
        bScanner?.setOnClickListener {
            startActivity(Intent(this, Scanner::class.java))
        }
        bGenerate = findViewById(R.id.button)
        bGenerate?.setOnClickListener {
            try {
                val barcodeEncode: BarcodeEncoder = BarcodeEncoder()
                val bitmap : Bitmap = barcodeEncode.encodeBitmap(edT.getText().toString(), BarcodeFormat.QR_CODE, 750, 750)
                im?.setImageBitmap(bitmap)
            } catch (e: WriterException){}

        }
    }
}