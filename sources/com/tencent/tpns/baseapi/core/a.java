package com.tencent.tpns.baseapi.core;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.network.pro.core.util.Period;
import com.huochat.community.network.domain.DomainTool;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.PushMd5Pref;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.baseapi.core.c.a;
import java.net.URL;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile long f49830a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f49831b = "";

    /* renamed from: c  reason: collision with root package name */
    private static volatile long f49832c = -1;

    /* renamed from: d  reason: collision with root package name */
    private static String f49833d = null;

    /* renamed from: e  reason: collision with root package name */
    private static String f49834e = null;

    /* renamed from: f  reason: collision with root package name */
    private static String f49835f = null;

    /* renamed from: g  reason: collision with root package name */
    private static String f49836g = null;

    /* renamed from: h  reason: collision with root package name */
    private static String f49837h = null;

    /* renamed from: i  reason: collision with root package name */
    private static String f49838i = null;

    /* renamed from: j  reason: collision with root package name */
    private static String f49839j = null;

    /* renamed from: k  reason: collision with root package name */
    private static int f49840k = -1;

    public static synchronized long a(Context context) {
        Object metaData;
        synchronized (a.class) {
            if (context == null) {
                long j11 = f49830a;
                return j11;
            } else if (f49830a != -1) {
                long j12 = f49830a;
                return j12;
            } else {
                f49830a = PushPreferences.getLong(context, XGPushConfig.TPUSH_ACCESS_ID, -1);
                if (f49830a == -1 && (metaData = CommonHelper.getMetaData(context, XGPushConfig.TPUSH_ACCESS_ID, (Object) null)) != null) {
                    try {
                        f49830a = Long.valueOf(metaData.toString()).longValue();
                    } catch (Throwable th2) {
                        Logger.w("XGApiConfigImpl", "get accessId from getMetaData failed: ", th2);
                        f49830a = -1;
                    }
                }
                if (f49830a == -1) {
                    Logger.e("XGApiConfigImpl", "accessId没有初始化");
                }
                long j13 = f49830a;
                return j13;
            }
        }
    }

    public static synchronized String b(Context context) {
        Object metaData;
        synchronized (a.class) {
            if (!Util.isNullOrEmptyString(f49831b)) {
                String str = f49831b;
                return str;
            }
            f49831b = PushPreferences.getString(context, XGPushConfig.TPUSH_ACCESS_KEY, (String) null);
            if (Util.isNullOrEmptyString(f49831b) && (metaData = CommonHelper.getMetaData(context, XGPushConfig.TPUSH_ACCESS_KEY, (Object) null)) != null) {
                f49831b = metaData.toString();
            }
            if (Util.isNullOrEmptyString(f49831b)) {
                Logger.e("XGApiConfigImpl", "accessKey is null");
            }
            String str2 = f49831b;
            return str2;
        }
    }

    public static String c(Context context) {
        Object metaData;
        Object metaData2;
        if (TextUtils.isEmpty(f49833d)) {
            f49833d = PushPreferences.getString(context, "XG_SERVER_SUFFIX", (String) null);
        }
        if (TextUtils.isEmpty(f49833d) && (metaData2 = CommonHelper.getMetaData(context, "XG_SERVER_SUFFIX", (Object) null)) != null) {
            f49833d = metaData2.toString();
        }
        if (TextUtils.isEmpty(f49833d)) {
            try {
                String string = PushPreferences.getString(context, "XG_GUID_SERVER", (String) null);
                if (TextUtils.isEmpty(string) && (metaData = CommonHelper.getMetaData(context, "XG_GUID_SERVER", (Object) null)) != null) {
                    string = metaData.toString();
                }
                if (!TextUtils.isEmpty(string)) {
                    a.C0632a aVar = a.C0632a.CLUSTER_SGP;
                    if (string.contains(aVar.a())) {
                        f49833d = aVar.b();
                    } else {
                        a.C0632a aVar2 = a.C0632a.CLUSTER_HK;
                        if (string.contains(aVar2.a())) {
                            f49833d = aVar2.b();
                        } else {
                            Logger.w("XGApiConfigImpl", "unexpected serverSuffix from old version config: " + string);
                        }
                    }
                }
            } catch (Throwable th2) {
                Logger.w("XGApiConfigImpl", "getServerSuffix from old version config error: " + th2.toString());
            }
        }
        if (TextUtils.isEmpty(f49833d)) {
            f49833d = "tpns.tencent.com";
        }
        return f49833d;
    }

    public static String d(Context context) {
        String str;
        String guid = CloudManager.getInstance(context).getGuid();
        if (!TextUtils.isEmpty(guid)) {
            str = "https://guid." + guid + "/guid/v4/register_device";
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = PushPreferences.getString(context, "XG_GUID_SERVER", (String) null);
            if (!TextUtils.isEmpty(str)) {
                try {
                    URL url = new URL(str);
                    if (!TextUtils.isEmpty(url.getHost())) {
                        str = DomainTool.DOMAIN_PREFIX + url.getHost() + "/guid/v4/register_device";
                    }
                } catch (Throwable unused) {
                    str = null;
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = "https://guid." + c(context) + "/guid/v4/register_device";
        }
        return TextUtils.isEmpty(str) ? "https://api.tpns.tencent.com/guid/v4/register_device" : str;
    }

    public static String e(Context context) {
        if (TextUtils.isEmpty(f49834e)) {
            String stat = CloudManager.getInstance(context).getStat();
            if (!TextUtils.isEmpty(stat)) {
                f49834e = "https://stat." + stat + "/log/v4/statistics/push";
            }
        }
        if (TextUtils.isEmpty(f49834e)) {
            f49834e = PushPreferences.getString(context, "XG_STAT_SERVER", (String) null);
        }
        if (TextUtils.isEmpty(f49834e)) {
            String c11 = c(context);
            f49834e = "https://stat." + c11 + "/log/v4/statistics/push";
        }
        if (TextUtils.isEmpty(f49834e)) {
            f49834e = "https://stat.api.tpns.tencent.com/log/v4/statistics/push";
        }
        return f49834e;
    }

    public static String f(Context context) {
        if (TextUtils.isEmpty(f49835f)) {
            String stat = CloudManager.getInstance(context).getStat();
            if (!TextUtils.isEmpty(stat)) {
                f49835f = "https://log." + stat + "/log/v4/statistics/push";
            }
        }
        if (TextUtils.isEmpty(f49835f)) {
            f49835f = PushPreferences.getString(context, "XG_ERRCODE_SERVER", (String) null);
        }
        if (TextUtils.isEmpty(f49835f)) {
            String c11 = c(context);
            f49835f = "https://log." + c11 + "/log/v4/statistics/push";
        }
        if (TextUtils.isEmpty(f49835f)) {
            f49835f = "https://log.tpns.tencent.com/log/v4/statistics/push";
        }
        return f49835f;
    }

    public static String g(Context context) {
        if (TextUtils.isEmpty(f49836g)) {
            String custom = CloudManager.getInstance(context).getCustom();
            if (!TextUtils.isEmpty(custom)) {
                f49836g = "https://log." + custom + "/log/v4/statistics/push";
            }
        }
        if (TextUtils.isEmpty(f49836g)) {
            f49836g = PushPreferences.getString(context, "XG_CUSTOMEVEN_SERVER", (String) null);
        }
        if (TextUtils.isEmpty(f49836g)) {
            String c11 = c(context);
            f49836g = "https://log." + c11 + "/log/v4/statistics/push";
        }
        if (TextUtils.isEmpty(f49836g)) {
            f49836g = "https://stat.api.tpns.tencent.com/log/v4/statistics/push";
        }
        return f49836g;
    }

    public static String h(Context context) {
        if (TextUtils.isEmpty(f49837h)) {
            String log = CloudManager.getInstance(context).getLog();
            if (!TextUtils.isEmpty(log)) {
                f49837h = "https://stat." + log + "/v3/mobile/log/upload";
            }
        }
        if (TextUtils.isEmpty(f49837h)) {
            String c11 = c(context);
            f49837h = "https://stat." + c11 + "/v3/mobile/log/upload";
        }
        if (TextUtils.isEmpty(f49837h)) {
            f49837h = "https://stat.api.tpns.tencent.com/v3/mobile/log/upload";
        }
        return f49837h;
    }

    public static String i(Context context) {
        if (TextUtils.isEmpty(f49838i)) {
            String c11 = c(context);
            f49838i = "https://log." + c11 + "/device/v4/get_offline_msg";
        }
        return f49838i;
    }

    public static String j(Context context) {
        String str;
        if (TextUtils.isEmpty(f49839j)) {
            String guid = CloudManager.getInstance(context).getGuid();
            if (!TextUtils.isEmpty(guid)) {
                str = "https://guid." + guid + "/device/v4/account/batch_operate";
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                str = PushPreferences.getString(context, "XG_GUID_SERVER", (String) null);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        URL url = new URL(str);
                        if (!TextUtils.isEmpty(url.getHost())) {
                            str = DomainTool.DOMAIN_PREFIX + url.getHost() + "/guid/v4/register_device";
                        }
                    } catch (Throwable unused) {
                        str = null;
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = "https://guid." + c(context) + "/device/v4/account/batch_operate";
            }
            if (Util.isNullOrEmptyString(str)) {
                str = "https://api.tpns.tencent.com/device/v4/account/batch_operate";
            }
            f49839j = str;
        }
        return f49839j;
    }

    public static boolean k(Context context) {
        try {
            return PushPreferences.getBoolean(context, "IS_POWER_SAVE_MODE", false);
        } catch (Throwable th2) {
            Logger.w("XGApiConfigImpl", "isPowerSaveMode Throwable: " + th2);
            return false;
        }
    }

    public static synchronized long l(Context context) {
        Object metaData;
        synchronized (a.class) {
            if (context == null) {
                long j11 = f49832c;
                return j11;
            } else if (f49832c != -1) {
                long j12 = f49832c;
                return j12;
            } else {
                if (f49832c == -1 && (metaData = CommonHelper.getMetaData(context, "XG_OLD_ACCESS_ID", (Object) null)) != null) {
                    try {
                        f49832c = Long.valueOf(metaData.toString().replace("L", "")).longValue();
                    } catch (Throwable th2) {
                        Logger.w("XGApiConfigImpl", "get freeVersionAccessId from getMetaData failed: ", th2);
                        f49832c = -1;
                    }
                }
                if (f49832c == -1) {
                    Logger.d("XGApiConfigImpl", "Not set freeVersionAccessId");
                }
                long j13 = f49832c;
                return j13;
            }
        }
    }

    public static boolean m(Context context) {
        if (context == null) {
            return true;
        }
        try {
            int i11 = PushMd5Pref.getInt(context, context.getPackageName() + ".enableService", f49840k);
            f49840k = i11;
            if (i11 == 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            Logger.w("XGApiConfigImpl", "unexpected for isEnableService");
            return true;
        }
    }

    public static void n(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            PushPreferences.putBoolean(context, "IS_REGISTERED", true);
            PushPreferences.putLong(context, "REGISTERED_TIME", currentTimeMillis);
        } catch (Throwable th2) {
            Logger.w("XGApiConfigImpl", "unexpected for setRegisterSuccess: " + th2.getMessage());
        }
    }

    public static void o(Context context) {
        try {
            PushPreferences.putBoolean(context, "IS_REGISTERED", false);
            PushPreferences.putLong(context, "REGISTERED_TIME", 0);
        } catch (Throwable th2) {
            Logger.w("XGApiConfigImpl", "unexpected for clearRegistered: " + th2.getMessage());
        }
    }

    public static boolean p(Context context) {
        if (q(context)) {
            return false;
        }
        try {
            return PushPreferences.getBoolean(context, "IS_REGISTERED", false);
        } catch (Throwable th2) {
            Logger.w("XGApiConfigImpl", "unexpected for isRegistered: " + th2.getMessage());
            return false;
        }
    }

    private static boolean q(Context context) {
        try {
            if (System.currentTimeMillis() - PushPreferences.getLong(context, "REGISTERED_TIME", 0) > Period.MIN60_MILLS) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            Logger.w("XGApiConfigImpl", "unexpected for isRegisterExpire: " + th2.getMessage());
            return true;
        }
    }

    public static void b(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(c(context))) {
            PushPreferences.putLong(context, "XG_GUID_LAST_REFRESH_TIME", 0);
            Logger.w("XGApiConfigImpl", "refresh Token");
            f49833d = str;
            f49834e = null;
            f49835f = null;
            f49837h = null;
            f49838i = null;
            PushPreferences.putString(context, "XG_SERVER_SUFFIX", str);
        }
    }

    public static synchronized void a(final Context context, final long j11) {
        synchronized (a.class) {
            if (context == null) {
                Logger.e("XGApiConfigImpl", "null  context");
                return;
            }
            if (j11 != a(context)) {
                GuidInfoManager.clearGuidInfo(context);
            }
            f49830a = j11;
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    PushPreferences.putLong(context, XGPushConfig.TPUSH_ACCESS_ID, j11);
                }
            });
        }
    }

    public static void e(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(f(context))) {
            f49835f = str;
            PushPreferences.putString(context, "XG_ERRCODE_SERVER", str);
        }
    }

    public static void f(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(g(context))) {
            f49836g = str;
            PushPreferences.putString(context, "XG_CUSTOMEVEN_SERVER", str);
        }
    }

    public static void g(Context context, String str) {
        PushPreferences.putString(context, "XG_GUID_SERVER", str);
    }

    public static void d(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(e(context))) {
            f49834e = str;
            PushPreferences.putString(context, "XG_STAT_SERVER", str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(final android.content.Context r3, final java.lang.String r4) {
        /*
            java.lang.Class<com.tencent.tpns.baseapi.core.a> r0 = com.tencent.tpns.baseapi.core.a.class
            monitor-enter(r0)
            if (r3 == 0) goto L_0x001c
            if (r4 != 0) goto L_0x0008
            goto L_0x001c
        L_0x0008:
            java.lang.String r1 = f49831b     // Catch:{ all -> 0x0025 }
            if (r1 == r4) goto L_0x001a
            f49831b = r4     // Catch:{ all -> 0x0025 }
            com.tencent.tpns.baseapi.base.util.CommonWorkingThread r1 = com.tencent.tpns.baseapi.base.util.CommonWorkingThread.getInstance()     // Catch:{ all -> 0x0025 }
            com.tencent.tpns.baseapi.core.a$2 r2 = new com.tencent.tpns.baseapi.core.a$2     // Catch:{ all -> 0x0025 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0025 }
            r1.execute(r2)     // Catch:{ all -> 0x0025 }
        L_0x001a:
            monitor-exit(r0)
            return
        L_0x001c:
            java.lang.String r3 = "XGApiConfigImpl"
            java.lang.String r4 = "null context or null accessKey"
            com.tencent.tpns.baseapi.base.util.Logger.e(r3, r4)     // Catch:{ all -> 0x0025 }
            monitor-exit(r0)
            return
        L_0x0025:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.core.a.a(android.content.Context, java.lang.String):void");
    }

    public static void c(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            String d11 = d(context);
            if (d11 != null && !d11.equals(str)) {
                PushPreferences.putLong(context, "XG_GUID_LAST_REFRESH_TIME", 0);
                Logger.w("XGApiConfigImpl", "refresh Token");
            }
            PushPreferences.putString(context, "XG_GUID_SERVER", str);
        }
    }

    public static void a(Context context, boolean z11) {
        try {
            PushPreferences.putBoolean(context, "IS_POWER_SAVE_MODE", z11);
        } catch (Throwable th2) {
            Logger.w("XGApiConfigImpl", "setPowerSaveMode Throwable: " + th2);
        }
    }
}
