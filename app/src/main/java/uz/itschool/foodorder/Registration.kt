package uz.itschool.foodorder

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.itschool.foodorder.databinding.ActivityRegistrationBinding

class Registration : AppCompatActivity() {

    lateinit var reg: Button
    lateinit var name: TextInputEditText
    lateinit var username: TextInputEditText
    lateinit var phone: TextInputEditText
    lateinit var password: TextInputEditText
    lateinit var rep_password: TextInputEditText

    private lateinit var userList:MutableList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
//        initUI()

//        val shared: SharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
//        val edit = shared.edit()
//        val gson = Gson()
//        val convert = object : TypeToken<List<User>>(){}.type
//
//        reg.setOnClickListener {
//            if (validate()){
//                val users = shared.getString("users","")
//                userList = if (users==""){
//                    mutableListOf()
//                } else{
//                    gson.fromJson(users,convert)
//                }
//
//                userList.add(User(name.text.toString(),username.text.toString(),phone.text.toString(),password.text.toString()))
//
//                val str = gson.toJson(userList)
//                edit.putString("users", str).apply()
//
//                val intent = Intent(this,Login::class.java)
//                startActivity(intent)
//            }
//            if (!validate()){
//                Toast.makeText(this,"Something went wrong", Toast.LENGTH_SHORT).show()
//            }
//        }

    }

//    private fun initUI(){
//        reg = findViewById(R.id.signup_reg)
//        name = findViewById(R.id.name)
//        username = findViewById(R.id.username)
//        phone = findViewById(R.id.phone)
//        password = findViewById(R.id.password)
//        rep_password = findViewById(R.id.rep_password)
//    }

    private fun validate():Boolean{
        if(name.text.toString() == "" || username.text.toString() == "" || phone.text.toString() == "" || password.text.toString() == "" || rep_password.text.toString() == ""){
            Toast.makeText(this,"Fill the form fully", Toast.LENGTH_SHORT).show()
            return false

        }
        if (password.text.toString() != rep_password.text.toString()){
            Toast.makeText(this,"Repeat password",Toast.LENGTH_SHORT).show()
            return false
        }
        for (i in userList.indices){
            if (username.text.toString() == userList[i].username){
                Toast.makeText(this,"User with this username already registered", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        return true
    }
}