package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

@Deprecated
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static long f8414a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f8415b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f8416c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f8417d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f8418e;

    public static class a {
        public static void a(String str) {
            Trace.beginSection(str);
        }

        public static void b() {
            Trace.endSection();
        }
    }

    static {
        Class<String> cls = String.class;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 18 && i11 < 29) {
            try {
                f8414a = Trace.class.getField("TRACE_TAG_APP").getLong((Object) null);
                Class cls2 = Long.TYPE;
                f8415b = Trace.class.getMethod("isTagEnabled", new Class[]{cls2});
                Class cls3 = Integer.TYPE;
                f8416c = Trace.class.getMethod("asyncTraceBegin", new Class[]{cls2, cls, cls3});
                f8417d = Trace.class.getMethod("asyncTraceEnd", new Class[]{cls2, cls, cls3});
                f8418e = Trace.class.getMethod("traceCounter", new Class[]{cls2, cls, cls3});
            } catch (Exception e11) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e11);
            }
        }
    }

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            a.a(str);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            a.b();
        }
    }
}
