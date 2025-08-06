package gx;

public abstract class a<T> extends c<T, Float> {
    public a(String str) {
        super(Float.class, str);
    }

    /* renamed from: d */
    public final void c(T t11, Float f11) {
        e(t11, f11.floatValue());
    }

    public abstract void e(T t11, float f11);
}
