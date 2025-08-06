package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.r;
import java.util.ArrayList;

final class ac extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private String f50957a = "";

    /* renamed from: co  reason: collision with root package name */
    private Context f50958co = null;

    public ac(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 3);
        this.f50957a = str;
        this.f50958co = context.getApplicationContext();
        if (c.k()) {
            b ao2 = t.bZ;
            ao2.b((Object) "SQLiteOpenHelper " + this.f50957a);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.database.Cursor} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.database.sqlite.SQLiteDatabase r9) {
        /*
            r0 = 0
            java.lang.String r2 = "user"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r9
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0047 }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ all -> 0x0044 }
            r2.<init>()     // Catch:{ all -> 0x0044 }
            boolean r3 = r1.moveToNext()     // Catch:{ all -> 0x0044 }
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0033
            java.lang.String r0 = r1.getString(r5)     // Catch:{ all -> 0x0044 }
            r1.getInt(r4)     // Catch:{ all -> 0x0044 }
            r3 = 2
            r1.getString(r3)     // Catch:{ all -> 0x0044 }
            r3 = 3
            r1.getLong(r3)     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = com.tencent.wxop.stat.b.r.q(r0)     // Catch:{ all -> 0x0044 }
            java.lang.String r6 = "uid"
            r2.put(r6, r3)     // Catch:{ all -> 0x0044 }
        L_0x0033:
            if (r0 == 0) goto L_0x0040
            java.lang.String r3 = "user"
            java.lang.String r6 = "uid=?"
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ all -> 0x0044 }
            r4[r5] = r0     // Catch:{ all -> 0x0044 }
            r9.update(r3, r2, r6, r4)     // Catch:{ all -> 0x0044 }
        L_0x0040:
            r1.close()
            return
        L_0x0044:
            r9 = move-exception
            r0 = r1
            goto L_0x0048
        L_0x0047:
            r9 = move-exception
        L_0x0048:
            com.tencent.wxop.stat.b.b r1 = com.tencent.wxop.stat.t.bZ     // Catch:{ all -> 0x0055 }
            r1.b((java.lang.Throwable) r9)     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0054
            r0.close()
        L_0x0054:
            return
        L_0x0055:
            r9 = move-exception
            if (r0 == 0) goto L_0x005b
            r0.close()
        L_0x005b:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.ac.a(android.database.sqlite.SQLiteDatabase):void");
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            Cursor query = sQLiteDatabase.query(DbParams.TABLE_EVENTS, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            ArrayList<ad> arrayList = new ArrayList<>();
            while (query.moveToNext()) {
                arrayList.add(new ad(query.getLong(0), query.getString(1), query.getInt(2), query.getInt(3)));
            }
            ContentValues contentValues = new ContentValues();
            for (ad adVar : arrayList) {
                contentValues.put("content", r.q(adVar.f50959b));
                sQLiteDatabase.update(DbParams.TABLE_EVENTS, contentValues, "event_id=?", new String[]{Long.toString(adVar.K)});
            }
            query.close();
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final synchronized void close() {
        super.close();
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
        sQLiteDatabase.execSQL("CREATE INDEX if not exists status_idx ON events(status)");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        b ao2 = t.bZ;
        ao2.debug("upgrade DB from oldVersion " + i11 + " to newVersion " + i12);
        if (i11 == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        }
        if (i11 == 2) {
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        }
    }
}
