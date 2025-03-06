package com.example.task_1_screenlayout.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
        firstHalfOfHomeScreen()
        secondHalfOfHomeScreen()
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "banner Image",
            modifier = Modifier
                .width(327.dp)
                .height(140.dp)
                .offset(x = 24.dp, y = 211.dp),
            contentScale = ContentScale.Crop
        )

    }
}

@Composable
fun secondHalfOfHomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(436.dp)
            .offset(y = 375.dp)
    ) {
        // Внутренний Box с параметрами из скриншота
        Box(
            modifier = Modifier
                .width(327.dp)
                .height(545.dp)
                .offset(x = 24.dp)
                .background(color = Color.Gray)
        ) {
            Column {
                // LazyRow с элементами
                CoffeeCategoryRow(
                    modifier = Modifier
                        .padding(bottom = 16.dp) // Отступ между LazyRow и LazyColumn
                )
                CoffeeCategoryColumn()
            }
        }
    }
}

@Composable
fun CoffeeCategoryRow(modifier: Modifier = Modifier) {
    // Список элементов для LazyRow
    val coffeeItems = listOf(
        "All Coffee", // Первый элемент
        "Machiato",
        "Latte",
        "Americano"
    )

    // Состояние для отслеживания выбранного элемента
    val selectedItem = remember { mutableStateOf("All Coffee") }

    // LazyRow с элементами
    LazyRow(
        modifier = modifier
            .fillMaxWidth(), // Заполняет всю ширину
        contentPadding = PaddingValues(end = 8.dp) // Отступ только справа (чтобы первый элемент был прижат к краю)
    ) {
        items(coffeeItems) { item ->
            // Элемент LazyRow
            Box(
                modifier = Modifier
                    .padding(end = 8.dp) // Отступ между элементами (кроме последнего)
                    .background(
                        color = if (item == selectedItem.value) colorDarkOrange else Color(0xFFF5F5F5), // Оранжевый фон для выбранного элемента
                        shape = RoundedCornerShape(6.dp) // Закругленные углы
                    )
                    .padding(
                        top = 4.dp, // Отступ сверху
                        bottom = 4.dp, // Отступ снизу
                        start = 8.dp, // Отступ слева
                        end = 8.dp // Отступ справа
                    )
                    .clickable { // Обработка нажатия
                        selectedItem.value = item
                    }
            ) {
                Text(
                    text = item, // Текст на кнопке
                    fontFamily = SoraFontFamily, // Шрифт Sora
                    fontWeight = if (item == selectedItem.value) FontWeight.W600 else FontWeight.W400, // Вес шрифта 600 (SemiBold)
                    fontSize = 14.sp, // Размер шрифта 14sp
                    lineHeight = 21.sp, // Высота строки 21sp
                    color = if (item == selectedItem.value) Color.White else Color(0xFF313131), // Белый текст для выбранного элемента, черный — для остальных
                )
            }
        }
    }
}
@Composable
fun CoffeeCategoryColumn(){
    // Временные данные для элементов
    val productItems = listOf(
        "Product 1", // Первый элемент
        "Product 2",
        "Product 3",
        "Product 4"
    )

    // LazyColumn с элементами
    LazyColumn(
        modifier = Modifier
            .width(327.dp) // Ширина LazyColumn
            .height(500.dp) // Высота LazyColumn
            .background(
                color = Color.LightGray, // Цвет фона
                shape = RoundedCornerShape(16.dp) // Закругленные углы
            )
            .padding(16.dp) // Внутренний отступ
    ) {
        items(productItems) { item ->
            // Элемент LazyColumn
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp) // Высота каждого элемента
                    .background(Color.White, shape = RoundedCornerShape(8.dp)) // Цвет фона элемента
                    .padding(8.dp) // Внутренний отступ элемента
            ) {
                Text(
                    text = item, // Текст элемента
                    modifier = Modifier.align(Alignment.Center), // Выравнивание текста по центру
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}


@Composable
fun firstHalfOfHomeScreen(){
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


@Preview(showBackground = true, showSystemUi = true, name = "pre")
@Composable
fun HomeScreenPreview() {
    homeScreen()
}