package org.greenrobot.greendao.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.greenrobot.greendao.DaoException;

public abstract class DatabaseOpenHelper extends SQLiteOpenHelper {
    private final Context context;
    private EncryptedHelper encryptedHelper;
    private boolean loadSQLCipherNativeLibs;
    private final String name;
    private final int version;

    public interface EncryptedHelper {
        Database getEncryptedReadableDb(String str);

        Database getEncryptedReadableDb(char[] cArr);

        Database getEncryptedWritableDb(String str);

        Database getEncryptedWritableDb(char[] cArr);
    }

    public DatabaseOpenHelper(Context context2, String str, int i11) {
        this(context2, str, (SQLiteDatabase.CursorFactory) null, i11);
    }

    private EncryptedHelper checkEncryptedHelper() {
        if (this.encryptedHelper == null) {
            try {
                Class.forName("net.sqlcipher.database.SQLiteOpenHelper");
                try {
                    this.encryptedHelper = (EncryptedHelper) Class.forName("org.greenrobot.greendao.database.SqlCipherEncryptedHelper").getConstructor(new Class[]{DatabaseOpenHelper.class, Context.class, String.class, Integer.TYPE, Boolean.TYPE}).newInstance(new Object[]{this, this.context, this.name, Integer.valueOf(this.version), Boolean.valueOf(this.loadSQLCipherNativeLibs)});
                } catch (Exception e11) {
                    throw new DaoException((Throwable) e11);
                }
            } catch (ClassNotFoundException unused) {
                throw new DaoException("Using an encrypted database requires SQLCipher, make sure to add it to dependencies: https://greenrobot.org/greendao/documentation/database-encryption/");
            }
        }
        return this.encryptedHelper;
    }

    public Database getEncryptedReadableDb(String str) {
        return checkEncryptedHelper().getEncryptedReadableDb(str);
    }

    public Database getEncryptedWritableDb(String str) {
        return checkEncryptedHelper().getEncryptedWritableDb(str);
    }

    public Database getReadableDb() {
        return wrap(getReadableDatabase());
    }

    public Database getWritableDb() {
        return wrap(getWritableDatabase());
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        onCreate(wrap(sQLiteDatabase));
    }

    public void onCreate(Database database) {
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        onOpen(wrap(sQLiteDatabase));
    }

    public void onOpen(Database database) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        onUpgrade(wrap(sQLiteDatabase), i11, i12);
    }

    public void onUpgrade(Database database, int i11, int i12) {
    }

    public void setLoadSQLCipherNativeLibs(boolean z11) {
        this.loadSQLCipherNativeLibs = z11;
    }

    public Database wrap(SQLiteDatabase sQLiteDatabase) {
        return new StandardDatabase(sQLiteDatabase);
    }

    public DatabaseOpenHelper(Context context2, String str, SQLiteDatabase.CursorFactory cursorFactory, int i11) {
        super(context2, str, cursorFactory, i11);
        this.loadSQLCipherNativeLibs = true;
        this.context = context2;
        this.name = str;
        this.version = i11;
    }

    public Database getEncryptedReadableDb(char[] cArr) {
        return checkEncryptedHelper().getEncryptedReadableDb(cArr);
    }

    public Database getEncryptedWritableDb(char[] cArr) {
        return checkEncryptedHelper().getEncryptedWritableDb(cArr);
    }

    @SuppressLint({"NewApi"})
    public DatabaseOpenHelper(Context context2, String str, SQLiteDatabase.CursorFactory cursorFactory, int i11, DatabaseErrorHandler databaseErrorHandler) {
        super(context2, str, cursorFactory, i11, databaseErrorHandler);
        this.loadSQLCipherNativeLibs = true;
        this.context = context2;
        this.name = str;
        this.version = i11;
    }
}
