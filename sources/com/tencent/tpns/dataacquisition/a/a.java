package com.tencent.tpns.dataacquisition.a;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.adjust.sdk.Constants;
import com.facebook.appevents.UserDataStore;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static BroadcastReceiver f49910a = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static String f49911b;

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f49912c = {"com.mumu.launcher", "com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.bluestacks.appmart", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f49913d = {"/data/data/com.android.flysilkworm", "/data/data/com.bluestacks.filemanager"};

    /* renamed from: e  reason: collision with root package name */
    private static DisplayMetrics f49914e = null;

    /* renamed from: f  reason: collision with root package name */
    private static int f49915f = -1;

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f49916g = null;

    /* renamed from: h  reason: collision with root package name */
    private static String f49917h = null;

    /* renamed from: i  reason: collision with root package name */
    private static long f49918i = -1;

    /* renamed from: j  reason: collision with root package name */
    private static C0634a f49919j = null;

    /* renamed from: com.tencent.tpns.dataacquisition.a.a$a  reason: collision with other inner class name */
    public static class C0634a {

        /* renamed from: com.tencent.tpns.dataacquisition.a.a$a$a  reason: collision with other inner class name */
        public class C0635a implements FileFilter {
            public boolean accept(File file) {
                return Pattern.matches("cpu[0-9]", file.getName());
            }
        }

        public static int a() {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new C0635a());
                if (listFiles != null) {
                    return listFiles.length;
                }
                return 1;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return 1;
            }
        }

        public static int b() {
            StringBuilder sb2;
            int i11 = 0;
            InputStream inputStream = null;
            String str = "";
            try {
                InputStream inputStream2 = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
                byte[] bArr = new byte[24];
                while (inputStream2.read(bArr) != -1) {
                    str = str + new String(bArr);
                }
                String trim = str.trim();
                if (trim.length() > 0) {
                    i11 = Integer.valueOf(trim).intValue();
                }
                try {
                    inputStream2.close();
                } catch (Throwable th2) {
                    th = th2;
                    sb2 = new StringBuilder();
                }
            } catch (Throwable th3) {
                th = th3;
                sb2 = new StringBuilder();
            }
            return i11 * 1000;
            sb2.append("unexpected for:");
            sb2.append(th.getMessage());
            com.tencent.tpns.dataacquisition.b.a.a(sb2.toString());
            return i11 * 1000;
        }

        public static int c() {
            StringBuilder sb2;
            int i11 = 0;
            InputStream inputStream = null;
            String str = "";
            try {
                InputStream inputStream2 = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"}).start().getInputStream();
                byte[] bArr = new byte[24];
                while (inputStream2.read(bArr) != -1) {
                    str = str + new String(bArr, "UTF-8");
                }
                String trim = str.trim();
                if (trim.length() > 0) {
                    i11 = Integer.valueOf(trim).intValue();
                }
                try {
                    inputStream2.close();
                } catch (Throwable th2) {
                    th = th2;
                    sb2 = new StringBuilder();
                }
            } catch (IOException e11) {
                try {
                    com.tencent.tpns.dataacquisition.b.a.a("getMinCpuFreq", (Throwable) e11);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th3) {
                    com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + th3.getMessage());
                }
            } catch (Throwable th4) {
                th = th4;
                sb2 = new StringBuilder();
            }
            return i11 * 1000;
            throw th;
            sb2.append("unexpected for: ");
            sb2.append(th.getMessage());
            com.tencent.tpns.dataacquisition.b.a.a(sb2.toString());
            return i11 * 1000;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0059 A[SYNTHETIC, Splitter:B:25:0x0059] */
        /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String d() {
            /*
                java.lang.String r0 = "unexpected for: "
                r1 = 0
                java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x004f }
                java.lang.String r3 = "/proc/cpuinfo"
                r2.<init>(r3)     // Catch:{ all -> 0x004f }
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x004f }
                r3.<init>(r2)     // Catch:{ all -> 0x004f }
                java.lang.String r1 = r3.readLine()     // Catch:{ all -> 0x004d }
                boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x004d }
                if (r2 != 0) goto L_0x0042
                java.lang.String r2 = ":\\s+"
                r4 = 2
                java.lang.String[] r1 = r1.split(r2, r4)     // Catch:{ all -> 0x004d }
                int r2 = r1.length     // Catch:{ all -> 0x004d }
                if (r2 <= 0) goto L_0x0042
                r2 = 1
                r1 = r1[r2]     // Catch:{ all -> 0x004d }
                r3.close()     // Catch:{ all -> 0x002a }
                goto L_0x0041
            L_0x002a:
                r2 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r0)
                java.lang.String r0 = r2.getMessage()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                com.tencent.tpns.dataacquisition.b.a.a(r0)
            L_0x0041:
                return r1
            L_0x0042:
                r3.close()     // Catch:{ all -> 0x0046 }
                goto L_0x0074
            L_0x0046:
                r1 = move-exception
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                goto L_0x0063
            L_0x004d:
                r1 = move-exception
                goto L_0x0052
            L_0x004f:
                r2 = move-exception
                r3 = r1
                r1 = r2
            L_0x0052:
                java.lang.String r2 = "getCpuName"
                com.tencent.tpns.dataacquisition.b.a.a((java.lang.String) r2, (java.lang.Throwable) r1)     // Catch:{ all -> 0x0077 }
                if (r3 == 0) goto L_0x0074
                r3.close()     // Catch:{ all -> 0x005d }
                goto L_0x0074
            L_0x005d:
                r1 = move-exception
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
            L_0x0063:
                r2.append(r0)
                java.lang.String r0 = r1.getMessage()
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                com.tencent.tpns.dataacquisition.b.a.a(r0)
            L_0x0074:
                java.lang.String r0 = ""
                return r0
            L_0x0077:
                r1 = move-exception
                if (r3 == 0) goto L_0x0095
                r3.close()     // Catch:{ all -> 0x007e }
                goto L_0x0095
            L_0x007e:
                r2 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r0)
                java.lang.String r0 = r2.getMessage()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                com.tencent.tpns.dataacquisition.b.a.a(r0)
            L_0x0095:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.dataacquisition.a.a.C0634a.d():java.lang.String");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
            com.tencent.tpns.dataacquisition.b.a.a("unexpected for br.close");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0048, code lost:
            if (r4 != null) goto L_0x0036;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String e() {
            /*
                java.lang.String r0 = "unexpected for br.close"
                java.lang.String r1 = ""
                r2 = 0
                java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x0040 }
                java.lang.String r4 = "/proc/cpuinfo"
                r3.<init>(r4)     // Catch:{ all -> 0x0040 }
                java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x0040 }
                r4.<init>(r3)     // Catch:{ all -> 0x0040 }
            L_0x0011:
                java.lang.String r2 = r4.readLine()     // Catch:{ all -> 0x003e }
                if (r2 == 0) goto L_0x0036
                java.lang.String r3 = ":\\s+"
                r5 = 2
                java.lang.String[] r2 = r2.split(r3, r5)     // Catch:{ all -> 0x003e }
                if (r2 == 0) goto L_0x0011
                r3 = 0
                r3 = r2[r3]     // Catch:{ all -> 0x003e }
                java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x003e }
                java.lang.String r3 = r3.toLowerCase()     // Catch:{ all -> 0x003e }
                java.lang.String r5 = "hardware"
                boolean r3 = r3.startsWith(r5)     // Catch:{ all -> 0x003e }
                if (r3 == 0) goto L_0x0011
                r3 = 1
                r1 = r2[r3]     // Catch:{ all -> 0x003e }
            L_0x0036:
                r4.close()     // Catch:{ all -> 0x003a }
                goto L_0x004b
            L_0x003a:
                com.tencent.tpns.dataacquisition.b.a.a(r0)
                goto L_0x004b
            L_0x003e:
                r2 = move-exception
                goto L_0x0043
            L_0x0040:
                r3 = move-exception
                r4 = r2
                r2 = r3
            L_0x0043:
                java.lang.String r3 = "getCpuManufacturer"
                com.tencent.tpns.dataacquisition.b.a.a((java.lang.String) r3, (java.lang.Throwable) r2)     // Catch:{ all -> 0x004c }
                if (r4 == 0) goto L_0x004b
                goto L_0x0036
            L_0x004b:
                return r1
            L_0x004c:
                r1 = move-exception
                if (r4 == 0) goto L_0x0056
                r4.close()     // Catch:{ all -> 0x0053 }
                goto L_0x0056
            L_0x0053:
                com.tencent.tpns.dataacquisition.b.a.a(r0)
            L_0x0056:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.dataacquisition.a.a.C0634a.e():java.lang.String");
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static int f49920a = -1;

        public static boolean a() {
            int i11 = f49920a;
            if (i11 == 1) {
                return true;
            }
            if (i11 == 0) {
                return false;
            }
            String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
            int i12 = 0;
            while (i12 < 6) {
                try {
                    if (new File(strArr[i12] + "su").exists()) {
                        f49920a = 1;
                        return true;
                    }
                    i12++;
                } catch (Throwable th2) {
                    com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + th2.getMessage());
                }
            }
            f49920a = 0;
            return false;
        }
    }

    public static Integer a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
            return null;
        } catch (Throwable unused) {
            com.tencent.tpns.dataacquisition.b.a.a("unexpected for getTelephonyNetworkType");
            return null;
        }
    }

    public static synchronized String a() {
        String str;
        synchronized (a.class) {
            if (f49911b == null) {
                f49911b = Build.MODEL;
            }
            if (f49911b == null) {
                f49911b = "";
            }
            str = f49911b;
        }
        return str;
    }

    private static String a(List<String> list) {
        String str = Build.MANUFACTURER;
        if (str.toLowerCase().contains(Constants.REFERRER_API_GOOGLE)) {
            return "Google";
        }
        if (list.size() == 0) {
            return "unknown";
        }
        String str2 = list.get(0);
        return str2.contains("mumu") ? "mumu" : str2.contains("ami") ? "AMIDuOS" : str2.contains("bluestacks") ? "蓝叠" : (str2.contains("kaopu001") || str2.contains("tiantian")) ? "天天" : str2.contains("kpzs") ? "靠谱助手" : str2.contains("genymotion") ? DeviceInfos.getDM().contains("iTools") ? "iTools" : DeviceInfos.getDM().contains("ChangWan") ? "畅玩" : "genymotion" : str2.contains("uc") ? "uc" : str2.contains("blue") ? "blue" : str2.contains("microvirt") ? "逍遥" : str2.contains("itools") ? "itools" : str2.contains("syd") ? "手游岛" : str2.contains("bignox") ? "夜神" : str2.contains("haimawan") ? "海马玩" : str2.contains("windroy") ? "windroy" : str2.contains("flysilkworm") ? "雷电" : str2.contains("emu") ? "emu" : str2.contains("le8") ? "le8" : str2.contains("vphone") ? "vphone" : str2.contains("duoyi") ? "多益" : str.toLowerCase().contains(Constants.REFERRER_API_GOOGLE) ? "Google" : "unknown";
    }

    public static boolean b() {
        try {
            String str = Build.CPU_ABI;
            return !TextUtils.isEmpty(str) && !str.toLowerCase().contains("x86") && !str.toLowerCase().contains("amd");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        try {
            if (!com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                return true;
            }
            com.tencent.tpns.dataacquisition.b.a.a("Network error");
            return false;
        } catch (Throwable th2) {
            com.tencent.tpns.dataacquisition.b.a.a("isNetworkAvailable error", th2);
            return false;
        }
    }

    public static byte c(Context context) {
        if (context != null) {
            try {
                if (com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        return 0;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        if (activeNetworkInfo.isConnected()) {
                            if (activeNetworkInfo.getType() == 1) {
                                return 1;
                            }
                            if (activeNetworkInfo.getType() != 0) {
                                return 0;
                            }
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                    return 2;
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 15:
                                    return 3;
                                case 13:
                                    return 4;
                                default:
                                    return 0;
                            }
                        }
                    }
                    return -1;
                }
            } catch (Throwable th2) {
                com.tencent.tpns.dataacquisition.b.a.a("getNetworkType: ", th2);
            }
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c A[SYNTHETIC, Splitter:B:31:0x007c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c() {
        /*
            java.lang.String r0 = "unexpected for: "
            java.lang.String r1 = android.os.Build.CPU_ABI
            java.lang.String r2 = "x86"
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x000f
            java.lang.String r0 = "Intel"
            return r0
        L_0x000f:
            java.lang.String r1 = ""
            r2 = 0
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0072 }
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = "/proc/cpuinfo"
            java.lang.String r6 = "r"
            r4.<init>(r5, r6)     // Catch:{ all -> 0x0072 }
            int r2 = r4.read(r3)     // Catch:{ all -> 0x0070 }
            if (r2 >= 0) goto L_0x0041
            r4.close()     // Catch:{ all -> 0x0029 }
            goto L_0x0040
        L_0x0029:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = r2.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.tencent.tpns.dataacquisition.b.a.a(r0)
        L_0x0040:
            return r1
        L_0x0041:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0070 }
            r2.<init>(r3)     // Catch:{ all -> 0x0070 }
            r3 = 0
            int r5 = r2.indexOf(r3)     // Catch:{ all -> 0x0070 }
            r6 = -1
            if (r5 == r6) goto L_0x0053
            java.lang.String r1 = r2.substring(r3, r5)     // Catch:{ all -> 0x0070 }
            goto L_0x0054
        L_0x0053:
            r1 = r2
        L_0x0054:
            r4.close()     // Catch:{ all -> 0x0058 }
            goto L_0x0087
        L_0x0058:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x005e:
            r3.append(r0)
            java.lang.String r0 = r2.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.tencent.tpns.dataacquisition.b.a.a(r0)
            goto L_0x0087
        L_0x0070:
            r2 = move-exception
            goto L_0x0075
        L_0x0072:
            r3 = move-exception
            r4 = r2
            r2 = r3
        L_0x0075:
            java.lang.String r3 = "getCpuString"
            com.tencent.tpns.dataacquisition.b.a.a((java.lang.String) r3, (java.lang.Throwable) r2)     // Catch:{ all -> 0x0088 }
            if (r4 == 0) goto L_0x0087
            r4.close()     // Catch:{ all -> 0x0080 }
            goto L_0x0087
        L_0x0080:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x005e
        L_0x0087:
            return r1
        L_0x0088:
            r1 = move-exception
            if (r4 == 0) goto L_0x00a6
            r4.close()     // Catch:{ all -> 0x008f }
            goto L_0x00a6
        L_0x008f:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = r2.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.tencent.tpns.dataacquisition.b.a.a(r0)
        L_0x00a6:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.dataacquisition.a.a.c():java.lang.String");
    }

    public static String d() {
        String str;
        StringBuilder sb2;
        String str2;
        String c11 = c();
        if (c11.contains("ARMv5")) {
            str = "armv5";
        } else if (c11.contains("ARMv6")) {
            str = "armv6";
        } else if (c11.contains("ARMv7")) {
            str = "armv7";
        } else if (!c11.contains("Intel")) {
            return "unknown";
        } else {
            str = "x86";
        }
        if (c11.contains("neon")) {
            sb2 = new StringBuilder();
            sb2.append(str);
            str2 = "_neon";
        } else if (c11.contains("vfpv3")) {
            sb2 = new StringBuilder();
            sb2.append(str);
            str2 = "_vfpv3";
        } else if (c11.contains(" vfp")) {
            sb2 = new StringBuilder();
            sb2.append(str);
            str2 = "_vfp";
        } else {
            sb2 = new StringBuilder();
            sb2.append(str);
            str2 = "_none";
        }
        sb2.append(str2);
        return sb2.toString();
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (!com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return "WIFI".equalsIgnoreCase(activeNetworkInfo.getTypeName());
        } catch (Throwable th2) {
            com.tencent.tpns.dataacquisition.b.a.a("Check isWiFiActive error", th2);
            return false;
        }
    }

    public static String e() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return String.valueOf((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1000000) + "/" + String.valueOf(f() / 1000000);
    }

    public static String e(Context context) {
        String typeName;
        try {
            if (!com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.INTERNET") || !com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                com.tencent.tpns.dataacquisition.b.a.b("can not get the permission of android.permission.ACCESS_WIFI_STATE");
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (!activeNetworkInfo.isConnected() || (typeName = activeNetworkInfo.getTypeName()) == null) {
                return null;
            }
            return "WIFI".equalsIgnoreCase(typeName) ? "WIFI" : "MOBILE".equalsIgnoreCase(typeName) ? "MOBILE" : typeName;
        } catch (Throwable th2) {
            com.tencent.tpns.dataacquisition.b.a.b(th2);
            return null;
        }
    }

    public static long f() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static DisplayMetrics f(Context context) {
        if (f49914e == null) {
            f49914e = new DisplayMetrics();
            Display defaultDisplay = ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay();
            if (defaultDisplay != null) {
                defaultDisplay.getMetrics(f49914e);
            }
        }
        return f49914e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        if (r0 != null) goto L_0x0034;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064 A[SYNTHETIC, Splitter:B:26:0x0064] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long g() {
        /*
            long r0 = f49918i
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.String r0 = "/proc/meminfo"
            r1 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ IOException -> 0x003f, all -> 0x003a }
            r4.<init>(r0)     // Catch:{ IOException -> 0x003f, all -> 0x003a }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003f, all -> 0x003a }
            r5 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r4, r5)     // Catch:{ IOException -> 0x003f, all -> 0x003a }
            java.lang.String r1 = r0.readLine()     // Catch:{ IOException -> 0x0038 }
            if (r1 == 0) goto L_0x0034
            java.lang.String r4 = "\\s+"
            java.lang.String[] r1 = r1.split(r4)     // Catch:{ IOException -> 0x0038 }
            r4 = 1
            r1 = r1[r4]     // Catch:{ IOException -> 0x0038 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ IOException -> 0x0038 }
            int r1 = r1.intValue()     // Catch:{ IOException -> 0x0038 }
            long r1 = (long) r1
            r3 = 1024(0x400, double:5.06E-321)
            long r2 = r1 * r3
        L_0x0034:
            r0.close()     // Catch:{ all -> 0x005e }
            goto L_0x005e
        L_0x0038:
            r1 = move-exception
            goto L_0x0043
        L_0x003a:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0062
        L_0x003f:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L_0x0043:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r4.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = "unexpected for: "
            r4.append(r5)     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0061 }
            r4.append(r1)     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0061 }
            com.tencent.tpns.dataacquisition.b.a.a(r1)     // Catch:{ all -> 0x0061 }
            if (r0 == 0) goto L_0x005e
            goto L_0x0034
        L_0x005e:
            f49918i = r2
            return r2
        L_0x0061:
            r1 = move-exception
        L_0x0062:
            if (r0 == 0) goto L_0x0067
            r0.close()     // Catch:{ all -> 0x0067 }
        L_0x0067:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.dataacquisition.a.a.g():long");
    }

    public static boolean g(Context context) {
        return ((SensorManager) context.getSystemService("sensor")) != null;
    }

    public static int h(Context context) {
        int i11 = f49915f;
        if (i11 >= 0) {
            return i11;
        }
        try {
            return b.a() ? 1 : 0;
        } catch (Throwable th2) {
            com.tencent.tpns.dataacquisition.b.a.a("call hasRootAccess Error:", th2);
            return 0;
        }
    }

    public static boolean h() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable th2) {
            com.tencent.tpns.dataacquisition.b.a.a("isSDCardMounted", th2);
            return false;
        }
    }

    public static String i() {
        try {
            NumberFormat instance = NumberFormat.getInstance();
            instance.setGroupingUsed(false);
            return instance.format(((double) (System.currentTimeMillis() - SystemClock.elapsedRealtime())) / 1000.0d);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String i(Context context) {
        String path;
        try {
            if (com.tencent.tpns.dataacquisition.b.a.a(context, PermissionConfig.WRITE_EXTERNAL_STORAGE)) {
                String externalStorageState = Environment.getExternalStorageState();
                if (!(externalStorageState == null || !externalStorageState.equals("mounted") || (path = Environment.getExternalStorageDirectory().getPath()) == null)) {
                    StatFs statFs = new StatFs(path);
                    return String.valueOf((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000000) + "/" + String.valueOf((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000);
                }
                return null;
            }
            com.tencent.tpns.dataacquisition.b.a.a("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th2) {
            com.tencent.tpns.dataacquisition.b.a.a("getExternalStorageInfo err:", th2);
        }
    }

    public static int j(Context context) {
        return 0;
    }

    public static String j() {
        return "";
    }

    public static boolean k(Context context) {
        return true;
    }

    public static boolean l(Context context) {
        if (f49916g == null) {
            f49916g = Boolean.valueOf(!b() || !k(context));
        }
        return f49916g.booleanValue();
    }

    public static String m(Context context) {
        if (f49917h == null) {
            f49917h = a(v(context));
        }
        return f49917h;
    }

    public static String n(Context context) {
        return String.valueOf(w(context) / 1000000) + "/" + String.valueOf(g() / 1000000);
    }

    public static JSONObject o(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            x(context);
            int b11 = C0634a.b();
            if (b11 > 0) {
                jSONObject.put("fx", b11 / 1000000);
            }
            x(context);
            int c11 = C0634a.c();
            if (c11 > 0) {
                jSONObject.put(UserDataStore.FIRST_NAME, c11 / 1000000);
            }
            x(context);
            int a11 = C0634a.a();
            if (a11 > 0) {
                jSONObject.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, a11);
            }
            x(context);
            String d11 = C0634a.d();
            if (!(d11 == null || d11.length() == 0)) {
                x(context);
                jSONObject.put("na", C0634a.d());
            }
            x(context);
            jSONObject.put("m", C0634a.e());
        } catch (Throwable th2) {
            com.tencent.tpns.dataacquisition.b.a.a("getCpuInfo", th2);
        }
        return jSONObject;
    }

    public static String p(Context context) {
        List<Sensor> sensorList;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < sensorList.size(); i11++) {
                sb2.append(sensorList.get(i11).getType());
                if (i11 != sensorList.size() - 1) {
                    sb2.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            return sb2.toString();
        } catch (Throwable th2) {
            com.tencent.tpns.dataacquisition.b.a.a("getAllSensors", th2);
            return "";
        }
    }

    public static JSONArray q(Context context) {
        List<Sensor> sensorList;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.size() <= 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (int i11 = 0; i11 < sensorList.size(); i11++) {
                Sensor sensor = sensorList.get(i11);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", sensor.getName());
                jSONObject.put("vendor", sensor.getVendor());
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        } catch (Throwable th2) {
            com.tencent.tpns.dataacquisition.b.a.a("getSensors:" + th2.toString());
            return null;
        }
    }

    public static boolean r(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable th2) {
            com.tencent.tpns.dataacquisition.b.a.a("Util -> isScreenOn", th2);
            return false;
        }
    }

    public static int s(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            Intent registerReceiver = Build.VERSION.SDK_INT >= 33 ? context.registerReceiver(f49910a, intentFilter, 4) : context.registerReceiver(f49910a, intentFilter);
            int intExtra = registerReceiver.getIntExtra("status", -1);
            if (!(intExtra == 2 || intExtra == 5)) {
                try {
                    context.unregisterReceiver(f49910a);
                } catch (Throwable unused) {
                }
                return -1;
            }
            int intExtra2 = registerReceiver.getIntExtra("plugged", -1);
            try {
                context.unregisterReceiver(f49910a);
            } catch (Throwable unused2) {
            }
            return intExtra2;
        } catch (Throwable unused3) {
        }
        return -1;
    }

    public static String t(Context context) {
        return "";
    }

    public static String u(Context context) {
        return "";
    }

    private static List<String> v(Context context) {
        return new ArrayList();
    }

    private static long w(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    private static synchronized C0634a x(Context context) {
        C0634a aVar;
        synchronized (a.class) {
            if (f49919j == null) {
                f49919j = new C0634a();
            }
            aVar = f49919j;
        }
        return aVar;
    }
}
