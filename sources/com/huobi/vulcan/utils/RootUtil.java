package com.huobi.vulcan.utils;

import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class RootUtil {
    public static boolean a() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static boolean b() {
        String[] strArr = {"/data/local/su", "/data/local/xbin/su", "/data/local/bin/su", "/sbin/su", "/system/app/Superuser.apk", "/system/bin/failsafe/su", "/system/bin/su", "/system/sd/xbin/su", "/system/xbin/su"};
        for (int i11 = 0; i11 < 9; i11++) {
            if (new File(strArr[i11]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean c() {
        boolean z11 = false;
        Process process = null;
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            if (new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine() != null) {
                z11 = true;
            }
            exec.destroy();
            return z11;
        } catch (Throwable unused) {
            if (process != null) {
                process.destroy();
            }
            return false;
        }
    }

    public static boolean d() {
        return a() || b() || c();
    }
}
