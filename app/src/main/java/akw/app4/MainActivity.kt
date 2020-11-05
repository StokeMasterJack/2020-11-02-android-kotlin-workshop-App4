package akw.app4

import akw.app4.ui.App4Theme
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App4Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Main(2)
                }
            }
        }
    }
}

@Composable
fun Main(currentScreen: Int) {
    when (currentScreen) {
        1 -> Screen1()
        2 -> Screen2()
        3 -> Screen3()
    }
}

@Composable
fun Screen1() {
    Text(text = "Screen1")
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
        Main(1)
    }
}