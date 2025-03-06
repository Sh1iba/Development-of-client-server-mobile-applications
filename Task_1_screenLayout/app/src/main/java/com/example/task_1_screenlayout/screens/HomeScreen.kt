package com.example.task_1_screenlayout.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.task_1_screenlayout.R
import com.example.task_1_screenlayout.ui.theme.SoraFontFamily
import com.example.task_1_screenlayout.ui.theme.colorBackgroudWhite
import com.example.task_1_screenlayout.ui.theme.colorDarkOrange
import com.example.task_1_screenlayout.ui.theme.colorFoundationGrey
import com.example.task_1_screenlayout.ui.theme.colorGrey
import com.example.task_1_screenlayout.ui.theme.colorGreyWhite
import com.example.task_1_screenlayout.ui.theme.colorLightGrey
import com.example.task_1_screenlayout.ui.theme.colorLightRecGrey

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            homeScreen() // Ваш основной Composable-компонент
        }
    }
}

@Composable
fun homeScreen() {
    // Размытый фон
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorBackgroudWhite)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF313131), // Первый цвет (#313131)
                            Color(0xFF111111)  // Второй цвет (#111111)
                        ),
                        start = androidx.compose.ui.geometry.Offset(
                            0f,
                            Float.POSITIVE_INFINITY
                        ), // Нижний левый угол
                        end = androidx.compose.ui.geometry.Offset(
                            Float.POSITIVE_INFINITY,
                            0f
                        )   // Верхний правый угол
                    )
                )
        )
        {
            Box(
                modifier = Modifier
                    .width(161.dp)
                    .height(43.dp)
                    .offset(x = 24.dp, y = 68.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(), // Занимает весь родительский Box
                    verticalArrangement = Arrangement.spacedBy(8.dp) // Расстояние между текстами (Gap = 8px)
                ) {
                    // Текст "Location"
                    Text(
                        text = "Location",
                        fontFamily = SoraFontFamily, // Шрифт Sora
                        fontWeight = FontWeight.W400, // Вес шрифта 400 (Regular)
                        fontSize = 12.sp, // Размер шрифта 12px
                        lineHeight = 14.4.sp, // Высота строки 14.4px
                        color = colorGrey, // Цвет текста #9C9C9C
                        modifier = Modifier
                            .width(55.dp) // Ширина текста 55px
                            .height(14.dp) // Высота текста 14px
                    )

                    // Текст "Bilzen, Tanjungbalai" с иконкой
                    Row(
                        modifier = Modifier
                            .width(176.dp) // Ширина контейнера
                            .height(21.dp), // Высота контейнера
                        verticalAlignment = Alignment.CenterVertically // Выравнивание по вертикали
                    ) {
                        // Текст "Bilzen, Tanjungbalai"
                        Text(
                            text = "Bilzen, Tanjungbalai",
                            fontFamily = SoraFontFamily, // Шрифт Sora
                            fontWeight = FontWeight.W600, // Вес шрифта 600 (SemiBold)
                            fontSize = 14.sp, // Размер шрифта 14px
                            lineHeight = 21.sp, // Высота строки 21px
                            color = colorGreyWhite, // Цвет текста
                            modifier = Modifier.weight(1f) // Занимает всё доступное пространство
                        )

                        // Иконка
                        Image(
                            painter = painterResource(id = R.drawable.img), // Укажите ваш drawable
                            contentDescription = "Custom Icon",
                            modifier = Modifier
                                .width(14.dp)
                                .height(14.dp)
                        )
                    }


                }
            }

            var searchText by remember { mutableStateOf("") } // Состояние для текста поиска
            Box(
                modifier = Modifier
                    .width(327.dp)
                    .height(52.dp)
                    .offset(x = 24.dp, y = 135.dp)
                    .zIndex(1f)


            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically, // Выравнивание по вертикали
                    horizontalArrangement = Arrangement.spacedBy(16.dp) // Расстояние между элементами (Gap
                ){

                Surface(
                    modifier = Modifier
                        .width(259.dp) // Ширина 259px
                        .height(52.dp), // Высота 52px
                    shape = RoundedCornerShape(12.dp), // Закругленные углы 12px
                    color = Color.Transparent // Прозрачный цвет, так как фон задается градиентом
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFF2C2C2C), // Начальный цвет (#2C2C2C)
                                        Color(0xFF2A2A2A)  // Конечный цвет (#2A2A2A)
                                    )
                                )
                            )
                    ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp), // Отступы 16px
                        verticalAlignment = Alignment.CenterVertically, // Выравнивание по вертикали
                        horizontalArrangement = Arrangement.spacedBy(8.dp) // Расстояние между элементами (Gap = 8px)
                    ){
                        // Иконка поиска
                        Image(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "Search Image",
                            modifier = Modifier
                                .width(16.89.dp)
                                .height(17.27.dp),
                        )

                        // Поле ввода
                        BasicTextField(
                            value = searchText,
                            onValueChange = { searchText = it },
                            textStyle = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Black
                            ),
                            singleLine = true,
                            modifier = Modifier
                                .weight(1f) // Занимает всё доступное пространство
                                .padding(horizontal = 8.dp),
                            decorationBox = { innerTextField ->
                                if (searchText.isEmpty()) {
                                    Text(
                                        text = "Search coffee",
                                        fontSize = 16.sp,
                                        color = Color.Gray
                                    )
                                }
                                innerTextField()
                            }
                        )

                    }
                    }

                }
                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .background(
                            color = colorDarkOrange, // Временный цвет для проверки
                            shape = RoundedCornerShape(12.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.filter),
                        contentDescription = "Filter Icon",
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
        }
    }
        }



@Preview(showBackground = true, showSystemUi = true, name = "pre")
@Composable
fun HomeScreenPreview() {
    homeScreen()
}