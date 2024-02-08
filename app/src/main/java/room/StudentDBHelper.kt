import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context): SQLiteOpenHelper (context,"LEMA_RECORDS",1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE LEMAYIAN_RECORDS(ADMIN_NO INTEGER PRIMARY KEY AUTO INCREMENT,NAME TEXT , COURSE TEXT )")
        db?.execSQL("INSERT INTO LEMAYIAN_RECORDS(ADMIN_NO,NAME,COURSE) VALUES ('10625','Denis','Computer Science')")
        db?.execSQL("INSERT INTO LEMAYIAN_RECORDS (ADMIN_NO,NAME,COURSE) VALUES ('10628','Elkanah','Mechanical Engineering')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}