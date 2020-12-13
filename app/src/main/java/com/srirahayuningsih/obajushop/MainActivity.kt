package com.srirahayuningsih.obajushop

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.srirahayuningsih.obajushop.model.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE = 100

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_simple_intent = findViewById<Button>(R.id.btn_simple_intent)
        val btn_intent_with_data = findViewById<Button>(R.id.btn_intent_with_data)
        val btn_intent_parcelable = findViewById<Button>(R.id.btn_intent_parcelable)
        val btn_implicit_intent = findViewById<Button>(R.id.btn_implicit_intent)
        val btn_intent_result = findViewById<Button>(R.id.btn_intent_result)

        btn_simple_intent.setOnClickListener {
            val simpleIntent = Intent(this@MainActivity, SimpleActivity::class.java)
            startActivity(simpleIntent)
        }

        btn_intent_with_data.setOnClickListener {
            val dataIntent = Intent(this@MainActivity, ExplicitIntentActivity::class.java)
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_NAME, "Sri Rahayu Ningsih")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_AGE, "18 Tahun")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_EMAIL, "srirn161101@gmail.com")
            startActivity(dataIntent)
        }

        btn_intent_parcelable.setOnClickListener {
            val parcelIntent = Intent(this@MainActivity, ParcleActivity::class.java)

            val user = User("Sri Rahayu Ningsih", "18 Tahun", "srirn161101@gmail.com")
            parcelIntent.putExtra(ParcleActivity.EXTRA_USER, user)
            startActivity(parcelIntent)
        }

        btn_implicit_intent.setOnClickListener {
            val phoneNumber = "08123456789011"
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNumber"))
            intent.putExtra("sms_body", "Assalamu'alaikum")
            startActivity(intent)
        }

        btn_intent_result.setOnClickListener {
            val intent =Intent(this@MainActivity, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 200){
            val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
                Log.d("Color", color.toString())
            view_result.setBackgroundColor(Color.parseColor(color.toString()))
        }
    }
}