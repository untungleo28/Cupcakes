package com.example.cupcake.ui

import androidx.lifecycle.ViewModel
import com.example.cupcake.data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

/** Harga untuk satu cupcake */
private const val HARGA_PER_CUPCAKE = 20.000

/** Biaya tambahan untuk pengambilan pesanan pada hari yang sama */
private const val BIAYA_PENGAMBILAN_HARI_SAMA = 30.00

/**
 * [OrderViewModel] menyimpan informasi tentang pesanan kue dalam hal jumlah, rasa, dan
 * tanggal pengambilan. Ini juga tahu cara menghitung total harga berdasarkan detail pesanan ini.
 */
class OrderViewModel : ViewModel() {

    /**
     * Status UI pesanan kue
     */
    private val _uiState = MutableStateFlow(OrderUiState(pickupOptions = pickupOptions()))
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    /**
     * Mengatur jumlah [numberCupcakes] kue untuk status pesanan ini dan memperbarui harga
     */
    fun setQuantity(numberCupcakes: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                quantity = numberCupcakes,
                price = calculatePrice(quantity = numberCupcakes)
            )
        }
    }

    /**
     * Mengatur [desiredFlavor] kue untuk status pesanan ini.
     * Hanya satu rasa dapat dipilih untuk seluruh pesanan.
     */
    fun setFlavor(desiredFlavor: String) {
        _uiState.update { currentState ->
            currentState.copy(flavor = desiredFlavor)
        }
    }

    /**
     * Mengatur [pickupDate] untuk status pesanan ini dan memperbarui harga
     */
    fun setDate(pickupDate: String) {
        _uiState.update { currentState ->
            currentState.copy(
                date = pickupDate,
                price = calculatePrice(pickupDate = pickupDate)
            )
        }
    }

    /**
     * Mereset status pesanan
     */
    fun resetOrder() {
        _uiState.value = OrderUiState(pickupOptions = pickupOptions())
    }

    /**
     * Mengembalikan harga yang dihitung berdasarkan detail pesanan.
     */
    private fun calculatePrice(
        quantity: Int = _uiState.value.quantity,
        pickupDate: String = _uiState.value.date
    ): String {
        var calculatedPrice = quantity * HARGA_PER_CUPCAKE
        // Jika pengguna memilih opsi pertama (hari ini) untuk pengambilan, tambahkan biaya tambahan
        if (pickupOptions()[0] == pickupDate) {
            calculatedPrice += BIAYA_PENGAMBILAN_HARI_SAMA
        }
        val formattedPrice = NumberFormat.getCurrencyInstance().format(calculatedPrice)
        return formattedPrice
    }

    /**
     * Mengembalikan daftar opsi tanggal dimulai dari tanggal saat ini dan 3 tanggal berikutnya.
     */
    private fun pickupOptions(): List<String> {
        val dateOptions = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        // tambahkan tanggal saat ini dan 3 tanggal berikutnya.
        repeat(4) {
            dateOptions.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return dateOptions
    }
}