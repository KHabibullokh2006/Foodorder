package uz.itschool.foodorder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import uz.itschool.foodorder.R
import uz.itschool.foodorder.template.Product

class ProductAdapter(var productList:MutableList<Product>, var proInter:ProductInterface):RecyclerView.Adapter<ProductAdapter.ProductHolder>(){

    class ProductHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var name:TextView = itemView.findViewById(R.id.product_name)
        var description:TextView = itemView.findViewById(R.id.product_desc)
        var price:TextView = itemView.findViewById(R.id.product_price)
        var img:ImageView = itemView.findViewById(R.id.product_img)
        var product:CardView = itemView.findViewById(R.id.product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        var holder = ProductHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_product,parent,false))
        return holder
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        var item = productList.get(position)
        holder.name.text = item.pro_name
        holder.description.text = item.pro_desc
        holder.price.text = item.pro_price
        holder.img.load(item.pro_img)
        holder.product.setOnClickListener {
            proInter.onClick(item)
        }

    }

    override fun getItemCount(): Int {
        return productList.size
    }

    interface ProductInterface{
        fun onClick(product: Product)
    }
}