package org.greenrobot.greendao.database;

import android.content.Context;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;
import org.greenrobot.greendao.database.DatabaseOpenHelper;

class SqlCipherEncryptedHelper extends SQLiteOpenHelper implements DatabaseOpenHelper.EncryptedHelper {
    private final DatabaseOpenHelper delegate;

    public SqlCipherEncryptedHelper(DatabaseOpenHelper databaseOpenHelper, Context context, String str, int i11, boolean z11) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i11);
        this.delegate = databaseOpenHelper;
        if (z11) {
            SQLiteDatabase.loadLibs(context);
        }
    }

    private Database wrap(SQLiteDatabase sQLiteDatabase) {
        return new EncryptedDatabase(sQLiteDatabase);
    }

    public Database getEncryptedReadableDb(String str) {
        return wrap(getReadableDatabase(str));
    }

    public Database getEncryptedWritableDb(String str) {
        return wrap(getWritableDatabase(str));
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.delegate.onCreate(wrap(sQLiteDatabase));
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        this.delegate.onOpen(wrap(sQLiteDatabase));
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        this.delegate.onUpgrade(wrap(sQLiteDatabase), i11, i12);
    }

    public Database getEncryptedReadableDb(char[] cArr) {
        return wrap(getReadableDatabase(cArr));
    }

    public Database getEncryptedWritableDb(char[] cArr) {
        return wrap(getWritableDatabase(cArr));
    }
}
