package com.daematech.m_parking.core.utils

import androidx.annotation.DrawableRes
import com.daematech.m_parking.R

sealed class OnboadingPage(
    @DrawableRes
    val image: Int,
    val title:String,
    val description:String
){
    object PageOne : OnboadingPage(
        image = R.drawable.page_one,
        title = "Welcome",
        description = "we are so pleased to welcome you to M-Parking a place to save more time and get affordable parking slots with fair prices"
    )
    object PageTwo : OnboadingPage(
        image = R.drawable.page_two,
        title = "Look and Book",
        description = "Find Parking sport in the Address,city or state. " +
                "Book parking sport like your choice"
    )
    object PageThree : OnboadingPage(
        image = R.drawable.page_three,
        title = "Enjoy",
        description = "Locate a car in the place you parked your Vehicle"
    )
}
