package com.mob.mcl.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.push.constant.RemoteMessageConst;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private a f27528a;

    public c(Context context) {
        this.f27528a = new a(context.getApplicationContext());
    }

    public void a(String str, long j11) {
        try {
            SQLiteDatabase writableDatabase = this.f27528a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("workId", str);
            contentValues.put("expireTime", Long.valueOf(j11));
            writableDatabase.replace(RemoteMessageConst.MessageBody.MSG, (String) null, contentValues);
            writableDatabase.close();
        } catch (Throwable th2) {
            b.a().a(th2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r10) {
        /*
            r9 = this;
            com.mob.mcl.d.a r0 = r9.f27528a     // Catch:{ all -> 0x002e }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x002e }
            java.lang.String r1 = "delete from msg where workId = ?"
            java.lang.Class<android.database.sqlite.SQLiteDatabase> r2 = android.database.sqlite.SQLiteDatabase.class
            java.lang.String r3 = "execSQL"
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x002e }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 0
            r5[r7] = r6     // Catch:{ all -> 0x002e }
            java.lang.Class<java.lang.Object[]> r6 = java.lang.Object[].class
            r8 = 1
            r5[r8] = r6     // Catch:{ all -> 0x002e }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r5)     // Catch:{ all -> 0x002e }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x002e }
            r3[r7] = r1     // Catch:{ all -> 0x002e }
            java.lang.String[] r1 = new java.lang.String[r8]     // Catch:{ all -> 0x002e }
            r1[r7] = r10     // Catch:{ all -> 0x002e }
            r3[r8] = r1     // Catch:{ all -> 0x002e }
            r2.invoke(r0, r3)     // Catch:{ all -> 0x002e }
            r0.close()     // Catch:{ all -> 0x002e }
            goto L_0x0036
        L_0x002e:
            r10 = move-exception
            com.mob.mcl.d.b r0 = com.mob.mcl.d.b.a()
            r0.a((java.lang.Throwable) r10)
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.mcl.d.c.b(java.lang.String):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long a(java.lang.String r10) {
        /*
            r9 = this;
            com.mob.mcl.d.a r0 = r9.f27528a     // Catch:{ all -> 0x0045 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = "select expireTime from msg where workId = ?"
            java.lang.Class<android.database.sqlite.SQLiteDatabase> r2 = android.database.sqlite.SQLiteDatabase.class
            java.lang.String r3 = "rawQuery"
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x0045 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 0
            r5[r7] = r6     // Catch:{ all -> 0x0045 }
            java.lang.Class<java.lang.String[]> r6 = java.lang.String[].class
            r8 = 1
            r5[r8] = r6     // Catch:{ all -> 0x0045 }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch:{ all -> 0x0045 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x0045 }
            r3[r7] = r1     // Catch:{ all -> 0x0045 }
            java.lang.String[] r1 = new java.lang.String[r8]     // Catch:{ all -> 0x0045 }
            r1[r7] = r10     // Catch:{ all -> 0x0045 }
            r3[r8] = r1     // Catch:{ all -> 0x0045 }
            java.lang.Object r10 = r2.invoke(r0, r3)     // Catch:{ all -> 0x0045 }
            android.database.Cursor r10 = (android.database.Cursor) r10     // Catch:{ all -> 0x0045 }
            boolean r1 = r10.moveToFirst()     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x003e
            java.lang.String r0 = "expireTime"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ all -> 0x0045 }
            long r0 = r10.getLong(r0)     // Catch:{ all -> 0x0045 }
            return r0
        L_0x003e:
            r10.close()     // Catch:{ all -> 0x0045 }
            r0.close()     // Catch:{ all -> 0x0045 }
            goto L_0x004d
        L_0x0045:
            r10 = move-exception
            com.mob.mcl.d.b r0 = com.mob.mcl.d.b.a()
            r0.a((java.lang.Throwable) r10)
        L_0x004d:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.mcl.d.c.a(java.lang.String):long");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r9 = this;
            com.mob.mcl.d.a r0 = r9.f27528a     // Catch:{ all -> 0x0043 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "delete from msg where expireTime < ?"
            java.lang.Class<android.database.sqlite.SQLiteDatabase> r2 = android.database.sqlite.SQLiteDatabase.class
            java.lang.String r3 = "execSQL"
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x0043 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 0
            r5[r7] = r6     // Catch:{ all -> 0x0043 }
            java.lang.Class<java.lang.Object[]> r6 = java.lang.Object[].class
            r8 = 1
            r5[r8] = r6     // Catch:{ all -> 0x0043 }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r5)     // Catch:{ all -> 0x0043 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x0043 }
            r3[r7] = r1     // Catch:{ all -> 0x0043 }
            java.lang.String[] r1 = new java.lang.String[r8]     // Catch:{ all -> 0x0043 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r4.<init>()     // Catch:{ all -> 0x0043 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0043 }
            r4.append(r5)     // Catch:{ all -> 0x0043 }
            java.lang.String r5 = ""
            r4.append(r5)     // Catch:{ all -> 0x0043 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0043 }
            r1[r7] = r4     // Catch:{ all -> 0x0043 }
            r3[r8] = r1     // Catch:{ all -> 0x0043 }
            r2.invoke(r0, r3)     // Catch:{ all -> 0x0043 }
            r0.close()     // Catch:{ all -> 0x0043 }
            goto L_0x004b
        L_0x0043:
            r0 = move-exception
            com.mob.mcl.d.b r1 = com.mob.mcl.d.b.a()
            r1.a((java.lang.Throwable) r0)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.mcl.d.c.a():void");
    }
}
