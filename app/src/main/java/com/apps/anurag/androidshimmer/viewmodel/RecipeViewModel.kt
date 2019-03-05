package com.apps.anurag.androidshimmer.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apps.anurag.androidshimmer.api.Api
import com.apps.anurag.androidshimmer.model.RecipeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 *Created by anurag on 05,March,2019
 */
class RecipeViewModel : ViewModel() {

private lateinit var recipeMutableList : MutableLiveData<List<RecipeModel>>

     fun getRecipeList() : LiveData<List<RecipeModel>>{

        recipeMutableList = MutableLiveData()

        Api.getInstance().getRecipe().enqueue(object : Callback<List<RecipeModel>>{

            override fun onResponse(call: Call<List<RecipeModel>>, response: Response<List<RecipeModel>>) {

                if (response.isSuccessful){

                    if (response.body()!=null){

                        recipeMutableList.value = response.body()
                    }else{

                        Log.e("null","null")
                    }
                }else{

                    Log.e("null","failure")
                }
            }

            override fun onFailure(call: Call<List<RecipeModel>>, t: Throwable) {

                Log.e("exception",t.message)
            }
        })

        return recipeMutableList
    }
}