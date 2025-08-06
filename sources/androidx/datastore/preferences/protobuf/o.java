package androidx.datastore.preferences.protobuf;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final m<?> f9188a = new n();

    /* renamed from: b  reason: collision with root package name */
    public static final m<?> f9189b = c();

    public static m<?> a() {
        m<?> mVar = f9189b;
        if (mVar != null) {
            return mVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static m<?> b() {
        return f9188a;
    }

    public static m<?> c() {
        try {
            return (m) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
