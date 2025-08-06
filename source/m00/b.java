package m00;

import h00.e;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import k00.d;
import z20.c;

public abstract class b<T, R> implements e<T>, d<R> {

    /* renamed from: b  reason: collision with root package name */
    public final c<? super R> f58092b;

    /* renamed from: c  reason: collision with root package name */
    public z20.d f58093c;

    /* renamed from: d  reason: collision with root package name */
    public d<T> f58094d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58095e;

    /* renamed from: f  reason: collision with root package name */
    public int f58096f;

    public b(c<? super R> cVar) {
        this.f58092b = cVar;
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable th2) {
        a.b(th2);
        this.f58093c.cancel();
        onError(th2);
    }

    public void cancel() {
        this.f58093c.cancel();
    }

    public void clear() {
        this.f58094d.clear();
    }

    public final int d(int i11) {
        d<T> dVar = this.f58094d;
        if (dVar == null || (i11 & 4) != 0) {
            return 0;
        }
        int requestFusion = dVar.requestFusion(i11);
        if (requestFusion != 0) {
            this.f58096f = requestFusion;
        }
        return requestFusion;
    }

    public boolean isEmpty() {
        return this.f58094d.isEmpty();
    }

    public final boolean offer(R r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.f58095e) {
            this.f58095e = true;
            this.f58092b.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f58095e) {
            o00.a.n(th2);
            return;
        }
        this.f58095e = true;
        this.f58092b.onError(th2);
    }

    public final void onSubscribe(z20.d dVar) {
        if (SubscriptionHelper.validate(this.f58093c, dVar)) {
            this.f58093c = dVar;
            if (dVar instanceof d) {
                this.f58094d = (d) dVar;
            }
            if (b()) {
                this.f58092b.onSubscribe(this);
                a();
            }
        }
    }

    public void request(long j11) {
        this.f58093c.request(j11);
    }
}
