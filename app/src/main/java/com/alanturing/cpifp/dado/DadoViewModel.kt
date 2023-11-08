package com.alanturing.cpifp.dado

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random
import kotlin.random.nextInt

class DadoViewModel():ViewModel() {
    private var valor:Int = 0
    // LiveData, es un stream de datos observables
    // que es lifecycle-aware, si los observadores son
    // activiades o fragmentos, livedata no los notificara
    // cuando se cierren
    private val _numero: MutableLiveData<Int> = MutableLiveData()
    val numero: LiveData<Int>
        get()=_numero
    fun roll() {
        valor = Random.nextInt(1..6)
        // Emitimos el valor actualizado
        _numero.value = valor
    }
}