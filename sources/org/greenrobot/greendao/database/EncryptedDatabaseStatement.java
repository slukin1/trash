package org.greenrobot.greendao.database;

import net.sqlcipher.database.SQLiteStatement;

public class EncryptedDatabaseStatement implements DatabaseStatement {
    private final SQLiteStatement delegate;

    public EncryptedDatabaseStatement(SQLiteStatement sQLiteStatement) {
        this.delegate = sQLiteStatement;
    }

    public void bindBlob(int i11, byte[] bArr) {
        this.delegate.bindBlob(i11, bArr);
    }

    public void bindDouble(int i11, double d11) {
        this.delegate.bindDouble(i11, d11);
    }

    public void bindLong(int i11, long j11) {
        this.delegate.bindLong(i11, j11);
    }

    public void bindNull(int i11) {
        this.delegate.bindNull(i11);
    }

    public void bindString(int i11, String str) {
        this.delegate.bindString(i11, str);
    }

    public void clearBindings() {
        this.delegate.clearBindings();
    }

    public void close() {
        this.delegate.close();
    }

    public void execute() {
        this.delegate.execute();
    }

    public long executeInsert() {
        return this.delegate.executeInsert();
    }

    public Object getRawStatement() {
        return this.delegate;
    }

    public long simpleQueryForLong() {
        return this.delegate.simpleQueryForLong();
    }
}
