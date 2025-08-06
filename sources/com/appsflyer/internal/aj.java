package com.appsflyer.internal;

import android.content.pm.PackageManager;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huobi.vulcan.model.VulcanInfo;
import com.sumsub.sns.internal.core.common.n0;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public final class aj {
    private static aj valueOf = null;
    private static String values = "https://%smonitorsdk.%s/remote-debug?app_id=";
    public boolean AFInAppEventParameterName;
    private boolean AFInAppEventType = true;
    private JSONObject AFKeystoreWrapper;
    private boolean AFLogger$LogLevel;
    private final List<String> AFVersionDeclaration = new ArrayList();
    private int AppsFlyer2dXConversionCallback = 0;
    private boolean getLevel;
    private String init = "-1";

    private aj() {
        boolean z11 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
        this.AFLogger$LogLevel = z11;
        this.AFInAppEventParameterName = true ^ z11;
        this.AppsFlyer2dXConversionCallback = 0;
        this.getLevel = false;
    }

    private synchronized void AFKeystoreWrapper(String str, String str2, String str3, String str4) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    this.AFKeystoreWrapper.put("app_id", str);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (str2 != null && str2.length() > 0) {
            this.AFKeystoreWrapper.put(Constants.EXTRA_KEY_APP_VERSION, str2);
        }
        if (str3 != null && str3.length() > 0) {
            this.AFKeystoreWrapper.put(AppsFlyerProperties.CHANNEL, str3);
        }
        if (str4 != null && str4.length() > 0) {
            this.AFKeystoreWrapper.put("preInstall", str4);
        }
    }

    private boolean AFLogger$LogLevel() {
        if (this.AFInAppEventParameterName) {
            return this.AFInAppEventType || this.getLevel;
        }
        return false;
    }

    private synchronized void AFVersionDeclaration() {
        this.AFVersionDeclaration.clear();
        this.AppsFlyer2dXConversionCallback = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r0 = null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.String init() {
        /*
            r4 = this;
            monitor-enter(r4)
            org.json.JSONObject r0 = r4.AFKeystoreWrapper     // Catch:{ JSONException -> 0x001c, all -> 0x0019 }
            java.lang.String r1 = "data"
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x001c, all -> 0x0019 }
            java.util.List<java.lang.String> r3 = r4.AFVersionDeclaration     // Catch:{ JSONException -> 0x001c, all -> 0x0019 }
            r2.<init>(r3)     // Catch:{ JSONException -> 0x001c, all -> 0x0019 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x001c, all -> 0x0019 }
            org.json.JSONObject r0 = r4.AFKeystoreWrapper     // Catch:{ JSONException -> 0x001c, all -> 0x0019 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x001c, all -> 0x0019 }
            r4.AFVersionDeclaration()     // Catch:{ JSONException -> 0x001d, all -> 0x0019 }
            goto L_0x001d
        L_0x0019:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x001c:
            r0 = 0
        L_0x001d:
            monitor-exit(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.aj.init():java.lang.String");
    }

    public static aj valueOf() {
        if (valueOf == null) {
            valueOf = new aj();
        }
        return valueOf;
    }

    public final synchronized void AFInAppEventParameterName(String str) {
        this.init = str;
    }

    public final synchronized void AFInAppEventType() {
        this.AFKeystoreWrapper = null;
        valueOf = null;
    }

    public final boolean getLevel() {
        return this.getLevel;
    }

    public final synchronized void values() {
        this.getLevel = true;
        AFInAppEventType("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
    }

    public final synchronized void AFInAppEventParameterName() {
        AFInAppEventType("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        this.getLevel = false;
        this.AFInAppEventType = false;
    }

    private synchronized void valueOf(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            this.AFKeystoreWrapper.put("brand", str);
            this.AFKeystoreWrapper.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, str2);
            this.AFKeystoreWrapper.put("platform", n0.f32119g);
            this.AFKeystoreWrapper.put("platform_version", str3);
            if (str4 != null && str4.length() > 0) {
                this.AFKeystoreWrapper.put("advertiserId", str4);
            }
            if (str5 != null && str5.length() > 0) {
                this.AFKeystoreWrapper.put(VulcanInfo.IMEI, str5);
            }
            if (str6 != null && str6.length() > 0) {
                this.AFKeystoreWrapper.put("android_id", str6);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0092, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void AFInAppEventType(java.lang.String r4, java.lang.String r5, java.lang.String... r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.AFLogger$LogLevel()     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x0091
            int r0 = r3.AppsFlyer2dXConversionCallback     // Catch:{ all -> 0x0093 }
            r1 = 98304(0x18000, float:1.37753E-40)
            if (r0 < r1) goto L_0x0010
            goto L_0x0091
        L_0x0010:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008f }
            java.lang.String r2 = ", "
            java.lang.String r6 = android.text.TextUtils.join(r2, r6)     // Catch:{ all -> 0x008f }
            if (r4 == 0) goto L_0x0051
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r2.<init>()     // Catch:{ all -> 0x008f }
            r2.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = " "
            r2.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x008f }
            long r0 = r0.getId()     // Catch:{ all -> 0x008f }
            r2.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = " _/AppsFlyer_6.3.2 ["
            r2.append(r0)     // Catch:{ all -> 0x008f }
            r2.append(r4)     // Catch:{ all -> 0x008f }
            java.lang.String r4 = "] "
            r2.append(r4)     // Catch:{ all -> 0x008f }
            r2.append(r5)     // Catch:{ all -> 0x008f }
            java.lang.String r4 = " "
            r2.append(r4)     // Catch:{ all -> 0x008f }
            r2.append(r6)     // Catch:{ all -> 0x008f }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x008f }
            goto L_0x007d
        L_0x0051:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r4.<init>()     // Catch:{ all -> 0x008f }
            r4.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = " "
            r4.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x008f }
            long r0 = r0.getId()     // Catch:{ all -> 0x008f }
            r4.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = " "
            r4.append(r0)     // Catch:{ all -> 0x008f }
            r4.append(r5)     // Catch:{ all -> 0x008f }
            java.lang.String r5 = "/AppsFlyer_6.3.2 "
            r4.append(r5)     // Catch:{ all -> 0x008f }
            r4.append(r6)     // Catch:{ all -> 0x008f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x008f }
        L_0x007d:
            java.util.List<java.lang.String> r5 = r3.AFVersionDeclaration     // Catch:{ all -> 0x008f }
            r5.add(r4)     // Catch:{ all -> 0x008f }
            int r5 = r3.AppsFlyer2dXConversionCallback     // Catch:{ all -> 0x008f }
            int r4 = r4.length()     // Catch:{ all -> 0x008f }
            int r4 = r4 << 1
            int r5 = r5 + r4
            r3.AppsFlyer2dXConversionCallback = r5     // Catch:{ all -> 0x008f }
            monitor-exit(r3)
            return
        L_0x008f:
            monitor-exit(r3)
            return
        L_0x0091:
            monitor-exit(r3)
            return
        L_0x0093:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.aj.AFInAppEventType(java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    public final synchronized void AFKeystoreWrapper() {
        this.AFInAppEventType = false;
        AFVersionDeclaration();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:1|2|(2:4|5)(8:6|7|8|9|10|11|13|14)|15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0089, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x007e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void AFInAppEventType(java.lang.String r11, android.content.pm.PackageManager r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x008f }
            com.appsflyer.internal.ae r1 = com.appsflyer.internal.ae.values()     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "remote_debug_static_data"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0019
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ all -> 0x007e }
            r11.<init>(r2)     // Catch:{ all -> 0x007e }
            r10.AFKeystoreWrapper = r11     // Catch:{ all -> 0x007e }
            goto L_0x007e
        L_0x0019:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x008f }
            r2.<init>()     // Catch:{ all -> 0x008f }
            r10.AFKeystoreWrapper = r2     // Catch:{ all -> 0x008f }
            java.lang.String r4 = android.os.Build.BRAND     // Catch:{ all -> 0x008f }
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ all -> 0x008f }
            java.lang.String r6 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "advertiserId"
            java.lang.String r7 = r0.getString(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r8 = r1.AppsFlyer2dXConversionCallback     // Catch:{ all -> 0x008f }
            java.lang.String r9 = r1.AFLogger$LogLevel     // Catch:{ all -> 0x008f }
            r3 = r10
            r3.valueOf(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "6.3.2."
            r1.<init>(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r2 = com.appsflyer.internal.ae.AFInAppEventParameterName     // Catch:{ all -> 0x008f }
            r1.append(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "AppsFlyerKey"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r3 = "KSAppsFlyerId"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x008f }
            java.lang.String r4 = "uid"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x008f }
            r10.valueOf(r1, r2, r3, r4)     // Catch:{ all -> 0x008f }
            r1 = 0
            android.content.pm.PackageInfo r12 = r12.getPackageInfo(r11, r1)     // Catch:{ all -> 0x0073 }
            int r12 = r12.versionCode     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = "channel"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x0073 }
            java.lang.String r2 = "preInstallName"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0073 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0073 }
            r10.AFKeystoreWrapper(r11, r12, r1, r2)     // Catch:{ all -> 0x0073 }
        L_0x0073:
            java.lang.String r11 = "remote_debug_static_data"
            org.json.JSONObject r12 = r10.AFKeystoreWrapper     // Catch:{ all -> 0x008f }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x008f }
            r0.set((java.lang.String) r11, (java.lang.String) r12)     // Catch:{ all -> 0x008f }
        L_0x007e:
            org.json.JSONObject r11 = r10.AFKeystoreWrapper     // Catch:{ JSONException -> 0x0089 }
            java.lang.String r12 = "launch_counter"
            java.lang.String r0 = r10.init     // Catch:{ JSONException -> 0x0089 }
            r11.put(r12, r0)     // Catch:{ JSONException -> 0x0089 }
            monitor-exit(r10)
            return
        L_0x0089:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ all -> 0x008f }
            monitor-exit(r10)
            return
        L_0x008f:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.aj.AFInAppEventType(java.lang.String, android.content.pm.PackageManager):void");
    }

    private synchronized void valueOf(String str, String str2, String str3, String str4) {
        try {
            this.AFKeystoreWrapper.put(HianalyticsBaseData.SDK_VERSION, str);
            if (str2 != null && str2.length() > 0) {
                this.AFKeystoreWrapper.put("devkey", str2);
            }
            if (str3 != null && str3.length() > 0) {
                this.AFKeystoreWrapper.put("originalAppsFlyerId", str3);
            }
            if (str4 != null && str4.length() > 0) {
                this.AFKeystoreWrapper.put("uid", str4);
            }
        } catch (Throwable unused) {
        }
    }

    public static void valueOf(String str, PackageManager packageManager) {
        try {
            if (valueOf == null) {
                valueOf = new aj();
            }
            valueOf.AFInAppEventType(str, packageManager);
            if (valueOf == null) {
                valueOf = new aj();
            }
            String init2 = valueOf.init();
            bi biVar = new bi();
            biVar.onDeepLinkingNative = init2;
            biVar.onConversionDataFail = AppsFlyerLib.getInstance().isStopped();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.format(values, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ae.values().getHostName()}));
            sb2.append(str);
            new Thread(new m((bf) biVar.AFInAppEventParameterName(sb2.toString()))).start();
        } catch (Throwable th2) {
            AFLogger.values(th2);
        }
    }

    public static String[] AFInAppEventType(String str, StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null) {
            return new String[]{str};
        }
        String[] strArr = new String[(stackTraceElementArr.length + 1)];
        strArr[0] = str;
        for (int i11 = 1; i11 < stackTraceElementArr.length; i11++) {
            strArr[i11] = stackTraceElementArr[i11].toString();
        }
        return strArr;
    }
}
