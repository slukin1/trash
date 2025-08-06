package androidx.datastore.preferences.protobuf;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f9177a = c();

    public static l a() {
        if (f9177a != null) {
            try {
                return b("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return l.f9181e;
    }

    public static final l b(String str) throws Exception {
        return (l) f9177a.getDeclaredMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }

    public static Class<?> c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
