package com.example.jetmovie.navagation

enum class Screens {
    HomeScreen,
    DetailsScreen;

    companion object {
        fun fromRoute(route: String?): Screens =
            when(route?.substringBefore('/')){
                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}