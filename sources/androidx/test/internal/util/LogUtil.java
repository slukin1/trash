package androidx.test.internal.util;

import android.util.Log;
import androidx.test.internal.util.ProcSummary;

public final class LogUtil {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f11607a;

    public interface Supplier<T> {
        T get();
    }

    public static boolean a(String str, int i11) {
        if (str.length() > 23) {
            str = str.substring(0, 22);
        }
        return Log.isLoggable(str, i11);
    }

    public static final /* synthetic */ String b(String str) {
        String e11 = e();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(e11).length());
        sb2.append(str);
        sb2.append(" in ");
        sb2.append(e11);
        return sb2.toString();
    }

    public static void c(String str, Supplier<String> supplier, Object... objArr) {
        if (a(str, 3)) {
            Log.d(str, String.format(supplier.get(), objArr));
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        c(str, new LogUtil$$Lambda$1(str2), objArr);
    }

    public static final String e() {
        String str;
        String str2 = f11607a;
        if (str2 != null) {
            return str2;
        }
        try {
            str = ProcSummary.c("self").f11613e;
        } catch (ProcSummary.SummaryException unused) {
            str = "unknown";
        }
        return (str.length() <= 64 || !str.contains("-classpath")) ? str : "robolectric";
    }
}
