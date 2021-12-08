package com.mehdi.myapplication

import java.io.Serializable

data class Product(
    val name: String,
    val brand: String,
    val barCode: String,
    val nutriscore: String,
    val url: String,
    val quantity: String,
    val country: Array<String>,
    val ingredients: Array<String>,
    val allergens: Array<String>,
    val additives: Array<String>
) : Serializable {


    fun countryToString(): String {

        var str = "";
        for (i in this.country.indices) {

            str += if (i == this.country.size - 1) {
                this.country[i]
            } else {
                this.country[i] + ", "
            }
        }

        return str
    }

    fun ingredientsToString(): String {

        var str = ""
        for (i in this.ingredients.indices) {

            str += if (i == this.ingredients.size - 1) {
                this.ingredients[i]
            } else {
                this.ingredients[i] + ", "
            }
        }

        return str
    }

    fun allergensToString(): String {

        if (this.allergens.size == 0) {
            return "Aucun"
        }

        var str = ""
        for (i in this.allergens.indices) {

            str += if (i == this.allergens.size - 1) {
                this.allergens[i]
            } else {
                this.allergens[i] + ", "
            }
        }
        return str
    }

    fun additivesToString(): String {

        if (this.additives.size == 0) {
            return "Aucun"
        }

        var str = ""
        for (i in this.additives.indices) {

            str += if (i == this.additives.size - 1) {
                this.additives[i]
            } else {
                this.additives[i] + ", "
            }
        }
        return str
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (name != other.name) return false
        if (brand != other.brand) return false
        if (barCode != other.barCode) return false
        if (nutriscore != other.nutriscore) return false
        if (url != other.url) return false
        if (quantity != other.quantity) return false
        if (!country.contentEquals(other.country)) return false
        if (!ingredients.contentEquals(other.ingredients)) return false
        if (!allergens.contentEquals(other.allergens)) return false
        if (!additives.contentEquals(other.additives)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + brand.hashCode()
        result = 31 * result + barCode.hashCode()
        result = 31 * result + nutriscore.hashCode()
        result = 31 * result + url.hashCode()
        result = 31 * result + quantity.hashCode()
        result = 31 * result + country.contentHashCode()
        result = 31 * result + ingredients.contentHashCode()
        result = 31 * result + allergens.contentHashCode()
        result = 31 * result + additives.contentHashCode()
        return result
    }
}