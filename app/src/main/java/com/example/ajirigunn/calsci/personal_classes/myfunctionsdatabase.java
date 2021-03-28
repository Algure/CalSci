package com.example.ajirigunn.calsci.personal_classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by AJIRI GUNN on 9/29/2017.
 */
public class myfunctionsdatabase extends SQLiteOpenHelper {
    public static final String dbname="myfun";
    public static final int dbversion=1;
    public static final String fun="myfunctions.db";
    // columns
    public static final String funvarnum="count";
    public static final String funid="id";
    public static final String funame="names";
    public static  final String funequation="formula";
    public static  final String funresult="answers";
    public static final String funvariables="variables";

    public  myfunctionsdatabase(Context context, Object o, Object o1, int i) {
        super(context, dbname, null, dbversion);
    }


    public int countallrows(){
        String where=null;
        SQLiteDatabase db=this.getReadableDatabase();
        String[] projection={funid,funame};
        Cursor c=db.query(dbname,projection,null,null,null,null,null,null);
        c.moveToLast();
        int i=c.getPosition();
        return i;
    }
    public Cursor getallrows(){
        String where=null;
        SQLiteDatabase db=this.getReadableDatabase();
        String[] projection={funid,funame};
        Cursor c=db.query(dbname,new String[]{funame},null,null,null,null,null,null);
        return c;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL("create table "+dbname+"("+funid+" INTEGER PRIMARY KEY,"+

                funame+" TEXT,"+
                funequation+" TEXT,"+
                funresult+" TEXT, "+
                funvariables+" TEXT,"+
                funvarnum+" INTEGER"+");");

       // insertnew();
    }
public void insertnew(){
    ContentValues vc=new ContentValues();
    vc.put(funame,"Simple Interest");
    vc.put(funequation,"P=I*R*T");
    vc.put(funresult,"P");
    vc.put(funvariables,"[I,R,T]");
    vc.put(funvarnum,3);
    SQLiteDatabase sqd=this.getWritableDatabase();
    sqd.insert(dbname,null,vc);
    sqd.close();
}
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+dbname);
        onCreate(db);
    }

    public void addfun(myfunctions myfun){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(funame,myfun.getName());
        values.put(funequation,myfun.getEquation());
        values.put(funresult,myfun.getResult());
        values.put(funvarnum,myfun.getVarcount());
        values.put(funvariables, Arrays.toString(myfun.getVariables()));

        db.insert(dbname,null,values);
        db.close();

    }


    public myfunctions getfun (int id){
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.query(fun,new String[]{funid,funame,funequation,funresult,funvariables},id+"=?",new String[]{String.valueOf(id)},null,null,null,null);

        if (cursor!=null){
            cursor.moveToFirst();
        }
        myfunctions myfun=new myfunctions(cursor.getString(1));
        myfun.setEquation(cursor.getString(2));
        myfun.setResult(cursor.getString(3));
        myfun.setVariables( cursor.getString(4).split(","));
        Cursor curs=db.query(fun,new String[]{String.valueOf(funvarnum)},funid+"=?",new String[]{String.valueOf(id)},null,null,null,null);
        myfun.setVarcount(Integer.parseInt(curs.getString(0)));
        return myfun;
    }
public Cursor getdata(String name){
    SQLiteDatabase db=getReadableDatabase();
    Cursor c=db.query(dbname,new String[]{funequation,funvariables},funame+"=?", new String[]{name},null,null,null,null);
    return c;
}
    public int getint(String name){
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.query(dbname,new String[]{(funvarnum)},funame+"=?", new String[]{name},null,null,null,null);
       c.moveToLast();

        return c.getInt(0);
    }

    public int numentries(){
        SQLiteDatabase db=getReadableDatabase();
        int numfunctions=(int) DatabaseUtils.queryNumEntries(db,fun);
        return numfunctions;
    }

    public boolean updatefun(int id,int count,String name,String add,String result,String vars){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(funame,name);
        cv.put(funequation,add);
        cv.put(funresult,result);
        cv.put(funvariables,vars);
        cv.put(funvarnum,count);
        db.update(fun,cv,"id=?",new String[]{Integer.toString(id)});
        db.close();
        return true;
    }

    public int deletefun(String fn){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(dbname,funame+"=?",new String[]{fn});
    }

    public ArrayList getall(){
        ArrayList al=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor res=db.rawQuery("select*from"+fun,null);
        res.moveToFirst();
        while (res.isAfterLast()==false){
            al.add(res.getString(res.getColumnIndex("id")));
            al.add(res.getString(res.getColumnIndex(funame)));
            al.add(res.getString(res.getColumnIndex(funequation)));
            al.add(res.getString(res.getColumnIndex(funresult)));
            al.add(res.getString(res.getColumnIndex(funvariables)));
            al.add(res.getString(res.getColumnIndex(String.valueOf(funvarnum))));
            res.moveToNext();
        }
        return al;
    }
    public boolean exists(String nn){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = null;
        try{
       cursor=db.query(dbname,new String[]{funame},funame+"=?",new String[]{nn},null,null,null,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        if(cursor.getString(0).toString().matches(nn)) {
            return true;
        }else{
                return false;
            }

    }finally{
        cursor.close();
    }

}
}
