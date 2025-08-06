package com.blankj.utilcode.util;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.List;

public final class r {
    public static String a() {
        String c11 = c();
        if (!TextUtils.isEmpty(c11)) {
            return c11;
        }
        String b11 = b();
        if (!TextUtils.isEmpty(b11)) {
            return b11;
        }
        return d();
    }

    public static String b() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String str;
        try {
            ActivityManager activityManager = (ActivityManager) Utils.a().getSystemService("activity");
            if (!(activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null)) {
                if (runningAppProcesses.size() != 0) {
                    int myPid = Process.myPid();
                    for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                        if (next.pid == myPid && (str = next.processName) != null) {
                            return str;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String c() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return trim;
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String d() {
        try {
            Application a11 = Utils.a();
            Field field = a11.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(a11);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            return (String) obj2.getClass().getDeclaredMethod("getProcessName", new Class[0]).invoke(obj2, new Object[0]);
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }
}
