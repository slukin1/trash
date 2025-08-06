package gx;

public abstract class b<T> extends c<T, Integer> {
    public b(String str) {
        super(Integer.class, str);
    }

    /* renamed from: d */
    public final void c(T t11, Integer num) {
        c(t11, Integer.valueOf(num.intValue()));
    }

    public abstract void e(T t11, int i11);
}
