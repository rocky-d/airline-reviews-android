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
        val dbHelper = UserDatabaseHelper(this)
        val db = dbHelper.writableDatabase

        // Check if the "user" table exists, if not, create it
        dbHelper.createTableIfNotExists(db)

        val columns = arrayOf("USR_NAME", "USR_HASHEDPASSWORD")
        val selection = "USR_NAME = ?"
        val selectionArgs = arrayOf(username)
        val cursor = db.query("user", columns, selection, selectionArgs, null, null, null)

        val userExists = cursor.moveToFirst()

        if (userExists) {
            val passwordIndex = cursor.getColumnIndex("USR_HASHEDPASSWORD")

            return if (passwordIndex != -1) {
                val storedPassword = cursor.getString(passwordIndex)
                cursor.close()
                db.close()
                password == storedPassword
            } else {
                // Handle the case where the column doesn't exist
                cursor.close()
                db.close()
                false
            }
        } else {
            // User doesn't exist, add the new user to the table
            val contentValues = ContentValues()
            contentValues.put("USR_NAME", username)
            contentValues.put("USR_HASHEDPASSWORD", hashPassword(password))
            db.insert("user", null, contentValues)
            cursor.close()
            db.close()
            return true
        }
    }

    fun hashPassword(password: String): Long {
        val DIGEST_ALGORITHM = "SHA-256"
        val SALT = "6GYxNi78Dqd2I"
        try {
            var hashedPassword: Long = 0
            val digest = MessageDigest.getInstance(DIGEST_ALGORITHM)
            val bytes = digest.digest((password + SALT).toByteArray(UTF_8))
            for (b in bytes) {
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