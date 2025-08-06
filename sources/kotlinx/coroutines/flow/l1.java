package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.c;

public final class l1 implements e<Object> {

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f57273b;

    public l1(Throwable th2) {
        this.f57273b = th2;
    }

    public Object emit(Object obj, c<? super Unit> cVar) {
        throw this.f57273b;
    }
}
