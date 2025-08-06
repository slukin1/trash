package com.mob.tools.log;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.mob.commons.q;
import com.mob.commons.s;
import com.mob.tools.proguard.ClassKeeper;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NLog implements ClassKeeper, PublicMemberKeeper {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, NLog> f27901a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, String> f27902b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private String f27903c;

    /* renamed from: d  reason: collision with root package name */
    private int f27904d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27905e;

    public NLog() {
        this.f27905e = false;
        this.f27903c = null;
        this.f27904d = -1;
    }

    private String a(Throwable th2) {
        try {
            return Log.getStackTraceString(th2);
        } catch (Throwable th3) {
            if (th3 instanceof OutOfMemoryError) {
                return s.a("023-ej8fi-el1idc1ehfcdjPdcfPelYiUdjdi2eKejifdkdkdf");
            }
            return th3.getMessage();
        }
    }

    private String b(Throwable th2) {
        try {
            String name = th2.getClass().getName();
            String c11 = c(th2);
            String str = "";
            if (th2.getStackTrace().length > 0) {
                str = th2.getStackTrace()[0].toString();
            }
            Throwable th3 = th2;
            while (th3 != null && th3.getCause() != null) {
                th3 = th3.getCause();
            }
            if (th3 == null || th3 == th2) {
                return a(th2);
            }
            return name + ":" + c11 + "\n" + str + "\n......" + "\nCaused by:\n" + a(th3);
        } catch (Throwable unused) {
            return a(th2);
        }
    }

    private static String c(Throwable th2) {
        String message = th2.getMessage();
        if (TextUtils.isEmpty(message)) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, cut!]";
    }

    public static NLog getInstance(String str, int i11, String str2) {
        NLog nLog;
        HashMap<String, NLog> hashMap = f27901a;
        synchronized (hashMap) {
            nLog = hashMap.get(str);
            if (nLog == null) {
                nLog = new NLog(str, i11);
                f27902b.put(str, str2);
                hashMap.put(str, nLog);
            }
        }
        return nLog;
    }

    public static NLog getInstanceForSDK(String str, boolean z11) {
        return getInstance(str);
    }

    public static void setCollector(String str, LogCollector logCollector) {
        getInstance(str).setCollector(logCollector);
    }

    public final void crash(Throwable th2) {
        a(6, 1, b(th2));
    }

    public final int d(Throwable th2) {
        return log(3, th2);
    }

    public final void dg() {
        this.f27905e = true;
    }

    public final int e(Throwable th2) {
        return log(6, th2);
    }

    public final void error(Throwable th2) {
        error(a(th2));
    }

    public final int i(Throwable th2) {
        return log(4, th2);
    }

    public final int log(int i11, Throwable th2) {
        return a(i11, 0, a(th2));
    }

    public NLog setCollector(LogCollector logCollector) {
        return this;
    }

    public final int v(Throwable th2) {
        return log(2, th2);
    }

    public final int w(Throwable th2) {
        return log(5, th2);
    }

    public final int d(Object obj, Object... objArr) {
        return log(3, obj, objArr);
    }

    public final int e(Throwable th2, Object obj, Object... objArr) {
        return log(6, th2, obj, objArr);
    }

    public final void error(String str) {
        e(str);
    }

    public final int i(Throwable th2, Object obj, Object... objArr) {
        return log(4, th2, obj, objArr);
    }

    public final int log(int i11, Object obj, Object... objArr) {
        String obj2 = obj.toString();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return a(i11, 0, obj2);
    }

    public final int v(Object obj, Object... objArr) {
        return log(2, obj, objArr);
    }

    public final int w(Object obj, Object... objArr) {
        return log(5, obj, objArr);
    }

    public final int d(Throwable th2, Object obj, Object... objArr) {
        return log(3, th2, obj, objArr);
    }

    public final int e(Object obj, Object... objArr) {
        return log(6, obj, objArr);
    }

    public final int i(Object obj, Object... objArr) {
        return log(4, obj, objArr);
    }

    public final int v(Throwable th2, Object obj, Object... objArr) {
        return log(2, th2, obj, objArr);
    }

    public final int w(Throwable th2, Object obj, Object... objArr) {
        return log(5, th2, obj, objArr);
    }

    public final int e(String str) {
        return log(6, str, new Object[0]);
    }

    public final int i(String str) {
        return log(4, str, new Object[0]);
    }

    public final int w(String str) {
        return log(5, str, new Object[0]);
    }

    private NLog(String str, int i11) {
        this.f27905e = false;
        this.f27903c = str;
        this.f27904d = i11;
    }

    private int a(int i11, int i12, String str) {
        try {
            String str2 = Process.myPid() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Process.myTid() + "(" + Thread.currentThread().getName() + ") " + str;
            if (i12 == 1) {
                String str3 = this.f27903c;
                int i13 = this.f27904d;
                HashMap<String, String> hashMap = f27902b;
                if (!hashMap.isEmpty()) {
                    NLog nLog = null;
                    Iterator<Map.Entry<String, String>> it2 = hashMap.entrySet().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Map.Entry next = it2.next();
                        if (next.getValue() != null && str.contains((CharSequence) next.getValue())) {
                            nLog = f27901a.get(next.getKey());
                            break;
                        }
                    }
                    if (nLog != null) {
                        str3 = nLog.f27903c;
                        i13 = nLog.f27904d;
                    }
                }
                q.a().a(1, str3, i13, str2);
            }
            q.a().a(i11, str2);
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final int log(int i11, Throwable th2, Object obj, Object... objArr) {
        String obj2 = obj.toString();
        StringBuilder sb2 = new StringBuilder();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        sb2.append(obj2);
        sb2.append(10);
        sb2.append(a(th2));
        return a(i11, 0, sb2.toString());
    }

    @Deprecated
    public static NLog getInstance(String str) {
        NLog nLog;
        HashMap<String, NLog> hashMap = f27901a;
        synchronized (hashMap) {
            nLog = hashMap.get(str);
            if (nLog == null) {
                nLog = new NLog(str, -1);
                f27902b.put(str, (Object) null);
                hashMap.put(str, nLog);
            }
        }
        return nLog;
    }
}
