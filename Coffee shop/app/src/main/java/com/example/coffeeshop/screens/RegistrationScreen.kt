package com.example.coffeeshop.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeshop.ui.theme.SoraFontFamily
import com.example.coffeeshop.ui.theme.colorFoundationGrey
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeeshop.R
import com.example.coffeeshop.network.repository.RegistrationManager
import com.example.coffeeshop.ui.theme.colorBackgroudWhite
import com.example.coffeeshop.ui.theme.colorDarkOrange
import com.example.coffeeshop.ui.theme.colorLightGrey
import com.example.coffeeshop.ui.theme.colorLightRecGrey
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun RegistrationScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorBackgroudWhite)
    ) {

        Text(
            text = "Создать Аккаунт",
            fontFamily = SoraFontFamily,
            fontWeight = FontWeight.W600,
            fontSize = 20.sp,
            lineHeight = 24.sp,
            color = colorFoundationGrey,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(162.dp)
                .height(24.dp)
                .offset(x = 107.dp, y = 163.dp)
        )


        Text(
            text = "Добавьте информацию о себе.",
            fontFamily = SoraFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 16.sp,
            lineHeight = 19.2.sp,
            color = colorLightGrey,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(300.dp)
                .height(19.dp)
                .offset(x = 38.dp, y = 203.dp)
        )
        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }

        Text(
            text = "Логин",
            fontFamily = SoraFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            color = colorFoundationGrey,
            modifier = Modifier
                .width(49.dp)
                .height(24.dp)
                .offset(x = 24.dp, y = 267.dp)
        )

        Box(
            modifier = Modifier
                .padding(start = 22.dp, top = 291.dp,end = 22.dp)
                .fillMaxWidth()
                .height(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(colorLightRecGrey),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 16.sp,
                    lineHeight = 16.sp
                ),
                singleLine = true
            )

        }

        Text(
            text = "Почта",
            fontFamily = SoraFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            color = colorFoundationGrey,
            modifier = Modifier
                .width(48.dp)
                .height(24.dp)
                .offset(x = 24.dp, y = 336.dp)
        )

        Box(
            modifier = Modifier
                .padding(start = 22.dp, top = 360.dp,end = 22.dp)
                .fillMaxWidth()
                .height(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(colorLightRecGrey),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 16.sp,
                    lineHeight = 16.sp
                ),
                singleLine = true
            )
        }

        Text(
            text = "Пароль",
            fontFamily = SoraFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Center,
            color = colorFoundationGrey,
            modifier = Modifier
                .width(56.dp)
                .height(24.dp)
                .offset(x = 24.dp, y = 403.dp)
        )

        Box(
            modifier = Modifier
                .padding(start = 22.dp, top = 427.dp,end = 22.dp)
                .fillMaxWidth()
                .height(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(colorLightRecGrey),
            contentAlignment = Alignment.CenterStart

        ) {
            BasicTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 16.sp,
                    lineHeight = 16.sp
                ),
                visualTransformation = if (passwordVisible)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
                singleLine = true
            )

            IconButton(
                onClick = { passwordVisible = !passwordVisible },
                modifier = Modifier
                    .size(48.dp)
                    .align(alignment = Alignment.CenterEnd)
            ) {
                Icon(
                    painter = painterResource(
                        id = if (passwordVisible)
                            R.drawable.eye_on_foreground
                        else
                            R.drawable.eye_off_foreground
                    ),
                    contentDescription = if (passwordVisible)
                        "Скрыть пароль"
                    else
                        "Показать пароль",
                    tint = colorFoundationGrey
                )
            }


        }



        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 39.dp, top = 507.dp, end = 39.dp),
            thickness = 1.dp,
            color = Color(0xFFE3E3E3)
        )

        val registrationManager = remember { RegistrationManager() }
        var errorMessage by remember { mutableStateOf<String?>(null) }
        var isLoading by remember { mutableStateOf(false) }
        val context = LocalContext.current

        LaunchedEffect(errorMessage) {
            errorMessage?.let { message ->
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                errorMessage = null
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 523.dp, end = 24.dp)

        ) {

            Button(
                onClick = {

                    if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                        errorMessage = "Все поля должны быть заполнены"
                        Log.d("Registration", "Все поля должны быть заполнены")
                        return@Button
                    }

                    errorMessage = null
                    isLoading = true

                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            Log.d("Registration", "Начало регистрации...")
                            val result = registrationManager.registerUser(name, email, password)

                            withContext(Dispatchers.Main) {
                                isLoading = false

                                when {
                                    result.isSuccess -> {
                                        Log.d("Registration", "Регистрация успешна!")
                                    }
                                    else -> {
                                        val error = result.exceptionOrNull()
                                        errorMessage = when {
                                            error?.message?.contains("400") == true -> "Неверная почта"
                                            error?.message?.contains("409") == true -> "Пользователь уже существует"
                                            error?.message?.contains("500") == true -> "Ошибка сервера"
                                            else -> "Ошибка: ${error?.message ?: "Неизвестная ошибка"}"
                                        }
                                    }
                                }
                            }
                        } catch (e: Exception) {
                            withContext(Dispatchers.Main) {
                                isLoading = false
                                errorMessage = "Ошибка сети: ${e.message}"
                                Log.e("Registration", "Ошибка в корутине", e)
                            }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorDarkOrange
                )
            ) {
                Text(
                    text = "Зарегистрироваться",
                    fontFamily = SoraFontFamily,
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    color = Color.White
                )
            }
        }

        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 710.dp),
            thickness = 4.dp,
            color = Color(0xFFF9F2ED)
        )

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = colorFoundationGrey
                        )
                    ) {
                        append("У вас уже есть учетная запись? ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = colorDarkOrange,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("Войти")
                    }
                },
                fontFamily = SoraFontFamily,
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                lineHeight = 19.2.sp,
                textAlign = TextAlign.Center,
            )
            }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "pre")
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen(navController = rememberNavController())
}