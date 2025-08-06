package com.tencent.android.tpush.stat.b;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.network.pro.core.util.Period;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huochat.community.util.FileTool;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.util.d;
import com.tencent.android.tpush.service.util.g;
import com.tencent.tpns.baseapi.base.util.Util;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.http.HttpHost;
import org.json.JSONArray;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f69962a;

    /* renamed from: b  reason: collision with root package name */
    private static String f69963b;

    /* renamed from: c  reason: collision with root package name */
    private static String f69964c;

    /* renamed from: d  reason: collision with root package name */
    private static Random f69965d;

    /* renamed from: e  reason: collision with root package name */
    private static Map<Long, String> f69966e = new HashMap(10);

    /* renamed from: f  reason: collision with root package name */
    private static String f69967f = "";

    /* renamed from: g  reason: collision with root package name */
    private static c f69968g = null;

    /* renamed from: h  reason: collision with root package name */
    private static String f69969h = null;

    /* renamed from: i  reason: collision with root package name */
    private static long f69970i = -1;

    /* renamed from: j  reason: collision with root package name */
    private static int f69971j = 0;

    /* renamed from: k  reason: collision with root package name */
    private static String f69972k = "__MTA_FIRST_ACTIVATE__";

    /* renamed from: l  reason: collision with root package name */
    private static int f69973l = -1;

    public static String a(Context context, long j11) {
        List<ResolveInfo> a11;
        RegisterEntity registerInfoByPkgName;
        try {
            if (f69966e.containsKey(Long.valueOf(j11))) {
                return f69966e.get(Long.valueOf(j11));
            }
            if (context == null || (a11 = g.a(context)) == null) {
                return "0";
            }
            for (ResolveInfo resolveInfo : a11) {
                String str = resolveInfo.activityInfo.packageName;
                if (str != null && (registerInfoByPkgName = CacheManager.getRegisterInfoByPkgName(str)) != null && registerInfoByPkgName.accessId == j11) {
                    String str2 = registerInfoByPkgName.xgSDKVersion + "";
                    f69966e.put(Long.valueOf(registerInfoByPkgName.accessId), str2);
                    return str2;
                }
            }
            return "0";
        } catch (Throwable th2) {
            f69968g.b(th2);
            return "0";
        }
    }

    public static HttpHost b(Context context) {
        NetworkInfo activeNetworkInfo;
        String defaultHost;
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0 || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
                return null;
            }
            if ((activeNetworkInfo.getTypeName() == null || !activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) && (defaultHost = Proxy.getDefaultHost()) != null && defaultHost.trim().length() > 0) {
                return new HttpHost(defaultHost, Proxy.getDefaultPort());
            }
            return null;
        } catch (Throwable th2) {
            f69968g.b(th2);
        }
    }

    public static String c(Context context) {
        if (c(f69967f)) {
            return f69967f;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f69967f = str;
            if (str == null || str.length() == 0) {
                return "unknown";
            }
        } catch (Throwable th2) {
            f69968g.b(th2);
        }
        return f69967f;
    }

    private static synchronized Random d() {
        Random random;
        synchronized (b.class) {
            if (f69965d == null) {
                f69965d = new Random();
            }
            random = f69965d;
        }
        return random;
    }

    public static boolean e(Context context) {
        if (f69970i < 0) {
            f69970i = d.a(context, "mta.qq.com.checktime", 0);
        }
        return Math.abs(System.currentTimeMillis() - f69970i) > Period.DAY_MILLS;
    }

    public static void f(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        f69970i = currentTimeMillis;
        d.b(context, "mta.qq.com.checktime", currentTimeMillis);
    }

    public static int g(Context context) {
        return d.a(context, "mta.qq.com.difftime", 0);
    }

    public static String h(Context context) {
        if (context == null) {
            return null;
        }
        return context.getClass().getName();
    }

    public static String d(Context context) {
        return Util.getCurProcessName(context);
    }

    public static long c() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + Period.DAY_MILLS;
        } catch (Throwable th2) {
            f69968g.b(th2);
            return System.currentTimeMillis() + Period.DAY_MILLS;
        }
    }

    public static String a(Context context) {
        return "1.4.4.2";
    }

    public static int a() {
        return d().nextInt(Integer.MAX_VALUE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0058 A[SYNTHETIC, Splitter:B:32:0x0058] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:36:0x0062=Splitter:B:36:0x0062, B:18:0x0038=Splitter:B:18:0x0038} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(byte[] r6) {
        /*
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r6)
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream
            r6.<init>()
            r1 = 0
            java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0045 }
            r2.<init>(r0)     // Catch:{ all -> 0x0045 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0043 }
        L_0x0014:
            int r4 = r2.read(r3)     // Catch:{ all -> 0x0043 }
            r5 = -1
            if (r4 == r5) goto L_0x0020
            r5 = 0
            r6.write(r3, r5, r4)     // Catch:{ all -> 0x0043 }
            goto L_0x0014
        L_0x0020:
            byte[] r1 = r6.toByteArray()     // Catch:{ all -> 0x0043 }
            r0.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x002e
        L_0x0028:
            r0 = move-exception
            com.tencent.android.tpush.stat.b.c r3 = f69968g
            r3.b((java.lang.Throwable) r0)
        L_0x002e:
            r2.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x0038
        L_0x0032:
            r0 = move-exception
            com.tencent.android.tpush.stat.b.c r2 = f69968g
            r2.b((java.lang.Throwable) r0)
        L_0x0038:
            r6.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0065
        L_0x003c:
            r6 = move-exception
            com.tencent.android.tpush.stat.b.c r0 = f69968g
            r0.b((java.lang.Throwable) r6)
            goto L_0x0065
        L_0x0043:
            r3 = move-exception
            goto L_0x0047
        L_0x0045:
            r3 = move-exception
            r2 = r1
        L_0x0047:
            com.tencent.android.tpush.stat.b.c r4 = f69968g     // Catch:{ all -> 0x0066 }
            r4.b((java.lang.Throwable) r3)     // Catch:{ all -> 0x0066 }
            r0.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0056
        L_0x0050:
            r0 = move-exception
            com.tencent.android.tpush.stat.b.c r3 = f69968g
            r3.b((java.lang.Throwable) r0)
        L_0x0056:
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0062
        L_0x005c:
            r0 = move-exception
            com.tencent.android.tpush.stat.b.c r2 = f69968g
            r2.b((java.lang.Throwable) r0)
        L_0x0062:
            r6.close()     // Catch:{ IOException -> 0x003c }
        L_0x0065:
            return r1
        L_0x0066:
            r1 = move-exception
            r0.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x0071
        L_0x006b:
            r0 = move-exception
            com.tencent.android.tpush.stat.b.c r3 = f69968g
            r3.b((java.lang.Throwable) r0)
        L_0x0071:
            if (r2 == 0) goto L_0x007d
            r2.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007d
        L_0x0077:
            r0 = move-exception
            com.tencent.android.tpush.stat.b.c r2 = f69968g
            r2.b((java.lang.Throwable) r0)
        L_0x007d:
            r6.close()     // Catch:{ IOException -> 0x0081 }
            goto L_0x0087
        L_0x0081:
            r6 = move-exception
            com.tencent.android.tpush.stat.b.c r0 = f69968g
            r0.b((java.lang.Throwable) r6)
        L_0x0087:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.stat.b.b.a(byte[]):byte[]");
    }

    public static String b(Context context, long j11) {
        return d.a(context).a(j11);
    }

    public static synchronized c b() {
        c cVar;
        synchronized (b.class) {
            if (f69968g == null) {
                c cVar2 = new c("XgStat");
                f69968g = cVar2;
                cVar2.a(true);
            }
            cVar = f69968g;
        }
        return cVar;
    }

    public static boolean c(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static long b(String str) {
        return a(str, InstructionFileId.DOT, 100, 3, 0L).longValue();
    }

    public static String a(String str) {
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
        } catch (Throwable th2) {
            f69968g.b(th2);
            return "0";
        }
    }

    public static Long a(String str, String str2, int i11, int i12, Long l11) {
        if (!(str == null || str2 == null)) {
            if (str2.equalsIgnoreCase(InstructionFileId.DOT) || str2.equalsIgnoreCase(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
                str2 = String.format("\\%s", new Object[]{str2});
            }
            String[] split = str.split(str2);
            if (split.length == i12) {
                try {
                    Long l12 = 0L;
                    for (String valueOf : split) {
                        l12 = Long.valueOf(((long) i11) * (l12.longValue() + Long.valueOf(valueOf).longValue()));
                    }
                    return l12;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return l11;
    }

    public static String a(Context context, String str) {
        if (com.tencent.android.tpush.stat.d.d()) {
            if (f69969h == null) {
                f69969h = d(context);
            }
            if (f69969h != null) {
                str = str + "_" + f69969h;
            }
        }
        return Util.getKey(str);
    }

    public static int a(Context context, boolean z11) {
        if (z11) {
            f69971j = g(context);
        }
        return f69971j;
    }

    public static void a(Context context, int i11) {
        f69971j = i11;
        d.b(context, "mta.qq.com.difftime", i11);
    }

    public static JSONArray a(Throwable th2) {
        JSONArray jSONArray = new JSONArray();
        if (th2 != null) {
            jSONArray.put(th2.toString());
            a(jSONArray, th2.getStackTrace());
        }
        return jSONArray;
    }

    public static JSONArray a(JSONArray jSONArray, StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                jSONArray.put(stackTraceElement.toString());
            }
        }
        return jSONArray;
    }
}
