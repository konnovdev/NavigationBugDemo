package com.example.navigationbug

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.navigationbug.ui.theme.NavigationBugDemoTheme

class MainFragment : Fragment() {
    private var _navController: NavController? = null
    val navController: NavController?
        get() = _navController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                NavigationBugDemoTheme {
                    val navController = rememberNavController()
                    _navController = navController

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

    override fun onDestroyView() {
        super.onDestroyView()
        _navController = null
    }
}
