package com.tencent.mmkv;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MMKVContentProvider extends ContentProvider {
    public static final String FUNCTION_NAME = "mmkvFromAshmemID";
    public static final String KEY = "KEY";
    public static final String KEY_CRYPT = "KEY_CRYPT";
    public static final String KEY_MODE = "KEY_MODE";
    public static final String KEY_SIZE = "KEY_SIZE";
    private static Uri gUri;

    public static Uri contentUri(Context context) {
        String queryAuthority;
        Uri uri = gUri;
        if (uri != null) {
            return uri;
        }
        if (context == null || (queryAuthority = queryAuthority(context)) == null) {
            return null;
        }
        Uri parse = Uri.parse("content://" + queryAuthority);
        gUri = parse;
        return parse;
    }

    public static String getProcessNameByPID(Context context, int i11) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo next : activityManager.getRunningAppProcesses()) {
            if (next.pid == i11) {
                return next.processName;
            }
        }
        return "";
    }

    private Bundle mmkvFromAshmemID(String str, int i11, int i12, String str2) throws RuntimeException {
        MMKV mmkvWithAshmemID = MMKV.mmkvWithAshmemID(getContext(), str, i11, i12, str2);
        ParcelableMMKV parcelableMMKV = new ParcelableMMKV(mmkvWithAshmemID);
        Log.i("MMKV", str + " fd = " + mmkvWithAshmemID.ashmemFD() + ", meta fd = " + mmkvWithAshmemID.ashmemMetaFD());
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY, parcelableMMKV);
        return bundle;
    }

    private static String queryAuthority(Context context) {
        ProviderInfo providerInfo;
        try {
            ComponentName componentName = new ComponentName(context, MMKVContentProvider.class.getName());
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (providerInfo = packageManager.getProviderInfo(componentName, 0)) == null) {
                return null;
            }
            return providerInfo.authority;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        if (str.equals(FUNCTION_NAME) && bundle != null) {
            try {
                return mmkvFromAshmemID(str2, bundle.getInt(KEY_SIZE), bundle.getInt(KEY_MODE), bundle.getString(KEY_CRYPT));
            } catch (Exception e11) {
                Log.e("MMKV", e11.getMessage());
            }
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    public boolean onCreate() {
        String queryAuthority;
        Context context = getContext();
        if (context == null || (queryAuthority = queryAuthority(context)) == null) {
            return false;
        }
        if (gUri != null) {
            return true;
        }
        gUri = Uri.parse("content://" + queryAuthority);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }
}
