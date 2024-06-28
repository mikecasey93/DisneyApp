package com.example.disneyapp.app

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.disneyapp.R
import com.example.disneyapp.app.ui.compose.home.HomeScreen
import com.example.disneyapp.app.ui.compose.screens.DisneyDetailsScreen
import com.example.disneyapp.app.ui.compose.screens.DisneyListScreen
import com.example.disneyapp.app.ui.theme.DisneyAppTheme
import com.example.disneyapp.common.nav.NavRoutes
import com.example.disneyapp.common.nav.routes.DisneyNavRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.the_lion_king_circle_of_life)
            //mediaPlayer!!.start()
            Toast.makeText(this, "Music Playing", Toast.LENGTH_LONG).show()
            DisneyAppTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                DisneyApp(navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisneyApp(navController: NavHostController) {
    val topState = remember { mutableStateOf(false) }
    val bottomState = remember { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    val barTitle = remember(currentRoute) {
        when (currentRoute) {
            NavRoutes.ROUTE_DISNEY -> "Disney"
            NavRoutes.Disney.routes -> "Disney Details"
            else -> "Details"
        }
    }

    when (navBackStackEntry?.destination?.route) {
        NavRoutes.Home.routes,
        NavRoutes.Home.routes -> {
            bottomState.value = true
            topState.value = false
        }
        else -> {
            bottomState.value = false
            topState.value = true
        }
    }
    
    Scaffold(
        topBar = {
            if (topState.value) {
                TopAppBar(
                    title = { Text(barTitle) },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        }
    ) {
        innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.ROUTE_HOME,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavRoutes.Home.routes) {
                HomeScreen(navController = navController)
            }
            composable(NavRoutes.ROUTE_DISNEY) {
                DisneyListScreen(viewModel = hiltViewModel(), navController = navController)
            }
            composable(
                route = NavRoutes.Disney.routes,
                arguments = NavRoutes.Disney.arguments
            ) {
                DisneyDetailsScreen(DisneyNavRoute.Details.fromEntry(it))
            }
        }
    }
}

