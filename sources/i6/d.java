package i6;

import android.text.TextUtils;
import android.util.Log;
import com.hbg.lib.common.utils.SystemUtils;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f68162a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f68163b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f68164c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f68165d = false;

    public static String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(f68163b);
        stringBuffer.append(":");
        stringBuffer.append(f68164c);
        stringBuffer.append("]");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static void b(String str) {
        if (k()) {
            h(Thread.currentThread().getStackTrace());
            try {
                Log.d(f68162a, a(str));
            } catch (Throwable unused) {
            }
        }
    }

    public static void c(String str, String str2) {
        if (k() && str2 != null) {
            Log.d(str, str2);
        }
    }

    public static void d(String str) {
        if (k()) {
            h(Thread.currentThread().getStackTrace());
            Log.e(f68162a, a(str));
        }
    }

    public static void e(String str, String str2) {
        if (k() && str2 != null) {
            Log.e(str, str2);
        }
    }

    public static void f(String str, Throwable th2) {
        if (k()) {
            h(Thread.currentThread().getStackTrace());
            try {
                Log.e(f68162a, a(str), th2);
            } catch (Exception unused) {
            }
        }
    }

    public static void g(Throwable th2) {
        if (k()) {
            h(Thread.currentThread().getStackTrace());
            Log.e(f68162a, a(String.format("Exception: %s. Caused by %s. Detail message: %s", new Object[]{th2.toString(), th2.getCause(), th2.getMessage()})));
        }
    }

    public static void h(StackTraceElement[] stackTraceElementArr) {
        f68162a = stackTraceElementArr[3].getFileName();
        f68163b = stackTraceElementArr[3].getMethodName();
        f68164c = stackTraceElementArr[3].getLineNumber();
    }

    public static void i(String str) {
        if (k()) {
            h(Thread.currentThread().getStackTrace());
            Log.i(f68162a, a(str));
        }
    }

    public static void j(String str, String str2) {
        if (k() && str2 != null) {
            Log.i(str, str2);
        }
    }

    public static boolean k() {
        return f68165d;
    }

    public static void l(int i11) {
        StringBuilder sb2 = new StringBuilder();
        int i12 = 3;
        String str = "";
        while (i12 < Thread.currentThread().getStackTrace().length && i12 - 3 <= i11) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[i12];
            sb2.append(stackTraceElement.getFileName() + ":" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber());
            sb2.append("\n");
            if (TextUtils.isEmpty(str)) {
                str = stackTraceElement.getFileName();
            }
            i12++;
        }
        if (SystemUtils.c()) {
            Log.i(str, sb2.toString());
        } else {
            Log.d(str, sb2.toString());
        }
    }

    public static void m(String str, String str2) {
        if (k() && str2 != null) {
            Log.v(str, str2);
        }
    }

    public static void n(String str) {
        if (k()) {
            h(Thread.currentThread().getStackTrace());
            Log.w(f68162a, a(str));
        }
    }

    public static void o(String str, String str2) {
        if (k() && str2 != null) {
            Log.w(str, str2);
        }
    }
}
