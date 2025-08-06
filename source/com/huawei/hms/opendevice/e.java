package com.huawei.hms.opendevice;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f38309a;

    private static String a() {
        BufferedReader bufferedReader;
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String trim = readLine.trim();
                        bufferedReader.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                        return trim;
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                    return "";
                } catch (Throwable th2) {
                    inputStreamReader.close();
                    throw th2;
                }
                throw th;
            } catch (Throwable th3) {
                fileInputStream.close();
                throw th3;
            }
        } catch (IOException unused) {
            HMSLog.e("CommFun", "get current app processes IOException!");
            return "";
        } catch (Exception e11) {
            HMSLog.e("CommFun", "get current app processes exception!" + e11.getMessage());
            return "";
        } catch (Throwable th4) {
            th3.addSuppressed(th4);
        }
    }

    public static boolean b() {
        int i11 = HwBuildEx.VERSION.EMUI_SDK_INT;
        HMSLog.d("CommFun", "Emui Api Level:" + i11);
        return i11 > 0;
    }

    public static String c(Context context) {
        String str;
        if (Build.VERSION.SDK_INT >= 24) {
            str = context.createDeviceProtectedStorageContext().getDataDir() + "";
        } else {
            str = context.getFilesDir().getParent();
        }
        if (TextUtils.isEmpty(str)) {
            HMSLog.e("CommFun", "get storage root path of the current user failed.");
        }
        return str;
    }

    public static long d(Context context) {
        try {
            return (long) context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
        } catch (Exception unused) {
            HMSLog.e("CommFun", "get nc versionCode error");
            return -1;
        }
    }

    public static boolean e(Context context) {
        return b() && HwBuildEx.VERSION.EMUI_SDK_INT < 21 && d(context) < 110001400;
    }

    private static String b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
            HMSLog.w("CommFun", "get running app processes null!");
            return "";
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid && next.processName != null) {
                HMSLog.i("CommFun", "info.pid -> " + next.pid + ", info.processName -> " + next.processName);
                return next.processName;
            }
        }
        return "";
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f38309a)) {
            return f38309a;
        }
        String b11 = b(context);
        f38309a = b11;
        if (!TextUtils.isEmpty(b11)) {
            return f38309a;
        }
        String a11 = a();
        f38309a = a11;
        return a11;
    }
}
