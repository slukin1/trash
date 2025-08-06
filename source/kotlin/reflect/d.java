package kotlin.reflect;

public final class d {
    public static final <T> T a(c<T> cVar, Object obj) {
        if (cVar.d(obj)) {
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + cVar.a());
    }
}
