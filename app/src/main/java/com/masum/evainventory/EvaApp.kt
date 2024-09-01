package com.masum.evainventory

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.masum.evainventory.ui.theme.Dimensions
import com.masum.evainventory.ui.theme.EvaInventoryTheme
import com.masum.evainventory.ui.theme.evaBlack
import com.masum.evainventory.ui.theme.evaColor
import com.masum.evainventory.ui.theme.evaColor40
import com.masum.evainventory.ui.theme.evaDarkGray
import com.masum.evainventory.ui.theme.evaLightGray2
import com.masum.evainventory.ui.theme.evaRedBrown
import com.masum.evainventory.ui.theme.evaWhite
import com.masum.evainventory.ui.theme.grayDarkLight
import com.masum.evainventory.ui.theme.interFontFamily
import com.masum.evainventory.ui.theme.robotoFontFamily

@Composable
fun EvaApp(
    viewModel: EvaViewModel = hiltViewModel(),
) {
    val dataList by viewModel.allData.collectAsStateWithLifecycle()

    EvaInventoryTheme(darkTheme = false, dynamicColor = false) {
        var selected by remember {
            mutableIntStateOf(-1)
        }

        val circleDimens = listOf(
            CircleDimen(
                evaColor,
                circleSize = Dimensions.size1900,
                titleSize = Dimensions.text275,
                descriptionSize = Dimensions.text150,
                true
            ),
            CircleDimen(
                evaBlack, circleSize = Dimensions.size1600,
                titleSize = Dimensions.text250,
                descriptionSize = Dimensions.text125,
                darkMode = true
            ),
            CircleDimen(
                grayDarkLight, circleSize = Dimensions.size1100, titleSize = Dimensions.text175,
                descriptionSize = Dimensions.text150,
                darkMode = false
            ),
            CircleDimen(
                evaColor40, circleSize = Dimensions.size950,
                titleSize = Dimensions.text200,
                descriptionSize = Dimensions.text100,
                darkMode = false
            )

        )
        Scaffold(
            modifier = Modifier.fillMaxSize(),

            ) { innerPadding ->
            LazyColumn(
                modifier = Modifier.padding(innerPadding),
            ) {
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IntroducationBox()


                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = Dimensions.padding750),
                        ) {

                            if(ShowDebugText){
                                Text(
                                    text = "dp=${LocalConfiguration.current.screenWidthDp} padding=${Dimensions.padding100} size=${Dimensions.size100}, text= ${Dimensions.text100}",
                                    textAlign = TextAlign.Center
                                )
                            }


                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                TextCircle(
                                    index = 0,
                                    value = if (dataList.isNotEmpty()) dataList[0].size else 0,
                                    description = "Utilized",
                                    circleDimen = circleDimens[2],
                                    selectedIndex = selected,
                                    onChangeSelection = { index -> selected = index }
                                )
                                TextCircle(
                                    value = if (dataList.isNotEmpty()) dataList[1].size else 0,
                                    description = "Soon Out of stock",
                                    circleDimen = circleDimens[0],
                                    index = 1,
                                    selectedIndex = selected,
                                    onChangeSelection = { index -> selected = index }
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                TextCircle(
                                    value = if (dataList.isNotEmpty()) dataList[2].size else 0,
                                    description = "Quantity revisions needed",
                                    circleDimens[1],
                                    2,
                                    selected,
                                ) { index -> selected = index }
                                TextCircle(
                                    value = if (dataList.isNotEmpty()) dataList[3].size else 0,
                                    description = " Out of stock",
                                    circleDimen = circleDimens[3],
                                    index = 3,
                                    selectedIndex = selected,
                                    onChangeSelection = { index -> selected = index }
                                )
                            }
                        }

                        Row(
                            modifier = Modifier.padding(top = Dimensions.padding500),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_info),
                                contentDescription = null
                            )
                            Text(
                                modifier = Modifier.padding(start = Dimensions.padding100),
                                text = "Click on the items to expand the list",
                                color = evaLightGray2,
                                fontFamily = robotoFontFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = Dimensions.text150,

                                )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = Dimensions.padding875,
                                    top = Dimensions.padding525,
                                    end = Dimensions.padding875
                                ),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Name",
                                color = evaLightGray2,
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = Dimensions.text125,
                            )
                            Text(
                                text = "Amount left",
                                color = evaLightGray2,
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = Dimensions.text125,
                            )
                        }

                    }
                }
                if (selected >= 0 && selected < dataList.size) {
                    items(dataList[selected]) {
                        Row(

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = Dimensions.padding875,
                                    top = Dimensions.padding100,
                                    bottom = Dimensions.padding100,
                                    end = Dimensions.padding875
                                ),
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {
                            Text(
                                text = it.name,
                                color = evaBlack,
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = Dimensions.text150,
                            )

                            Text(
                                text = "${it.quantity} ${it.unit}",
                                color = evaRedBrown,
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = Dimensions.text150,
                            )

                        }
                    }
                }
            }
        }
    }

}


@Composable
fun TextCircle(
    value: Int,
    description: String,
    circleDimen: CircleDimen,
    index: Int,
    selectedIndex: Int?,
    onChangeSelection: (Int) -> Unit,
) {

    val circleTextColor = if (circleDimen.darkMode) evaWhite else evaBlack

    Card(
        modifier = Modifier
            .padding(horizontal = Dimensions.padding150)
            .size(circleDimen.circleSize),
        elevation = CardDefaults
            .cardElevation(defaultElevation = if (index == selectedIndex) Dimensions.padding150 else 0.dp),
        shape = CircleShape,
        colors = CardDefaults.cardColors(containerColor = circleDimen.color),
        onClick = { onChangeSelection(index) }

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = value.toString(),
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Bold,
                color = circleTextColor,
                fontSize = circleDimen.titleSize
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = Dimensions.padding100),
                text = description,
                textAlign = TextAlign.Center,
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Medium,
                color = circleTextColor,
                fontSize = circleDimen.descriptionSize,
                lineHeight = Dimensions.text150
            )
        }

    }

}

@Composable
private fun IntroducationBox() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = Dimensions.padding300,
                start = Dimensions.padding250,
                end = Dimensions.padding250
            )
            .background(color = evaWhite, shape = RoundedCornerShape(Dimensions.padding150)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = Dimensions.padding350),
            text = "Intorducing",
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Medium,
            color = evaDarkGray,
            fontSize = Dimensions.text175
        )
        Text(
            modifier = Modifier.padding(top = Dimensions.padding50),
            text = "Eva Inventory",
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimensions.text300,
            color = evaColor
        )
        Text(
            modifier = Modifier.padding(top = Dimensions.padding50, bottom = Dimensions.padding250),
            text = "Manage your inventory",
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Medium,
            color = evaBlack,

            )

    }
}

@Preview(showBackground = true)
@Preview(name = "Pixel 6A", device = Devices.PIXEL_6A)
@Preview(name = "Pixel 2 XL", device = Devices.PIXEL_2_XL)
@Preview(name = "Pixel 4 A", device = Devices.PIXEL_4A)
@Preview(name = "Pixel XL", device = Devices.PIXEL_XL)
@Preview(name = "Pixel Tablet", device = Devices.PIXEL_TABLET)
@Composable
fun EvaPreview() {
    EvaApp()

}