package androidx.datastore.preferences.protobuf;

public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a0 f9069a = c();

    /* renamed from: b  reason: collision with root package name */
    public static final a0 f9070b = new b0();

    public static a0 a() {
        return f9069a;
    }

    public static a0 b() {
        return f9070b;
    }

    public static a0 c() {
        try {
            return (a0) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
