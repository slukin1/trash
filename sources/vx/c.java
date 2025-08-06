package vx;

import android.util.Log;
import com.nostra13.universalimageloader.core.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f29374a = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f29375b = true;

    public static void a(String str, Object... objArr) {
        if (f29374a) {
            e(3, (Throwable) null, str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        e(6, (Throwable) null, str, objArr);
    }

    public static void c(Throwable th2) {
        e(6, th2, (String) null, new Object[0]);
    }

    public static void d(String str, Object... objArr) {
        e(4, (Throwable) null, str, objArr);
    }

    public static void e(int i11, Throwable th2, String str, Object... objArr) {
        if (f29375b) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th2 != null) {
                if (str == null) {
                    str = th2.getMessage();
                }
                str = String.format("%1$s\n%2$s", new Object[]{str, Log.getStackTraceString(th2)});
            }
            Log.println(i11, b.f28375d, str);
        }
    }

    public static void f(String str, Object... objArr) {
        e(5, (Throwable) null, str, objArr);
    }

    public static void g(boolean z11) {
        f29374a = z11;
    }
}
