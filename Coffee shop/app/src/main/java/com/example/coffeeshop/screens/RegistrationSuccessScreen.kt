package com.example.coffeeshop.screens

//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.coffeeshop.ui.theme.SoraFontFamily
//import com.example.coffeeshop.ui.theme.colorFoundationGrey
//import androidx.compose.foundation.layout.Box
//
//import androidx.compose.foundation.layout.Column
//
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.HorizontalDivider
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.draw.blur
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.SpanStyle
//import androidx.compose.ui.text.buildAnnotatedString
//import androidx.compose.ui.text.style.TextDecoration
//import androidx.compose.ui.text.withStyle
//import com.example.coffeeshop.R
//import com.example.coffeeshop.ui.theme.colorDarkOrange
//import com.example.coffeeshop.ui.theme.colorLightGrey
//import com.example.coffeeshop.ui.theme.colorLightRecGrey
//
//class RegistrationSuccessScreen : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            registrationSuccessScreen() // Ваш основной Composable-компонент
//        }
//    }
//}
//
//@Composable
//fun registrationSuccessScreen() {
//    // Размытый фон
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .blur(8.dp) // Размытие фона
//    ) {
//        Text(
//            text = "Create Account",
//            fontFamily = SoraFontFamily, // Шрифт Sora
//            fontWeight = FontWeight.W600, // Вес шрифта 600 (SemiBold)
//            fontSize = 20.sp, // Размер шрифта 20px
//            lineHeight = 24.sp, // Высота строки 24px
//            color = colorFoundationGrey, // Цвет текста #242424
//            textAlign = TextAlign.Center, // Выравнивание по центру
//            modifier = Modifier
//                .width(162.dp) // Ширина текста 162px
//                .height(24.dp) // Высота текста 24px
//                .offset(x = 107.dp, y = 163.dp) // Смещение текста
//        )
//
//        // Текст "Add information about yourself."
//        Text(
//            text = "Add information about yourself.",
//            fontFamily = SoraFontFamily, // Шрифт Sora
//            fontWeight = FontWeight.W400, // Вес шрифта 400 (Regular)
//            fontSize = 16.sp, // Размер шрифта 16px
//            lineHeight = 19.2.sp, // Высота строки 19.2px
//            color = colorLightGrey, // Цвет текста #9C9C9C
//            textAlign = TextAlign.Center, // Выравнивание по центру
//            modifier = Modifier
//                .width(300.dp) // Ширина текста 258px
//                .height(19.dp) // Высота текста 19px
//                .offset(x = 38.dp, y = 203.dp) // Смещение текста
//        )
//
//        Text(
//            text = "Name",
//            fontFamily = SoraFontFamily, // Шрифт Sora
//            fontWeight = FontWeight.W400, // Вес шрифта 400 (Regular)
//            fontSize = 16.sp, // Размер шрифта 16px
//            lineHeight = 24.sp,
//            color = colorFoundationGrey,
//            modifier = Modifier
//                .width(49.dp) // Ширина текста 299px
//                .height(24.dp) // Высота текста 19px
//                .offset(x = 24.dp, y = 267.dp)
//        )
//
//        Column(
//            modifier = Modifier
//                .padding(start = 22.dp, top = 291.dp) // Отступы слева и сверху
//        ) {
//            Box(
//                modifier = Modifier
//                    .width(330.dp) // Ширина прямоугольника 330px
//                    .height(40.dp) // Высота прямоугольника 40px
//                    .clip(RoundedCornerShape(10.dp)) // Закругленные углы с радиусом 10px
//                    .background(colorLightRecGrey) // Цвет прямоугольника #EDEDED
//
//            )
//        }
//
//        Text(
//            text = "Email",
//            fontFamily = SoraFontFamily, // Шрифт Sora
//            fontWeight = FontWeight.W400, // Вес шрифта 400 (Regular)
//            fontSize = 16.sp, // Размер шрифта 16px
//            lineHeight = 24.sp,
//            color = colorFoundationGrey,
//            modifier = Modifier
//                .width(44.dp) // Ширина текста 299px
//                .height(24.dp) // Высота текста 19px
//                .offset(x = 24.dp, y = 336.dp)
//        )
//
//        Column(
//            modifier = Modifier
//                .padding(start = 22.dp, top = 360.dp) // Отступы слева и сверху
//        ) {
//            Box(
//                modifier = Modifier
//                    .width(330.dp) // Ширина прямоугольника 330px
//                    .height(40.dp) // Высота прямоугольника 40px
//                    .clip(RoundedCornerShape(10.dp)) // Закругленные углы с радиусом 10px
//                    .background(colorLightRecGrey) // Цвет прямоугольника #EDEDED
//
//            )
//        }
//
//        Text(
//            text = "Password",
//            fontFamily = SoraFontFamily, // Шрифт Sora
//            fontWeight = FontWeight.W400, // Вес шрифта 400 (Regular)
//            fontSize = 16.sp, // Размер шрифта 16px
//            lineHeight = 24.sp,
//            color = colorFoundationGrey,
//            modifier = Modifier
//                .width(80.dp)
//                .height(24.dp)
//                .offset(x = 24.dp, y = 403.dp)
//        )
//
//        Column(
//            modifier = Modifier
//                .padding(start = 24.dp, top = 427.dp) // Отступы слева и сверху
//        ) {
//            Box(
//                modifier = Modifier
//                    .width(330.dp) // Ширина прямоугольника 330px
//                    .height(40.dp) // Высота прямоугольника 40px
//                    .clip(RoundedCornerShape(10.dp)) // Закругленные углы с радиусом 10px
//                    .background(colorLightRecGrey) // Цвет прямоугольника #EDEDED
//            )
//        }
//
//        Image(
//            painter = painterResource(id = R.drawable.eye_off), // Иконка из drawable
//            contentDescription = "Eye Icon", // Описание для доступности
//            modifier = Modifier
//                .width(24.dp) // Ширина иконки 24px
//                .height(24.dp) // Высота иконки 24px
//                .offset(x = 322.dp, y = 434.dp) // Позиция иконки (Left: 320px, Top: 400px)
//        )
//
//        HorizontalDivider(
//            modifier = Modifier
//                .width(335.dp) // Ширина линии 295px (или на весь экран, если нужно)
//                .padding(start = 39.dp, top = 507.dp), // Позиция линии (Left: 39px, Top: 473px)
//            thickness = 1.dp, // Толщина линии 1px
//            color = Color(0xFFE3E3E3) // Цвет линии #E3E3E3
//        )
//
//        Button(
//            onClick = {  },
//            modifier = Modifier
//                .width(327.dp) // Ширина кнопки 327px
//                .height(56.dp) // Высота кнопки 56px
//                .offset(x = 24.dp, y = 523.dp), // Позиция кнопки (Left: 24px, Top: 489px)
//            shape = RoundedCornerShape(16.dp), // Закругленные углы с радиусом 16px
//            colors = ButtonDefaults.buttonColors(
//                containerColor = colorDarkOrange
//            )
//        ) {
//            Text(
//                text = "Sign Up", // Текст на кнопке
//                fontFamily = SoraFontFamily, // Шрифт Sora
//                fontWeight = FontWeight.W600, // Вес шрифта 600 (SemiBold)
//                fontSize = 16.sp, // Размер шрифта 16px
//                lineHeight = 24.sp, // Высота строки 24px
//                color = Color.White, // Цвет текста #FFFFFF
//                modifier = Modifier
//                    .width(65.dp)
//                    .height(24.dp)// Отступы внутри кнопки
//            )
//        }
//
//        HorizontalDivider(
//            modifier = Modifier
//                .fillMaxWidth() // Ширина линии 375px (или на весь экран, если нужно)
//                .padding(top = 710.dp), // Позиция линии (Top: 710px)
//            thickness = 4.dp, // Толщина линии 4px
//            color = Color(0xFFF9F2ED)
//        )
//
//        Text(
//            text = buildAnnotatedString {
//                withStyle(
//                    style = SpanStyle(
//                        color = colorFoundationGrey // Цвет для "Don't have an account?"
//                    )
//                ) {
//                    append("Already have an account? ") // Обычный текст
//                }
//                withStyle(
//                    style = SpanStyle(
//                        color = colorDarkOrange, // Цвет для "Sign Up"
//                        textDecoration = TextDecoration.Underline // Подчеркивание
//                    )
//                ) {
//                    append("Sign In") // Подчеркнутый текст
//                }
//            },
//            fontFamily = SoraFontFamily, // Шрифт Sora
//            fontWeight = FontWeight.W400, // Вес шрифта 400 (Regular)
//            fontSize = 16.sp, // Размер шрифта 16px
//            lineHeight = 19.2.sp, // Высота строки 19.2px
//            textAlign = TextAlign.Center, // Выравнивание по центру
//            modifier = Modifier
//                .width(276.dp) // Ширина текста 256px
//                .height(19.dp) // Высота текста 19px
//                .offset(x = 54.dp, y = 735.dp) // Позиция текста (Left: 56px, Top: 735px)
//        )
//
//    }
//
//    Box (
//        modifier = Modifier
//            .fillMaxSize()
//
//    ){
//        Image(
//            painter = painterResource(id = R.drawable.success), // Укажите ваш вектор
//            contentDescription = "Vector Image", // Описание для доступности
//            modifier = Modifier
//                .width(100.dp) // Ширина 100dp
//                .height(100.dp) // Высота 100dp
//                .offset(x = 140.dp, y = 330.dp), // Смещение (если нужно)
//        )
//
//        Button(
//            onClick = {  },
//            modifier = Modifier
//                .width(327.dp) // Ширина кнопки 327px
//                .height(56.dp) // Высота кнопки 56px
//                .offset(x = 24.dp, y = 523.dp), // Позиция кнопки (Left: 24px, Top: 489px)
//            shape = RoundedCornerShape(16.dp), // Закругленные углы с радиусом 16px
//            colors = ButtonDefaults.buttonColors(
//                containerColor = colorDarkOrange
//            )
//        ) {
//            Text(
//                text = "OK", // Текст на кнопке
//                fontFamily = SoraFontFamily, // Шрифт Sora
//                fontWeight = FontWeight.W600, // Вес шрифта 600 (SemiBold)
//                fontSize = 16.sp, // Размер шрифта 16px
//                lineHeight = 24.sp, // Высота строки 24px
//                color = Color.White, // Цвет текста #FFFFFF
//                modifier = Modifier
//                    .width(30.dp)
//                    .height(24.dp)// Отступы внутри кнопки
//            )
//        }
//        Text(
//            text = "Congratulations!",
//            fontFamily = SoraFontFamily, // Шрифт Sora
//            fontWeight = FontWeight.W600, // Вес шрифта 400 (Regular)
//            fontSize = 20.sp, // Размер шрифта 16px
//            lineHeight = 24.sp,
//            color = Color.Black,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .width(175.dp)
//                .height(24.dp)
//                .offset(x = 95.dp,y = 440.dp)
//        )
//        Text(
//            text = "Registration was successful.",
//            fontFamily = SoraFontFamily, // Шрифт Sora
//            fontWeight = FontWeight.W400, // Вес шрифта 400 (Regular)
//            fontSize = 16.sp, // Размер шрифта 16px
//            lineHeight = 19.2.sp,
//            color = Color.Black,
//
//            modifier = Modifier
//                .width(249.dp)
//                .height(19.dp)
//                .offset(x = 70.dp,y = 470.dp)
//        )
//
//    }
//
//}
//
//@Preview(showBackground = true, showSystemUi = true, name = "pre")
//@Composable
//fun RegistrationSuccessScreenPreview() {
//    registrationSuccessScreen()
//}