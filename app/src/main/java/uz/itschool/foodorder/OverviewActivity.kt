package uz.itschool.foodorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.itschool.foodorder.databinding.ActivityOverviewBinding

class OverviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityOverviewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        
        var img = intent.getStringExtra("img")
        var name = intent.getStringExtra("name")
        var desc = intent.getStringExtra("desc")
        var price = intent.getStringExtra("price")
        
        binding.img.load(img)
        binding.product_name.text = name
        binding.product_desc.text = desc
        binding.product_price.text = price
        
        binding.button.setOnClickListener{
            Toast.makeText(this, "Meal was added to cart", Toast.LENGTH_SHORT).show();
        }

    }
}
