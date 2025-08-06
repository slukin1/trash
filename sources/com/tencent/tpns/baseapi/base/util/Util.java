package com.tencent.tpns.baseapi.base.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.core.c.c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;

public class Util {

    /* renamed from: a  reason: collision with root package name */
    private static PowerManager.WakeLock f49827a = null;

    /* renamed from: b  reason: collision with root package name */
    private static long f49828b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static String f49829c;

    public static boolean checkAccessId(long j11) {
        if (j11 >= 1500000000 && j11 < 1600000000) {
            return true;
        }
        if (j11 >= 1800000000 && j11 < 1900000000) {
            return true;
        }
        Logger.e("Util", "AccessId is Invalid!!, accessId: " + j11);
        return false;
    }

    public static boolean checkAccessKey(String str) {
        if (str == null || str.length() != 12) {
            Logger.e("Util", "AccessKey is Invalid!!, accessKey: " + str);
            return false;
        }
        int i11 = 0;
        while (i11 < str.length()) {
            if (Character.isUpperCase(str.charAt(i11)) || Character.isDigit(str.charAt(i11))) {
                i11++;
            } else {
                Logger.e("Util", "AccessKey is Invalid!!, accessKey: " + str);
                return false;
            }
        }
        return true;
    }

    public static boolean checkPermission(Context context, String str) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            Logger.i("Util", "checkPermission error:" + str, th2);
            return false;
        }
    }

    public static String getCurAppVersion(Context context) {
        if (!isNullOrEmptyString(f49829c)) {
            return f49829c;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f49829c = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th2) {
            Logger.e("Util", "get app version error", th2);
        }
        return f49829c;
    }

    public static String getCurProcessName(Context context) {
        if (!TextUtils.isEmpty(TGlobalHelper.curProcessName)) {
            return TGlobalHelper.curProcessName;
        }
        String curProcessNameByProcFile = getCurProcessNameByProcFile(context);
        if (!isNullOrEmptyString(curProcessNameByProcFile) && curProcessNameByProcFile.contains(context.getPackageName()) && !curProcessNameByProcFile.contains("SecurityException")) {
            TGlobalHelper.curProcessName = curProcessNameByProcFile;
            return curProcessNameByProcFile;
        } else if (context == null) {
            return null;
        } else {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null) {
                    int myPid = Process.myPid();
                    Iterator<ActivityManager.RunningAppProcessInfo> it2 = activityManager.getRunningAppProcesses().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it2.next();
                        if (next.pid == myPid) {
                            TGlobalHelper.curProcessName = next.processName;
                            break;
                        }
                    }
                }
            } catch (Throwable th2) {
                Logger.w("Util", "#unexcepted - getCurProcessName failed:" + th2.getMessage());
            }
            return TGlobalHelper.curProcessName;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0067 A[SYNTHETIC, Splitter:B:18:0x0067] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCurProcessNameByProcFile(android.content.Context r6) {
        /*
            java.lang.String r6 = ""
            java.lang.String r0 = "Util"
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0051 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r4.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = "/proc/"
            r4.append(r5)     // Catch:{ all -> 0x0051 }
            int r5 = android.os.Process.myPid()     // Catch:{ all -> 0x0051 }
            r4.append(r5)     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = "/cmdline"
            r4.append(r5)     // Catch:{ all -> 0x0051 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0051 }
            r3.<init>(r4)     // Catch:{ all -> 0x0051 }
            r2.<init>(r3)     // Catch:{ all -> 0x0051 }
            java.lang.String r3 = r2.readLine()     // Catch:{ all -> 0x004f }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x004f }
            if (r4 != 0) goto L_0x0037
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x004f }
        L_0x0037:
            r2.close()     // Catch:{ all -> 0x003b }
            goto L_0x004e
        L_0x003b:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r2.append(r1)
            java.lang.String r6 = r2.toString()
            com.tencent.tpns.baseapi.base.util.Logger.e(r0, r6)
        L_0x004e:
            return r3
        L_0x004f:
            r3 = move-exception
            goto L_0x0053
        L_0x0051:
            r3 = move-exception
            r2 = r1
        L_0x0053:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007f }
            r4.<init>()     // Catch:{ all -> 0x007f }
            r4.append(r6)     // Catch:{ all -> 0x007f }
            r4.append(r3)     // Catch:{ all -> 0x007f }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x007f }
            com.tencent.tpns.baseapi.base.util.Logger.e(r0, r3)     // Catch:{ all -> 0x007f }
            if (r2 == 0) goto L_0x007e
            r2.close()     // Catch:{ all -> 0x006b }
            goto L_0x007e
        L_0x006b:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            r3.append(r2)
            java.lang.String r6 = r3.toString()
            com.tencent.tpns.baseapi.base.util.Logger.e(r0, r6)
        L_0x007e:
            return r1
        L_0x007f:
            r1 = move-exception
            if (r2 == 0) goto L_0x0099
            r2.close()     // Catch:{ all -> 0x0086 }
            goto L_0x0099
        L_0x0086:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            r3.append(r2)
            java.lang.String r6 = r3.toString()
            com.tencent.tpns.baseapi.base.util.Logger.e(r0, r6)
        L_0x0099:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.base.util.Util.getCurProcessNameByProcFile(android.content.Context):java.lang.String");
    }

    public static long getCurVersionCode(Context context) {
        long j11 = f49828b;
        if (j11 > 0) {
            return j11;
        }
        try {
            f49828b = (long) context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
        } catch (PackageManager.NameNotFoundException e11) {
            Logger.e("Util", "getCurVersionCode error: PackageManager.NameNotFoundException", e11);
            f49828b = -1;
        }
        return f49828b;
    }

    public static String getKey(String str) {
        return Md5.md5(str);
    }

    public static String getNotifiedMsgIds(Context context, long j11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(PushMd5Pref.getString(context, "tpush_msgId_" + j11, true));
        String sb3 = sb2.toString();
        if (sb3 != null && sb3.length() > 20480) {
            sb3 = sb3.substring(0, sb3.indexOf("@@", 5120));
        }
        if (sb3 != null) {
            return sb3;
        }
        return "";
    }

    public static String getThrowableToString(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void getWakeCpu(Context context) {
        if (context == null) {
            Logger.e("Util", "Util -> getWakeCpu error null context");
            return;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (f49827a == null) {
                f49827a = powerManager.newWakeLock(536870913, "TPNS:VIP");
                c.a().a(f49827a);
            }
            if (!c.a().b().isHeld()) {
                c.a().b().setReferenceCounted(false);
                c.a().b().acquire(10000);
            }
            Logger.d("Util", "get Wake Cpu ");
        } catch (Throwable th2) {
            Logger.e("Util", "get Wake cpu", th2);
        }
    }

    public static boolean isMainProcess(Context context) {
        if (context == null) {
            return false;
        }
        String curProcessName = getCurProcessName(context);
        if (isNullOrEmptyString(curProcessName)) {
            return false;
        }
        return context.getPackageName().equals(curProcessName);
    }

    public static boolean isNullOrEmptyString(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static void killPushProcess(Context context) {
        try {
            String curProcessName = getCurProcessName(context);
            if (curProcessName != null && curProcessName.contains(":xg_vip_service")) {
                Logger.d("Util", "killPushProcess @ " + curProcessName);
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th2) {
            Logger.w("Util", "killPushProcess error: " + th2.toString());
        }
    }

    public static void stopWakeCpu() {
        try {
            PowerManager.WakeLock b11 = c.a().b();
            if (b11 != null) {
                if (b11.isHeld()) {
                    b11.release();
                }
                Logger.d("Util", "stop WakeLock CPU");
            }
        } catch (Throwable th2) {
            Logger.e("Util", "stopWakeLock", th2);
        }
    }
}
