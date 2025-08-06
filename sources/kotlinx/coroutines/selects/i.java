package kotlinx.coroutines.selects;

import d10.l;
import d10.q;
import kotlin.Unit;
import kotlin.jvm.internal.r;

public final class i<P, Q> implements h<P, Q> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f57533a;

    /* renamed from: b  reason: collision with root package name */
    public final q<Object, k<?>, Object, Unit> f57534b;

    /* renamed from: c  reason: collision with root package name */
    public final q<Object, Object, Object, Object> f57535c;

    /* renamed from: d  reason: collision with root package name */
    public final q<k<?>, Object, Object, l<Throwable, Unit>> f57536d;

    public i(Object obj, q<Object, ? super k<?>, Object, Unit> qVar, q<Object, Object, Object, ? extends Object> qVar2, q<? super k<?>, Object, Object, ? extends l<? super Throwable, Unit>> qVar3) {
        this.f57533a = obj;
        this.f57534b = qVar;
        this.f57535c = qVar2;
        this.f57536d = qVar3;
    }

    public q<Object, Object, Object, Object> b() {
        return this.f57535c;
    }

    public q<Object, k<?>, Object, Unit> c() {
        return this.f57534b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(Object obj, q qVar, q qVar2, q qVar3, int i11, r rVar) {
        this(obj, qVar, qVar2, (i11 & 8) != 0 ? null : qVar3);
    }
}
