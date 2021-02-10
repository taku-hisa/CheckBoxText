package com.example.checkboxtext

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(
    private val animalList:ArrayList<Animal>
) :RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val name : TextView
        val age : TextView
        val checkbox : CheckBox
        val check : TextView

        init{
            name = view.findViewById(R.id.name)
            age = view.findViewById(R.id.age)
            checkbox = view.findViewById(R.id.checkbox)
            check = view.findViewById(R.id.check)
        }
    }

    override fun onCreateViewHolder(viewgroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewgroup.context).inflate(R.layout.list_item,viewgroup,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val animal = animalList[position]

        viewHolder.name.text = animal.name
        viewHolder.age.text = animal.age.toString()
        viewHolder.checkbox.isChecked = animal.bool

        viewHolder.checkbox.setOnClickListener {
            val check = viewHolder.checkbox.isChecked
            if(check){
                viewHolder.check.text = "チェックされた"
                animal.bool = true
            }else{
                viewHolder.check.text = "チェックされてない"
                animal.bool = false
            }
        }
    }

    override fun getItemCount(): Int = animalList.size
}