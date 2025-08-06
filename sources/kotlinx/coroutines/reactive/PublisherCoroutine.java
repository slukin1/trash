package kotlinx.coroutines.reactive;

import d10.l;
import d10.p;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.a;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.channels.m;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.sync.a;
import z20.c;
import z20.d;

public final class PublisherCoroutine<T> extends a<Unit> implements k<T>, d {

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f57408h = AtomicLongFieldUpdater.newUpdater(PublisherCoroutine.class, "_nRequested");
    private volatile long _nRequested;
    private volatile boolean cancelled;

    /* renamed from: e  reason: collision with root package name */
    public final c<T> f57409e;

    /* renamed from: f  reason: collision with root package name */
    public final p<Throwable, CoroutineContext, Unit> f57410f;

    /* renamed from: g  reason: collision with root package name */
    public final kotlinx.coroutines.sync.a f57411g;

    public boolean K(Throwable th2) {
        return X(th2);
    }

    public void c1(Throwable th2, boolean z11) {
        o1(th2, z11);
    }

    public void cancel() {
        this.cancelled = true;
        super.b((CancellationException) null);
    }

    public m<T> getChannel() {
        return this;
    }

    public final Throwable i1(T t11) {
        if (t11 == null) {
            p1();
            throw new NullPointerException("Attempted to emit `null` inside a reactive publisher");
        } else if (!isActive()) {
            p1();
            return A();
        } else {
            try {
                this.f57409e.onNext(t11);
                while (true) {
                    AtomicLongFieldUpdater atomicLongFieldUpdater = f57408h;
                    long j11 = atomicLongFieldUpdater.get(this);
                    if (j11 < 0 || j11 == Long.MAX_VALUE) {
                        break;
                    }
                    long j12 = j11 - 1;
                    if (atomicLongFieldUpdater.compareAndSet(this, j11, j12)) {
                        if (j12 == 0) {
                            return null;
                        }
                    }
                }
                p1();
                return null;
            } catch (Throwable th2) {
                this.cancelled = true;
                boolean K = K(th2);
                p1();
                if (K) {
                    return th2;
                }
                this.f57410f.invoke(th2, getContext());
                return A();
            }
        }
    }

    public final void j1(Throwable th2, boolean z11) {
        try {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f57408h;
            if (atomicLongFieldUpdater.get(this) != -2) {
                atomicLongFieldUpdater.set(this, -2);
                if (!this.cancelled) {
                    if (th2 == null) {
                        this.f57409e.onComplete();
                    } else {
                        try {
                            this.f57409e.onError(th2);
                        } catch (Throwable th3) {
                            if (th3 != th2) {
                                ExceptionsKt__ExceptionsKt.a(th2, th3);
                            }
                            e0.a(getContext(), th2);
                        }
                    }
                    a.C0668a.c(this.f57411g, (Object) null, 1, (Object) null);
                    return;
                } else if (th2 != null && !z11) {
                    this.f57410f.invoke(th2, getContext());
                }
            }
            a.C0668a.c(this.f57411g, (Object) null, 1, (Object) null);
        } catch (Throwable th4) {
            a.C0668a.c(this.f57411g, (Object) null, 1, (Object) null);
            throw th4;
        }
    }

    /* renamed from: k1 */
    public Void H(l<? super Throwable, Unit> lVar) {
        throw new UnsupportedOperationException("PublisherCoroutine doesn't support invokeOnClose");
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
        if (a.C0668a.b(this.f57411g, (Object) null, 1, (Object) null)) {
            kVar.d(Unit.f56620a);
            return;
        }
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new PublisherCoroutine$registerSelectForSend$1(this, kVar, (kotlin.coroutines.c<? super PublisherCoroutine$registerSelectForSend$1>) null), 3, (Object) null);
    }

    public final void o1(Throwable th2, boolean z11) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j11;
        int i11;
        do {
            atomicLongFieldUpdater = f57408h;
            j11 = atomicLongFieldUpdater.get(this);
            if (j11 != -2) {
                i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
                if (!(i11 >= 0)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, -1));
        if (i11 == 0) {
            j1(th2, z11);
        } else if (a.C0668a.b(this.f57411g, (Object) null, 1, (Object) null)) {
            j1(th2, z11);
        }
    }

    public final void p1() {
        a.C0668a.c(this.f57411g, (Object) null, 1, (Object) null);
        if (a() && a.C0668a.b(this.f57411g, (Object) null, 1, (Object) null)) {
            j1(k0(), l0());
        }
    }

    public Object q(T t11) {
        if (!a.C0668a.b(this.f57411g, (Object) null, 1, (Object) null)) {
            return ChannelResult.f57037b.b();
        }
        Throwable i12 = i1(t11);
        if (i12 == null) {
            return ChannelResult.f57037b.c(Unit.f56620a);
        }
        return ChannelResult.f57037b.a(i12);
    }

    public void request(long j11) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j12;
        int i11;
        long j13;
        if (j11 <= 0) {
            X(new IllegalArgumentException("non-positive subscription request " + j11));
            return;
        }
        do {
            atomicLongFieldUpdater = f57408h;
            j12 = atomicLongFieldUpdater.get(this);
            i11 = (j12 > 0 ? 1 : (j12 == 0 ? 0 : -1));
            if (i11 >= 0) {
                j13 = j12 + j11;
                if (j13 < 0 || j11 == Long.MAX_VALUE) {
                    j13 = Long.MAX_VALUE;
                }
                if (j12 == j13) {
                    return;
                }
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j12, j13));
        if (i11 == 0) {
            p1();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object send(T r5, kotlin.coroutines.c<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.reactive.PublisherCoroutine$send$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.reactive.PublisherCoroutine$send$1 r0 = (kotlinx.coroutines.reactive.PublisherCoroutine$send$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.reactive.PublisherCoroutine$send$1 r0 = new kotlinx.coroutines.reactive.PublisherCoroutine$send$1
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
            kotlinx.coroutines.reactive.PublisherCoroutine r0 = (kotlinx.coroutines.reactive.PublisherCoroutine) r0
            kotlin.k.b(r6)
            goto L_0x004b
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.k.b(r6)
            kotlinx.coroutines.sync.a r6 = r4.f57411g
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.PublisherCoroutine.send(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    public boolean u() {
        return !isActive();
    }
}
