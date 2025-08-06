package vz;

public final class a {
    public static void a(String str) {
        throw new IllegalArgumentException(str);
    }

    public static void b(boolean z11) {
        if (z11) {
            throw new IllegalArgumentException("Must be false");
        }
    }

    public static void c(boolean z11, String str) {
        if (z11) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void d(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException("Must be true");
        }
    }

    public static void e(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String must not be empty");
        }
    }

    public static void f(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object must not be null");
        }
    }
}
