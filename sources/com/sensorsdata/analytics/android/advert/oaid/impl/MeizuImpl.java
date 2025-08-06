package com.sensorsdata.analytics.android.advert.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.sensorsdata.analytics.android.advert.oaid.IRomOAID;
import com.sensorsdata.analytics.android.sdk.SALog;

class MeizuImpl implements IRomOAID {
    private static final String TAG = "SA.MeizuImpl";
    private final Context mContext;

    public MeizuImpl(Context context) {
        this.mContext = context;
    }

    public String getRomOAID() {
        try {
            Cursor query = this.mContext.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), (String[]) null, (String) null, new String[]{"oaid"}, (String) null);
            if (query == null || !query.moveToFirst()) {
                return null;
            }
            String string = query.getString(query.getColumnIndex("value"));
            SALog.i(TAG, "OAID query success: " + string);
            query.close();
            return string;
        } catch (Throwable th2) {
            SALog.i(TAG, th2);
            return null;
        }
    }

    public boolean isSupported() {
        try {
            return this.mContext.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Throwable th2) {
            SALog.i(TAG, th2);
            return false;
        }
    }
}
