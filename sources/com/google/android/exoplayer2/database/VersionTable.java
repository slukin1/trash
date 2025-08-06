package com.google.android.exoplayer2.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.util.Util;

public final class VersionTable {
    private static final String COLUMN_FEATURE = "feature";
    private static final String COLUMN_INSTANCE_UID = "instance_uid";
    private static final String COLUMN_VERSION = "version";
    public static final int FEATURE_CACHE_CONTENT_METADATA = 1;
    public static final int FEATURE_CACHE_FILE_METADATA = 2;
    public static final int FEATURE_EXTERNAL = 1000;
    public static final int FEATURE_OFFLINE = 0;
    private static final String PRIMARY_KEY = "PRIMARY KEY (feature, instance_uid)";
    private static final String SQL_CREATE_TABLE_IF_NOT_EXISTS = "CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))";
    private static final String TABLE_NAME = "ExoPlayerVersions";
    public static final int VERSION_UNSET = -1;
    private static final String WHERE_FEATURE_AND_INSTANCE_UID_EQUALS = "feature = ? AND instance_uid = ?";

    private VersionTable() {
    }

    private static String[] featureAndInstanceUidArguments(int i11, String str) {
        return new String[]{Integer.toString(i11), str};
    }

    public static int getVersion(SQLiteDatabase sQLiteDatabase, int i11, String str) throws DatabaseIOException {
        Cursor query;
        try {
            if (!Util.tableExists(sQLiteDatabase, TABLE_NAME)) {
                return -1;
            }
            query = sQLiteDatabase.query(TABLE_NAME, new String[]{"version"}, WHERE_FEATURE_AND_INSTANCE_UID_EQUALS, featureAndInstanceUidArguments(i11, str), (String) null, (String) null, (String) null);
            if (query.getCount() == 0) {
                query.close();
                return -1;
            }
            query.moveToNext();
            int i12 = query.getInt(0);
            query.close();
            return i12;
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static void removeVersion(SQLiteDatabase sQLiteDatabase, int i11, String str) throws DatabaseIOException {
        try {
            if (Util.tableExists(sQLiteDatabase, TABLE_NAME)) {
                sQLiteDatabase.delete(TABLE_NAME, WHERE_FEATURE_AND_INSTANCE_UID_EQUALS, featureAndInstanceUidArguments(i11, str));
            }
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public static void setVersion(SQLiteDatabase sQLiteDatabase, int i11, String str, int i12) throws DatabaseIOException {
        try {
            sQLiteDatabase.execSQL(SQL_CREATE_TABLE_IF_NOT_EXISTS);
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_FEATURE, Integer.valueOf(i11));
            contentValues.put(COLUMN_INSTANCE_UID, str);
            contentValues.put("version", Integer.valueOf(i12));
            sQLiteDatabase.replaceOrThrow(TABLE_NAME, (String) null, contentValues);
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }
}
