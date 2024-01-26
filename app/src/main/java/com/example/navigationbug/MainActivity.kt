package com.example.navigationbug

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.navigationbug.ui.theme.NavigationBugDemoTheme
import timber.log.Timber

class MainActivity : AppCompatActivity() {


    private val onBackPressedCallback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            println("hahaha")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        onBackPressedDispatcher.addCallback(this, onBackPressedCallback) // navigation breaker

        val container = FrameLayout(this).apply {
            id = View.generateViewId()
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }
        containerId = container.id
        setContentView(container)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(container.id, MainFragment())
                .commit()
        }

    }
    private var containerId: Int = 0

    override fun onBackPressed() {
        val mainFragment = supportFragmentManager.findFragmentById(containerId)
        if (mainFragment is MainFragment) {
            val navController = mainFragment.navController
            if (navController != null && navController.navigateUp()) {
                // Navigation handled by NavController
                return
            }
        }
        super.onBackPressed()
    }
    override fun onResume() {
        super.onResume()
        // Re-enable the callback
        onBackPressedCallback.isEnabled = true

    }

    override fun onPause() {
        super.onPause()
        // Optionally disable the callback
        onBackPressedCallback.isEnabled = false
    }
}