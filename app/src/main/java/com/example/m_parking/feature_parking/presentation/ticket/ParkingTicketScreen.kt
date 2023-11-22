package com.daematech.m_parking.feature_parking.presentation.ticket

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.daematech.m_parking.R
import com.daematech.m_parking.navigation.BottomNavItem
import com.daematech.m_parking.navigation.BottomNavMenu


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParkingTicketScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Parking Ticket",
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        fontWeight = FontWeight.ExtraBold
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack()},
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = if (isSystemInDarkTheme()) Color.White.copy(.24f) else Color.Black.copy(
                                .14f
                            )
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "clear"
                        )
                    }
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
        }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = paddingValues.calculateBottomPadding(),
                    top = paddingValues.calculateTopPadding()
                )
                .padding(horizontal = 10.dp),
        ) {
            QrCode(modifier = Modifier.align(Alignment.CenterHorizontally))
            ParkingDetails()
            BookingDetails()
            Actions()
        }
    }
}

@Composable
fun QrCode(
    modifier: Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(.3f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.qr_code),
            contentDescription = "Qr code"
        )
    }
}

@Composable
fun ParkingDetails() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "Name")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Emmanuel Bett",
                fontWeight = FontWeight.ExtraBold,
            )
        }
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "Mobile Number")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "1234567890",
                fontWeight = FontWeight.ExtraBold,
            )
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "Vehicle")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Isuzu Dimax",
                fontWeight = FontWeight.ExtraBold,
            )
        }
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "Vehicle Number")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "GKB 123Z",
                fontWeight = FontWeight.ExtraBold,
            )
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "Parking pass")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "#32-56-79",
                fontWeight = FontWeight.ExtraBold,
            )
        }
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "Parking Spot")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "#B2-01",
                fontWeight = FontWeight.ExtraBold,
            )
        }
    }
}

@Composable
fun BookingDetails() {
    Column {
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "Date From")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "May 21, 07:30 Pm",
                fontWeight = FontWeight.ExtraBold,
            )
        }
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "Date to")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "May 21, 09:30 Pm",
                fontWeight = FontWeight.ExtraBold,
            )
        }
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "Parking Address")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Naivas Supermarket, Block B\n Meru,Kenya",
                fontWeight = FontWeight.ExtraBold,
            )
        }
    }
}

@Composable
fun Actions() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color.Magenta
            ),
            modifier = Modifier.weight(.3f)
        ) {
            Icon(imageVector = Icons.Default.Directions, contentDescription = "Directions")
            Text(
                text = "Direction",
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color.Magenta
            ),
            modifier = Modifier.weight(.3f)
        ) {
            Icon(imageVector = Icons.Default.Download, contentDescription = "Download")
            Text(
                text = "Download",
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color.Magenta
            ),
            modifier = Modifier.weight(.3f)
        ) {
            Icon(imageVector = Icons.Default.Share, contentDescription = "share")
            Text(
                text = "share",
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            )
        }
    }
}
