package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class TransferDatabaseHelper extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    public final Context f14969b;

    /* renamed from: c  reason: collision with root package name */
    public int f14970c;

    public TransferDatabaseHelper(Context context) {
        this(context, 6);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        TransferTable.f(sQLiteDatabase, this.f14970c);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        this.f14969b.deleteDatabase("awss3transfertable.db");
        onCreate(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        TransferTable.g(sQLiteDatabase, i11, i12);
    }

    public TransferDatabaseHelper(Context context, int i11) {
        super(context, "awss3transfertable.db", (SQLiteDatabase.CursorFactory) null, i11);
        this.f14969b = context;
        this.f14970c = i11;
    }
}
