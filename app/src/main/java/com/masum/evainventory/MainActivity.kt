package com.masum.evainventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masum.evainventory.ui.theme.Dimensions
import com.masum.evainventory.ui.theme.evaBlack
import com.masum.evainventory.ui.theme.evaColor
import com.masum.evainventory.ui.theme.evaDarkGray
import com.masum.evainventory.ui.theme.evaWhite
import com.masum.evainventory.ui.theme.interFontFamily
import com.masum.evainventory.ui.theme.robotoFontFamily
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_main)

        val composeView=findViewById<androidx.compose.ui.platform.ComposeView>(R.id.compose_view)
        composeView.setContent {
            EvaApp()
        }
    }


}
const val  ShowDebugText = true
