package com.example.planets

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyCustomAdapter(val context: Context, val planets: List<Planet>): BaseAdapter() {

    override fun getCount(): Int {
        return planets.size
    }

    override fun getItem(position: Int): Any {
        return planets[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View
        if(convertView == null) {
            view = inflater.inflate(R.layout.item_list_layout, parent, false)
        } else {
            view = convertView
        }

        val item = planets[position]

        val titleTextview = view.findViewById<TextView>(R.id.planetname)
        val positionTextView = view.findViewById<TextView>(R.id.planetposition)
        val planetImage = view.findViewById<ImageView>(R.id.planeticon)

        titleTextview.text = item.name
        positionTextView.text = item.position
        planetImage.setImageResource(item.image)

        return view
    }
}
