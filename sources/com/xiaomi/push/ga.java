package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.huobi.vulcan.model.VulcanInfo;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ag;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ga {

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f51887a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static long f2889a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    private static ag f2890a = new ag(true);

    /* renamed from: a  reason: collision with other field name */
    private static com.xiaomi.push.providers.a f2891a = null;

    /* renamed from: a  reason: collision with other field name */
    private static final Object f2892a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static String f2893a = "";

    /* renamed from: a  reason: collision with other field name */
    private static List<a> f2894a = Collections.synchronizedList(new ArrayList());

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f51889a = -1;

        /* renamed from: a  reason: collision with other field name */
        public long f2895a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f2896a = "";

        /* renamed from: b  reason: collision with root package name */
        public int f51890b = -1;

        /* renamed from: b  reason: collision with other field name */
        public long f2897b = 0;

        /* renamed from: b  reason: collision with other field name */
        public String f2898b = "";

        public a(String str, long j11, int i11, int i12, String str2, long j12) {
            this.f2896a = str;
            this.f2895a = j11;
            this.f51889a = i11;
            this.f51890b = i12;
            this.f2898b = str2;
            this.f2897b = j12;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f2896a, this.f2896a) && TextUtils.equals(aVar.f2898b, this.f2898b) && aVar.f51889a == this.f51889a && aVar.f51890b == this.f51890b && Math.abs(aVar.f2895a - this.f2895a) <= 5000;
        }
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.xiaomi.push.aw] */
    private static int b(Context context) {
        ? a11 = av.a();
        if (a11 == 0) {
            return -1;
        }
        return a11.a();
    }

    /* access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.f3262a) {
                SQLiteDatabase writableDatabase = a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a next : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(Constants.PACKAGE_NAME, next.f2896a);
                        contentValues.put("message_ts", Long.valueOf(next.f2895a));
                        contentValues.put("network_type", Integer.valueOf(next.f51889a));
                        contentValues.put("bytes", Long.valueOf(next.f2897b));
                        contentValues.put("rcv", Integer.valueOf(next.f51890b));
                        contentValues.put(VulcanInfo.IMSI, next.f2898b);
                        writableDatabase.insert("traffic", (String) null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (Throwable th2) {
            b.a(th2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m2719a(Context context) {
        f51887a = b(context);
    }

    public static int a(Context context) {
        if (f51887a == -1) {
            f51887a = b(context);
        }
        return f51887a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static synchronized String m2718a(Context context) {
        synchronized (ga.class) {
            if (TextUtils.isEmpty(f2893a)) {
                return "";
            }
            String str = f2893a;
            return str;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m2720a(String str) {
        synchronized (ga.class) {
            if (!j.d() && !TextUtils.isEmpty(str)) {
                f2893a = str;
            }
        }
    }

    public static void a(Context context, String str, long j11, boolean z11, boolean z12, long j12) {
        a(context, str, a(a(context), j11, z11, j12, z12), z11, j12);
    }

    private static void a(final Context context, String str, long j11, boolean z11, long j12) {
        int a11;
        boolean isEmpty;
        if (context != null && !TextUtils.isEmpty(str) && "com.xiaomi.xmsf".equals(context.getPackageName())) {
            String str2 = str;
            if (!"com.xiaomi.xmsf".equals(str) && -1 != (a11 = a(context))) {
                synchronized (f2892a) {
                    isEmpty = f2894a.isEmpty();
                    a(new a(str, j12, a11, z11 ? 1 : 0, a11 == 0 ? a(context) : "", j11));
                }
                if (isEmpty) {
                    f2890a.a((ag.b) new ag.b() {
                        public void b() {
                            ArrayList arrayList;
                            synchronized (ga.a()) {
                                arrayList = new ArrayList(ga.a());
                                ga.a().clear();
                            }
                            ga.b(context, arrayList);
                        }
                    }, 5000);
                }
            }
        }
    }

    private static long a(int i11, long j11, boolean z11, long j12, boolean z12) {
        if (z11 && z12) {
            long j13 = f2889a;
            f2889a = j12;
            if (j12 - j13 > 30000 && j11 > 1024) {
                return j11 * 2;
            }
        }
        return (j11 * ((long) (i11 == 0 ? 13 : 11))) / 10;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m2717a(Context context) {
        com.xiaomi.push.providers.a aVar = f2891a;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
        f2891a = aVar2;
        return aVar2;
    }

    public static int a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    private static void a(a aVar) {
        for (a next : f2894a) {
            if (next.a(aVar)) {
                next.f2897b += aVar.f2897b;
                return;
            }
        }
        f2894a.add(aVar);
    }
}
