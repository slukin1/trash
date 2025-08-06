package com.engagelab.privates.common.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.adjust.sdk.Constants;
import com.facebook.places.model.PlaceFields;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

public class DeviceUtil {
    private static final FileFilter CPU_FILTER = new a();
    private static String CPU_HARDWARE = "";
    private static String CPU_INFO = "";
    private static final String TAG = "DeviceUtil";

    public static class a implements FileFilter {
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i11 = 3; i11 < name.length(); i11++) {
                if (name.charAt(i11) < '0' || name.charAt(i11) > '9') {
                    return false;
                }
            }
            return true;
        }
    }

    private static int extractValue(byte[] bArr, int i11) {
        while (i11 < bArr.length && bArr[i11] != 10) {
            try {
                if (bArr[i11] < 48 || bArr[i11] > 57) {
                    i11++;
                } else {
                    int i12 = i11 + 1;
                    while (i12 < bArr.length && bArr[i12] >= 48 && bArr[i12] <= 57) {
                        i12++;
                    }
                    return Integer.parseInt(new String(bArr, 0, i11, i12 - i11));
                }
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public static String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String getBrand() {
        return String.format(Locale.ENGLISH, Build.BRAND, new Object[0]);
    }

    public static int getCPUMaxFreqKHz() {
        int i11 = 0;
        while (i11 < getCpuCoreCount()) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i11 + "/cpufreq/cpuinfo_max_freq");
                if (!file.exists()) {
                    i11++;
                } else {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    fileInputStream.read(bArr);
                    int i12 = 0;
                    while (bArr[i12] >= 48 && bArr[i12] <= 57) {
                        i12++;
                    }
                    int parseInt = Integer.parseInt(new String(bArr, 0, i12));
                    fileInputStream.close();
                    return parseInt;
                }
            } catch (Throwable unused) {
                return -1;
            }
        }
        FileInputStream fileInputStream2 = new FileInputStream(l.f34626a);
        int parseFileForValue = parseFileForValue("cpu MHz", fileInputStream2);
        fileInputStream2.close();
        return parseFileForValue * 1000;
    }

    public static String getCarrier(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getNetworkOperatorName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int getCpuCoreCount() {
        File[] listFiles;
        try {
            if (Build.VERSION.SDK_INT <= 10) {
                return 1;
            }
            File file = new File("/sys/devices/system/cpu/");
            if (!file.exists() || (listFiles = file.listFiles(CPU_FILTER)) == null) {
                return -1;
            }
            if (listFiles.length == 0) {
                return -1;
            }
            return listFiles.length;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String getCpuHardwareInfo() {
        if (!TextUtils.isEmpty(CPU_HARDWARE)) {
            return CPU_HARDWARE;
        }
        matchCpuInfo();
        return CPU_HARDWARE;
    }

    public static String getCpuInfo() {
        if (!TextUtils.isEmpty(CPU_INFO)) {
            return CPU_INFO;
        }
        matchCpuInfo();
        return CPU_INFO;
    }

    public static String getLanguage(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String getManufacturer() {
        return String.format(Locale.ENGLISH, Build.MANUFACTURER, new Object[0]);
    }

    public static String getModel() {
        return String.format(Locale.ENGLISH, Build.MODEL, new Object[0]);
    }

    public static String getProduct() {
        return String.format(Locale.ENGLISH, Build.PRODUCT, new Object[0]);
    }

    public static long getRamSize(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                activityManager.getProcessMemoryInfo(new int[]{0});
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.totalMem / 1024;
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    public static String getResolution(Context context) {
        DisplayMetrics displayMetrics;
        try {
            if (context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
                return "0*0";
            }
            int i11 = displayMetrics.widthPixels;
            int i12 = displayMetrics.heightPixels;
            return i11 + "*" + i12;
        } catch (Throwable unused) {
            return "0*0";
        }
    }

    public static long getRomSize(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1024;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static double getScreenSize(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static String getSsid(Context context) {
        try {
            return StringUtil.filterSpecialCharacter(((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getSSID());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getSystemDevice() {
        return Build.DEVICE.toLowerCase();
    }

    public static String getSystemVersionRelease() {
        return String.format(Locale.ENGLISH, Build.VERSION.RELEASE, new Object[0]);
    }

    public static int getSystemVersionSdkInt() {
        return Build.VERSION.SDK_INT;
    }

    public static String getTimeZone() {
        long rawOffset = (long) (TimeZone.getDefault().getRawOffset() / Constants.ONE_HOUR);
        int i11 = (rawOffset > 0 ? 1 : (rawOffset == 0 ? 0 : -1));
        if (i11 > 0) {
            return "+" + rawOffset;
        } else if (i11 < 0) {
            return com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + rawOffset;
        } else {
            return "" + rawOffset;
        }
    }

    public static String getTimeZoneId() {
        if (Build.VERSION.SDK_INT >= 26) {
            return ZoneId.systemDefault().getId();
        }
        return TimeZone.getDefault().getID();
    }

    private static void matchCpuInfo() {
        try {
            File file = new File(l.f34626a);
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                if (!fileReader.equals((Object) null)) {
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    if (!bufferedReader.equals((Object) null)) {
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                if (readLine.contains("Processor")) {
                                    StringBuilder sb2 = new StringBuilder();
                                    int indexOf = readLine.indexOf(":");
                                    if (indexOf >= 0 && indexOf < readLine.length() - 1) {
                                        sb2.append(readLine.substring(indexOf + 1).trim());
                                    }
                                    CPU_INFO = sb2.toString();
                                }
                                if (readLine.contains("Hardware")) {
                                    CPU_HARDWARE = readLine.substring(readLine.indexOf(":") + 1).trim();
                                }
                            } else {
                                bufferedReader.close();
                                return;
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static int parseFileForValue(String str, FileInputStream fileInputStream) {
        try {
            byte[] bArr = new byte[1024];
            int read = fileInputStream.read(bArr);
            int i11 = 0;
            while (i11 < read) {
                if (bArr[i11] == 10 || i11 == 0) {
                    if (bArr[i11] == 10) {
                        i11++;
                    }
                    int i12 = i11;
                    while (true) {
                        if (i12 >= read) {
                            continue;
                            break;
                        }
                        int i13 = i12 - i11;
                        if (bArr[i12] != str.charAt(i13)) {
                            break;
                        } else if (i13 == str.length() - 1) {
                            return extractValue(bArr, i12);
                        } else {
                            i12++;
                        }
                    }
                }
                i11++;
            }
        } catch (Throwable unused) {
        }
        return -1;
    }
}
