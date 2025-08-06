package kotlinx.coroutines.reactive;

import d10.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.channels.BufferedChannel;
import z20.c;
import z20.d;

public final class f<T> extends BufferedChannel<T> implements c<T> {

    /* renamed from: o  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57415o;

    /* renamed from: p  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57416p;
    private volatile int _requested;
    private volatile Object _subscription;

    /* renamed from: n  reason: collision with root package name */
    public final int f57417n;

    static {
        Class<f> cls = f.class;
        f57415o = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_subscription");
        f57416p = AtomicIntegerFieldUpdater.newUpdater(cls, "_requested");
    }

    public f(int i11) {
        super(Integer.MAX_VALUE, (l) null, 2, (r) null);
        this.f57417n = i11;
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("Invalid request size: " + i11).toString());
        }
    }

    public void onComplete() {
        K((Throwable) null);
    }

    public void onError(Throwable th2) {
        K(th2);
    }

    public void onNext(T t11) {
        f57416p.decrementAndGet(this);
        q(t11);
    }

    public void onSubscribe(d dVar) {
        f57415o.set(this, dVar);
        while (!u()) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57416p;
            int i11 = atomicIntegerFieldUpdater.get(this);
            int i12 = this.f57417n;
            if (i11 < i12) {
                if (atomicIntegerFieldUpdater.compareAndSet(this, i11, i12)) {
                    dVar.request((long) (this.f57417n - i11));
                    return;
                }
            } else {
                return;
            }
        }
        dVar.cancel();
    }

    public void q0() {
        d dVar = (d) f57415o.getAndSet(this, (Object) null);
        if (dVar != null) {
            dVar.cancel();
        }
    }

    public void x0() {
        f57416p.incrementAndGet(this);
    }

    public void y0() {
        d dVar;
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57416p;
        while (true) {
            int i12 = atomicIntegerFieldUpdater.get(this);
            dVar = (d) f57415o.get(this);
            i11 = i12 - 1;
            if (dVar != null && i11 < 0) {
                int i13 = this.f57417n;
                if (i12 == i13 || f57416p.compareAndSet(this, i12, i13)) {
                    dVar.request((long) (this.f57417n - i11));
                }
            } else if (f57416p.compareAndSet(this, i12, i11)) {
                return;
            }
        }
        dVar.request((long) (this.f57417n - i11));
    }
}
