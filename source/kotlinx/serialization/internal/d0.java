package kotlinx.serialization.internal;

import kotlinx.serialization.b;

public interface d0<T> extends b<T> {

    public static final class a {
        public static <T> b<?>[] a(d0<T> d0Var) {
            return j1.f57731a;
        }
    }

    b<?>[] childSerializers();

    b<?>[] typeParametersSerializers();
}
