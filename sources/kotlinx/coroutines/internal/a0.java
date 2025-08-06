package kotlinx.coroutines.internal;

import kotlinx.coroutines.internal.z;

public final class a0<S extends z<S>> {
    public static <S extends z<S>> Object a(Object obj) {
        return obj;
    }

    public static final S b(Object obj) {
        if (obj != d.f57303a) {
            return (z) obj;
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static final boolean c(Object obj) {
        return obj == d.f57303a;
    }
}
