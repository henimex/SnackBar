package com.example.snackbarkullanimi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnN.setOnClickListener { nesne_view ->
            Snackbar.make(nesne_view, "Connection Type: Local Network", Snackbar.LENGTH_LONG).show()
        }

        btnR.setOnClickListener { x ->
            Snackbar.make(x, "Switch Connection Type", Snackbar.LENGTH_LONG)
                    .setAction("Yes") { y ->
                        Toast.makeText(this@MainActivity, "Connection Type Changed To WLAN", Toast.LENGTH_SHORT).show()
                        Snackbar.make(y, "Connection Type: WLAN", Snackbar.LENGTH_LONG).setTextColor(Color.GREEN).show()
                    }
                    .setActionTextColor(Color.RED)
                    .setBackgroundTint(Color.DKGRAY)
                    .show()
        }

        btnS.setOnClickListener {x ->
            val sb = Snackbar.make(x,"Customization Already Complated",Snackbar.LENGTH_LONG)
                    .setTextColor(Color.WHITE)
                    .setBackgroundTint(Color.RED)

                    sb.setAction("Yep"){

                    }

                    sb.setActionTextColor(Color.BLUE)

            sb.show()
        }

        btnAct.setOnClickListener {x ->
            val ad = edtName.text.toString().trim()
            val tel = edtNumber.text.toString().trim()

            if (TextUtils.isEmpty(ad)){
                Toast.makeText(this@MainActivity,"Lütfen İsminizi Giriniz", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(tel)){
                Toast.makeText(this@MainActivity,"Telefon Numarası Olmadan Kayıt Tamamlanamaz.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (tel.length > 10){
                Toast.makeText(this@MainActivity,"Telefon Numaranız 10 Haneden Fazla Olamaz.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (tel.length < 10){
                Toast.makeText(this@MainActivity,"Telefon Numaranız en az 10 Haneli Olmalıdır.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            Snackbar.make(x,"Ad : $ad | Tel : $tel Listeye Eklendi",Snackbar.LENGTH_LONG).setTextColor(Color.GREEN).show()
        }
    }
}