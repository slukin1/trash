package androidx.test.internal.util;

import android.os.Looper;
import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.internal.platform.ThreadChecker;
import java.util.List;
import java.util.Objects;

public final class Checks {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadChecker f11606a;

    static {
        Class<ThreadChecker> cls = ThreadChecker.class;
        List<ThreadChecker> a11 = ServiceLoaderWrapper.a(cls);
        if (a11.isEmpty()) {
            f11606a = new ThreadChecker() {
                public void a() {
                    Checks.e(!Thread.currentThread().equals(Looper.getMainLooper().getThread()), "Method cannot be called on the main application thread (on: %s)", Thread.currentThread().getName());
                }
            };
        } else if (a11.size() == 1) {
            f11606a = a11.get(0);
        } else {
            throw new IllegalStateException(String.format("Found more than one %s implementations.", new Object[]{cls.getName()}));
        }
    }

    public static void a() {
        f11606a.a();
    }

    public static <T> T b(T t11) {
        Objects.requireNonNull(t11);
        return t11;
    }

    public static <T> T c(T t11, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void d(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void e(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new IllegalStateException(f(str, objArr));
        }
    }

    public static String f(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i11 = 0;
        int i12 = 0;
        while (i11 < objArr.length && (indexOf = valueOf.indexOf("%s", i12)) != -1) {
            sb2.append(valueOf.substring(i12, indexOf));
            sb2.append(objArr[i11]);
            i12 = indexOf + 2;
            i11++;
        }
        sb2.append(valueOf.substring(i12));
        if (i11 < objArr.length) {
            sb2.append(" [");
            sb2.append(objArr[i11]);
            for (int i13 = i11 + 1; i13 < objArr.length; i13++) {
                sb2.append(", ");
                sb2.append(objArr[i13]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }
}
