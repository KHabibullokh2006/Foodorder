package uz.itschool.foodorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.itschool.foodorder.databinding.ActivityCartBinding

class OverviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityCartBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}