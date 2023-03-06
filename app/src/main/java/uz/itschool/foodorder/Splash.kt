package uz.itschool.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

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


        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        },splashtime)


    }
}