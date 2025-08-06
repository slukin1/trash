package org.greenrobot.greendao.database;

public interface DatabaseStatement {
    void bindBlob(int i11, byte[] bArr);

    void bindDouble(int i11, double d11);

    void bindLong(int i11, long j11);

    void bindNull(int i11);

    void bindString(int i11, String str);

    void clearBindings();

    void close();

    void execute();

    long executeInsert();

    Object getRawStatement();

    long simpleQueryForLong();
}
