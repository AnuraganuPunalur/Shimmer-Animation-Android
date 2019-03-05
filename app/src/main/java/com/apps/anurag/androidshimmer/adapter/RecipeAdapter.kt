package com.apps.anurag.androidshimmer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.anurag.androidshimmer.databinding.RecyclerRecipeDataBinding
import com.apps.anurag.androidshimmer.model.RecipeModel
import com.bumptech.glide.Glide

/**
 *Created by anurag on 05,March,2019
 */
class RecipeAdapter(var context : Context,var recipeList : List<RecipeModel>) : RecyclerView.Adapter<RecipeAdapter.RecipeHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeAdapter.RecipeHolder {

        val recyclerRecipeDataBinding = RecyclerRecipeDataBinding.
            inflate(LayoutInflater.from(parent.context),parent,false)
        return RecipeHolder(recyclerRecipeDataBinding)
    }



    override fun getItemCount(): Int {

        return recipeList.size
    }

    override fun onBindViewHolder(holder: RecipeAdapter.RecipeHolder, position: Int) {

        holder.setBinding(recipeList[position])
    }

    class RecipeHolder(var recyclerRecipeDataBinding: RecyclerRecipeDataBinding) : RecyclerView.ViewHolder(recyclerRecipeDataBinding.root) {

        fun setBinding(recipeModel: RecipeModel){

            Glide.with(recyclerRecipeDataBinding.ivRecipe).load(recipeModel.getThumbnail()).
                into(recyclerRecipeDataBinding.ivRecipe)

            recyclerRecipeDataBinding.setVariable(com.apps.anurag.androidshimmer.BR.recipeData,recipeModel)
            recyclerRecipeDataBinding.executePendingBindings()
        }

    }
}