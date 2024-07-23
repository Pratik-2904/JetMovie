package com.example.jetmovie.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetmovie.model.Movie
import com.example.jetmovie.model.getMovies
import com.example.jetmovie.navagation.Screens
import com.example.jetmovie.widgets.MovieRow

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController = NavController(
        context = LocalContext.current
    )
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.heightIn(20.dp),
                navigationIcon = {
                    Icon(
                        modifier = Modifier.padding(start = 5.dp),
                        imageVector = Icons.Default.Movie, contentDescription = "Movies"
                    )
                },
                title = {
                    Text(
                        modifier = Modifier.padding(start = 6.dp), text = "Movies"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        },
    ) {
        MainContent(navController = navController, modifier = Modifier.padding(it))
    }

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainContent(
    modifier: Modifier,
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Column(modifier = modifier) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = Screens.DetailsScreen.name + "/$movie")
                }
            }
        }

    }

}