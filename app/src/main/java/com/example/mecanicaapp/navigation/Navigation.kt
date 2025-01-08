package com.example.mecanicaapp.navigation

sealed class Navigation(val route: String) {

        object Search : Navigation("search")
        object Detail : Navigation("detail/{id}")
        object Scan : Navigation("scan")
}