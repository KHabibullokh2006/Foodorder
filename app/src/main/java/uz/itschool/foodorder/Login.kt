package uz.itschool.foodorder

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Login : AppCompatActivity() {

    var status:Boolean = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val signIn: Button = findViewById(R.id.signin)
        val signUp: Button = findViewById(R.id.signup)
        val username: TextInputEditText = findViewById(R.id.username)
        val password: TextInputEditText = findViewById(R.id.password)
        var forgot: Button = findViewById(R.id.forgotpassword)

        var userList: MutableList<User>
        val shared = getSharedPreferences("login", MODE_PRIVATE)
        val gson = Gson()
        val convert = object : TypeToken<List<User>>(){}.type
        val users = shared.getString("users","")

        signUp.setOnClickListener {
            val intent = Intent(this,Registration::class.java)
            startActivity(intent)
        }

        signIn.setOnClickListener {
            userList = gson.fromJson(users,convert)
            if (users==""){
                Toast.makeText(this,"Register", Toast.LENGTH_SHORT).show()
            }
            else{
                for (user in userList) {
                    if (username.text.toString() == user.username && password.text.toString() == user.password){
                        Log.d("ABC", username.toString())
                        status = true
                        val intent = Intent(this,MainActivity::class.java)
                        intent.putExtra("name",username.text.toString())
                        startActivity(intent)
                    }
                }
            }
        }
    }
}