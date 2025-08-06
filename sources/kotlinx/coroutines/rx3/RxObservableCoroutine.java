package kotlinx.coroutines.rx3;

import d10.l;
import h00.i;
import io.reactivex.rxjava3.exceptions.UndeliverableException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.a;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.channels.m;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.sync.a;

public final class RxObservableCoroutine<T> extends a<Unit> implements k<T> {

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57444g = AtomicIntegerFieldUpdater.newUpdater(RxObservableCoroutine.class, "_signal");
    private volatile int _signal;

    /* renamed from: e  reason: collision with root package name */
    public final i<T> f57445e;

    /* renamed from: f  reason: collision with root package name */
    public final kotlinx.coroutines.sync.a f57446f;

    public boolean K(Throwable th2) {
        return X(th2);
    }

    public void c1(Throwable th2, boolean z11) {
        o1(th2, z11);
    }

    public m<T> getChannel() {
        return this;
    }

    public final Throwable i1(T t11) {
        if (!isActive()) {
            j1(k0(), l0());
            return A();
        }
        try {
            this.f57445e.onNext(t11);
            p1();
            return null;
        } catch (Throwable th2) {
            UndeliverableException undeliverableException = new UndeliverableException(th2);
            boolean K = K(undeliverableException);
            p1();
            if (K) {
                return undeliverableException;
            }
            b.a(undeliverableException, getContext());
            return A();
        }
    }

    public final void j1(Throwable th2, boolean z11) {
        try {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57444g;
            if (atomicIntegerFieldUpdater.get(this) == -2) {
                a.C0668a.c(this.f57446f, (Object) null, 1, (Object) null);
                return;
            }
            atomicIntegerFieldUpdater.set(this, -2);
            Throwable l11 = th2 != null ? !j0.d() ? th2 : b0.l(th2) : null;
            if (l11 == null) {
                this.f57445e.onComplete();
            } else if ((l11 instanceof UndeliverableException) && !z11) {
                b.a(th2, getContext());
            } else if (l11 != A() || !this.f57445e.isDisposed()) {
                try {
                    this.f57445e.onError(th2);
                } catch (Exception e11) {
                    ExceptionsKt__ExceptionsKt.a(th2, e11);
                    b.a(th2, getContext());
                }
            }
            a.C0668a.c(this.f57446f, (Object) null, 1, (Object) null);
        } catch (Exception e12) {
            b.a(e12, getContext());
        } catch (Throwable th3) {
            a.C0668a.c(this.f57446f, (Object) null, 1, (Object) null);
            throw th3;
        }
    }

    /* renamed from: k1 */
    public Void H(l<? super Throwable, Unit> lVar) {
        throw new UnsupportedOperationException("RxObservableCoroutine doesn't support invokeOnClose");
    }

    /* renamed from: l1 */
    public void d1(Unit unit) {
        o1((Throwable) null, false);
    }

    public final Object m1(Object obj, Object obj2) {
        Throwable i12 = i1(obj);
        if (i12 == null) {
            return this;
        }
        throw i12;
    }

    public final void n1(kotlinx.coroutines.selects.k<?> kVar, Object obj) {
        if (a.C0668a.b(this.f57446f, (Object) null, 1, (Object) null)) {
            kVar.d(Unit.f56620a);
            return;
        }
        n1 unused = kotlinx.coroutines.i.d(this, (CoroutineContext) null, (CoroutineStart) null, new RxObservableCoroutine$registerSelectForSend$1(this, kVar, (c<? super RxObservableCoroutine$registerSelectForSend$1>) null), 3, (Object) null);
    }

    public final void o1(Throwable th2, boolean z11) {
        if (f57444g.compareAndSet(this, 0, -1) && a.C0668a.b(this.f57446f, (Object) null, 1, (Object) null)) {
            j1(th2, z11);
        }
    }

    public final void p1() {
        a.C0668a.c(this.f57446f, (Object) null, 1, (Object) null);
        if (!isActive() && a.C0668a.b(this.f57446f, (Object) null, 1, (Object) null)) {
            j1(k0(), l0());
        }
    }

    public Object q(T t11) {
        if (!a.C0668a.b(this.f57446f, (Object) null, 1, (Object) null)) {
            return ChannelResult.f57037b.b();
        }
        Throwable i12 = i1(t11);
        if (i12 == null) {
            return ChannelResult.f57037b.c(Unit.f56620a);
        }
        return ChannelResult.f57037b.a(i12);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object send(T r5, kotlin.coroutines.c<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.rx3.RxObservableCoroutine$send$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.rx3.RxObservableCoroutine$send$1 r0 = (kotlinx.coroutines.rx3.RxObservableCoroutine$send$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx3.RxObservableCoroutine$send$1 r0 = new kotlinx.coroutines.rx3.RxObservableCoroutine$send$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.L$1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.rx3.RxObservableCoroutine r0 = (kotlinx.coroutines.rx3.RxObservableCoroutine) r0
            kotlin.k.b(r6)
            goto L_0x004b
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.k.b(r6)
            kotlinx.coroutines.sync.a r6 = r4.f57446f
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            r2 = 0
            java.lang.Object r6 = kotlinx.coroutines.sync.a.C0668a.a(r6, r2, r0, r3, r2)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r0 = r4
        L_0x004b:
            java.lang.Throwable r5 = r0.i1(r5)
            if (r5 != 0) goto L_0x0054
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        L_0x0054:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxObservableCoroutine.send(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    public boolean u() {
        return !isActive();
    }
}
