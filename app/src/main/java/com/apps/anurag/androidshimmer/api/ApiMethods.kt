package com.apps.anurag.androidshimmer.api

import com.apps.anurag.androidshimmer.model.RecipeModel
import retrofit2.Call
import retrofit2.http.GET

/**
 *Created by anurag on 05,March,2019
 */
interface ApiMethods {

    @GET(ApiEndPoints.GET_RECIPE)
    fun getRecipe() : Call<List<RecipeModel>>
}