package com.huobi.woodpecker.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;

public class BackupDBHelper {
    public final void a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + str2 + " AS SELECT * FROM " + str);
    }

    public final void b(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        a(sQLiteDatabase, str, str2);
    }

    public final void c(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    public final List<String> d(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT name FROM SQLITE_MASTER WHERE type='table' ORDER BY name", (String[]) null);
        while (rawQuery.moveToNext()) {
            arrayList.add(rawQuery.getString(0));
        }
        rawQuery.close();
        return arrayList;
    }

    public final String[] e(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str, (String[]) null);
        String[] columnNames = rawQuery.getColumnNames();
        rawQuery.close();
        return columnNames;
    }

    public final void f(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        String join = TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, e(sQLiteDatabase, str2));
        sQLiteDatabase.execSQL("INSERT INTO " + str + "(" + join + ") SELECT " + join + " FROM " + str2);
    }

    public void g(SQLiteDatabase sQLiteDatabase, SQLiteOpenHelper sQLiteOpenHelper) {
        for (String next : d(sQLiteDatabase)) {
            if (!"android_metadata".equals(next) && !"sqlite_sequence".equals(next)) {
                String str = next + "_Temp";
                b(sQLiteDatabase, next, str);
                c(sQLiteDatabase, next);
                sQLiteOpenHelper.onCreate(sQLiteDatabase);
                f(sQLiteDatabase, next, str);
                c(sQLiteDatabase, str);
            }
        }
    }
}
