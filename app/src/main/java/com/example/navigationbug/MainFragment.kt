package com.example.navigationbug

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.navigationbug.ui.theme.NavigationBugDemoTheme

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                NavigationBugDemoTheme {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = navigationRoute,
                    ) {
                        appNavGraph(
                            navController = navController,
                        )
                    }
                }
            }
        }
    }
}