package uz.itschool.foodorder

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.itschool.foodorder.template.User
import java.util.*

class Registration : AppCompatActivity() {

    lateinit var reg: Button
    lateinit var name: TextInputEditText
    lateinit var username: TextInputEditText
    lateinit var phone: TextInputEditText
    lateinit var password: TextInputEditText
    lateinit var rep_password: TextInputEditText
    lateinit var spinner: Spinner

    private lateinit var userList: MutableList<User>

    lateinit var locale: Locale
    private var currentLanguage = "en"
    private var currentLang: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        initUI()
        
        currentLanguage = intent.getStringExtra(currentLang).toString()

        var list = mutableListOf<String>()

        list.add("Select Language")
        list.add("English")
        list.add("Uzbek")

        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list)
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
      spinner.adapter = adapter
      spinner.onItemSelectedListener = object : OnItemSelectedListener {
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

        val shared: SharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val edit = shared.edit()
        val gson = Gson()
        val convert = object : TypeToken<List<User>>() {}.type

        reg.setOnClickListener {
            if (validate()) {
                val users = shared.getString("users", "")

                if (users == "") {
                    userList = mutableListOf()
                } else {
                    userList = gson.fromJson(users, convert)

                }

                userList.add(
                    User(
                        name.text.toString(),
                        username.text.toString(),
                        phone.text.toString(),
                        password.text.toString()
                    )
                )

                val str = gson.toJson(userList)
                edit.putString("users", str).apply()

                val intent = Intent(this, Login::class.java)
                startActivity(intent)
            }
            if (!validate()) {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun initUI() {
        reg = findViewById(R.id.signup_reg)
        name = findViewById(R.id.name)
        username = findViewById(R.id.username)
        phone = findViewById(R.id.phone)
        password = findViewById(R.id.password)
        rep_password = findViewById(R.id.rep_password)
        spinner = findViewById(R.id.spinner)
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
         this@MainActivity, "Language, , already, , selected)!", Toast.LENGTH_SHORT).show();
      }
   }

    private fun validate(): Boolean {
        val shared: SharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val gson = Gson()
        val convert = object : TypeToken<List<User>>() {}.type

        val users = shared.getString("users", "")

        if (users == "") {
            userList = mutableListOf()
        } else {
            userList = gson.fromJson(users, convert)
        }

        if (name.text.toString() == "" || username.text.toString() == "" || phone.text.toString() == "" || password.text.toString() == "" || rep_password.text.toString() == "") {
            Toast.makeText(this, "Fill the form fully", Toast.LENGTH_SHORT).show()
            return false

        }
        if (password.text.toString() != rep_password.text.toString()) {
            Toast.makeText(this, "Repeat password", Toast.LENGTH_SHORT).show()
            return false
        }
        for (i in userList.indices) {
            if (username.text.toString() == userList[i].username) {
                Toast.makeText(
                    this,
                    "User with this username already registered",
                    Toast.LENGTH_SHORT
                ).show()
                return false
            }
        }
        return true
    }
}
