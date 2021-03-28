package com.example.ajirigunn.calsci.personal_classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AJIRI GUNN on 12/25/2017.
 */
public class recentsdatabase extends SQLiteOpenHelper {
    public static String name="recents.db";
    static String tablename="Recent";
    static String row="function";
    static String id="id";

    public recentsdatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "recents.db", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+tablename+" ("+id+" INTEGER PRIMARY KEY,"+row+" TEXT);");
        ContentValues cv=new ContentValues();
        cv.put(row,"No recents");
        sqLiteDatabase.insert(tablename,null,cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(" drop table if exists "+tablename);
        onCreate(sqLiteDatabase);
    }
    public String getValues(){
        SQLiteDatabase sq=this.getReadableDatabase();
        Cursor c=sq.query(tablename, new String[]{row},null,null,null,null,null,null);
        String  result=null;
        c.moveToFirst();
        if(c.getString(0)!=null){
            result=c.getString(0);
        }
        return result;
    }
    public void setrecent(String funs){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(row,funs);

        db.update(tablename,cv,"where id=1",null);
    }
}
