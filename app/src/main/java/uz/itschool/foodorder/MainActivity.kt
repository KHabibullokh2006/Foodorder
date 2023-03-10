package uz.itschool.foodorder

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import uz.itschool.foodorder.adapter.ItemAdapter
import uz.itschool.foodorder.adapter.ProductAdapter
import uz.itschool.foodorder.databinding.ActivityMainBinding
import uz.itschool.foodorder.menu.SettingsActivity
import uz.itschool.foodorder.template.Item
import uz.itschool.foodorder.template.Product

class MainActivity : AppCompatActivity() {

    var itemList = mutableListOf<Item>()
    var productList = mutableListOf<Product>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var home:TextView = findViewById(R.id.home)
        var cart:TextView = findViewById(R.id.cart)
        var profile:TextView = findViewById(R.id.profile)
        var settings:TextView = findViewById(R.id.settings)

        val name = intent.getStringExtra("name")
        binding.name.text = "Welcome, $name"

        binding.search.addTextChangedListener {
            var filter = mutableListOf<Product>()
            if (it != null){
                for (i in productList){
                    if (i.pro_name.contains(it.toString())){
                        filter.add(i)
                    }
                }
//                var pro_adapter = ProductAdapter(filter,object : ProductAdapter.ProductInterface{
//                    override fun onClick(product: Product) {
//                        var intent = Intent(this@MainActivity,OverviewActivity::class.java)
//                        intent.putExtra("img",product.pro_img)
//                        intent.putExtra("name",product.pro_name)
//                        intent.putExtra("img",product.pro_img)
//                        intent.putExtra("price",product.pro_price)
//                    }
//
//                })
            }
        }


        itemList.add(Item("Burger", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSohV8qyF_DsTe3OZjCEwZz_qyHc7izOHRuAQ&usqp=CAU"))
        itemList.add(Item("Pizza", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_AMpVD3wJVOQ7GUdw4kURtJZmPEYROAtFiw&usqp=CAU"))
        itemList.add(Item("Hotdog", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROSXAE64Yrktw2UA2Nzz6-lTqkHWiEK-SCDw&usqp=CAU"))

        productList.add(Product("?????? ?????????????? ????????????","Burger","34000","https://kfc.com.uz/admin/files/5122.jpg"))
        productList.add(Product("?????? ?????????????? ???????????? ????????????","","34000","https://kfc.com.uz/admin/files/5122.jpg"))
        productList.add(Product("?????????????? ????????????","","28000","https://kfc.com.uz/admin/files/5121.jpg"))
        productList.add(Product("?????????????? ???????????? ????????????","","28000","https://kfc.com.uz/admin/files/5121.jpg"))
        productList.add(Product("?????? ?????????? ????????????????????????","","25000","https://kfc.com.uz/admin/files/4472.jpg"))
        productList.add(Product("?????? ?????????? ????????????","","25000","https://kfc.com.uz/admin/files/4472.jpg"))
        productList.add(Product("?????????????????? ????????????????????????","","20000","https://kfc.com.uz/admin/files/4474.jpg"))
        productList.add(Product("?????????????????? ????????????","","20000","https://kfc.com.uz/admin/files/4474.jpg"))
        productList.add(Product("?????????????????? ???? ????????","","20000","https://kfc.com.uz/admin/files/4476.jpg"))
        productList.add(Product("??????????????????","","16000","https://kfc.com.uz/admin/files/4449.jpg"))
        productList.add(Product("????????????","","13000","https://kfc.com.uz/admin/files/4450.jpg"))
        productList.add(Product("????????????","","64000","https://api.choparpizza.uz/storage/products/2022/03/03/dXbMedBpXqHZxCOOlQl58wp5R1zPA1X11YH74sTw.webp"))
        productList.add(Product("??????????????????","","64000","https://api.choparpizza.uz/storage/products/2022/03/03/wXNMPeUybWjgBUCTuIir8yfRv3L1ZmN4fqheRJwQ.webp"))
        productList.add(Product("CHOPAR SPECIAL","","99000","https://api.choparpizza.uz/storage/products/2022/06/27/IG4VTMiYdhGr0aDj2TuOouyR2jykDJwJZ4W6woJm.webp"))


        val item_adapter = ItemAdapter(itemList)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.itemRv.adapter = item_adapter
        binding.itemRv.layoutManager = layoutManager

        val pro_adapter = ProductAdapter(productList,object : ProductAdapter.ProductInterface{
            override fun onClick(product: Product) {
                var intent = Intent(this@MainActivity,OverviewActivity::class.java)
                intent.putExtra("img",product.pro_img)
                intent.putExtra("name",product.pro_name)
                intent.putExtra("desc",product.pro_desc)
                intent.putExtra("price",product.pro_price)
                startActivity(intent)

            }

        })

        var proManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
        binding.productRv.adapter = pro_adapter
        binding.productRv.layoutManager = proManager


        home.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        settings.setOnClickListener {
            var intent = Intent(this,SettingsActivity::class.java)
            startActivity(intent)
        }


        }


    }

