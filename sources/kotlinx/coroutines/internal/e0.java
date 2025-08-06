package kotlinx.coroutines.internal;

public final /* synthetic */ class e0 {

    /* renamed from: a  reason: collision with root package name */
    public static final int f57306a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f57306a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
