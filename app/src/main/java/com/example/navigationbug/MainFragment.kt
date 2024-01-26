package com.example.navigationbug

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.navigationbug.ui.theme.NavigationBugDemoTheme

class MainFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner))

            setContent {

                NavigationBugDemoTheme {
                    val navController = rememberNavController()
                    sharedViewModel.setNavController(navController)

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