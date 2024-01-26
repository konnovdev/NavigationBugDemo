package com.example.navigationbug

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class SharedViewModel : ViewModel() {
    private val _navController = MutableLiveData<NavController>()
    val navController: LiveData<NavController> = _navController

    fun setNavController(controller: NavController) {
        _navController.value = controller
    }
}
