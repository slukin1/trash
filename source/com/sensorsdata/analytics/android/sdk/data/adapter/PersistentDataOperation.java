package com.sensorsdata.analytics.android.sdk.data.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import org.json.JSONObject;

class PersistentDataOperation extends DataOperation {
    public PersistentDataOperation(Context context) {
        super(context);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009a, code lost:
        switch(r6) {
            case 0: goto L_0x010a;
            case 1: goto L_0x0100;
            case 2: goto L_0x00f4;
            case 3: goto L_0x00e8;
            case 4: goto L_0x00e0;
            case 5: goto L_0x00d4;
            case 6: goto L_0x00c8;
            case 7: goto L_0x00c0;
            case 8: goto L_0x00b8;
            case 9: goto L_0x00b0;
            case 10: goto L_0x00a1;
            default: goto L_0x009d;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009d, code lost:
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a0, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_KEY, r1.optString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_KEY));
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_VALUE, r1.optString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_VALUE));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b0, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY, r1.optString("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b8, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_USER_ID, r1.optString("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c0, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.REMOTE_CONFIG, r1.optString("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00c8, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_FIRST_PROCESS_START, java.lang.Boolean.valueOf(r1.optBoolean("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d4, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.SUB_PROCESS_FLUSH_DATA, java.lang.Boolean.valueOf(r1.optBoolean("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e0, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.LOGIN_ID, r1.optString("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e8, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_SESSION_INTERVAL_TIME, java.lang.Long.valueOf(r1.optLong("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f4, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_APP_START_TIME, java.lang.Long.valueOf(r1.optLong("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0100, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.APP_EXIT_DATA, r1.optString("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010a, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_ACTIVITY_START_COUNT, java.lang.Integer.valueOf(r1.optInt("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r16.contentResolver.insert(r17, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x011e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleInsertUri(android.net.Uri r17, org.json.JSONObject r18) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "push_value"
            r3 = -1
            if (r0 != 0) goto L_0x000a
            return r3
        L_0x000a:
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ Exception -> 0x0123 }
            r5.<init>()     // Catch:{ Exception -> 0x0123 }
            java.lang.String r6 = r17.getPath()     // Catch:{ Exception -> 0x0123 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0123 }
            if (r7 != 0) goto L_0x0120
            r7 = 1
            java.lang.String r6 = r6.substring(r7)     // Catch:{ Exception -> 0x0123 }
            int r8 = r6.hashCode()     // Catch:{ Exception -> 0x0123 }
            java.lang.String r9 = "sub_process_flush_data"
            java.lang.String r10 = "sensorsdata_sdk_configuration"
            java.lang.String r11 = "app_exit_data"
            java.lang.String r12 = "app_start_time"
            java.lang.String r13 = "user_ids"
            java.lang.String r14 = "login_id_key"
            java.lang.String r15 = "first_process_start"
            java.lang.String r7 = "session_interval_time"
            java.lang.String r4 = "events_login_id"
            java.lang.String r3 = "activity_started_count"
            java.lang.String r0 = "push_key"
            switch(r8) {
                case -1437430111: goto L_0x008f;
                case -1436067305: goto L_0x0087;
                case -1173524450: goto L_0x007f;
                case -1109940413: goto L_0x0077;
                case -456824111: goto L_0x006e;
                case -266152892: goto L_0x0065;
                case 791585128: goto L_0x005d;
                case 923005325: goto L_0x0055;
                case 947194773: goto L_0x004d;
                case 1776312250: goto L_0x0044;
                case 1964784692: goto L_0x003c;
                default: goto L_0x003b;
            }
        L_0x003b:
            goto L_0x0097
        L_0x003c:
            boolean r6 = r6.equals(r9)     // Catch:{ Exception -> 0x0123 }
            if (r6 == 0) goto L_0x0097
            r6 = 5
            goto L_0x0098
        L_0x0044:
            boolean r6 = r6.equals(r0)     // Catch:{ Exception -> 0x0123 }
            if (r6 == 0) goto L_0x0097
            r6 = 10
            goto L_0x0098
        L_0x004d:
            boolean r6 = r6.equals(r10)     // Catch:{ Exception -> 0x0123 }
            if (r6 == 0) goto L_0x0097
            r6 = 7
            goto L_0x0098
        L_0x0055:
            boolean r6 = r6.equals(r11)     // Catch:{ Exception -> 0x0123 }
            if (r6 == 0) goto L_0x0097
            r6 = 1
            goto L_0x0098
        L_0x005d:
            boolean r6 = r6.equals(r12)     // Catch:{ Exception -> 0x0123 }
            if (r6 == 0) goto L_0x0097
            r6 = 2
            goto L_0x0098
        L_0x0065:
            boolean r6 = r6.equals(r13)     // Catch:{ Exception -> 0x0123 }
            if (r6 == 0) goto L_0x0097
            r6 = 8
            goto L_0x0098
        L_0x006e:
            boolean r6 = r6.equals(r14)     // Catch:{ Exception -> 0x0123 }
            if (r6 == 0) goto L_0x0097
            r6 = 9
            goto L_0x0098
        L_0x0077:
            boolean r6 = r6.equals(r15)     // Catch:{ Exception -> 0x0123 }
            if (r6 == 0) goto L_0x0097
            r6 = 6
            goto L_0x0098
        L_0x007f:
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x0123 }
            if (r6 == 0) goto L_0x0097
            r6 = 3
            goto L_0x0098
        L_0x0087:
            boolean r6 = r6.equals(r4)     // Catch:{ Exception -> 0x0123 }
            if (r6 == 0) goto L_0x0097
            r6 = 4
            goto L_0x0098
        L_0x008f:
            boolean r6 = r6.equals(r3)     // Catch:{ Exception -> 0x0123 }
            if (r6 == 0) goto L_0x0097
            r6 = 0
            goto L_0x0098
        L_0x0097:
            r6 = -1
        L_0x0098:
            java.lang.String r8 = "value"
            switch(r6) {
                case 0: goto L_0x010a;
                case 1: goto L_0x0100;
                case 2: goto L_0x00f4;
                case 3: goto L_0x00e8;
                case 4: goto L_0x00e0;
                case 5: goto L_0x00d4;
                case 6: goto L_0x00c8;
                case 7: goto L_0x00c0;
                case 8: goto L_0x00b8;
                case 9: goto L_0x00b0;
                case 10: goto L_0x00a1;
                default: goto L_0x009d;
            }
        L_0x009d:
            r1 = r16
            r0 = -1
            return r0
        L_0x00a1:
            java.lang.String r3 = r1.optString(r0)     // Catch:{ Exception -> 0x0123 }
            r5.put(r0, r3)     // Catch:{ Exception -> 0x0123 }
            java.lang.String r0 = r1.optString(r2)     // Catch:{ Exception -> 0x0123 }
            r5.put(r2, r0)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0107
        L_0x00b0:
            java.lang.String r0 = r1.optString(r8)     // Catch:{ Exception -> 0x0123 }
            r5.put(r14, r0)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0107
        L_0x00b8:
            java.lang.String r0 = r1.optString(r8)     // Catch:{ Exception -> 0x0123 }
            r5.put(r13, r0)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0107
        L_0x00c0:
            java.lang.String r0 = r1.optString(r8)     // Catch:{ Exception -> 0x0123 }
            r5.put(r10, r0)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0107
        L_0x00c8:
            boolean r0 = r1.optBoolean(r8)     // Catch:{ Exception -> 0x0123 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x0123 }
            r5.put(r15, r0)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0107
        L_0x00d4:
            boolean r0 = r1.optBoolean(r8)     // Catch:{ Exception -> 0x0123 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x0123 }
            r5.put(r9, r0)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0107
        L_0x00e0:
            java.lang.String r0 = r1.optString(r8)     // Catch:{ Exception -> 0x0123 }
            r5.put(r4, r0)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0107
        L_0x00e8:
            long r0 = r1.optLong(r8)     // Catch:{ Exception -> 0x0123 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x0123 }
            r5.put(r7, r0)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0107
        L_0x00f4:
            long r0 = r1.optLong(r8)     // Catch:{ Exception -> 0x0123 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x0123 }
            r5.put(r12, r0)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0107
        L_0x0100:
            java.lang.String r0 = r1.optString(r8)     // Catch:{ Exception -> 0x0123 }
            r5.put(r11, r0)     // Catch:{ Exception -> 0x0123 }
        L_0x0107:
            r1 = r16
            goto L_0x0116
        L_0x010a:
            int r0 = r1.optInt(r8)     // Catch:{ Exception -> 0x0123 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0123 }
            r5.put(r3, r0)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0107
        L_0x0116:
            android.content.ContentResolver r0 = r1.contentResolver     // Catch:{ Exception -> 0x011e }
            r2 = r17
            r0.insert(r2, r5)     // Catch:{ Exception -> 0x011e }
            goto L_0x0129
        L_0x011e:
            r0 = move-exception
            goto L_0x0126
        L_0x0120:
            r1 = r16
            goto L_0x0129
        L_0x0123:
            r0 = move-exception
            r1 = r16
        L_0x0126:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x0129:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.data.adapter.PersistentDataOperation.handleInsertUri(android.net.Uri, org.json.JSONObject):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00dc, code lost:
        if (r11 != null) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00e9, code lost:
        if (r11 != null) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00eb, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00ee, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String[] handleQueryUri(android.net.Uri r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = r11.getPath()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x000f
            return r0
        L_0x000f:
            r2 = 1
            java.lang.String r1 = r1.substring(r2)     // Catch:{ Exception -> 0x00e4, all -> 0x00df }
            android.content.ContentResolver r3 = r10.contentResolver     // Catch:{ Exception -> 0x00e4, all -> 0x00df }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r4 = r11
            android.database.Cursor r11 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00e4, all -> 0x00df }
            if (r11 == 0) goto L_0x00dc
            int r3 = r11.getCount()     // Catch:{ Exception -> 0x00da }
            if (r3 <= 0) goto L_0x00dc
            r11.moveToNext()     // Catch:{ Exception -> 0x00da }
            r3 = -1
            int r4 = r1.hashCode()     // Catch:{ Exception -> 0x00da }
            r5 = 0
            switch(r4) {
                case -1437430111: goto L_0x009d;
                case -1436067305: goto L_0x0093;
                case -1173524450: goto L_0x0088;
                case -1109940413: goto L_0x007e;
                case -456824111: goto L_0x0074;
                case -266152892: goto L_0x006a;
                case 791585128: goto L_0x005f;
                case 923005325: goto L_0x0055;
                case 947194773: goto L_0x004b;
                case 1776312250: goto L_0x0040;
                case 1964784692: goto L_0x0035;
                default: goto L_0x0033;
            }     // Catch:{ Exception -> 0x00da }
        L_0x0033:
            goto L_0x00a6
        L_0x0035:
            java.lang.String r4 = "sub_process_flush_data"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00da }
            if (r1 == 0) goto L_0x00a6
            r3 = r2
            goto L_0x00a6
        L_0x0040:
            java.lang.String r4 = "push_key"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00da }
            if (r1 == 0) goto L_0x00a6
            r3 = 8
            goto L_0x00a6
        L_0x004b:
            java.lang.String r4 = "sensorsdata_sdk_configuration"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00da }
            if (r1 == 0) goto L_0x00a6
            r3 = 5
            goto L_0x00a6
        L_0x0055:
            java.lang.String r4 = "app_exit_data"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00da }
            if (r1 == 0) goto L_0x00a6
            r3 = 3
            goto L_0x00a6
        L_0x005f:
            java.lang.String r4 = "app_start_time"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00da }
            if (r1 == 0) goto L_0x00a6
            r3 = 10
            goto L_0x00a6
        L_0x006a:
            java.lang.String r4 = "user_ids"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00da }
            if (r1 == 0) goto L_0x00a6
            r3 = 6
            goto L_0x00a6
        L_0x0074:
            java.lang.String r4 = "login_id_key"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00da }
            if (r1 == 0) goto L_0x00a6
            r3 = 7
            goto L_0x00a6
        L_0x007e:
            java.lang.String r4 = "first_process_start"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00da }
            if (r1 == 0) goto L_0x00a6
            r3 = 2
            goto L_0x00a6
        L_0x0088:
            java.lang.String r4 = "session_interval_time"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00da }
            if (r1 == 0) goto L_0x00a6
            r3 = 9
            goto L_0x00a6
        L_0x0093:
            java.lang.String r4 = "events_login_id"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00da }
            if (r1 == 0) goto L_0x00a6
            r3 = 4
            goto L_0x00a6
        L_0x009d:
            java.lang.String r4 = "activity_started_count"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00da }
            if (r1 == 0) goto L_0x00a6
            r3 = r5
        L_0x00a6:
            switch(r3) {
                case 0: goto L_0x00c6;
                case 1: goto L_0x00c6;
                case 2: goto L_0x00c6;
                case 3: goto L_0x00ba;
                case 4: goto L_0x00ba;
                case 5: goto L_0x00ba;
                case 6: goto L_0x00ba;
                case 7: goto L_0x00ba;
                case 8: goto L_0x00ba;
                case 9: goto L_0x00aa;
                case 10: goto L_0x00aa;
                default: goto L_0x00a9;
            }     // Catch:{ Exception -> 0x00da }
        L_0x00a9:
            goto L_0x00d6
        L_0x00aa:
            java.lang.String[] r1 = new java.lang.String[r2]     // Catch:{ Exception -> 0x00da }
            long r2 = r11.getLong(r5)     // Catch:{ Exception -> 0x00da }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00da }
            r1[r5] = r2     // Catch:{ Exception -> 0x00da }
            r11.close()
            return r1
        L_0x00ba:
            java.lang.String[] r1 = new java.lang.String[r2]     // Catch:{ Exception -> 0x00da }
            java.lang.String r2 = r11.getString(r5)     // Catch:{ Exception -> 0x00da }
            r1[r5] = r2     // Catch:{ Exception -> 0x00da }
            r11.close()
            return r1
        L_0x00c6:
            java.lang.String[] r1 = new java.lang.String[r2]     // Catch:{ Exception -> 0x00da }
            int r2 = r11.getInt(r5)     // Catch:{ Exception -> 0x00da }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00da }
            r1[r5] = r2     // Catch:{ Exception -> 0x00da }
            r11.close()
            return r1
        L_0x00d6:
            r11.close()
            return r0
        L_0x00da:
            r1 = move-exception
            goto L_0x00e6
        L_0x00dc:
            if (r11 == 0) goto L_0x00ee
            goto L_0x00eb
        L_0x00df:
            r11 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
            goto L_0x00f0
        L_0x00e4:
            r1 = move-exception
            r11 = r0
        L_0x00e6:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)     // Catch:{ all -> 0x00ef }
            if (r11 == 0) goto L_0x00ee
        L_0x00eb:
            r11.close()
        L_0x00ee:
            return r0
        L_0x00ef:
            r0 = move-exception
        L_0x00f0:
            if (r11 == 0) goto L_0x00f5
            r11.close()
        L_0x00f5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.data.adapter.PersistentDataOperation.handleQueryUri(android.net.Uri):java.lang.String[]");
    }

    public void deleteData(Uri uri, String str) {
        this.contentResolver.delete(uri.buildUpon().appendQueryParameter(DbParams.REMOVE_SP_KEY, str).build(), (String) null, (String[]) null);
    }

    public int insertData(Uri uri, JSONObject jSONObject) {
        return handleInsertUri(uri, jSONObject);
    }

    public String[] queryData(Uri uri, int i11) {
        return handleQueryUri(uri);
    }

    public int insertData(Uri uri, ContentValues contentValues) {
        this.contentResolver.insert(uri, contentValues);
        return 0;
    }
}
