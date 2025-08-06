package com.facebook.stetho.inspector.database;

import android.annotation.TargetApi;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

public abstract class SQLiteDatabaseCompat {
    public static final int ENABLE_FOREIGN_KEY_CONSTRAINTS = 2;
    public static final int ENABLE_WRITE_AHEAD_LOGGING = 1;
    private static final SQLiteDatabaseCompat sInstance;

    @TargetApi(11)
    public static class HoneycombImpl extends SQLiteDatabaseCompat {
        private HoneycombImpl() {
        }

        public void enableFeatures(@SQLiteOpenOptions int i11, SQLiteDatabase sQLiteDatabase) {
            if ((i11 & 1) != 0) {
                sQLiteDatabase.enableWriteAheadLogging();
            }
            if ((i11 & 2) != 0) {
                sQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
            }
        }

        public int provideOpenFlags(@SQLiteOpenOptions int i11) {
            return 0;
        }
    }

    @TargetApi(16)
    public static class JellyBeanAndBeyondImpl extends SQLiteDatabaseCompat {
        private JellyBeanAndBeyondImpl() {
        }

        public void enableFeatures(@SQLiteOpenOptions int i11, SQLiteDatabase sQLiteDatabase) {
            if ((i11 & 2) != 0) {
                sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
            }
        }

        public int provideOpenFlags(@SQLiteOpenOptions int i11) {
            return (i11 & 1) != 0 ? 536870912 : 0;
        }
    }

    public static class NoopImpl extends SQLiteDatabaseCompat {
        private NoopImpl() {
        }

        public void enableFeatures(@SQLiteOpenOptions int i11, SQLiteDatabase sQLiteDatabase) {
        }

        public int provideOpenFlags(@SQLiteOpenOptions int i11) {
            return 0;
        }
    }

    public @interface SQLiteOpenOptions {
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 16) {
            sInstance = new JellyBeanAndBeyondImpl();
        } else if (i11 >= 11) {
            sInstance = new HoneycombImpl();
        } else {
            sInstance = new NoopImpl();
        }
    }

    public static SQLiteDatabaseCompat getInstance() {
        return sInstance;
    }

    public abstract void enableFeatures(@SQLiteOpenOptions int i11, SQLiteDatabase sQLiteDatabase);

    public abstract int provideOpenFlags(@SQLiteOpenOptions int i11);
}
