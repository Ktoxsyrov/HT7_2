package com.example.ht5_2


data class SuperHero (
    val id: Long,
    val name: String,
    val powerstats: Powerstats,
    val appearance: Appearance,
    val biography: Biography,
    val images: Images
)

data class Appearance (
    val gender: String,
    val race: String? = null,
    val height: List<String>,
    val weight: List<String>,
    val eyeColor: String,
    val hairColor: String
)
data class Biography (
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String? = null,
    val alignment: String?
)
data class Powerstats (
    val intelligence: Long,
    val strength: Long,
    val speed: Long,
    val durability: Long,
    val power: Long,
    val combat: Long
)
data class Images (
    val xs: String,
    val sm: String,
    val md: String,
    val lg: String
)