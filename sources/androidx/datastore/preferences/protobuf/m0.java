package androidx.datastore.preferences.protobuf;

public final class m0 {

    /* renamed from: a  reason: collision with root package name */
    public static final k0 f9185a = c();

    /* renamed from: b  reason: collision with root package name */
    public static final k0 f9186b = new l0();

    public static k0 a() {
        return f9185a;
    }

    public static k0 b() {
        return f9186b;
    }

    public static k0 c() {
        try {
            return (k0) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
