package com.example.task_1_screenlayout.screens

import android.os.Bundle
import android.util.Log
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.task_1_screenlayout.R
import com.example.task_1_screenlayout.network.model.CoffeeImageResponse
import com.example.task_1_screenlayout.network.repository.CoffeeRepository
import com.example.task_1_screenlayout.ui.theme.SoraFontFamily
import com.example.task_1_screenlayout.ui.theme.colorBackgroudWhite
import com.example.task_1_screenlayout.ui.theme.colorDarkOrange
import com.example.task_1_screenlayout.ui.theme.colorGrey
import com.example.task_1_screenlayout.ui.theme.colorGreyWhite
import kotlinx.coroutines.launch

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: HomeViewModel = viewModel()
            homeScreen(viewModel = viewModel)
        }
    }
}

@Composable
fun homeScreen(viewModel: HomeViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorBackgroudWhite)
    ) {
        secondHalfOfHomeScreen(viewModel)
        firstHalfOfHomeScreen(viewModel)

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
fun secondHalfOfHomeScreen(viewModel: HomeViewModel) {
    Scaffold(
        bottomBar = {
            BottomMenu()
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .width(327.dp)
                .height(545.dp)
                .offset(x = 24.dp, y = 375.dp)
                .padding(innerPadding)
        ) {
            Column {
                CoffeeCategoryRow(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
                CoffeeCategoryColumn(viewModel)
            }
        }
    }
}


@Composable
fun firstHalfOfHomeScreen(viewModel: HomeViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF313131),
                        Color(0xFF111111)
                    ),
                    start = androidx.compose.ui.geometry.Offset(
                        0f,
                        Float.POSITIVE_INFINITY
                    ),
                    end = androidx.compose.ui.geometry.Offset(
                        Float.POSITIVE_INFINITY,
                        0f
                    )
                )
            )
    ) {
        Box(
            modifier = Modifier
                .width(161.dp)
                .height(43.dp)
                .offset(x = 24.dp, y = 68.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Location",
                    fontFamily = SoraFontFamily,
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp,
                    lineHeight = 14.4.sp,
                    color = colorGrey,
                    modifier = Modifier
                        .width(55.dp)
                        .height(14.dp)
                )

                Row(
                    modifier = Modifier
                        .width(176.dp)
                        .height(21.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Bilzen, Tanjungbalai",
                        fontFamily = SoraFontFamily,
                        fontWeight = FontWeight.W600,
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        color = colorGreyWhite,
                        modifier = Modifier.weight(1f)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "Custom Icon",
                        modifier = Modifier
                            .width(14.dp)
                            .height(14.dp)
                    )
                }
            }
        }

        var searchText by rememberSaveable { mutableStateOf("") }
        val keyboardController = LocalSoftwareKeyboardController.current

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
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .width(259.dp)
                        .height(52.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = Color.Transparent
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFF2C2C2C),
                                        Color(0xFF2A2A2A)
                                    )
                                )
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = "Search Image",
                                modifier = Modifier
                                    .width(16.89.dp)
                                    .height(17.27.dp),
                            )

                            BasicTextField(
                                value = searchText,
                                onValueChange = { searchText = it },
                                textStyle = TextStyle(
                                    fontSize = 16.sp,
                                    color = Color.White
                                ),
                                singleLine = true,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(horizontal = 8.dp),
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                                keyboardActions = KeyboardActions(
                                    onSearch = {
                                        viewModel.fetchCoffeeImage(searchText)
                                        keyboardController?.hide()
                                    }
                                ),
                                decorationBox = { innerTextField ->
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Box(modifier = Modifier.weight(1f)) {
                                            if (searchText.isEmpty()) {
                                                Text(
                                                    text = "Search coffee",
                                                    fontSize = 16.sp,
                                                    color = Color.Gray
                                                )
                                            }
                                            innerTextField()
                                        }

                                        if (searchText.isNotEmpty()) {
                                            IconButton(
                                                onClick = {
                                                    searchText = ""
                                                    keyboardController?.hide()
                                                },
                                                modifier = Modifier.size(24.dp)
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Default.Close,
                                                    contentDescription = "Clear",
                                                    tint = Color.Gray
                                                )
                                            }
                                        }
                                    }
                                }
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .background(
                            color = colorDarkOrange,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clickable {
                            viewModel.fetchCoffeeImage(searchText)
                            keyboardController?.hide()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (viewModel.isLoading.value) {
                        CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "Search",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}


data class BottomMenuItem(
    val label: String,
    val icon: Int,
    val selectedIndicator: Int
)

@Composable
fun CoffeeCategoryColumn(viewModel: HomeViewModel = viewModel()) {
    val productImages = listOf(
        R.drawable.item_1,
        R.drawable.item_2,
        R.drawable.item_2,
        R.drawable.item_2
    )

    LazyColumn(
        modifier = Modifier
            .width(327.dp)
            .height(240.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            when {
                viewModel.isLoading.value -> LoadingState()
                viewModel.errorMessage.value != null -> ErrorState(viewModel)
                viewModel.coffeeImage.value != null -> CoffeeImageLoader(viewModel)
                else -> EmptyState(viewModel)
            }
        }

        items(productImages.chunked(2)) { pair ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                pair.forEach { imageRes ->
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .width(156.dp)
                            .height(238.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CoffeeImageLoader(viewModel: HomeViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(bottom = 16.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        AsyncImage(
            model = viewModel.coffeeImage.value?.file,
            contentDescription = "Coffee image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun LoadingState() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorState(viewModel: HomeViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = "Error",
            tint = Color.Red,
            modifier = Modifier.size(48.dp)
        )
        Text(
            text = viewModel.errorMessage.value ?: "Произошла ошибка",
            color = Color.Red,
            modifier = Modifier.padding(8.dp)
        )
        Button(
            onClick = { viewModel.fetchCoffeeImage() },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorDarkOrange
            )
        ) {
            Text("Обновить")
        }
    }
}

@Composable
fun EmptyState(viewModel: HomeViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Нет результатов поиска",
            color = Color.Gray
        )
        Button(
            onClick = { viewModel.fetchCoffeeImage() },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorDarkOrange
            ),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Попробовать снова")
        }
    }
}

// Обновленный ViewModel
class HomeViewModel : ViewModel() {
    private val repository = CoffeeRepository()
    val coffeeImage = mutableStateOf<CoffeeImageResponse?>(null)
    val isLoading = mutableStateOf(false)
    val errorMessage = mutableStateOf<String?>(null)
    var lastQuery = ""

    fun fetchCoffeeImage(query: String = "") {
        lastQuery = query
        isLoading.value = true
        errorMessage.value = null
        coffeeImage.value = null

        viewModelScope.launch {
            try {
                coffeeImage.value = repository.getRandomCoffeeImage()
            } catch (e: Exception) {
                errorMessage.value = when {
                    e.message?.contains("404") == true -> "Ничего не найдено"
                    else -> "Ошибка: ${e.message}"
                }
            } finally {
                isLoading.value = false
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true, name = "pre")
@Composable
fun HomeScreenPreview() {
    homeScreen(viewModel = HomeViewModel())
}

@Composable
fun BottomMenuIcon(item: BottomMenuItem, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.label,
            modifier = Modifier.size(24.dp),
            colorFilter = if (isSelected) {
                ColorFilter.tint(Color(0xFFC67C4E))
            } else {
                ColorFilter.tint(Color(0xFFA2A2A2))
            }
        )

        if (isSelected) {
            Image(
                painter = painterResource(id = item.selectedIndicator),
                contentDescription = "Selected indicator",
                modifier = Modifier.size(8.dp)
                    .padding(top = 4.dp)
            )
        }
    }
}

@Composable
fun CoffeeCategoryRow(modifier: Modifier = Modifier) {
    val coffeeItems = listOf(
        "All Coffee",
        "Machiato",
        "Latte",
        "Americano"
    )

    val selectedItem = remember { mutableStateOf("All Coffee") }

    LazyRow(
        modifier = modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(end = 8.dp)
    ) {
        items(coffeeItems) { item ->
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .background(
                        color = if (item == selectedItem.value) colorDarkOrange else Color(0xFFF5F5F5),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .padding(
                        top = 4.dp,
                        bottom = 4.dp,
                        start = 8.dp,
                        end = 8.dp
                    )
                    .clickable {
                        selectedItem.value = item
                    }
            ) {
                Text(
                    text = item,
                    fontFamily = SoraFontFamily,
                    fontWeight = if (item == selectedItem.value) FontWeight.W600 else FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    color = if (item == selectedItem.value) Color.White else Color(0xFF313131),
                )
            }
        }
    }
}

@Composable
fun BottomMenu() {
    val menuItems = listOf(
        BottomMenuItem("Home", R.drawable.menu_home, R.drawable.selected_dot),
        BottomMenuItem("Favorite", R.drawable.heart, R.drawable.selected_dot),
        BottomMenuItem("Cart", R.drawable.cart, R.drawable.selected_dot),
        BottomMenuItem("Profile", R.drawable.notification, R.drawable.selected_dot)
    )

    val selectedItem = remember { mutableStateOf(menuItems[0].label) }

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(99.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp
                )
            ),
        containerColor = Color.White,
        contentPadding = PaddingValues(24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            menuItems.forEach { item ->
                BottomMenuIcon(
                    item = item,
                    isSelected = item.label == selectedItem.value,
                    onClick = { selectedItem.value = item.label }
                )
            }
        }
    }
}