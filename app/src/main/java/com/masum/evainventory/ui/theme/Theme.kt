package com.masum.evainventory.ui.theme

import android.os.Build
import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color(0xfffbfbfb)

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun EvaInventoryTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }



val config= LocalConfiguration.current
val dimension=if(config.screenWidthDp>=1280) Multiplier(8.0, sizeBase = 12.0, textBase = 12.0).normalDimens
    else if(config.screenWidthDp>=411)Multiplier(paddingBase = 8.3, sizeBase = 8.3, textBase = 8.3).normalDimens
    else Multiplier(paddingBase = 8.0, sizeBase = 8.0, textBase = 8.0).normalDimens
    ProvideDimens(dimensions = dimension) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }

}

@Composable
fun ProvideDimens(dimensions: Dimens, content: @Composable () -> Unit) {
    val dimensionSet = remember { dimensions }
    CompositionLocalProvider(LocalAppDimens provides dimensionSet, content = content)
}
private val LocalAppDimens = staticCompositionLocalOf {
    Multiplier(8.0).normalDimens
}

object EvaInventoryTheme{
    val dimens: Dimens
        @Composable
        get() = LocalAppDimens.current

}

val Dimensions: Dimens
    @Composable
    get() = EvaInventoryTheme.dimens

inline val Int.dp: Dp
    @Composable get() = with(LocalDensity.current) { this@dp.toDp() }

inline val Dp.px: Float
    @Composable get() = with(LocalDensity.current) { this@px.toPx() }
    
