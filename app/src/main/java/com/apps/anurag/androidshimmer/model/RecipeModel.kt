package com.apps.anurag.androidshimmer.model

/**
 *Created by anurag on 05,March,2019
 */
class RecipeModel {

    private var id: Int? = null
    private var name: String? = null
    private var description: String? = null
    private var price: Double = 0.toDouble()
    private var thumbnail: String? = null
    private var chef: String? = null
    private var timestamp: String? = null


    fun getId(): Int? {
        return id
    }

    fun getName(): String? {
        return name
    }

    fun getDescription(): String? {
        return description
    }

    fun getPrice(): Double {
        return price
    }

    fun getThumbnail(): String? {
        return thumbnail
    }

    fun getChef(): String? {
        return chef
    }

    fun getTimestamp(): String? {
        return timestamp
    }
}