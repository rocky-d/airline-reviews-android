package njit.rocky.airlinereviews

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            if (isValidCredentials(username, password)) {
                // Credentials are valid, navigate to the main activity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Optional: finish the login activity to prevent going back to it
            } else {
                // Invalid credentials, show a toast or an error message
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        // Implement your own logic for validating the credentials
        // You can compare the entered username and password with a predefined value,
        // check against a database, or use any other authentication mechanism.
        // Return true if credentials are valid, false otherwise.
        // Example: return (username == "admin" && password == "admin123")
        return true
    }
}