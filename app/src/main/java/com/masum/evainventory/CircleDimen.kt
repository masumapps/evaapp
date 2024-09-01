package com.masum.evainventory

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masum.evainventory.ui.theme.Dimens
import com.masum.evainventory.ui.theme.Dimensions
import com.masum.evainventory.ui.theme.evaBlack
import com.masum.evainventory.ui.theme.evaColor
import com.masum.evainventory.ui.theme.evaColor40
import com.masum.evainventory.ui.theme.grayDarkLight

data class CircleDimen(
    val color: Color,
    val circleSize: Dp,
    val titleSize:TextUnit,
    val descriptionSize:TextUnit,
    val darkMode:Boolean
)


