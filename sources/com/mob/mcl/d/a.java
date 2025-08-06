package com.mob.mcl.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "elp_msg.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            SQLiteDatabase.class.getMethod("execSQL", new Class[]{String.class}).invoke(sQLiteDatabase, new Object[]{"CREATE TABLE msg (workId TEXT PRIMARY KEY,expireTime INTEGER )"});
        } catch (Throwable th2) {
            b.a().a(th2);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }
}
