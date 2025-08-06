package br;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huobi.search.database.BackupDBHelper;

public class d extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    public static String f77023b = "userSymbols.db";

    /* renamed from: c  reason: collision with root package name */
    public static int f77024c = 3;

    public d(Context context) {
        super(context, f77023b, (SQLiteDatabase.CursorFactory) null, f77024c);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS user_symbol_table( _id INTEGER PRIMARY KEY AUTOINCREMENT, uid VARCHAR, search_key_word VARCHAR, search_time TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS local_collecation_symbol_table( _id INTEGER PRIMARY KEY AUTOINCREMENT, uid TEXT, symbolid TEXT, market_type TEXT, from_type TEXT);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        new BackupDBHelper().g(sQLiteDatabase, this);
    }
}
