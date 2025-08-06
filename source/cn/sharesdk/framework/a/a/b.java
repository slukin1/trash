package cn.sharesdk.framework.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.sharesdk.framework.utils.SSDKLog;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f13319b;

    /* renamed from: a  reason: collision with root package name */
    private a f13320a = new a();

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f13319b == null) {
                f13319b = new b();
            }
            bVar = f13319b;
        }
        return bVar;
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        SQLiteDatabase writableDatabase = this.f13320a.getWritableDatabase();
        SSDKLog.b().a("Query table: %s", str);
        try {
            return writableDatabase.query(str, strArr, str2, strArr2, (String) null, (String) null, str3);
        } catch (Exception e11) {
            Exception exc = e11;
            SSDKLog.b().b(exc, "when query database occur error table:%s,", str);
            return null;
        }
    }

    public long a(String str, ContentValues contentValues) {
        try {
            return this.f13320a.getWritableDatabase().replace(str, (String) null, contentValues);
        } catch (Exception e11) {
            SSDKLog.b().b(e11, "when insert database occur error table:%s,", str);
            return -1;
        }
    }

    public int a(String str, String str2, String[] strArr) {
        int i11;
        try {
            i11 = this.f13320a.getWritableDatabase().delete(str, str2, strArr);
            try {
                SSDKLog.b().a("Deleted %d rows from table: %s", Integer.valueOf(i11), str);
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Exception e12) {
            e = e12;
            i11 = 0;
            SSDKLog.b().b(e, "when delete database occur error table:%s,", str);
            return i11;
        }
        return i11;
    }

    public int a(String str) {
        Cursor cursor;
        Exception e11;
        int i11 = 0;
        try {
            SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.f13320a.getClass().getMethod("getWritableDatabase", new Class[0]).invoke(this.f13320a, new Object[0]);
            cursor = (Cursor) sQLiteDatabase.getClass().getDeclaredMethod("rawQuery", new Class[]{String.class, String[].class}).invoke(sQLiteDatabase, new Object[]{"select " + "count(*) from " + str, null});
            try {
                if (cursor.moveToNext()) {
                    i11 = cursor.getInt(0);
                }
            } catch (Exception e12) {
                e11 = e12;
                try {
                    SSDKLog.b().b((Throwable) e11);
                    cursor.close();
                    return i11;
                } catch (Throwable th2) {
                    th = th2;
                    cursor.close();
                    throw th;
                }
            }
        } catch (Exception e13) {
            Exception exc = e13;
            cursor = null;
            e11 = exc;
            SSDKLog.b().b((Throwable) e11);
            cursor.close();
            return i11;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            cursor = null;
            th = th4;
            cursor.close();
            throw th;
        }
        cursor.close();
        return i11;
    }
}
