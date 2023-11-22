package com.daematech.m_parking.feature_account.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.daematech.m_parking.R
import com.daematech.m_parking.core.composables.CustomSwitch
import com.daematech.m_parking.core.composables.NavigationRowItem
import com.daematech.m_parking.feature_account.presentation.settings.SupportSettingsItem
import com.daematech.m_parking.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
        TopAppBar(
            title = {

                Text(
                    text = "My Profile",
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.titleLarge
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
            actions = {
               IconButton(
                   onClick = {
                             navController.navigate(Screens.SettingsScreen.route)
                   },

                   modifier = Modifier.clip(CircleShape),
                   colors = IconButtonDefaults.iconButtonColors(
                       containerColor = if (isSystemInDarkTheme()) Color.White.copy(.24f) else Color.Black.copy(
                           .14f
                       )
                   )
               ) {
                   Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
               }
            },
            colors = TopAppBarDefaults.topAppBarColors(

                containerColor = Color.Transparent,
                navigationIconContentColor = Color.Cyan,
                titleContentColor = Color.Magenta
            )
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .padding(10.dp)
                .fillMaxSize()
        ) {
            ProfileSection(navController)
            Spacer(modifier = Modifier.height(8.dp))
            EditProfile()
            Spacer(modifier = Modifier.height(8.dp))
            NavItems()
            Spacer(modifier = Modifier.height(8.dp))
            EnableDarkTheme()
            Spacer(modifier = Modifier.height(8.dp))
            LogOut()
        }
    }
}

@Composable
fun ProfileSection(
    navController: NavController
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box {
            AsyncImage(model = ImageRequest.Builder(LocalContext.current).data(R.drawable.h)
                .crossfade(true).build(),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable {
                        navController.navigate(Screens.ProfileImageScreen.route)
                    }
                    .size(100.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .wrapContentHeight()
                    .clip(CircleShape)
                    .size(40.dp)
                    .clickable {

                    }
                    .background(
                        if (isSystemInDarkTheme()) Color.Black else Color.White,
                    )
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.PhotoCamera,
                    contentDescription = "Change Profile",
                    tint = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {

                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Emmanuel Bett",
                    fontWeight = FontWeight.ExtraBold,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "@emmanuel_bett",
                    fontWeight = FontWeight.Light,
                    color = Color.Blue,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

            }
            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = null
            )

        }
    }
}

@Composable
fun LogOut() {
    Button(
        onClick = { /*TODO*/ },
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) Color.White.copy(.24f) else Color.White.copy(
                .24f
            ), contentColor = Color.Red
        )
    ) {
        Icon(
            imageVector = Icons.Default.Logout,
            contentDescription = "LogoutIcon",
            tint = Color.Red
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Logout"
        )
    }
}
@Composable
fun NavItems() {
    Column {
        SupportSettingsItem(icon = Icons.Default.Payments, mainText = "Payments") {

        }
        Spacer(modifier = Modifier.height(4.dp))
        SupportSettingsItem(icon = Icons.Default.CardMembership, mainText = "MemberShip") {

        }
        Spacer(modifier = Modifier.height(4.dp))
        SupportSettingsItem(icon = Icons.Default.CardGiftcard, mainText = "Refer & Earn") {

        }
        Spacer(modifier = Modifier.height(4.dp))
        SupportSettingsItem(icon = Icons.Default.Help, mainText = "Help") {

        }
    }
}

@Composable
fun EditProfile() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isSystemInDarkTheme()) Color.White.copy(.24f) else Color.Black.copy(
                    .24f
                ),
                contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
            )
        ) {
            Icon(
                imageVector = Icons.Default.Edit, contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Edit Profile",
                fontWeight = FontWeight.ExtraBold,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            )
        }
    }
}

@Composable
fun EnableDarkTheme() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Enable Dark Theme",
            fontSize = 18.sp,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontWeight = FontWeight.Light
        )
        CustomSwitch(
            checkable = true,
            checked = isSystemInDarkTheme(),
            onCheckedChange = !isSystemInDarkTheme()
        )
    }
}