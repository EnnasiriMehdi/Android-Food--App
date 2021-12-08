package com.mehdi.myapplication

enum class NutrientLevel(val colorId : Int, val stringId : String) {
    LOW(
        R.color.nutrient_level_low,
        "LOW"
    ),
    MODERATED(
        R.color.nutrient_level_moderate,
        "MODERATE"
    ),
    HIGH(
        R.color.nutrient_level_high,
        "HIGH",
    )
}