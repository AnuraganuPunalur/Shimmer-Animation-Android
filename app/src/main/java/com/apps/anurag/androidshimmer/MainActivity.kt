package com.apps.anurag.androidshimmer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.anurag.androidshimmer.adapter.RecipeAdapter
import com.apps.anurag.androidshimmer.databinding.ActivityMainBinding
import com.apps.anurag.androidshimmer.model.RecipeModel
import com.apps.anurag.androidshimmer.viewmodel.RecipeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var recipeViewModel: RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        initViews()

        getRecipeList()
    }

    private fun initViews(){

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val linearLayoutManager = LinearLayoutManager(this)
        activityMainBinding.shimmerViewContainer.startShimmer()
        activityMainBinding.recipeRecycler.layoutManager = linearLayoutManager
        recipeViewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)

    }

    private fun getRecipeList(){

        recipeViewModel.getRecipeList().observe(this,object : Observer<List<RecipeModel>>{

            override fun onChanged(recipeList: List<RecipeModel>?) {

                if (recipeList!=null){

                    activityMainBinding.shimmerViewContainer.stopShimmer()
                    activityMainBinding.shimmerViewContainer.visibility = View.GONE
                    recipeAdapter = RecipeAdapter(this@MainActivity,recipeList)
                    activityMainBinding.recipeRecycler.adapter = recipeAdapter
                    recipeAdapter.notifyDataSetChanged()

                }
            }
        })
    }
}
