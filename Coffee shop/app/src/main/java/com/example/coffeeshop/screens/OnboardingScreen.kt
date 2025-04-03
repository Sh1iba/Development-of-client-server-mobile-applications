package com.example.coffeeshop.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.coffeeshop.R
import com.example.coffeeshop.ui.theme.SoraFontFamily
import com.example.coffeeshop.ui.theme.colorDarkOrange
import com.example.coffeeshop.ui.theme.colorGrey

class OnboardingScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            onboardingScreen() // Ваш основной Composable-компонент
        }
    }
}

@Composable
fun onboardingScreen() {
    // Размытый фон
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        // Фоновое изображение
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(536.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.coffee),
                contentDescription = "Coffee Image",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // Белый Box, который должен быть поверх изображения
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
                .offset(y = 452.dp) // Смещение вниз на 452dp
                .zIndex(1f) // Убедитесь, что Box поверх изображения
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(215.dp)
                    .padding(start = 24.dp,top = 24.dp)

            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp) // Расстояние между элементами
                ) {
                    Text(
                        text = "Fall in Love with Coffee in Blissful Delight!",
                        fontFamily = SoraFontFamily, // Шрифт Sora
                        fontWeight = FontWeight.W600, // Вес шрифта 600 (SemiBold)
                        fontSize = 32.sp, // Размер шрифта 20px
                        lineHeight = 48.sp, // Высота строки 24px
                        color = Color.White, // Цвет текста #242424
                        letterSpacing = 0.005.sp, // Межбуквенный интервал 0.5%
                        textAlign = TextAlign.Center, // Выравнивание по центру
                        modifier = Modifier
                            .width(327.dp) // Ширина текста 162px
                            .height(144.dp) // Высота текста 24px

                    )

                    Text(
                        text = "Welcome to our cozy coffee corner, where every cup is a delightful for you.",
                        fontFamily = SoraFontFamily, // Шрифт Sora
                        fontWeight = FontWeight.W400, // Вес шрифта 400 (Regular)
                        fontSize = 14.sp, // Размер шрифта 16px
                        lineHeight = 21.sp, // Высота строки 19.2px
                        color = colorGrey, // Цвет текста #9C9C9C
                        letterSpacing = 0.01.sp, // Межбуквенный интервал 0.5%
                        textAlign = TextAlign.Center, // Выравнивание по центру
                        modifier = Modifier
                            .width(327.dp) // Ширина текста 258px
                            .height(42.dp) // Высота текста 19px
                    )

                }
            }
            Button(
                onClick = {  },
                modifier = Modifier
                    .width(327.dp) // Ширина кнопки 327px
                    .height(56.dp) // Высота кнопки 56px
                    .offset(x = 24.dp, y = 250.dp), // Позиция кнопки (Left: 24px, Top: 489px)
                    shape = RoundedCornerShape(16.dp), // Закругленные углы с радиусом 16px
                    colors = ButtonDefaults.buttonColors(
                    containerColor = colorDarkOrange
                )
            ) {
                Text(
                    text = "Get Started", // Текст на кнопке
                    fontFamily = SoraFontFamily, // Шрифт Sora
                    fontWeight = FontWeight.W600, // Вес шрифта 600 (SemiBold)
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp, // Размер шрифта 16px
                    lineHeight = 24.sp, // Высота строки 24px
                    color = Color.White, // Цвет текста #FFFFFF
                    modifier = Modifier
                        .width(116.dp)
                        .height(24.dp)// Отступы внутри кнопки
                )
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true, name = "pre")
@Composable
fun OnboardingScreenPreview() {
    onboardingScreen()
}