package uz.itschool.foodorder.menu

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import uz.itschool.foodorder.Login
import uz.itschool.foodorder.MainActivity
import uz.itschool.foodorder.R
import java.util.*


class SettingsActivity : AppCompatActivity() {

    lateinit var locale: Locale
    private var currentLanguage = "en"
    private var currentLang: String? = null
    var spinner:Spinner = findViewById(R.id.spinner)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        currentLanguage = intent.getStringExtra(currentLang).toString()

        var list = mutableListOf<String>()

        list.add("Select Language")
        list.add("English")
        list.add("Uzbek")

        val adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                when (position) {
                    0 -> {
                    }
                    1 -> setLocale("en")
                    2 -> setLocale("uz")
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }


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

    private fun setLocale(localeName: String) {
        if (localeName != currentLanguage) {
            locale = Locale(localeName)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = locale
            res.updateConfiguration(conf, dm)
            val refresh = Intent(
                this,
                MainActivity::class.java
            )
            refresh.putExtra(currentLang, localeName)
            startActivity(refresh)
        } else {
            Toast.makeText(
                this, "Language, , already, , selected)!", Toast.LENGTH_SHORT).show();
        }
    }
}