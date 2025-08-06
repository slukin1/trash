package com.sensorsdata.analytics.android.sdk.data.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.encrypt.SensorsDataEncrypt;
import org.json.JSONObject;

class EncryptDataOperation extends DataOperation {
    private final SensorsDataEncrypt mSensorsDataEncrypt;

    public EncryptDataOperation(Context context, SensorsDataEncrypt sensorsDataEncrypt) {
        super(context);
        this.mSensorsDataEncrypt = sensorsDataEncrypt;
    }

    public void deleteData(Uri uri, String str) {
        super.deleteData(uri, str);
    }

    public int insertData(Uri uri, JSONObject jSONObject) {
        try {
            if (deleteDataLowMemory(uri) != 0) {
                return -2;
            }
            JSONObject encryptTrackData = this.mSensorsDataEncrypt.encryptTrackData(jSONObject);
            ContentValues contentValues = new ContentValues();
            contentValues.put("data", encryptTrackData.toString() + "\t" + encryptTrackData.toString().hashCode());
            contentValues.put(DbParams.KEY_CREATED_AT, Long.valueOf(System.currentTimeMillis()));
            this.contentResolver.insert(uri, contentValues);
            return 0;
        } catch (Throwable th2) {
            SALog.d(this.TAG, th2.getMessage());
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0167 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x016d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] queryData(android.net.Uri r18, int r19) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "9"
            r4 = 0
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x014a, all -> 0x0147 }
            r6.<init>()     // Catch:{ Exception -> 0x014a, all -> 0x0147 }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ Exception -> 0x014a, all -> 0x0147 }
            r7.<init>()     // Catch:{ Exception -> 0x014a, all -> 0x0147 }
            android.content.ContentResolver r8 = r1.contentResolver     // Catch:{ Exception -> 0x014a, all -> 0x0147 }
            r10 = 0
            r11 = 0
            r12 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014a, all -> 0x0147 }
            r0.<init>()     // Catch:{ Exception -> 0x014a, all -> 0x0147 }
            java.lang.String r9 = "created_at ASC LIMIT "
            r0.append(r9)     // Catch:{ Exception -> 0x014a, all -> 0x0147 }
            r9 = r19
            r0.append(r9)     // Catch:{ Exception -> 0x014a, all -> 0x0147 }
            java.lang.String r13 = r0.toString()     // Catch:{ Exception -> 0x014a, all -> 0x0147 }
            r9 = r18
            android.database.Cursor r8 = r8.query(r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x014a, all -> 0x0147 }
            if (r8 == 0) goto L_0x013e
            r9 = 0
        L_0x0030:
            boolean r0 = r8.moveToNext()     // Catch:{ Exception -> 0x013a }
            java.lang.String r10 = "pkv"
            java.lang.String r11 = "payloads"
            java.lang.String r12 = "$"
            java.lang.String r13 = "ekey"
            if (r0 == 0) goto L_0x00cd
            boolean r0 = r8.isLast()     // Catch:{ Exception -> 0x013a }
            if (r0 == 0) goto L_0x004e
            java.lang.String r0 = "_id"
            int r0 = r8.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x013a }
            java.lang.String r9 = r8.getString(r0)     // Catch:{ Exception -> 0x013a }
        L_0x004e:
            java.lang.String r0 = "data"
            int r0 = r8.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r0 = r8.getString(r0)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r0 = r1.parseData(r0)     // Catch:{ Exception -> 0x00c7 }
            boolean r14 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00c7 }
            if (r14 == 0) goto L_0x0063
            goto L_0x0030
        L_0x0063:
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c7 }
            r14.<init>(r0)     // Catch:{ Exception -> 0x00c7 }
            boolean r0 = r14.has(r13)     // Catch:{ Exception -> 0x00c7 }
            if (r0 != 0) goto L_0x0074
            com.sensorsdata.analytics.android.sdk.encrypt.SensorsDataEncrypt r0 = r1.mSensorsDataEncrypt     // Catch:{ Exception -> 0x00c7 }
            org.json.JSONObject r14 = r0.encryptTrackData(r14)     // Catch:{ Exception -> 0x00c7 }
        L_0x0074:
            boolean r0 = r14.has(r13)     // Catch:{ Exception -> 0x00c7 }
            if (r0 == 0) goto L_0x00b9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c7 }
            r0.<init>()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r13 = r14.getString(r13)     // Catch:{ Exception -> 0x00c7 }
            r0.append(r13)     // Catch:{ Exception -> 0x00c7 }
            r0.append(r12)     // Catch:{ Exception -> 0x00c7 }
            int r10 = r14.getInt(r10)     // Catch:{ Exception -> 0x00c7 }
            r0.append(r10)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00c7 }
            boolean r10 = r6.containsKey(r0)     // Catch:{ Exception -> 0x00c7 }
            if (r10 == 0) goto L_0x00a8
            java.lang.Object r0 = r6.get(r0)     // Catch:{ Exception -> 0x00c7 }
            org.json.JSONArray r0 = (org.json.JSONArray) r0     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r10 = r14.getString(r11)     // Catch:{ Exception -> 0x00c7 }
            r0.put(r10)     // Catch:{ Exception -> 0x00c7 }
            goto L_0x0030
        L_0x00a8:
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch:{ Exception -> 0x00c7 }
            r10.<init>()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r11 = r14.getString(r11)     // Catch:{ Exception -> 0x00c7 }
            r10.put(r11)     // Catch:{ Exception -> 0x00c7 }
            r6.put(r0, r10)     // Catch:{ Exception -> 0x00c7 }
            goto L_0x0030
        L_0x00b9:
            java.lang.String r0 = "_flush_time"
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00c7 }
            r14.put(r0, r10)     // Catch:{ Exception -> 0x00c7 }
            r7.put(r14)     // Catch:{ Exception -> 0x00c7 }
            goto L_0x0030
        L_0x00c7:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ Exception -> 0x013a }
            goto L_0x0030
        L_0x00cd:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x013a }
            r0.<init>()     // Catch:{ Exception -> 0x013a }
            java.util.Set r14 = r6.keySet()     // Catch:{ Exception -> 0x013a }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x013a }
        L_0x00da:
            boolean r15 = r14.hasNext()     // Catch:{ Exception -> 0x013a }
            if (r15 == 0) goto L_0x0121
            java.lang.Object r15 = r14.next()     // Catch:{ Exception -> 0x013a }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x013a }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x013a }
            r5.<init>()     // Catch:{ Exception -> 0x013a }
            int r3 = r15.indexOf(r12)     // Catch:{ Exception -> 0x013a }
            java.lang.String r3 = r15.substring(r4, r3)     // Catch:{ Exception -> 0x013a }
            r5.put(r13, r3)     // Catch:{ Exception -> 0x013a }
            int r3 = r15.indexOf(r12)     // Catch:{ Exception -> 0x013a }
            r16 = 1
            int r3 = r3 + 1
            java.lang.String r3 = r15.substring(r3)     // Catch:{ Exception -> 0x013a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x013a }
            r5.put(r10, r3)     // Catch:{ Exception -> 0x013a }
            java.lang.Object r3 = r6.get(r15)     // Catch:{ Exception -> 0x013a }
            r5.put(r11, r3)     // Catch:{ Exception -> 0x013a }
            java.lang.String r3 = "flush_time"
            r15 = r2
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0138 }
            r5.put(r3, r1)     // Catch:{ Exception -> 0x0138 }
            r0.put(r5)     // Catch:{ Exception -> 0x0138 }
            r1 = r17
            r2 = r15
            goto L_0x00da
        L_0x0121:
            r15 = r2
            int r1 = r0.length()     // Catch:{ Exception -> 0x0138 }
            if (r1 <= 0) goto L_0x012e
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0138 }
            r2 = r15
            goto L_0x0141
        L_0x012e:
            java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r2 = "1"
            r0 = r1
            goto L_0x0141
        L_0x0136:
            r0 = move-exception
            goto L_0x014f
        L_0x0138:
            r0 = move-exception
            goto L_0x013c
        L_0x013a:
            r0 = move-exception
            r15 = r2
        L_0x013c:
            r1 = 0
            goto L_0x014f
        L_0x013e:
            r15 = r2
            r0 = 0
            r9 = 0
        L_0x0141:
            if (r8 == 0) goto L_0x0159
            r8.close()
            goto L_0x0159
        L_0x0147:
            r0 = move-exception
            r5 = 0
            goto L_0x016b
        L_0x014a:
            r0 = move-exception
            r15 = r2
            r1 = 0
            r8 = 0
            r9 = 0
        L_0x014f:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ all -> 0x0169 }
            if (r8 == 0) goto L_0x0157
            r8.close()
        L_0x0157:
            r0 = r1
            r2 = r15
        L_0x0159:
            if (r9 == 0) goto L_0x0167
            r1 = 3
            java.lang.String[] r1 = new java.lang.String[r1]
            r1[r4] = r9
            r3 = 1
            r1[r3] = r0
            r0 = 2
            r1[r0] = r2
            return r1
        L_0x0167:
            r1 = 0
            return r1
        L_0x0169:
            r0 = move-exception
            r5 = r8
        L_0x016b:
            if (r5 == 0) goto L_0x0170
            r5.close()
        L_0x0170:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.data.adapter.EncryptDataOperation.queryData(android.net.Uri, int):java.lang.String[]");
    }

    public int insertData(Uri uri, ContentValues contentValues) {
        try {
            if (deleteDataLowMemory(uri) != 0) {
                return -2;
            }
            this.contentResolver.insert(uri, contentValues);
            return 0;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return 0;
        }
    }
}
