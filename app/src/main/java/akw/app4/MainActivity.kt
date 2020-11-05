package akw.app4

import akw.app4.ui.App4Theme
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.padding(20.dp)
                ) {
                    MainNav()
                }
            }
        }
    }
}


@Composable
fun MainNav() {

    val nav: NavHostController = rememberNavController()

    val onNav: (route: String) -> Unit = {
        nav.navigate(it)
    }

    NavHost(navController = nav, startDestination = "Screen1") {
        composable("Screen1") { Screen1(onNav) }
        composable("Screen2") { Screen2() }
        composable("Screen3") { Screen3() }
    }


}
//
//@Composable
//fun MainCrude() {
//
//    val (currentScreen, setCurrentScreen) = remember { mutableStateOf(1) }
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        Head(currentScreen, setCurrentScreen)  //3 buttons:  Screen1,Screen2,Screen3
//        Body(currentScreen)
//    }
//
//}
//
//@Composable
//fun Body(currentScreen: Int) {
//    when (currentScreen) {
//        1 -> Screen1()
//        2 -> Screen2()
//        3 -> Screen3()
//    }
//}
//
//@Composable
//fun VSpace(preferredHeight:Int = 10) {
//    Spacer(modifier = Modifier.preferredHeight(preferredHeight.dp))
//}
//@Composable
//fun HSpace(preferredWidth:Int = 10) {
//    Spacer(modifier = Modifier.preferredWidth(preferredWidth.dp))
//}
//
//@Composable
//fun Head(currentScreen: Int, onNav: (screen: Int) -> Unit) {
//    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
//        Button(onClick = { onNav(1) }) { Text(text = "S1", fontWeight = if (currentScreen == 1) FontWeight.Bold else FontWeight.Normal) }
//        HSpace()
//        Button(onClick = { onNav(2) }) { Text(text = "S2", fontWeight = if (currentScreen == 2) FontWeight.Bold else FontWeight.Normal) }
//        HSpace()
//        Button(onClick = { onNav(3) }) { Text(text = "S3", fontWeight = if (currentScreen == 3) FontWeight.Bold else FontWeight.Normal) }
//    }
//}

@Composable
fun Screen1(onNav: (screen: String) -> Unit) {
    Column {
        Text(text = "Screen1")
        Button(onClick = { onNav("Screen2") }) { Text(text = "S2") }
    }
}

@Composable
fun Screen2() {
    Text(text = "Screen2")
}

@Composable
fun Screen3() {
    Text(text = "Screen3")
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App4Theme {
        MainNav()
    }
}