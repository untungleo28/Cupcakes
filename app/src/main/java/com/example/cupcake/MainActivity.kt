package com.example.cupcake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.cupcake.ui.theme.CupcakeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Konfigurasi jendela agar tidak menyesuaikan sistem windows secara otomatis
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Mengatur konten utama dengan tema Cupcake
        setContent {
            CupcakeTheme {

                // Inisialisasi CupcakeApp sebagai aplikasi utama
                CupcakeApp()
            }
        }
    }
}
