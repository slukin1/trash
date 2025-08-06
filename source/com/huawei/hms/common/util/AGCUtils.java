package com.huawei.hms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.xiaomi.mipush.sdk.Constants;

public class AGCUtils {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "Get "
            java.lang.String r1 = ""
            java.lang.String r2 = "AGCUtils"
            r3 = 0
            com.huawei.agconnect.AGConnectOptionsBuilder r4 = new com.huawei.agconnect.AGConnectOptionsBuilder     // Catch:{ IOException -> 0x0044, NullPointerException -> 0x0028 }
            r4.<init>()     // Catch:{ IOException -> 0x0044, NullPointerException -> 0x0028 }
            android.content.res.Resources r5 = r7.getResources()     // Catch:{ IOException -> 0x0044, NullPointerException -> 0x0028 }
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ IOException -> 0x0044, NullPointerException -> 0x0028 }
            java.lang.String r6 = "agconnect-services.json"
            java.io.InputStream r3 = r5.open(r6)     // Catch:{ IOException -> 0x0044, NullPointerException -> 0x0028 }
            r4.setInputStream(r3)     // Catch:{ IOException -> 0x0044, NullPointerException -> 0x0028 }
            com.huawei.agconnect.AGConnectOptions r7 = r4.build(r7)     // Catch:{ IOException -> 0x0044, NullPointerException -> 0x0028 }
            java.lang.String r7 = r7.getString(r8)     // Catch:{ IOException -> 0x0044, NullPointerException -> 0x0028 }
            goto L_0x0060
        L_0x0026:
            r7 = move-exception
            goto L_0x0084
        L_0x0028:
            r7 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
            r4.<init>()     // Catch:{ all -> 0x0026 }
            r4.append(r0)     // Catch:{ all -> 0x0026 }
            r4.append(r8)     // Catch:{ all -> 0x0026 }
            java.lang.String r0 = " with AGConnectServicesConfig failed: "
            r4.append(r0)     // Catch:{ all -> 0x0026 }
            r4.append(r7)     // Catch:{ all -> 0x0026 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0026 }
            com.huawei.hms.support.log.HMSLog.e(r2, r7)     // Catch:{ all -> 0x0026 }
            goto L_0x005f
        L_0x0044:
            r7 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
            r4.<init>()     // Catch:{ all -> 0x0026 }
            r4.append(r0)     // Catch:{ all -> 0x0026 }
            r4.append(r8)     // Catch:{ all -> 0x0026 }
            java.lang.String r0 = " failed: "
            r4.append(r0)     // Catch:{ all -> 0x0026 }
            r4.append(r7)     // Catch:{ all -> 0x0026 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0026 }
            com.huawei.hms.support.log.HMSLog.e(r2, r7)     // Catch:{ all -> 0x0026 }
        L_0x005f:
            r7 = r1
        L_0x0060:
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r3)
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L_0x006a
            return r7
        L_0x006a:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "The "
            r7.append(r0)
            r7.append(r8)
            java.lang.String r8 = " is null."
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.huawei.hms.support.log.HMSLog.e(r2, r7)
            return r1
        L_0x0084:
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.util.AGCUtils.a(android.content.Context, java.lang.String):java.lang.String");
    }

    private static String b(Context context) {
        Bundle bundle;
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("com.huawei.hms.client.cpid")) == null) {
                HMSLog.i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
                return "";
            }
            String valueOf = String.valueOf(obj);
            return valueOf.startsWith("cpid=") ? valueOf.substring(5) : valueOf;
        } catch (AndroidException unused) {
            HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
            return "";
        } catch (RuntimeException e11) {
            HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.", (Throwable) e11);
            return "";
        }
    }

    private static boolean c(Context context) {
        return context.getPackageName().equals(HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService());
    }

    public static String getAppId(Context context) {
        if (context == null) {
            HMSLog.w("AGCUtils", "getAppId context is null");
            return "";
        }
        String str = null;
        if (c(context)) {
            str = a(context, "client/app_id");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        try {
            AGConnectInstance instance = AGConnectInstance.getInstance();
            if (instance.getContext() != context) {
                instance = AGConnectInstance.buildInstance(new AGConnectOptionsBuilder().build(context));
            }
            str = instance.getOptions().getString("client/app_id");
        } catch (NullPointerException unused) {
            HMSLog.e("AGCUtils", "Get appId with AGConnectServicesConfig failed");
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String a11 = a(context);
        if (!TextUtils.isEmpty(a11)) {
            return a11;
        }
        return a(context, "client/app_id");
    }

    public static String getCpId(Context context) {
        if (context == null) {
            HMSLog.w("AGCUtils", "getCpId context is null");
            return "";
        } else if (c(context)) {
            return a(context, "client/cp_id");
        } else {
            String str = null;
            try {
                AGConnectInstance instance = AGConnectInstance.getInstance();
                if (instance.getContext() != context) {
                    instance = AGConnectInstance.buildInstance(new AGConnectOptionsBuilder().build(context));
                }
                str = instance.getOptions().getString("client/cp_id");
            } catch (NullPointerException unused) {
                HMSLog.e("AGCUtils", "Get cpid with AGConnectServicesConfig failed");
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String b11 = b(context);
            if (!TextUtils.isEmpty(b11)) {
                return b11;
            }
            return a(context, "client/cp_id");
        }
    }

    private static String a(Context context) {
        Bundle bundle;
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get(Constants.HUAWEI_HMS_CLIENT_APPID)) == null) {
                HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
                return "";
            }
            String valueOf = String.valueOf(obj);
            return valueOf.startsWith("appid=") ? valueOf.substring(6) : valueOf;
        } catch (AndroidException unused) {
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        } catch (RuntimeException e11) {
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.", (Throwable) e11);
            return "";
        }
    }
}
