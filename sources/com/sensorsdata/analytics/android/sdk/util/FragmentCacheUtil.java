package com.sensorsdata.analytics.android.sdk.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import com.sensorsdata.analytics.android.sdk.SALog;
import java.lang.ref.WeakReference;

public class FragmentCacheUtil {
    @SuppressLint({"NewApi"})
    private static LruCache<String, WeakReference<Object>> sFragmentLruCache = new LruCache<>(Integer.MAX_VALUE);

    public static Object getFragmentFromCache(String str) {
        Object obj;
        try {
            if (!TextUtils.isEmpty(str)) {
                int i11 = Build.VERSION.SDK_INT;
                WeakReference weakReference = i11 >= 12 ? sFragmentLruCache.get(str) : null;
                if (weakReference != null && (obj = weakReference.get()) != null) {
                    return obj;
                }
                Object newInstance = Class.forName(str).newInstance();
                if (i11 >= 12) {
                    sFragmentLruCache.put(str, new WeakReference(newInstance));
                }
                return newInstance;
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        return null;
    }

    public static void setFragmentToCache(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null && Build.VERSION.SDK_INT >= 12) {
            sFragmentLruCache.put(str, new WeakReference(obj));
        }
    }
}
