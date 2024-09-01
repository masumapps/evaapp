package com.masum.evainventory

data class ItemModel (
    val name: String,
    val quantity: Int,
    val unit: String
)
val sampleItem= listOf(
    ItemModel(name = "Sinkers 80g", quantity = 2, unit = "pcs"),
    ItemModel(name = "Cup", quantity = 10, unit = "pcs"),
    ItemModel(name = "Tissue", quantity = 5, unit = "pcs"),
    ItemModel(name = "Apple", quantity = 10, unit = "Kg")
)