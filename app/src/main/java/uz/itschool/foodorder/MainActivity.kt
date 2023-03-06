package uz.itschool.foodorder

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import uz.itschool.foodorder.adapter.ItemAdapter
import uz.itschool.foodorder.adapter.ProductAdapter
import uz.itschool.foodorder.databinding.ActivityMainBinding
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

        val name = intent.getStringExtra("name")
        binding.name.text = "Welcome, $name"


        itemList.add(Item("Burger", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSohV8qyF_DsTe3OZjCEwZz_qyHc7izOHRuAQ&usqp=CAU"))
        itemList.add(Item("Pizza", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_AMpVD3wJVOQ7GUdw4kURtJZmPEYROAtFiw&usqp=CAU"))
        itemList.add(Item("Hotdog", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROSXAE64Yrktw2UA2Nzz6-lTqkHWiEK-SCDw&usqp=CAU"))

        productList.add(Product("БИГ САНДЕРС БУРГЕР","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","34000","https://kfc.com.uz/admin/files/5122.jpg"))
        productList.add(Product("БИГ САНДЕРС БУРГЕР ОСТРЫЙ","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","34000","https://kfc.com.uz/admin/files/5122.jpg"))
        productList.add(Product("САНДЕРС БУРГЕР","Уникальная рецептура, продуманная до мелочей – для создания неповторимого вкуса премиального бургера KFC.","28000","https://kfc.com.uz/admin/files/5121.jpg"))
        productList.add(Product("САНДЕРС БУРГЕР ОСТРЫЙ","Уникальная рецептура, продуманная до мелочей – для создания неповторимого вкуса премиального бургера KFC.","28000","https://kfc.com.uz/admin/files/5121.jpg"))
        productList.add(Product("ШЕФ ТАУЭР ОРИГИНАЛЬНЫЙ","соус Цезарь, филе в оригинальной панировке, хашбраун, ломтик сыра, салат айcберг и помидоры на пшеничной булочке с черно-белым кунжутом.","25000","https://kfc.com.uz/admin/files/4472.jpg"))
        productList.add(Product("ШЕФ ТАУЭР ОСТРЫЙ","Фирменный соус «Бургер», сочное филе в острой панировке, румяный хашбраун, ломтик сыра, салат айcберг и маринованные огурчики на пшеничной булочке с черно-белым кунжутом.","25000","https://kfc.com.uz/admin/files/4472.jpg"))
        productList.add(Product("ШЕФБУРГЕР ОРИГИНАЛЬНЫЙ","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","20000","https://kfc.com.uz/admin/files/4474.jpg"))
        productList.add(Product("ШЕФБУРГЕР ОСТРЫЙ","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","20000","https://kfc.com.uz/admin/files/4474.jpg"))
        productList.add(Product("ЧИЗБУРГЕР ДЕ ЛЮКС","орчичный соус, кетчуп,  филе в оригинальной панировке, лук, сыр Чеддер, огурцы на пшеничной булочке,  салат и ломтики помидора.","20000","https://kfc.com.uz/admin/files/4476.jpg"))
        productList.add(Product("ЧИЗБУРГЕР","орчичный соус, кетчуп,  филе в оригинальной панировке, лук, сыр Чеддер, огурцы на пшеничной булочке,  салат и ломтики помидора.","16000","https://kfc.com.uz/admin/files/4449.jpg"))
        productList.add(Product("ЛОНГЕР","Сочная курочка, маринованные огурчики, лук майонез и кетчуп","13000","https://kfc.com.uz/admin/files/4450.jpg"))
        productList.add(Product("БАЙРАМ","Фирменный томатный соус, сыр Моцарелла, микс мясных деликатесов (говядина, баранина), лук красный, маслины, базилик","64000","https://api.choparpizza.uz/storage/products/2022/03/03/dXbMedBpXqHZxCOOlQl58wp5R1zPA1X11YH74sTw.webp"))
        productList.add(Product("ПЕППЕРОНИ","Фирменный томатный соус, сыр Моцарелла, колбаса копченая","64000","https://api.choparpizza.uz/storage/products/2022/03/03/wXNMPeUybWjgBUCTuIir8yfRv3L1ZmN4fqheRJwQ.webp"))
        productList.add(Product("CHOPAR SPECIAL","Двухслойная пицца 35 см\n" +
                "\n" +
                "Фирменный томатный соус, сыр Моцарелла, томаты, копченое говяжье мясо, говяжий фарш","99000","https://api.choparpizza.uz/storage/products/2022/06/27/IG4VTMiYdhGr0aDj2TuOouyR2jykDJwJZ4W6woJm.webp"))
        productList.add(Product("БИГ САНДЕРС БУРГЕР","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","34000","https://kfc.com.uz/admin/files/5122.jpg"))
        productList.add(Product("БИГ САНДЕРС БУРГЕР","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","34000","https://kfc.com.uz/admin/files/5122.jpg"))
        productList.add(Product("БИГ САНДЕРС БУРГЕР","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","34000","https://kfc.com.uz/admin/files/5122.jpg"))
        productList.add(Product("БИГ САНДЕРС БУРГЕР","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","34000","https://kfc.com.uz/admin/files/5122.jpg"))
        productList.add(Product("БИГ САНДЕРС БУРГЕР","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","34000","https://kfc.com.uz/admin/files/5122.jpg"))
        productList.add(Product("БИГ САНДЕРС БУРГЕР","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","34000","https://kfc.com.uz/admin/files/5122.jpg"))
        productList.add(Product("БИГ САНДЕРС БУРГЕР","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","34000","https://kfc.com.uz/admin/files/5122.jpg"))
        productList.add(Product("БИГ САНДЕРС БУРГЕР","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","34000","https://kfc.com.uz/admin/files/5122.jpg"))
        productList.add(Product("БИГ САНДЕРС БУРГЕР","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","34000","https://kfc.com.uz/admin/files/5122.jpg"))
        productList.add(Product("БИГ САНДЕРС БУРГЕР","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","34000","https://kfc.com.uz/admin/files/5122.jpg"))
        productList.add(Product("БИГ САНДЕРС БУРГЕР","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","34000","https://kfc.com.uz/admin/files/5122.jpg"))
        productList.add(Product("БИГ САНДЕРС БУРГЕР","Биг Сандерс бургер оригинальный – невероятно большой и аппетитный!","34000","https://kfc.com.uz/admin/files/5122.jpg"))


        val item_adapter = ItemAdapter(itemList)
        var layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.itemRv.adapter = item_adapter
        binding.itemRv.layoutManager = layoutManager

        val pro_adapter = ProductAdapter(productList)
        var proManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
        binding.productRv.adapter = pro_adapter
        binding.productRv.layoutManager = proManager

//        binding.bottomNav.setOnItemSelectedListener {
//            when(it.itemId){
//                R.id.settings -> replaceLayout(SettingsActivity)
//            }
//        }

    }

//    fun replaceLayout(activity:Activity){
//        val intent = Intent(this,activity::class.java)
//        startActivity(intent)
//    }
}