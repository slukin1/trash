package com.tencent.android.tpush.common;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import java.util.HashMap;
import java.util.Map;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f68910a = {"android.permission.INTERNET", "android.permission.ACCESS_WIFI_STATE", "android.permission.ACCESS_NETWORK_STATE"};

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, Boolean> f68911b = new HashMap(8);

    public static boolean a() {
        Context b11 = b();
        if (b11 != null) {
            try {
                PackageManager packageManager = b11.getPackageManager();
                if (packageManager == null) {
                    return true;
                }
                String[] strArr = packageManager.getPackageInfo(b11.getPackageName(), 4096).requestedPermissions;
                if (strArr == null) {
                    return false;
                }
                for (String str : f68910a) {
                    boolean a11 = a(strArr, str);
                    f68911b.put(str, Boolean.valueOf(a11));
                    if (!a11) {
                        TLogger.ee("PermissionChecker", "The required permission of <" + str + "> does not found!");
                        return false;
                    }
                }
                return true;
            } catch (Throwable th2) {
                TLogger.e("PermissionChecker", "check required permissins exception.", th2);
                return false;
            }
        } else {
            throw new IllegalArgumentException("The context parameter can not be null!");
        }
    }

    private static Context b() {
        if (XGPushManager.getContext() != null) {
            return XGPushManager.getContext();
        }
        return b.e();
    }

    private static boolean a(String[] strArr, String str) {
        for (String equals : strArr) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }
}
