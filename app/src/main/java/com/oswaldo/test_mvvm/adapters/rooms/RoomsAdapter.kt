package com.oswaldo.test_mvvm.adapters.rooms

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.oswaldo.test_mvvm.R
import com.oswaldo.test_mvvm.adapters.rooms.RoomsAdapter.RoomsViewHolder
import com.oswaldo.test_mvvm.data.Restroom
import java.util.*

class RoomsAdapter(var context: Context, var items: ArrayList<Restroom>) :
    RecyclerView.Adapter<RoomsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_room, parent, false)
        return RoomsViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RoomsViewHolder, position: Int) {
        var item = items[position]

        holder.txtName.text = item.name
        holder.txtStreet.text = "Street: ${item.street}"

        if (item.country.equals("US")) {
            holder.imgCountry.setImageResource(R.drawable.ic_us)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class RoomsViewHolder(itemView: View) : ViewHolder(itemView) {
        var txtName: TextView
        var txtStreet: TextView
        var imgCountry: ImageView

        init {
            txtName = itemView.findViewById(R.id.txtName)
            txtStreet = itemView.findViewById(R.id.txtStreet)
            imgCountry = itemView.findViewById(R.id.imgCountry)
        }
    }

}