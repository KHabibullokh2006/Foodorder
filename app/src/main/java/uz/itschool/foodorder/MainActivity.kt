package uz.itschool.foodorder

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import coil.transform.CircleCropTransformation
import uz.itschool.foodorder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var itemList: MutableList<Item>

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        binding.name.text = "Welcome, $name"

        itemList.add(Item("Burger",""))





    }
}