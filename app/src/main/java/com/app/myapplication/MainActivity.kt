package com.app.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var rs  = contentResolver.query(Contentpvovider.CONTENT_URI, arrayOf(Contentpvovider.admin_no,
            Contentpvovider.name,Contentpvovider.course), null,null,null)
        button.setOnClickListener{
            if(rs?.moveToNext()!!){
                editText.setText(rs.getString(1))
                editText2.seText(rs.getString())
            }
        }
    }
}