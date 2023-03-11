package com.example.m_parking.core.utils

import androidx.annotation.DrawableRes
import com.example.m_parking.R

sealed class OnboadingPage(
    @DrawableRes
    val image: Int,
    val title:String,
    val description:String
){
    object PageOne : OnboadingPage(
        image = R.drawable.page_one,
        title = "Welcom",
        description = "we are so pleased to welcome you to M-Parking a plase to save more time and get affordable parking slots with fair prices"
    )
    object PageTwo : OnboadingPage(
        image = R.drawable.page_two,
        title = "Welcom",
        description = "we are so pleased to welcome you to M-Parking a plase to save more time and get affordable parking slots with fair prices"
    )
    object PageThree : OnboadingPage(
        image = R.drawable.page_three,
        title = "Welcom",
        description = "we are so pleased to welcome you to M-Parking a plase to save more time and get affordable parking slots with fair prices"
    )
}
