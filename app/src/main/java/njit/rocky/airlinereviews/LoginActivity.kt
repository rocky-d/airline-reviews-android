package njit.rocky.airlinereviews

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.nio.charset.StandardCharsets.UTF_8
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.system.exitProcess

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

            if (username.isEmpty() || password.isEmpty()) {
                // Username or password is empty, show a toast and treat it as invalid credentials
                Toast.makeText(this, "Username and Password cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                if (isValidCredentials(username, password)) {
                    // Credentials are valid, navigate to the main activity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    // finish() // Optional: finish the login activity to prevent going back to it
                } else {
                    // Invalid credentials, show a toast or an error message
                    Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        val dbHelper = UserDatabaseHelper(this)
        val db = dbHelper.writableDatabase

        // Check if the "user" table exists, if not, create it
        dbHelper.createTableIfNotExists(db)

        val cursor = db.query(
            "user",
            arrayOf("USR_NAME", "USR_HASHEDPASSWORD"),
            "USR_NAME = ?",
            arrayOf(username),
            null,
            null,
            null
        )

        val res = if (cursor.moveToFirst()) {
            cursor.getLong(1) == hashPassword(password)
        } else {
            // User doesn't exist, add the new user to the table
            val contentValues = ContentValues()
            contentValues.put("USR_NAME", username)
            contentValues.put("USR_HASHEDPASSWORD", hashPassword(password))
            db.insert("user", null, contentValues)
            true
        }
        cursor.close()
        db.close()
        return res
    }

    private fun hashPassword(password: String): Long {
        val DIGEST_ALGORITHM = "SHA-256"
        val SALT = "6GYxNi78Dqd2I"
        try {
            var hashedPassword: Long = 0
            for (b in MessageDigest.getInstance(DIGEST_ALGORITHM)
                .digest((password + SALT).toByteArray(UTF_8))) {
                hashedPassword = hashedPassword shl 8
                hashedPassword = hashedPassword or (b.toLong() and 0xFF)
            }
            return hashedPassword
        } catch (noSuchAlgorithmException: NoSuchAlgorithmException) {
            println("${noSuchAlgorithmException::class.java.name}: ${noSuchAlgorithmException.message}")
            noSuchAlgorithmException.printStackTrace(System.err)
            exitProcess(-2302)
        }
    }
}