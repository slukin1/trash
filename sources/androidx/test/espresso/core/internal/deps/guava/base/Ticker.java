package androidx.test.espresso.core.internal.deps.guava.base;

public abstract class Ticker {

    /* renamed from: a  reason: collision with root package name */
    public static final Ticker f11170a = new Ticker() {
        public long a() {
            return Platform.c();
        }
    };

    public static Ticker b() {
        return f11170a;
    }

    public abstract long a();
}
