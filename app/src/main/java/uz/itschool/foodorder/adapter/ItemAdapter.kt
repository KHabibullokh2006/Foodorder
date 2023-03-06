package uz.itschool.foodorder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import uz.itschool.foodorder.template.Item
import uz.itschool.foodorder.R

class ItemAdapter(var itemList: MutableList<Item>) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    class ItemHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var name: TextView = itemView.findViewById(R.id.item_name)
        var img: ImageView = itemView.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var holder = ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_categories,parent,false))
        return holder
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var item = itemList.get(position)
        holder.name.text = item.name
        holder.img.load(item.img)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}