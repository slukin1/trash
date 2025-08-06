package kotlin.sequences;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.c;

public abstract class SequenceScope<T> {
    public abstract Object b(T t11, c<? super Unit> cVar);

    public abstract Object d(Iterator<? extends T> it2, c<? super Unit> cVar);

    public final Object f(g<? extends T> gVar, c<? super Unit> cVar) {
        Object d11 = d(gVar.iterator(), cVar);
        return d11 == IntrinsicsKt__IntrinsicsKt.d() ? d11 : Unit.f56620a;
    }
}
