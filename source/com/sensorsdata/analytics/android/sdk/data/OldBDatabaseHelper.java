package com.sensorsdata.analytics.android.sdk.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OldBDatabaseHelper extends SQLiteOpenHelper {
    public OldBDatabaseHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getAllEvents(android.database.sqlite.SQLiteDatabase r8, com.sensorsdata.analytics.android.sdk.data.SAProviderHelper.QueryEventsListener r9) {
        /*
            r7 = this;
            java.lang.String r0 = "created_at"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r7.getReadableDatabase()     // Catch:{ Exception -> 0x0047 }
            java.lang.String r3 = "SELECT * FROM %s ORDER BY %s"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0047 }
            r5 = 0
            java.lang.String r6 = "events"
            r4[r5] = r6     // Catch:{ Exception -> 0x0047 }
            r5 = 1
            r4[r5] = r0     // Catch:{ Exception -> 0x0047 }
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ Exception -> 0x0047 }
            android.database.Cursor r1 = r2.rawQuery(r3, r1)     // Catch:{ Exception -> 0x0047 }
            r8.beginTransaction()     // Catch:{ Exception -> 0x0047 }
        L_0x001f:
            boolean r2 = r1.moveToNext()     // Catch:{ Exception -> 0x0047 }
            if (r2 == 0) goto L_0x003b
            java.lang.String r2 = "data"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x0047 }
            int r3 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x0047 }
            r9.insert(r2, r3)     // Catch:{ Exception -> 0x0047 }
            goto L_0x001f
        L_0x003b:
            r8.setTransactionSuccessful()     // Catch:{ Exception -> 0x0047 }
            r8.endTransaction()
            r7.close()
            goto L_0x0053
        L_0x0045:
            r9 = move-exception
            goto L_0x0057
        L_0x0047:
            r9 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r9)     // Catch:{ all -> 0x0045 }
            r8.endTransaction()
            r7.close()
            if (r1 == 0) goto L_0x0056
        L_0x0053:
            r1.close()
        L_0x0056:
            return
        L_0x0057:
            r8.endTransaction()
            r7.close()
            if (r1 == 0) goto L_0x0062
            r1.close()
        L_0x0062:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.data.OldBDatabaseHelper.getAllEvents(android.database.sqlite.SQLiteDatabase, com.sensorsdata.analytics.android.sdk.data.SAProviderHelper$QueryEventsListener):void");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }
}
