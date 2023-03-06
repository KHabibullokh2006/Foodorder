package uz.itschool.foodorder

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.imageLoader
import coil.load
import coil.transform.CircleCropTransformation
import uz.itschool.foodorder.adapter.ItemAdapter
import uz.itschool.foodorder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

     var itemList = mutableListOf<Item>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        binding.name.text = "Welcome, $name"

        itemList.add(Item("Burger", "https://kfc.com.uz/admin/files/5122.jpg"))
        itemList.add(Item("Burger", "https://kfc.com.uz/admin/files/5121.jpg"))
        itemList.add(Item("Burger", "https://kfc.com.uz/admin/files/4472.jpg"))

        val item_adapter = ItemAdapter(itemList)
        binding.itemRv.adapter = item_adapter





    }
}