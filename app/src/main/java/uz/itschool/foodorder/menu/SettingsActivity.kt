package uz.itschool.foodorder.menu

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import uz.itschool.foodorder.Login
import uz.itschool.foodorder.MainActivity
import uz.itschool.foodorder.R


class SettingsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        var home: TextView = findViewById(R.id.home)
        var cart: TextView = findViewById(R.id.cart)
        var profile: TextView = findViewById(R.id.profile)
        var settings: TextView = findViewById(R.id.settings)

        val logout: Button = findViewById(R.id.logout)
        logout.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        home.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        settings.setOnClickListener {
            var intent = Intent(this,SettingsActivity::class.java)
            startActivity(intent)
        }

    }
}