package com.tencent.wxop.stat.b;

import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

final class m {
    public static int D() {
        int i11 = 0;
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            String trim = str.trim();
            if (trim.length() > 0) {
                i11 = Integer.valueOf(trim).intValue();
            }
        } catch (Throwable th2) {
            l.cT.b(th2);
        }
        return i11 * 1000;
    }

    public static int aA() {
        int i11 = 0;
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            String trim = str.trim();
            if (trim.length() > 0) {
                i11 = Integer.valueOf(trim).intValue();
            }
        } catch (Exception e11) {
            l.cT.b((Throwable) e11);
        }
        return i11 * 1000;
    }

    public static String ax() {
        String[] strArr = {"", ""};
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(l.f34626a), 8192);
            String[] split = bufferedReader.readLine().split("\\s+");
            for (int i11 = 2; i11 < split.length; i11++) {
                strArr[0] = strArr[0] + split[i11] + " ";
            }
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return strArr[0];
    }

    public static int r() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new n()).length;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 1;
        }
    }
}
