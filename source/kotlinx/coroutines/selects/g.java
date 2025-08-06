package kotlinx.coroutines.selects;

import d10.l;
import d10.q;
import kotlin.Unit;

public final class g<Q> implements f<Q> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f57529a;

    /* renamed from: b  reason: collision with root package name */
    public final q<Object, k<?>, Object, Unit> f57530b;

    /* renamed from: c  reason: collision with root package name */
    public final q<Object, Object, Object, Object> f57531c;

    /* renamed from: d  reason: collision with root package name */
    public final q<k<?>, Object, Object, l<Throwable, Unit>> f57532d;

    public g(Object obj, q<Object, ? super k<?>, Object, Unit> qVar, q<Object, Object, Object, ? extends Object> qVar2, q<? super k<?>, Object, Object, ? extends l<? super Throwable, Unit>> qVar3) {
        this.f57529a = obj;
        this.f57530b = qVar;
        this.f57531c = qVar2;
        this.f57532d = qVar3;
    }

    public q<k<?>, Object, Object, l<Throwable, Unit>> a() {
        return this.f57532d;
    }

    public q<Object, Object, Object, Object> b() {
        return this.f57531c;
    }

    public q<Object, k<?>, Object, Unit> c() {
        return this.f57530b;
    }

    public Object d() {
        return this.f57529a;
    }
}
