package njit.rocky.airlinereviews

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDatabaseHelper(context: Context) : SQLiteOpenHelper(context, "user.sqlite.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        createTableIfNotExists(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS user")
        onCreate(db)
    }

    fun createTableIfNotExists(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE IF NOT EXISTS user (\n" +
                    "    USR_NAME            TEXT     NOT NULL  PRIMARY KEY  UNIQUE,\n" +
                    "    USR_HASHEDPASSWORD  INTEGER  NOT NULL\n" +
                    ");\n"
        )
    }
}