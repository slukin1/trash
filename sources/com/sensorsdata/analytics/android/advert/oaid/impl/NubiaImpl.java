package com.sensorsdata.analytics.android.advert.oaid.impl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.sensorsdata.analytics.android.advert.oaid.IRomOAID;
import com.sensorsdata.analytics.android.sdk.SALog;

class NubiaImpl implements IRomOAID {
    private static final String TAG = "SA.NubiaImpl";
    private final Context mContext;

    public NubiaImpl(Context context) {
        this.mContext = context;
    }

    public String getRomOAID() {
        String str = null;
        if (!isSupported()) {
            SALog.i(TAG, "Only supports Android 10.0 and above for Nubia");
            return null;
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.mContext.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (acquireContentProviderClient == null) {
                return null;
            }
            Bundle call = acquireContentProviderClient.call("getOAID", (String) null, (Bundle) null);
            if (Build.VERSION.SDK_INT >= 24) {
                acquireContentProviderClient.close();
            } else {
                acquireContentProviderClient.release();
            }
            if (call == null) {
                SALog.i(TAG, "OAID query failed: bundle is null");
                return null;
            }
            if (call.getInt("code", -1) == 0) {
                str = call.getString("id");
            }
            SALog.i(TAG, "OAID query success: " + str);
            return str;
        } catch (Throwable th2) {
            SALog.i(TAG, th2);
        }
    }

    public boolean isSupported() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
