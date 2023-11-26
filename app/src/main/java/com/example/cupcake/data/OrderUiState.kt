package com.example.cupcake.data

/**
 * Kelas data OrderUiState merepresentasikan status UI saat ini dalam hal [quantity], [flavor],
 * [dateOptions], pickup date yang terpilih [date], dan [price].
 */
data class OrderUiState(
    /** Jumlah kue yang dipilih (1, 6, 12) */
    val quantity: Int = 0,
    /** Rasa dari kue dalam pesanan (seperti "Cokelat", "Vanila", dll.) */
    val flavor: String = "",
    /** Tanggal terpilih untuk pengambilan (seperti "1 Jan") */
    val date: String = "",
    /** Harga total untuk pesanan */
    val price: String = "",
    /** Opsi tanggal pengambilan yang tersedia untuk pesanan */
    val pickupOptions: List<String> = listOf()
)

