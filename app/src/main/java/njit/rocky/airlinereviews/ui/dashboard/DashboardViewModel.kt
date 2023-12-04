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
import java.net.ProtocolException
import java.net.URL

class DashboardViewModel : ViewModel() {

    private val _imageData = MutableLiveData<Bitmap>()
    val imageData: LiveData<Bitmap> = _imageData

    fun fetchDataFromServer(airlineName: Array<String>) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = sendDataToServer(createJsonData(airlineName))
                val bitmap = BitmapFactory.decodeByteArray(response, 0, response.size)
                _imageData.postValue(bitmap)
            } catch (protocolException: ProtocolException) {
                println(protocolException)
            }
        }
    }

    private fun createJsonData(airlineName: Array<String>): String {
        return "{\"arl_name\":\"${airlineName[0]}\",\"width\":\"${airlineName[3].ifEmpty { 300 }}\",\"height\":\"${airlineName[4].ifEmpty { 200 }}\",\"bc\":\"${airlineName[5]}\"}"
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

        val buffer = ByteArray(2048)
        var bytesRead: Int
        while (inputStream.read(buffer).also { bytesRead = it } != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead)
        }

        return byteArrayOutputStream.toByteArray()
    }
}