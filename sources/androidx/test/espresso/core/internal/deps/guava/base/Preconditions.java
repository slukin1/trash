package androidx.test.espresso.core.internal.deps.guava.base;

import java.util.Objects;

public final class Preconditions {
    public static String a(int i11, int i12, String str) {
        if (i11 < 0) {
            return Strings.a("%s (%s) must not be negative", str, Integer.valueOf(i11));
        } else if (i12 >= 0) {
            return Strings.a("%s (%s) must be less than size (%s)", str, Integer.valueOf(i11), Integer.valueOf(i12));
        } else {
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("negative size: ");
            sb2.append(i12);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public static String b(int i11, int i12, String str) {
        if (i11 < 0) {
            return Strings.a("%s (%s) must not be negative", str, Integer.valueOf(i11));
        } else if (i12 >= 0) {
            return Strings.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i11), Integer.valueOf(i12));
        } else {
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("negative size: ");
            sb2.append(i12);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public static String c(int i11, int i12, int i13) {
        if (i11 < 0 || i11 > i13) {
            return b(i11, i13, "start index");
        }
        if (i12 < 0 || i12 > i13) {
            return b(i12, i13, "end index");
        }
        return Strings.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i12), Integer.valueOf(i11));
    }

    public static void d(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z11, String str, long j11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.a(str, Long.valueOf(j11), obj));
        }
    }

    public static int g(int i11, int i12) {
        return h(i11, i12, "index");
    }

    public static int h(int i11, int i12, String str) {
        if (i11 >= 0 && i11 < i12) {
            return i11;
        }
        throw new IndexOutOfBoundsException(a(i11, i12, str));
    }

    public static <T> T i(T t11) {
        Objects.requireNonNull(t11);
        return t11;
    }

    public static <T> T j(T t11, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T k(T t11, String str, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.a(str, obj));
    }

    public static int l(int i11, int i12) {
        return m(i11, i12, "index");
    }

    public static int m(int i11, int i12, String str) {
        if (i11 >= 0 && i11 <= i12) {
            return i11;
        }
        throw new IndexOutOfBoundsException(b(i11, i12, str));
    }

    public static void n(int i11, int i12, int i13) {
        if (i11 < 0 || i12 < i11 || i12 > i13) {
            throw new IndexOutOfBoundsException(c(i11, i12, i13));
        }
    }

    public static void o(boolean z11) {
        if (!z11) {
            throw new IllegalStateException();
        }
    }

    public static void p(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void q(boolean z11, String str, int i11) {
        if (!z11) {
            throw new IllegalStateException(Strings.a(str, Integer.valueOf(i11)));
        }
    }

    public static void r(boolean z11, String str, long j11) {
        if (!z11) {
            throw new IllegalStateException(Strings.a(str, Long.valueOf(j11)));
        }
    }

    public static void s(boolean z11, String str, Object obj) {
        if (!z11) {
            throw new IllegalStateException(Strings.a(str, obj));
        }
    }
}
