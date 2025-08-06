package com.huawei.hms.framework.common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.io.Closeable;
import java.io.File;

public class NetworkKitSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME_DYNAMIC = "networkkit_dynamic.db";
    private static final String DB_NAME_LOCAL = "networkkit.db";
    private static final String DB_NAME_SUFFIX = "-journal";
    public static final int DB_VERSION = 1;
    private static final String TAG = "PLSQLiteOpenHelper";
    private static String dbName = DB_NAME_DYNAMIC;
    private static volatile NetworkKitSQLiteOpenHelper instance;

    static {
        if (ContextHolder.getKitContext() != null) {
        }
    }

    private NetworkKitSQLiteOpenHelper(Context context, String str, int i11) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i11);
    }

    public static NetworkKitSQLiteOpenHelper getInstance() {
        Context context;
        if (instance == null) {
            synchronized (NetworkKitSQLiteOpenHelper.class) {
                if (instance == null) {
                    if (Build.VERSION.SDK_INT < 24) {
                        context = ContextHolder.getAppContext();
                    } else {
                        context = ContextHolder.getAppContext().createDeviceProtectedStorageContext();
                    }
                    instance = new NetworkKitSQLiteOpenHelper(context, dbName, 1);
                }
            }
        }
        return instance;
    }

    public boolean deleteDbFile() {
        return deleteDbFileByPath(getNetworkKitReadableDatabase().getPath());
    }

    public boolean deleteDbFileByPath(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        Logger.i(TAG, "db is not exists");
        return false;
    }

    public boolean deleteUnusedDbFile() {
        String str = dbName;
        String str2 = DB_NAME_DYNAMIC;
        if (str.equals(str2)) {
            str2 = DB_NAME_LOCAL;
        }
        return deleteDbFileByPath(getNetworkKitReadableDatabase().getPath().replace(dbName, str2));
    }

    public SQLiteDatabase getDbByName(String str) {
        SQLiteDatabase networkKitReadableDatabase = getNetworkKitReadableDatabase();
        if (networkKitReadableDatabase == null) {
            return networkKitReadableDatabase;
        }
        String replace = networkKitReadableDatabase.getPath().replace(dbName, str);
        if (new File(replace).exists()) {
            return SQLiteDatabase.openDatabase(replace, (SQLiteDatabase.CursorFactory) null, 0);
        }
        Logger.i(TAG, "old db is not exists");
        return networkKitReadableDatabase;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbNameSuffix() {
        return DB_NAME_SUFFIX;
    }

    public SQLiteDatabase getNetworkKitReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = getReadableDatabase();
        } catch (Throwable th2) {
            Logger.e(TAG, "getReadableDatabase db error:" + th2.getMessage());
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            Logger.e(TAG, "getReadableDatabase db is null");
        }
        return sQLiteDatabase;
    }

    public SQLiteDatabase getNetworkKitWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = getWritableDatabase();
        } catch (Throwable th2) {
            Logger.e(TAG, "getWritableDatabase db error:" + th2.getMessage());
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            Logger.e(TAG, "getWritableDatabase db is null");
        }
        return sQLiteDatabase;
    }

    public SQLiteDatabase getNetworkkitUnusedDbDB() {
        String str = dbName;
        String str2 = DB_NAME_DYNAMIC;
        if (str.equals(str2)) {
            str2 = DB_NAME_LOCAL;
        }
        return getDbByName(str2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }

    public boolean tabbleIsExistInDB(String str, String str2) {
        boolean z11 = false;
        if (str2 == null) {
            return false;
        }
        SQLiteDatabase networkKitReadableDatabase = getNetworkKitReadableDatabase();
        if (networkKitReadableDatabase != null) {
            try {
                networkKitReadableDatabase = SQLiteDatabase.openDatabase(networkKitReadableDatabase.getPath().replace(dbName, str), (SQLiteDatabase.CursorFactory) null, 0);
                networkKitReadableDatabase.rawQuery("select count(1) from " + str2, (String[]) null);
                z11 = true;
            } catch (Throwable unused) {
            }
            IoUtils.closeSecure((Closeable) networkKitReadableDatabase);
        }
        return z11;
    }
}
