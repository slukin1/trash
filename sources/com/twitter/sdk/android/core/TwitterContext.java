package com.twitter.sdk.android.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

class TwitterContext extends ContextWrapper {
    private final String componentName;
    private final String componentPath;

    public TwitterContext(Context context, String str, String str2) {
        super(context);
        this.componentName = str;
        this.componentPath = str2;
    }

    public File getCacheDir() {
        return new File(super.getCacheDir(), this.componentPath);
    }

    public File getDatabasePath(String str) {
        File file = new File(super.getDatabasePath(str).getParentFile(), this.componentPath);
        file.mkdirs();
        return new File(file, str);
    }

    public File getExternalCacheDir() {
        return new File(super.getExternalCacheDir(), this.componentPath);
    }

    public File getExternalFilesDir(String str) {
        return new File(super.getExternalFilesDir(str), this.componentPath);
    }

    public File getFilesDir() {
        return new File(super.getFilesDir(), this.componentPath);
    }

    public SharedPreferences getSharedPreferences(String str, int i11) {
        return super.getSharedPreferences(this.componentName + ":" + str, i11);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i11, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i11, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str).getPath(), cursorFactory, databaseErrorHandler);
    }
}
