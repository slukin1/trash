package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f38391a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static int f38392b = -1;

    private static boolean a(Context context) {
        HMSLog.d("CommFun", "existFrameworkPush:" + f38392b);
        try {
            File file = new File("/system/framework/" + "hwpush.jar");
            if (a()) {
                HMSLog.d("CommFun", "push jarFile is exist");
            } else if (!file.isFile()) {
                return false;
            } else {
                HMSLog.d("CommFun", "push jarFile is exist");
            }
            return true;
        } catch (Exception e11) {
            HMSLog.e("CommFun", "get Apk version faild ,Exception e= " + e11.toString());
            return false;
        }
    }

    public static long b(Context context) {
        try {
            return (long) context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
        } catch (Exception unused) {
            HMSLog.e("CommFun", "get nc versionCode error");
            return -1;
        }
    }

    public static boolean c() {
        return HwBuildEx.VERSION.EMUI_SDK_INT < 19;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (1 != f38392b) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d(android.content.Context r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "existFrameworkPush:"
            r0.append(r1)
            int r1 = f38392b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "CommFun"
            com.huawei.hms.support.log.HMSLog.d(r1, r0)
            java.lang.Object r0 = f38391a
            monitor-enter(r0)
            int r1 = f38392b     // Catch:{ all -> 0x0039 }
            r2 = 0
            r3 = 1
            r4 = -1
            if (r4 == r1) goto L_0x0027
            if (r3 != r1) goto L_0x0025
            r2 = r3
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return r2
        L_0x0027:
            boolean r5 = a(r5)     // Catch:{ all -> 0x0039 }
            if (r5 == 0) goto L_0x0030
            f38392b = r3     // Catch:{ all -> 0x0039 }
            goto L_0x0032
        L_0x0030:
            f38392b = r2     // Catch:{ all -> 0x0039 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            int r5 = f38392b
            if (r3 != r5) goto L_0x0038
            r2 = r3
        L_0x0038:
            return r2
        L_0x0039:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.d.d(android.content.Context):boolean");
    }

    public static String c(Context context) {
        return AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }

    public static boolean b() {
        return HwBuildEx.VERSION.EMUI_SDK_INT >= 21;
    }

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("huawei.cust.HwCfgFilePolicy");
            int intValue = ((Integer) cls.getDeclaredField("CUST_TYPE_CONFIG").get(cls)).intValue();
            File file = (File) cls.getDeclaredMethod("getCfgFile", new Class[]{String.class, Integer.TYPE}).invoke(cls, new Object[]{"jars/hwpush.jar", Integer.valueOf(intValue)});
            if (file != null && file.exists()) {
                HMSLog.d("CommFun", "get push cust File path success.");
                return true;
            }
        } catch (ClassNotFoundException unused) {
            HMSLog.e("CommFun", "HwCfgFilePolicy ClassNotFoundException");
        } catch (SecurityException unused2) {
            HMSLog.e("CommFun", "check cust exist push SecurityException.");
        } catch (NoSuchFieldException unused3) {
            HMSLog.e("CommFun", "check cust exist push NoSuchFieldException.");
        } catch (NoSuchMethodException unused4) {
            HMSLog.e("CommFun", "check cust exist push NoSuchMethodException.");
        } catch (IllegalArgumentException unused5) {
            HMSLog.e("CommFun", "check cust exist push IllegalArgumentException.");
        } catch (IllegalAccessException unused6) {
            HMSLog.e("CommFun", "check cust exist push IllegalAccessException.");
        } catch (InvocationTargetException unused7) {
            HMSLog.e("CommFun", "check cust exist push InvocationTargetException.");
        }
        return false;
    }

    public static boolean a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        return jSONObject == null || (TextUtils.isEmpty(str) && jSONObject2 == null);
    }
}
