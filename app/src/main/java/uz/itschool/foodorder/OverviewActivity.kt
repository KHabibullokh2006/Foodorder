package uz.itschool.foodorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.itschool.foodorder.databinding.ActivityOverviewBinding

class OverviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityOverviewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}