package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.coroutines.flow.e;

public final class m<T> implements e<T> {

    /* renamed from: b  reason: collision with root package name */
    public final kotlinx.coroutines.channels.m<T> f57268b;

    public m(kotlinx.coroutines.channels.m<? super T> mVar) {
        this.f57268b = mVar;
    }

    public Object emit(T t11, c<? super Unit> cVar) {
        Object send = this.f57268b.send(t11, cVar);
        return send == IntrinsicsKt__IntrinsicsKt.d() ? send : Unit.f56620a;
    }
}
