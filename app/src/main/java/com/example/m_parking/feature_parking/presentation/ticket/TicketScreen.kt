package com.example.m_parking.feature_parking.presentation.ticket

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.m_parking.navigation.BottomNavItem
import com.example.m_parking.navigation.BottomNavMenu
import com.example.m_parking.navigation.Screens
import com.example.m_parking.ui.theme.MParkingTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicketScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My Bookings",
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        fontWeight = FontWeight.ExtraBold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(

                    containerColor = Color.Transparent,
                    navigationIconContentColor = Color.Cyan,
                    titleContentColor = Color.Magenta
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(48.dp),
                containerColor = Color.Transparent
            ) {
                BottomNavMenu(selectedItem = BottomNavItem.TICKET, navController)
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
                .padding(10.dp)
                .fillMaxSize()
        ) {
            StatusRow()
            TicketCard {
                navController.navigate(Screens.ParkingTicketScreen.route)
            }
        }
    }
}

@Composable
fun StatusRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.Black,
                containerColor = Color.Magenta,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Upcoming")
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.Black,
                containerColor = Color.Magenta,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Completed")
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.Black,
                containerColor = Color.Magenta,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Canceled")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicketCard(
    onClick: () -> Unit
) {
    Card(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = MaterialTheme.shapes.extraLarge
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 14.dp, vertical = 10.dp)
                .fillMaxWidth(),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Naivas Supermarket",
                        fontWeight = FontWeight.ExtraBold,
                    )
                    Text(text = "Ksh. 100")
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(verticalArrangement = Arrangement.Center) {
                        Text(text = "Naivas Supermarket Block B")
                        Text(text = "Meru, Kenya")
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.AccessTime, contentDescription = "clock")
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(verticalArrangement = Arrangement.Center) {
                            Text(
                                text = "May 21, 2023",
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "07:30 Pm",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Icon(imageVector = Icons.Default.ArrowRightAlt, contentDescription = null)
                    Column(verticalArrangement = Arrangement.Center) {
                        Text(
                            text = "May 21, 2023",
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "09:30 Pm",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun TickCardPrev() {
    MParkingTheme() {
        TicketCard {

        }
    }
}