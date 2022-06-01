package com.example.ht5_2.adapter
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ht5_2.R
import com.example.ht5_2.SuperHero
import com.example.ht5_2.databinding.SuperheroItemBinding
import com.squareup.picasso.Picasso



class SuperHeroesAdapter()
    : RecyclerView.Adapter<SuperHeroesAdapter.HeroViewHolder>(){

    var heroes : List<SuperHero> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): HeroViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SuperheroItemBinding.inflate(inflater, parent, false)

        return HeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(heroes[position])
    }


    override fun getItemCount(): Int = heroes.size


    class HeroViewHolder (val binding: SuperheroItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: SuperHero){
            binding.heroData = data
            if(data.biography.alignment == "good")
                binding.goodOrBad.setImageResource(R.drawable.good)
            else
                binding.goodOrBad.setImageResource(R.drawable.bad)
            Picasso.get()
                .load(data.images.sm)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.heroItemImage)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setHeroesList(heroes: List<SuperHero>){
        this.heroes = heroes;
        notifyDataSetChanged()
    }

}