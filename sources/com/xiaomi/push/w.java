package com.xiaomi.push;

import android.util.Log;
import java.io.File;
import java.util.HashMap;

public class w {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, String> f52619a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f52619a = hashMap;
        hashMap.put("FFD8FF", "jpg");
        hashMap.put("89504E47", "png");
        hashMap.put("47494638", "gif");
        hashMap.put("474946", "gif");
        hashMap.put("424D", "bmp");
    }

    public static long a(File file) {
        long j11;
        long j12 = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i11 = 0; i11 < listFiles.length; i11++) {
                if (listFiles[i11].isDirectory()) {
                    j11 = a(listFiles[i11]);
                } else {
                    j11 = listFiles[i11].length();
                }
                j12 += j11;
            }
        } catch (Exception e11) {
            Log.e("FileUtils", "Get folder size error: " + e11.getMessage());
        }
        return j12;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m3068a(File file) {
        long j11;
        if (file == null) {
            return false;
        }
        try {
            if (!file.exists()) {
                return true;
            }
            if (file.isDirectory()) {
                j11 = a(file);
            } else {
                j11 = file.length();
            }
            if (j11 < 104857600) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            Log.e("FileUtils", "Check if internal file can be written error :" + e11.getMessage());
            return false;
        }
    }
}
