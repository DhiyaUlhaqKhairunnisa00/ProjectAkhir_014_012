package com.example.projectakhir

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.projectakhir.ui.theme.ProjectAkhirTheme

class MainActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000 // Waktu tampilan splash screen (dalam milidetik)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        // Handler untuk menunda pembukaan MainActivity
        Handler().postDelayed({
            // Intent untuk membuka MainActivity setelah SPLASH_TIME_OUT
            val intent = Intent(this, HalamanUtama::class.java)
            startActivity(intent)
            finish() // Menutup MainActivity agar tidak dapat kembali
        }, SPLASH_TIME_OUT)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectAkhirTheme {
        Greeting("Android")
    }
}
