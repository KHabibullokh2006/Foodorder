package uz.itschool.foodorder

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import coil.transform.CircleCropTransformation
import uz.itschool.foodorder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        binding.name.text = "Welcome, $name"

        binding.imageView.load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9vaUeG5nc5-n8h_4mO6k0S5lvTpSJMtphUQ&usqp=CAU"){
            crossfade(true)
            placeholder(R.drawable.image)
            transformations(CircleCropTransformation())
        }

    }
}