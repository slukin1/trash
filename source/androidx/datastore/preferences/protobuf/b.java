package androidx.datastore.preferences.protobuf;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f9056a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f9057b = (a("org.robolectric.Robolectric") != null);

    public static <T> Class<T> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> b() {
        return f9056a;
    }

    public static boolean c() {
        return f9056a != null && !f9057b;
    }
}
