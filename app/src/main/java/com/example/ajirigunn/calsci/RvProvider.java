package com.example.ajirigunn.calsci;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.CursorAdapter;

import static com.example.hp.field_s.database.address;
import static com.example.hp.field_s.database.day;
import static com.example.hp.field_s.database.name;
import static com.example.hp.field_s.database.phone;
import static com.example.hp.field_s.database.place;
import static com.example.hp.field_s.database.time;
import static com.example.hp.field_s.database.topics;

/**
 * Created by HP on 11/06/2018.
 */

public class RvProvider extends ContentProvider {
    private static final UriMatcher murimatcher=new UriMatcher(UriMatcher.NO_MATCH);
    static {
        murimatcher.addURI("com.example.hp.field_s","record",101);
        murimatcher.addURI("com.example.hp.field_s","record/#",102);
        murimatcher.addURI("com.example.hp.field_s","record/*",103);

    }
    public SQLiteDatabase db;
    @Override
    public boolean onCreate() {
        Context context=getContext();
        database dbhelper=new database(context,null,null,1);
        db=dbhelper.getWritableDatabase();
        return (db==null)?false:true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {

        int match = murimatcher.match(uri);
        if (match == 101) {
            return db.query(database.dbname, new String[]{name, address, topics, day, place, time, phone}, null, null, null, null, null);
        } else if (match == 103) {
            String urr = String.valueOf(uri);
            urr = urr.replace("content://com.example.hp.field_s/", "").replace(" ", "");
            database daba = new database(this.getContext(), null, null, 0);
            Cursor cursor=daba.dayquery(urr);
            cursor.setNotificationUri(getContext().getContentResolver(),uri);
            return cursor;

        } else {
            return null;
        }

    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {

        long id= db.insert(database.dbname,null,contentValues);

        getContext().getContentResolver().notifyChange(uri,null);
        return ContentUris.withAppendedId(uri,id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
