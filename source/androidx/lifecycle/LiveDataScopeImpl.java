package androidx.lifecycle;

import android.annotation.SuppressLint;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.g;
import kotlinx.coroutines.v0;

public final class LiveDataScopeImpl<T> implements y<T> {

    /* renamed from: a  reason: collision with root package name */
    public h<T> f9923a;

    /* renamed from: b  reason: collision with root package name */
    public final CoroutineContext f9924b;

    public LiveDataScopeImpl(h<T> hVar, CoroutineContext coroutineContext) {
        this.f9924b = coroutineContext.plus(v0.c().G());
    }

    public final h<T> a() {
        return this.f9923a;
    }

    @SuppressLint({"NullSafeMutableLiveData"})
    public Object emit(T t11, c<? super Unit> cVar) {
        Object g11 = g.g(this.f9924b, new LiveDataScopeImpl$emit$2(this, t11, (c<? super LiveDataScopeImpl$emit$2>) null), cVar);
        return g11 == IntrinsicsKt__IntrinsicsKt.d() ? g11 : Unit.f56620a;
    }
}
