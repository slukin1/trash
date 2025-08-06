package kotlin.coroutines;

import d10.p;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;

public final class EmptyCoroutineContext implements CoroutineContext, Serializable {
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    public <R> R fold(R r11, p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return r11;
    }

    public <E extends CoroutineContext.a> E get(CoroutineContext.b<E> bVar) {
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public CoroutineContext minusKey(CoroutineContext.b<?> bVar) {
        return this;
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return coroutineContext;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
