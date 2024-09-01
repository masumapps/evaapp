package com.masum.evainventory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class EvaViewModel @Inject constructor() : ViewModel() {
    private val _utilized = flowOf(sampleItem.shuffled())
    private val _soonOutOfStock = flowOf(sampleItem.shuffled())
    private val _quantityRevisions = flowOf(sampleItem.shuffled())
    private val _outOfStock = flowOf(listOf<ItemModel>())

    //connect with repository


    val allData: StateFlow<List<List<ItemModel>>> = combine(
        _utilized,
        _soonOutOfStock,
        _quantityRevisions,
        _outOfStock
    ) { utilized, soonOutOfStock, quantityRevisions, outOfStock ->

        listOf(utilized, soonOutOfStock, quantityRevisions, outOfStock)
    }
        .stateIn(viewModelScope, started = WhileSubscribed(5000), initialValue = listOf())
}