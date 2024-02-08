package com.app.myapplication

import MyDbHelper
import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import java.net.URL
import java.util.concurrent.locks.Condition

class Contentpvovider : ContentProvider() {
    companion object{
        val PROVIDER_NAME ="com.app.myapplication/Contentprovider"
        val URL = "content://$PROVIDER_NAME/LEMAYIAN_RECORDS"
        val CONTENT_URI: Uri = Uri.parse(URL)

        val admin_no ="ADMIN_NO"
        val name ="NAME"
        val course ="COURSE"
    }
    lateinit var db:SQLiteDatabase
    override fun onCreate(): Boolean {
        var helper= MyDbHelper(context)
        db = helper.writableDatabase
        return if (db==null)false else true
    }

    override fun query(
        uri: Uri,
        cols: Array<out String>?,
        condition: String?,
        condition_val: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
         return db.query("LEMAYIAN_RECORDS",cols,condition,condition_val,null,null,sortOrder)
    }

    override fun getType(uri: Uri): String? {
        return "vnd.android.cursor.dir/com.app.myapplication/LEMAYIAN_RECORDS"
    }

    override fun insert(uri: Uri, cv: ContentValues?): Uri? {
        db.insert("LEMAYIAN_RECORDS",null,cv)
        context?.contentResolver?.notifyChange(uri,null)
        return uri
    }

    override fun delete(uri: Uri, condition: String?, condition_val: Array<out String>?): Int {
        var count = db.delete("LEMAYIAN_RECORDS",condition,condition_val)
        context?.contentResolver.notifyChange(uri,null)
        return count
    }

    override fun update(
        uri: Uri,
        cv: ContentValues?,
        condition: String?,
        condition_val: Array<out String>?
    ): Int {
       var count = db.update("LEMAYIAN_RECORDS",cv,condition,condition_val)
        context?.contentResolver?.notifyChange(uri,null)
        return count

    }
}