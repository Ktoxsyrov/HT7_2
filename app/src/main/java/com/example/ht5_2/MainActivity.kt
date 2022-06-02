package com.example.ht5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ht5_2.adapter.SuperHeroesAdapter
import com.example.ht5_2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SuperHeroesAdapter

    interface OnItemClickListener{
        fun onItemClicked(position: Int, view: View)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = SuperHeroesAdapter()
        binding.heroesRecyclerView.addOnItemCLickListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                val clickedHero = adapter.heroes[position]
        //        Toast.makeText(this@MainActivity, clickedHero.name, Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, HeroDetailsActivity::class.java)
                intent.putExtra("img", clickedHero.images.sm)
                intent.putExtra("name", clickedHero.name)
                intent.putExtra("placeOfBirth", clickedHero.biography.placeOfBirth)
                intent.putExtra("firstAppearance", clickedHero.biography.firstAppearance)
                intent.putExtra("publisher", clickedHero.biography.publisher)
                intent.putExtra("height", clickedHero.appearance.height[1])
                intent.putExtra("weight", clickedHero.appearance.weight[1])
                intent.putExtra("alignment", clickedHero.biography.alignment)
                startActivity(intent)
            }


        })

        val apiInterface = RetroInstance.getRetroInstance().getHeroesFromApi()

        binding.heroesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.heroesRecyclerView.adapter = adapter

        apiInterface.enqueue(object : Callback<List<SuperHero>> {
            override fun onResponse(
                call: Call<List<SuperHero>>,
                response: Response<List<SuperHero>>
            ) {
                if(response.body() != null)
                    adapter.setHeroesList(response.body()!!)
            }

            override fun onFailure(call: Call<List<SuperHero>>, t: Throwable) {

            }

        } )

    }
    private fun RecyclerView.addOnItemCLickListener(onClickListener: OnItemClickListener){
        this.addOnChildAttachStateChangeListener(object: RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewDetachedFromWindow(view: View) {
                view.setOnClickListener(null)
            }
            override fun onChildViewAttachedToWindow(view: View) {
                view.setOnClickListener {
                    val holder = getChildViewHolder(view)
                    onClickListener.onItemClicked(holder.bindingAdapterPosition, view)
                }
            }
        })
    }

}