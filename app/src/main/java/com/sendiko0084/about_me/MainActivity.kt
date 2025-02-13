package com.sendiko0084.about_me

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sendiko0084.about_me.model.Hewan
import com.sendiko0084.about_me.ui.theme.Mobpro1Theme

class MainActivity : ComponentActivity() {

    private val data = getData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mobpro1Theme {
                MainScreen()
            }
        }
    }

    private fun getData(): List<Hewan> {
        return listOf(
            Hewan(
                nama = "Ayam",
                imageResId = R.drawable.ayam
            ),
            Hewan(
                nama = "Bebek",
                imageResId = R.drawable.bebek
            ),
            Hewan(
                nama = "Kambing",
                imageResId = R.drawable.kambing
            ),
            Hewan(
                nama = "Bebek",
                imageResId = R.drawable.bebek
            ),
            Hewan(
                nama = "Domba",
                imageResId = R.drawable.domba
            ),
            Hewan(
                nama = "Kambing",
                imageResId = R.drawable.kambing
            ),
            Hewan(
                nama = "Sapi",
                imageResId = R.drawable.sapi
            ),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Mobpro1Theme {
    }
}