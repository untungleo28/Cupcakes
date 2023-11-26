package com.example.cupcake.data

import com.example.cupcake.R
/**
 * Objek DataSource berisi data mentah yang digunakan dalam aplikasi Cupcake.
 * Ini mencakup daftar rasa kue dan opsi kuantitas.
 */
object DataSource {
    // Daftar ID sumber daya string yang mewakili berbagai rasa kue
    val flavors = listOf(
        R.string.vanilla,
        R.string.chocolate,
        R.string.red_velvet,
        R.string.salted_caramel,
        R.string.coffee
    )
    // Daftar pasangan kunci nilai yang mewakili opsi kuantitas kue
    val quantityOptions = listOf(
        Pair(R.string.one_cupcake, 1),
        Pair(R.string.six_cupcakes, 6),
        Pair(R.string.twelve_cupcakes, 12)
    )
}
