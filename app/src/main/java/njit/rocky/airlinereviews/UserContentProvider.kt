package njit.rocky.airlinereviews

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

class UserContentProvider : ContentProvider() {

    private lateinit var dbHelper: UserDatabaseHelper

    override fun onCreate(): Boolean {
        dbHelper = UserDatabaseHelper(context!!)
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        val db = dbHelper.readableDatabase
        return db.query("user", projection, selection, selectionArgs, null, null, sortOrder)
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val db = dbHelper.writableDatabase
        val id = db.insert("user", null, values)
        return Uri.withAppendedPath(uri, id.toString())
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val db = dbHelper.writableDatabase
        return db.delete("user", selection, selectionArgs)
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        val db = dbHelper.writableDatabase
        return db.update("user", values, selection, selectionArgs)
    }
}