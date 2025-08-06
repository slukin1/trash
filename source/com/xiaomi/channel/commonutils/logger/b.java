package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.xiaomi.push.j;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f51259a = 2;

    /* renamed from: a  reason: collision with other field name */
    private static Context f2404a = null;

    /* renamed from: a  reason: collision with other field name */
    private static LoggerInterface f2405a = new a();

    /* renamed from: a  reason: collision with other field name */
    private static final Integer f2406a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static String f2407a = ("XMPush-" + Process.myPid());

    /* renamed from: a  reason: collision with other field name */
    private static final HashMap<Integer, Long> f2408a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static AtomicInteger f2409a = new AtomicInteger(1);

    /* renamed from: a  reason: collision with other field name */
    private static boolean f2410a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<Integer, String> f51260b = new HashMap<>();

    /* renamed from: b  reason: collision with other field name */
    private static boolean f2411b = false;

    public static class a implements LoggerInterface {

        /* renamed from: a  reason: collision with root package name */
        private String f51261a = b.a();

        public void log(String str) {
            Log.v(this.f51261a, str);
        }

        public void setTag(String str) {
            this.f51261a = str;
        }

        public void log(String str, Throwable th2) {
            Log.v(this.f51261a, str, th2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m2315a() {
        return false;
    }

    public static void b(String str) {
        if (a(0)) {
            a(0, a(str));
        }
    }

    public static void c(String str) {
        if (a(0)) {
            a(1, a(str));
        }
    }

    public static void d(String str) {
        if (a(4)) {
            a(4, a(str));
        }
    }

    public static void e(String str) {
        if (f2410a) {
            a(str);
            return;
        }
        Log.w(f2407a, a(str));
        if (!f2411b) {
            a(str);
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f2405a = loggerInterface;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m2316a(int i11) {
        return i11 >= f51259a || a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public static void m2317b(String str, String str2) {
        if (a(1)) {
            a(1, b(str, str2));
        }
    }

    public static void c(String str, String str2) {
        if (a(4)) {
            a(4, b(str, str2));
        }
    }

    public static void d(String str, String str2) {
        if (f2410a) {
            a(str, str2);
            return;
        }
        Log.w(f2407a, b(str, str2));
        if (!f2411b) {
            a(str, str2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m2312a(String str) {
        if (a(2)) {
            a(2, a(str));
        }
    }

    public static void b(String str, Object... objArr) {
        if (a(1)) {
            a(1, a(str, objArr));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m2313a(String str, String str2) {
        if (a(2)) {
            a(2, b(str, str2));
        }
    }

    private static String b(String str, String str2) {
        return b() + a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m2314a(String str, Object... objArr) {
        if (a(2)) {
            a(2, a(str, objArr));
        }
    }

    private static String b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    public static void a(String str, Throwable th2) {
        if (a(4)) {
            a(4, a(str), th2);
        }
    }

    public static void a(Throwable th2) {
        if (a(4)) {
            a(4, th2);
        }
    }

    public static Integer a(String str) {
        if (f51259a > 1) {
            return f2406a;
        }
        Integer valueOf = Integer.valueOf(f2409a.incrementAndGet());
        f2408a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
        f51260b.put(valueOf, str);
        LoggerInterface loggerInterface = f2405a;
        loggerInterface.log(str + " starts");
        return valueOf;
    }

    public static void a(Integer num) {
        if (f51259a <= 1) {
            HashMap<Integer, Long> hashMap = f2408a;
            if (hashMap.containsKey(num)) {
                long currentTimeMillis = System.currentTimeMillis() - hashMap.remove(num).longValue();
                LoggerInterface loggerInterface = f2405a;
                loggerInterface.log(f51260b.remove(num) + " ends in " + currentTimeMillis + " ms");
            }
        }
    }

    public static void a(int i11, String str) {
        if (i11 >= f51259a) {
            f2405a.log(str);
        } else if (a()) {
            Log.d("MyLog", "-->log(" + i11 + "): " + str);
        }
    }

    public static void a(int i11, Throwable th2) {
        if (i11 >= f51259a) {
            f2405a.log("", th2);
        } else if (a()) {
            Log.w("MyLog", "-->log(" + i11 + "): ", th2);
        }
    }

    public static void a(int i11, String str, Throwable th2) {
        if (i11 >= f51259a) {
            f2405a.log(str, th2);
        } else if (a()) {
            Log.w("MyLog", "-->log(" + i11 + "): " + str, th2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m2311a(String str) {
        return b() + str;
    }

    private static String a(String str, Object... objArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[Tid:");
        sb2.append(Thread.currentThread().getId());
        sb2.append("] ");
        sb2.append("[");
        sb2.append(str);
        sb2.append("] ");
        if (objArr != null && objArr.length > 0) {
            for (Object append : objArr) {
                sb2.append(append);
            }
        }
        return sb2.toString();
    }

    public static String a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    public static void a(int i11) {
        if (i11 < 0 || i11 > 5) {
            a(2, "set log level as " + i11);
        }
        f51259a = i11;
    }

    public static int a() {
        return f51259a;
    }

    public static void a(Context context) {
        f2404a = context;
        if (j.a(context)) {
            f2410a = true;
        }
        if (j.a()) {
            f2411b = true;
        }
    }
}
