package com.tencent.wxop.stat.b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.appevents.UserDataStore;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.hbg.lib.network.pro.core.util.Period;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huochat.community.util.FileTool;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.tencent.wxop.stat.c;
import com.tencent.wxop.stat.f;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public final class l {
    private static int U = -1;
    private static String W = null;

    /* renamed from: a  reason: collision with root package name */
    private static String f51020a = null;
    private static String aR = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f51021b = null;
    private static int bG = -1;

    /* renamed from: bn  reason: collision with root package name */
    private static volatile int f51022bn = -1;

    /* renamed from: bq  reason: collision with root package name */
    private static String f51023bq = null;

    /* renamed from: br  reason: collision with root package name */
    private static String f51024br = "";

    /* renamed from: bs  reason: collision with root package name */
    private static String f51025bs = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f51026c = null;
    private static String cC = null;
    private static String cE = "";
    private static Random cR = null;
    private static DisplayMetrics cS = null;
    /* access modifiers changed from: private */
    public static b cT = null;
    private static String cU = null;
    private static String cV = null;
    private static long cW = -1;
    private static o cX = null;
    private static String cY = "__MTA_FIRST_ACTIVATE__";
    private static long cZ = -1;

    /* renamed from: da  reason: collision with root package name */
    private static String f51027da = "";

    /* renamed from: w  reason: collision with root package name */
    private static int f51028w;

    public static String A(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            Object obj = applicationInfo.metaData.get("InstallChannel");
            if (obj != null) {
                return obj.toString();
            }
            cT.c("Could not read InstallChannel meta-data from AndroidManifest.xml");
            return null;
        } catch (Throwable unused) {
            cT.d("Could not read InstallChannel meta-data from AndroidManifest.xml");
            return null;
        }
    }

    public static String B(Context context) {
        if (context == null) {
            return null;
        }
        return context.getClass().getName();
    }

    public static String C(Context context) {
        TelephonyManager telephonyManager;
        String str = f51023bq;
        if (str != null) {
            return str;
        }
        try {
            if (r.a(context, "android.permission.READ_PHONE_STATE")) {
                if ((context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0) && (telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE)) != null) {
                    f51023bq = telephonyManager.getSimOperator();
                }
            } else {
                cT.d("Could not get permission of android.permission.READ_PHONE_STATE");
            }
        } catch (Throwable th2) {
            cT.b(th2);
        }
        return f51023bq;
    }

    public static String D(Context context) {
        if (e(f51024br)) {
            return f51024br;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f51024br = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th2) {
            cT.b(th2);
        }
        return f51024br;
    }

    public static String E(Context context) {
        try {
            if (!r.a(context, "android.permission.INTERNET") || !r.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                cT.d("can not get the permission of android.permission.ACCESS_WIFI_STATE");
                return "";
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                String typeName = activeNetworkInfo.getTypeName();
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (typeName != null) {
                    if (typeName.equalsIgnoreCase("WIFI")) {
                        return "WIFI";
                    }
                    if (typeName.equalsIgnoreCase("MOBILE")) {
                        if (extraInfo == null) {
                            return "MOBILE";
                        }
                    } else if (extraInfo == null) {
                        return typeName;
                    }
                    return extraInfo;
                }
            }
            return "";
        } catch (Throwable th2) {
            cT.b(th2);
        }
    }

    public static Integer F(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String G(Context context) {
        if (e(f51025bs)) {
            return f51025bs;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f51025bs = str;
            if (str == null || str.length() == 0) {
                return "unknown";
            }
        } catch (Throwable th2) {
            cT.b(th2);
        }
        return f51025bs;
    }

    public static String H(Context context) {
        String path;
        if (e(cU)) {
            return cU;
        }
        try {
            if (r.a(context, PermissionConfig.WRITE_EXTERNAL_STORAGE)) {
                String externalStorageState = Environment.getExternalStorageState();
                if (!(externalStorageState == null || !externalStorageState.equals("mounted") || (path = Environment.getExternalStorageDirectory().getPath()) == null)) {
                    StatFs statFs = new StatFs(path);
                    String str = String.valueOf((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000000) + "/" + String.valueOf((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000);
                    cU = str;
                    return str;
                }
                return null;
            }
            cT.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th2) {
            cT.b(th2);
        }
    }

    public static String I(Context context) {
        try {
            String str = aR;
            if (str != null) {
                return str;
            }
            int myPid = Process.myPid();
            Iterator<ActivityManager.RunningAppProcessInfo> it2 = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it2.next();
                if (next.pid == myPid) {
                    aR = next.processName;
                    break;
                }
            }
            return aR;
        } catch (Throwable unused) {
        }
    }

    public static String J(Context context) {
        return e(context, a.f50989ct);
    }

    public static synchronized Integer K(Context context) {
        Integer valueOf;
        synchronized (l.class) {
            int i11 = 0;
            if (f51022bn <= 0) {
                f51022bn = q.a(context, "MTA_EVENT_INDEX", 0);
                q.b(context, "MTA_EVENT_INDEX", f51022bn + 1000);
            } else if (f51022bn % 1000 == 0) {
                try {
                    int i12 = f51022bn + 1000;
                    if (f51022bn < 2147383647) {
                        i11 = i12;
                    }
                    q.b(context, "MTA_EVENT_INDEX", i11);
                } catch (Throwable th2) {
                    cT.c(th2);
                }
            }
            int i13 = f51022bn + 1;
            f51022bn = i13;
            valueOf = Integer.valueOf(i13);
        }
        return valueOf;
    }

    public static String L(Context context) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return String.valueOf(memoryInfo.availMem / 1000000) + "/" + String.valueOf(ay() / 1000000);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static String M(Context context) {
        List<Sensor> sensorList;
        if (e(cE)) {
            return cE;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (!(sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null)) {
                StringBuilder sb2 = new StringBuilder(sensorList.size() * 10);
                for (int i11 = 0; i11 < sensorList.size(); i11++) {
                    sb2.append(sensorList.get(i11).getType());
                    if (i11 != sensorList.size() - 1) {
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                cE = sb2.toString();
            }
        } catch (Throwable th2) {
            cT.b(th2);
        }
        return cE;
    }

    public static synchronized int N(Context context) {
        synchronized (l.class) {
            int i11 = U;
            if (i11 != -1) {
                return i11;
            }
            O(context);
            int i12 = U;
            return i12;
        }
    }

    public static void O(Context context) {
        int a11 = q.a(context, cY, 1);
        U = a11;
        if (a11 == 1) {
            q.b(context, cY, 0);
        }
    }

    public static boolean P(Context context) {
        if (cZ < 0) {
            cZ = q.f(context, "mta.qq.com.checktime");
        }
        return Math.abs(System.currentTimeMillis() - cZ) > Period.DAY_MILLS;
    }

    public static void Q(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        cZ = currentTimeMillis;
        q.a(context, "mta.qq.com.checktime", currentTimeMillis);
    }

    public static String R(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        ActivityInfo activityInfo = resolveActivity.activityInfo;
        if (activityInfo != null && !activityInfo.packageName.equals("android")) {
            return resolveActivity.activityInfo.packageName;
        }
        return null;
    }

    public static int a(Context context, boolean z11) {
        if (z11) {
            f51028w = q.a(context, "mta.qq.com.difftime", 0);
        }
        return f51028w;
    }

    private static Long a(String str, String str2, Long l11) {
        if (!(str == null || str2 == null)) {
            if (str2.equalsIgnoreCase(InstructionFileId.DOT) || str2.equalsIgnoreCase(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
                str2 = "\\" + str2;
            }
            String[] split = str.split(str2);
            if (split.length == 3) {
                try {
                    Long l12 = 0L;
                    for (String valueOf : split) {
                        l12 = Long.valueOf((l12.longValue() + Long.valueOf(valueOf).longValue()) * 100);
                    }
                    return l12;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return l11;
    }

    public static void a(Context context, int i11) {
        f51028w = i11;
        q.b(context, "mta.qq.com.difftime", i11);
    }

    public static boolean a(f fVar) {
        if (fVar == null) {
            return false;
        }
        return e(fVar.S());
    }

    public static long ad() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + Period.DAY_MILLS;
        } catch (Throwable th2) {
            cT.b(th2);
            return System.currentTimeMillis() + Period.DAY_MILLS;
        }
    }

    private static synchronized Random at() {
        Random random;
        synchronized (l.class) {
            if (cR == null) {
                cR = new Random();
            }
            random = cR;
        }
        return random;
    }

    public static int au() {
        int i11 = bG;
        if (i11 != -1) {
            return i11;
        }
        try {
            if (p.a()) {
                bG = 1;
            }
        } catch (Throwable th2) {
            cT.b(th2);
        }
        bG = 0;
        return 0;
    }

    public static synchronized b av() {
        b bVar;
        synchronized (l.class) {
            if (cT == null) {
                b bVar2 = new b("MtaSDK");
                cT = bVar2;
                bVar2.ap();
            }
            bVar = cT;
        }
        return bVar;
    }

    public static String aw() {
        Calendar instance = Calendar.getInstance();
        instance.roll(6, 0);
        return new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
    }

    public static String ax() {
        if (e(cC)) {
            return cC;
        }
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = (long) statFs.getBlockSize();
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        String str = String.valueOf((((long) statFs2.getBlockSize()) * ((long) statFs2.getAvailableBlocks())) / 1000000) + "/" + String.valueOf((((long) statFs.getBlockCount()) * blockSize) / 1000000);
        cC = str;
        return str;
    }

    private static long ay() {
        long j11 = cW;
        if (j11 > 0) {
            return j11;
        }
        long j12 = 1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            j12 = (long) (Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024);
            bufferedReader.close();
        } catch (Exception unused) {
        }
        cW = j12;
        return j12;
    }

    public static JSONObject az() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, m.r());
            String ax2 = m.ax();
            if (ax2 != null && ax2.length() > 0) {
                jSONObject.put("na", ax2);
            }
            int aA = m.aA();
            if (aA > 0) {
                jSONObject.put("fx", aA / 1000000);
            }
            int D = m.D();
            if (D > 0) {
                jSONObject.put(UserDataStore.FIRST_NAME, D / 1000000);
            }
        } catch (Throwable th2) {
            Log.w("MtaSDK", "get cpu error", th2);
        }
        return jSONObject;
    }

    public static byte[] b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public static synchronized String c(Context context) {
        synchronized (l.class) {
            String str = f51020a;
            if (str == null || str.trim().length() == 0) {
                String b11 = r.b(context);
                f51020a = b11;
                if (b11 == null || b11.trim().length() == 0) {
                    f51020a = Integer.toString(at().nextInt(Integer.MAX_VALUE));
                }
                String str2 = f51020a;
                return str2;
            }
            String str3 = f51020a;
            return str3;
        }
    }

    public static String d(long j11) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j11));
    }

    public static String e(Context context, String str) {
        if (c.E()) {
            if (aR == null) {
                aR = I(context);
            }
            if (aR != null) {
                return str + "_" + aR;
            }
        }
        return str;
    }

    public static boolean e(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static int r() {
        return at().nextInt(Integer.MAX_VALUE);
    }

    public static String t(String str) {
        if (str == null) {
            return "0";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b11 : digest) {
                byte b12 = b11 & 255;
                if (b12 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(b12));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static long u(String str) {
        return a(str, InstructionFileId.DOT, 0L).longValue();
    }

    public static HttpHost v(Context context) {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0 || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
                return null;
            }
            if ((activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) || (extraInfo = activeNetworkInfo.getExtraInfo()) == null) {
                return null;
            }
            if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap")) {
                if (!extraInfo.equals("uniwap")) {
                    if (extraInfo.equals("ctwap")) {
                        return new HttpHost("10.0.0.200", 80);
                    }
                    String defaultHost = Proxy.getDefaultHost();
                    if (defaultHost != null && defaultHost.trim().length() > 0) {
                        return new HttpHost(defaultHost, Proxy.getDefaultPort());
                    }
                    return null;
                }
            }
            return new HttpHost("10.0.0.172", 80);
        } catch (Throwable th2) {
            cT.b(th2);
        }
    }

    public static synchronized String w(Context context) {
        String str;
        synchronized (l.class) {
            String str2 = f51026c;
            if (str2 == null || str2.trim().length() == 0) {
                f51026c = r.c(context);
            }
            str = f51026c;
        }
        return str;
    }

    public static DisplayMetrics x(Context context) {
        if (cS == null) {
            cS = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(cS);
        }
        return cS;
    }

    public static boolean y(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            if (r.a(context, "android.permission.ACCESS_WIFI_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (!(connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null)) {
                    for (int i11 = 0; i11 < allNetworkInfo.length; i11++) {
                        if (allNetworkInfo[i11].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i11].isConnected()) {
                            return true;
                        }
                    }
                }
                return false;
            }
            cT.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        } catch (Throwable th2) {
            cT.b(th2);
        }
    }

    public static String z(Context context) {
        String str = f51021b;
        if (str != null) {
            return str;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("TA_APPKEY");
            if (string != null) {
                f51021b = string;
                return string;
            }
            cT.b((Object) "Could not read APPKEY meta-data from AndroidManifest.xml");
            return null;
        } catch (Throwable unused) {
            cT.b((Object) "Could not read APPKEY meta-data from AndroidManifest.xml");
            return null;
        }
    }
}
