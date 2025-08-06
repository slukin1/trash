package lu;

import android.util.Log;
import com.huobi.vulcan.utils.ExceptionLogUtil;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f22945a = false;

    public static String a() {
        return Thread.currentThread().toString() + ":" + Thread.currentThread().getId() + ":\t";
    }

    public static void b(String str, String str2) {
        if (f22945a) {
            Log.d(str, "\tzp:::" + a() + str2);
        }
    }

    public static void c(String str, String str2) {
        ExceptionLogUtil.a("10001", str2);
        if (f22945a) {
            Log.e(str, "\tzp:::" + a() + str2);
        }
    }

    public static void d(String str, String str2, Throwable th2) {
        ExceptionLogUtil.a("10001", str2);
        if (f22945a) {
            Log.e(str, "\tzp:::" + a() + str2, th2);
        }
    }

    public static boolean e() {
        return f22945a;
    }

    public static void f(String str, String str2) {
        if (f22945a) {
            Log.i(str, "\tzp:::" + a() + str2);
        }
    }

    public static void g(boolean z11) {
        f22945a = z11;
    }
}
