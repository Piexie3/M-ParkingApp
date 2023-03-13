package com.example.m_parking.feature_parking.presentation.search

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.m_parking.core.composables.SearchBar
import com.example.m_parking.navigation.BottomNavItem
import com.example.m_parking.navigation.BottomNavMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(verticalArrangement = Arrangement.Center) {
                        Text(
                            text = "Discover",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.ExtraBold,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Search for any parking lots and price",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Light,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
                actions = {
                          IconButton(
                              onClick = { /*TODO*/ },
                              modifier = Modifier.clip(CircleShape),
                              colors = IconButtonDefaults.iconButtonColors(
                                  containerColor = if (isSystemInDarkTheme()) Color.White.copy(.24f) else Color.Black.copy(
                                      .14f
                                  )
                              )
                          ) {
                              Icon(imageVector = Icons.Default.Sort, contentDescription = "Sort")
                          }

                },
                colors = TopAppBarDefaults.topAppBarColors(

                    containerColor = Color.Transparent,
                    actionIconContentColor = Color.Cyan,
                    navigationIconContentColor = Color.Cyan,
                    titleContentColor =  if (isSystemInDarkTheme())
                        Color.White else
                        Color.Black
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(48.dp),
                containerColor = Color.Transparent
            ) {
                BottomNavMenu(selectedItem = BottomNavItem.SEARCH, navController)
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { PaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = PaddingValues.calculateBottomPadding(),
                    top = PaddingValues.calculateTopPadding()
                ),
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 4.dp)
                    .fillMaxWidth()
            ) {
                SearchBar(
                    onSearchParamChange = {

                    },
                    onSearchClick = {

                    })
            }
        }
    }
}


@Composable
fun SortIcon(
    onSortIconClicked: () -> Unit,
    onSortMenuDismiss: () -> Unit,
    onSortItemA2ZClicked: () -> Unit,
    onSortItemZ2AClicked: () -> Unit,
    onSortItemNoneClicked: () -> Unit,
    isSortMenuVisible: Boolean
) {

    IconButton(
        onClick = onSortIconClicked
    ) {
        Icon(
            imageVector = Icons.Default.Sort,
            contentDescription = "Sort Icon",
            tint = Color.White,
            modifier = Modifier.size(30.dp)
        )
        DropdownMenu(
            expanded = isSortMenuVisible,
            onDismissRequest = onSortMenuDismiss
        ) {
            DropdownMenuItem(
                text = {
                    Text(text = "Sort  A -> Z")
                },
                onClick = {
                    onSortItemA2ZClicked()
                }
            )
            DropdownMenuItem(
                text = {
                    Text(text = "Sort  Z -> A")
                },
                onClick = {
                    onSortItemZ2AClicked()
                }
            )
            DropdownMenuItem(
                text = {
                    Text(text = "No Sort")
                },
                onClick = {
                    onSortItemNoneClicked()
                }
            )

        }
    }


}

