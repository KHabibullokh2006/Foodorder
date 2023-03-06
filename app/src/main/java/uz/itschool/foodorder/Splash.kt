package uz.itschool.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Splash : AppCompatActivity() {

    private var splashtime:Long = 2500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)

        var anim_img = AnimationUtils.loadAnimation(this,R.anim.img_animation)
        var anim_text = AnimationUtils.loadAnimation(this,R.anim.text_animation)

        var img = findViewById<ImageView>(R.id.img)
        var tv = findViewById<TextView>(R.id.text)

        img.startAnimation(anim_img)
        tv.startAnimation(anim_text)

        val shared = getSharedPreferences("login", MODE_PRIVATE)
        val users = shared.getString("users","")

        val handler = Handler()

        if (users == ""){
            handler.postDelayed({
                val intent = Intent(this,Registration::class.java)
                startActivity(intent)
            },splashtime)
        }
        else{
            handler.postDelayed({
                val intent = Intent(this,Login::class.java)
                startActivity(intent)
            },splashtime)
        }



    }
}