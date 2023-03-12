package com.example.m_parking.feature_parking.presentation.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterVintage
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.m_parking.core.composables.SearchBar
import com.example.m_parking.feature_maps.presentation.MapScreen
import com.example.m_parking.navigation.BottomNavItem
import com.example.m_parking.navigation.BottomNavMenu


@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(48.dp),
                containerColor = Color.Transparent
            ) {
                BottomNavMenu(selectedItem = BottomNavItem.HOME, navController)
            }
        },
        containerColor = Color.Transparent
    ) {paddingValues->
        Column(
            modifier = Modifier.fillMaxSize().padding(bottom = paddingValues.calculateBottomPadding())
        ){
            MapScreen()
        }
    }
}


@Composable
fun TopApp() {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        SearchBar(
            modifier = Modifier
                .clip(RoundedCornerShape(100))
                .fillMaxWidth(.80F),
            onSearchParamChange = {
                // TODO("Update value in viewModel")
            },
            onSearchClick = {
                // TODO("Perform search event")
            }
        )
        IconButton(
            onClick = { /*TODO*/ },
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = if (isSystemInDarkTheme())
                    Color.White.copy(alpha = .24F) else
                    Color.Black.copy(alpha = .24F),
                contentColor = if (isSystemInDarkTheme())
                    Color.White else
                    Color.Black
            ),
            modifier = Modifier.clip(CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.FilterVintage,
                contentDescription = "Filter"
            )
        }
    }
}
