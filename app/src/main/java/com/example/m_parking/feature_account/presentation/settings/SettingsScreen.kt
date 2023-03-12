package com.example.m_parking.feature_account.presentation.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.m_parking.R
import com.example.m_parking.navigation.BottomNavItem
import com.example.m_parking.navigation.BottomNavMenu
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Settings",
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16.sp
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.clip(CircleShape),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = if (isSystemInDarkTheme()) Color.White.copy(.24f) else Color.Black.copy(
                            .14f
                        )
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "Back"
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
                navigationIconContentColor = Color.Cyan,
                titleContentColor = Color.Magenta
            )
        )
    }) { PaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = PaddingValues.calculateTopPadding())
        ) {
            ProfileCardUI()
            GeneralOptionsUi()
            SupportOptionsUi()
        }
    }
}


@Composable
fun ProfileCardUI() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(20.dp),
        shape = MaterialTheme.shapes.large
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(
                    text = "Check Your Profile",
                    fontFamily = FontFamily.Serif,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = "UI.Stack.YT@gmail.com",
                    fontFamily = FontFamily.Serif,
                    color = Color.Gray,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                )

                Button(
                    modifier = Modifier.padding(top = 10.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White.copy(.24f)
                    ),
                    contentPadding = PaddingValues(horizontal = 30.dp),
                    elevation =ButtonDefaults.buttonElevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 2.dp
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(
                        text = "View",
                        fontFamily = FontFamily.Serif,
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.page_one),
                contentDescription = "",
                modifier = Modifier.height(120.dp)
            )
        }
    }
}

@Composable
fun SupportOptionsUi() {
    Column(modifier = Modifier
        .padding(horizontal = 14.dp)
        .padding(top = 10.dp)
    ) {
        Text(
            text = "Support",
            fontFamily = FontFamily.Monospace,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 8.dp)
                .fillMaxWidth()
        )
        SupportSettingsItem(
            icon = Icons.Rounded.Whatsapp,
            mainText = "Contact",
            onClick = {

            }
        )
        SupportSettingsItem(
            icon = Icons.Rounded.Feedback,
            mainText = "FeedBack",
            onClick = {

            }
        )
        SupportSettingsItem(
            icon = Icons.Rounded.PrivacyTip,
            mainText = "Privacy & Policy",
            onClick = {

            }
        )
        SupportSettingsItem(
            icon = Icons.Rounded.Details,
            mainText = "About",
            onClick = {

            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SupportSettingsItem(
    icon: ImageVector,
    mainText: String,
    onClick: () -> Unit
) {
    Card(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .wrapContentHeight()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 14.dp, vertical = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(
                            if (isSystemInDarkTheme()) Color.Black.copy(.24f) else Color.White.copy(
                                .24f
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Notification"
                    )
                }
                Spacer(modifier = Modifier.width(14.dp))
                Text(
                    text = mainText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                )
            }
            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun HeaderText() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ){
        Text(
            text = "Settings",
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier

                .padding(top = 10.dp, bottom = 5.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp
        )
    }
}

@Composable
fun GeneralOptionsUi() {
    Column(
        modifier = Modifier
            .padding(horizontal = 14.dp)
            .padding(top = 10.dp)
    ) {
        Text(
            text = "General",
            fontFamily = FontFamily.Monospace,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
        )
        GeneralSettingsItem(
            icon = Icons.Rounded.Notifications,
            mainText = "Notification",
            subText = "customize notifications",
            onClick = {

            }
        )
        GeneralSettingsItem(
            icon = Icons.Rounded.DashboardCustomize,
            mainText = "Dashboard Customize",
            subText = "customize Dashboard",
            onClick = {

            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralSettingsItem(
    icon: ImageVector,
    mainText: String,
    subText: String,
    onClick: () -> Unit
) {
    Card(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .wrapContentHeight()
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 14.dp, vertical = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(
                            if (isSystemInDarkTheme()) Color.Black.copy(.24f) else Color.White.copy(
                                .24f
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Notification"
                    )
                }
                Spacer(modifier = Modifier.width(14.dp))
                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = mainText,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                    )
                    Text(
                        text = subText,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        modifier = Modifier.offset(y = (-4).dp)
                    )
                }
            }
            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
