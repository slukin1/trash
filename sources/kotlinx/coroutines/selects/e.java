package kotlinx.coroutines.selects;

import d10.l;
import d10.q;
import kotlin.Unit;
import kotlin.jvm.internal.r;

public final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public final Object f57525a;

    /* renamed from: b  reason: collision with root package name */
    public final q<Object, k<?>, Object, Unit> f57526b;

    /* renamed from: c  reason: collision with root package name */
    public final q<k<?>, Object, Object, l<Throwable, Unit>> f57527c;

    /* renamed from: d  reason: collision with root package name */
    public final q<Object, Object, Object, Object> f57528d;

    public e(Object obj, q<Object, ? super k<?>, Object, Unit> qVar, q<? super k<?>, Object, Object, ? extends l<? super Throwable, Unit>> qVar2) {
        this.f57525a = obj;
        this.f57526b = qVar;
        this.f57527c = qVar2;
        this.f57528d = SelectKt.f57518a;
    }

    public q<k<?>, Object, Object, l<Throwable, Unit>> a() {
        return this.f57527c;
    }

    public q<Object, Object, Object, Object> b() {
        return this.f57528d;
    }

    public q<Object, k<?>, Object, Unit> c() {
        return this.f57526b;
    }

    public Object d() {
        return this.f57525a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Object obj, q qVar, q qVar2, int i11, r rVar) {
        this(obj, qVar, (i11 & 4) != 0 ? null : qVar2);
    }
}
