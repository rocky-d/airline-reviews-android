package njit.rocky.airlinereviews.ui.dashboard

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.ByteArrayOutputStream
import java.net.HttpURLConnection
import java.net.URL

class DashboardViewModel : ViewModel() {

    private val _imageData = MutableLiveData<Bitmap>()
    val imageData: LiveData<Bitmap> = _imageData

    fun fetchDataFromServer(airlineName: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val response = sendDataToServer(createJsonData(airlineName))

            val bitmap = BitmapFactory.decodeByteArray(response, 0, response.size)
            _imageData.postValue(bitmap)
        }
    }

    private fun createJsonData(airlineName: String): String {
        return "hello"
    }

    private suspend fun sendDataToServer(jsonData: String): ByteArray {
        val url = URL("http://10.0.2.2:5000/android")
        val connection = url.openConnection() as HttpURLConnection

        connection.requestMethod = "POST"
        connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8")
        connection.doOutput = true

        val outputStream = BufferedOutputStream(connection.outputStream)
        outputStream.write(jsonData.toByteArray())
        outputStream.flush()

        val inputStream = BufferedInputStream(connection.inputStream)
        val byteArrayOutputStream = ByteArrayOutputStream()

        inputStream.use {
            it.copyTo(byteArrayOutputStream)
        }

        return byteArrayOutputStream.toByteArray()
    }
}