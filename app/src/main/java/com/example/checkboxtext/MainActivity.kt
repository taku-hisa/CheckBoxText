package com.example.checkboxtext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.checkboxtext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding   //ビューバインディング
    lateinit var mAdapter:CustomAdapter
    lateinit var mAnimalList:ArrayList<Animal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dog = Animal("犬",3,false)
        val cat = Animal("猫",2,false)
        val elephant = Animal("象",10,false)
        val horse = Animal("馬",4,false)
        val lion = Animal("ライオン",6,false)
        mAnimalList = arrayListOf(dog,cat,elephant,horse,lion)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = CustomAdapter(mAnimalList)
        recyclerView.adapter = mAdapter

        binding.button.setOnClickListener {
            var count = 0
            for(animal in mAnimalList){
                if(animal.bool){
                    count++
                }else{
                    //
                }
            }
            binding.count.text = count.toString()
        }
    }
}