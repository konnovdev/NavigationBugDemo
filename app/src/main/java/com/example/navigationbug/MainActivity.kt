package com.example.navigationbug

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.navigationbug.ui.theme.NavigationBugDemoTheme

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private val sharedViewModel: SharedViewModel by viewModels()

    private val onBackPressedCallback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (!navController.navigateUp()) {
                println("No more back navigation, can exit app or do any other task")
                finish() // Close the app or replace with custom back press handling
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel.navController.observe(this) { controller ->
            navController = controller
            // Setup back press callback with NavController

            onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
        }

        val container = FrameLayout(this).apply {
            id = View.generateViewId()
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }

        setContentView(container)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(container.id, MainFragment())
                .commit()
        }
    }
}