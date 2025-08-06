package com.tencent.imsdk.common;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huochat.community.util.FileTool;
import java.io.File;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SystemUtil {
    private static final String DEVICE_ID = "DeviceID";
    private static final String DEVICE_INFO = "DeviceInfo";
    private static final String TAG = "SystemUtil";
    private static final int TIME_INTERVAL = 15000;
    private static String buildBrand = "";
    private static String buildManufacturer = "";
    private static String buildModel = "";
    private static String buildVersionRelease = "";
    private static int buildVersionSDKInt = 0;
    private static String currentProcessName = "";
    private static float lastAppCpu = 0.0f;
    private static long lastAppCpuTime = 0;
    /* access modifiers changed from: private */
    public static long lastMemCheckTimeStamps = 0;
    /* access modifiers changed from: private */
    public static int lastMemUsage = 0;
    private static float lastSysCpu = 0.0f;
    private static long lastSysCpuTime = 0;
    private static boolean mFirstTimeRun = true;
    private static CpuUsageMeasurer sCpuUsageMeasurer = null;
    private static boolean sIsLoadLibrarySuccess = false;
    /* access modifiers changed from: private */
    public static boolean sRunningMemCheck = false;

    public static float getAppCpuUsage() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastAppCpuTime < 15000) {
            return lastAppCpu;
        }
        float f11 = ((float) (getProcessCPURate()[0] / 10)) / 100.0f;
        lastAppCpu = f11;
        lastAppCpuTime = currentTimeMillis;
        return f11;
    }

    public static float getAppMemory() {
        int i11;
        final long currentTimeMillis = System.currentTimeMillis();
        if (!sRunningMemCheck) {
            long j11 = lastMemCheckTimeStamps;
            if (j11 == 0 || currentTimeMillis - j11 >= 15000) {
                sRunningMemCheck = true;
                AsyncTask.execute(new Runnable() {
                    public void run() {
                        System.currentTimeMillis();
                        boolean unused = SystemUtil.sRunningMemCheck = false;
                        try {
                            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                            Debug.getMemoryInfo(memoryInfo);
                            int totalPss = memoryInfo.getTotalPss();
                            long unused2 = SystemUtil.lastMemCheckTimeStamps = currentTimeMillis;
                            int unused3 = SystemUtil.lastMemUsage = totalPss / 1024;
                        } catch (Exception unused4) {
                        }
                    }
                });
                i11 = lastMemUsage;
                return (float) i11;
            }
        }
        i11 = lastMemUsage;
        return (float) i11;
    }

    private static String getBuildBrand() {
        if (TextUtils.isEmpty(buildBrand)) {
            buildBrand = Build.BRAND;
        }
        return buildBrand;
    }

    private static String getBuildManufacturer() {
        if (TextUtils.isEmpty(buildManufacturer)) {
            buildManufacturer = Build.MANUFACTURER;
        }
        return buildManufacturer;
    }

    public static String getCurrentProcessName() {
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            String processName = Application.getProcessName();
            currentProcessName = processName;
            return processName;
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
            if (invoke instanceof String) {
                currentProcessName = (String) invoke;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return currentProcessName;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDeviceID() {
        /*
            com.tencent.imsdk.common.IMContext r0 = com.tencent.imsdk.common.IMContext.getInstance()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            java.lang.String r2 = "DeviceInfo"
            r3 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r2, r3)
            java.lang.String r2 = "DeviceID"
            boolean r4 = r0.contains(r2)
            r5 = 1
            if (r4 != 0) goto L_0x0027
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
        L_0x0025:
            r3 = r5
            goto L_0x0042
        L_0x0027:
            java.lang.String r1 = r0.getString(r2, r1)
            java.lang.String r4 = "\\w{8}(-\\w{4}){3}-\\w{12}"
            boolean r4 = java.util.regex.Pattern.matches(r4, r1)
            if (r4 == 0) goto L_0x0039
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L_0x0042
        L_0x0039:
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            goto L_0x0025
        L_0x0042:
            if (r3 == 0) goto L_0x004e
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putString(r2, r1)
            r0.apply()
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.common.SystemUtil.getDeviceID():java.lang.String");
    }

    public static String getDeviceType() {
        if (TextUtils.isEmpty(buildModel)) {
            buildModel = Build.MODEL;
        }
        return buildModel;
    }

    public static int getInstanceType() {
        if (isBrandXiaoMi()) {
            return 2000;
        }
        if (isBrandNewHonor()) {
            return 2006;
        }
        if (isBrandHuawei()) {
            return 2001;
        }
        if (isBrandMeizu()) {
            return 2003;
        }
        if (isBrandOppo()) {
            return 2004;
        }
        return isBrandVivo() ? 2005 : 2002;
    }

    public static int[] getProcessCPURate() {
        if (sCpuUsageMeasurer == null) {
            sCpuUsageMeasurer = new CpuUsageMeasurer();
        }
        if (!mFirstTimeRun) {
            return sCpuUsageMeasurer.getCpuUsage();
        }
        mFirstTimeRun = false;
        sCpuUsageMeasurer.getCpuUsage();
        return new int[]{0, 0};
    }

    public static String getSDKInitPath() {
        Context applicationContext = IMContext.getInstance().getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        String file = applicationContext.getFilesDir().toString();
        String packageName = applicationContext.getPackageName();
        String currentProcessName2 = getCurrentProcessName();
        if (!TextUtils.isEmpty(currentProcessName2) && !packageName.equals(currentProcessName2)) {
            try {
                int lastIndexOf = currentProcessName2.lastIndexOf(":");
                if (lastIndexOf < 0) {
                    lastIndexOf = currentProcessName2.lastIndexOf(InstructionFileId.DOT);
                }
                if (lastIndexOf >= 0) {
                    currentProcessName2 = currentProcessName2.substring(lastIndexOf + 1);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(file);
                String str = File.separator;
                sb2.append(str);
                sb2.append(currentProcessName2);
                sb2.append(str);
                file = sb2.toString();
            } catch (Exception e11) {
                String str2 = TAG;
                Log.e(str2, "getSDKInitPath exception = " + e11);
            }
        }
        String str3 = TAG;
        Log.d(str3, "SDK Init Path: " + file);
        return file;
    }

    public static String getSDKLogPath() {
        String str;
        Context applicationContext = IMContext.getInstance().getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        File externalFilesDir = applicationContext.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            str = "/sdcard/Android/data/" + applicationContext.getPackageName() + "/log/tencent/imsdk";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(externalFilesDir.getAbsolutePath());
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append("log");
            sb2.append(str2);
            sb2.append("tencent");
            sb2.append(str2);
            sb2.append("imsdk");
            str = sb2.toString();
        }
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            file = applicationContext.getFilesDir();
            Log.e(TAG, "create log folder failed");
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(file.getAbsolutePath());
        String str3 = File.separator;
        sb3.append(str3);
        String sb4 = sb3.toString();
        String packageName = applicationContext.getPackageName();
        String currentProcessName2 = getCurrentProcessName();
        if (!TextUtils.isEmpty(currentProcessName2) && !packageName.equals(currentProcessName2)) {
            try {
                int lastIndexOf = currentProcessName2.lastIndexOf(":");
                if (lastIndexOf < 0) {
                    lastIndexOf = currentProcessName2.lastIndexOf(InstructionFileId.DOT);
                }
                if (lastIndexOf >= 0) {
                    currentProcessName2 = currentProcessName2.substring(lastIndexOf + 1);
                }
                sb4 = sb4 + currentProcessName2 + str3;
            } catch (Exception e11) {
                Log.e(TAG, "getSDKLogPath exception = " + e11);
            }
        }
        Log.d(TAG, "SDK LOG Path: " + sb4);
        return sb4;
    }

    public static int getSDKVersion() {
        if (buildVersionSDKInt == 0) {
            buildVersionSDKInt = Build.VERSION.SDK_INT;
        }
        return buildVersionSDKInt;
    }

    public static float getSysCpuUsage() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastSysCpuTime < 15000) {
            return lastSysCpu;
        }
        float f11 = ((float) (getProcessCPURate()[1] / 10)) / 100.0f;
        lastSysCpu = f11;
        lastSysCpuTime = currentTimeMillis;
        return f11;
    }

    public static String getSystemVersion() {
        if (TextUtils.isEmpty(buildVersionRelease)) {
            buildVersionRelease = Build.VERSION.RELEASE;
        }
        return buildVersionRelease;
    }

    public static boolean isBrandHuawei() {
        return MTPushConstants.Manufacturer.HUAWEI.equalsIgnoreCase(getBuildBrand()) || MTPushConstants.Manufacturer.HUAWEI.equalsIgnoreCase(getBuildManufacturer()) || MTPushConstants.Manufacturer.HONOR.equalsIgnoreCase(getBuildBrand());
    }

    public static boolean isBrandMeizu() {
        return MTPushConstants.Manufacturer.MEIZU.equalsIgnoreCase(getBuildBrand()) || MTPushConstants.Manufacturer.MEIZU.equalsIgnoreCase(getBuildManufacturer());
    }

    public static boolean isBrandNewHonor() {
        return MTPushConstants.Manufacturer.HONOR.equalsIgnoreCase(getBuildBrand()) && MTPushConstants.Manufacturer.HONOR.equalsIgnoreCase(getBuildManufacturer());
    }

    public static boolean isBrandOppo() {
        return MTPushConstants.Manufacturer.OPPO.equalsIgnoreCase(getBuildBrand()) || MTPushConstants.Manufacturer.OPPO.equalsIgnoreCase(getBuildManufacturer()) || MTPushConstants.Manufacturer.REALME.equalsIgnoreCase(getBuildBrand()) || MTPushConstants.Manufacturer.REALME.equalsIgnoreCase(getBuildManufacturer()) || MTPushConstants.Manufacturer.ONEPLUS.equalsIgnoreCase(getBuildBrand()) || MTPushConstants.Manufacturer.ONEPLUS.equalsIgnoreCase(getBuildManufacturer());
    }

    public static boolean isBrandVivo() {
        return "vivo".equalsIgnoreCase(getBuildBrand()) || "vivo".equalsIgnoreCase(getBuildManufacturer());
    }

    public static boolean isBrandXiaoMi() {
        return "xiaomi".equalsIgnoreCase(getBuildBrand()) || "xiaomi".equalsIgnoreCase(getBuildManufacturer());
    }

    public static boolean isLibraryLoaded() {
        return sIsLoadLibrarySuccess;
    }

    public static boolean loadIMLibrary() {
        return loadIMLibrary((String) null);
    }

    public static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = "";
            for (byte b11 : MessageDigest.getInstance(FileTool.HASH_TYPE_MD5).digest(str.getBytes())) {
                String hexString = Integer.toHexString(b11 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        } catch (NoSuchAlgorithmException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static void setBuildBrand(String str) {
        buildBrand = str;
    }

    public static void setBuildManufacturer(String str) {
        buildManufacturer = str;
    }

    public static void setBuildModel(String str) {
        buildModel = str;
    }

    public static void setBuildVersionRelease(String str) {
        buildVersionRelease = str;
    }

    public static void setBuildVersionSDKInt(int i11) {
        buildVersionSDKInt = i11;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static boolean loadIMLibrary(String str) {
        if (sIsLoadLibrarySuccess) {
            return true;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                String str2 = str + File.separator + "libImSDK.so";
                System.load(str2);
                sIsLoadLibrarySuccess = true;
                Log.i(TAG, "system load so library success: " + str2);
            } else {
                System.loadLibrary("ImSDK");
                sIsLoadLibrarySuccess = true;
                Log.i(TAG, "system load so library success, libImSDK.so");
            }
        } catch (UnsatisfiedLinkError e11) {
            sIsLoadLibrarySuccess = false;
            Log.e(TAG, "system load so library failed, " + e11.getMessage());
        } catch (Exception e12) {
            sIsLoadLibrarySuccess = false;
            Log.e(TAG, "system load so library failed, " + e12.getMessage());
        }
        return sIsLoadLibrarySuccess;
    }
}
