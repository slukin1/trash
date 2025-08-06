package m00;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import k00.d;

public abstract class a<T, R> implements k00.a<T>, d<R> {

    /* renamed from: b  reason: collision with root package name */
    public final k00.a<? super R> f58087b;

    /* renamed from: c  reason: collision with root package name */
    public z20.d f58088c;

    /* renamed from: d  reason: collision with root package name */
    public d<T> f58089d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58090e;

    /* renamed from: f  reason: collision with root package name */
    public int f58091f;

    public a(k00.a<? super R> aVar) {
        this.f58087b = aVar;
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable th2) {
        io.reactivex.rxjava3.exceptions.a.b(th2);
        this.f58088c.cancel();
        onError(th2);
    }

    public void cancel() {
        this.f58088c.cancel();
    }

    public void clear() {
        this.f58089d.clear();
    }

    public final int d(int i11) {
        d<T> dVar = this.f58089d;
        if (dVar == null || (i11 & 4) != 0) {
            return 0;
        }
        int requestFusion = dVar.requestFusion(i11);
        if (requestFusion != 0) {
            this.f58091f = requestFusion;
        }
        return requestFusion;
    }

    public boolean isEmpty() {
        return this.f58089d.isEmpty();
    }

    public final boolean offer(R r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.f58090e) {
            this.f58090e = true;
            this.f58087b.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f58090e) {
            o00.a.n(th2);
            return;
        }
        this.f58090e = true;
        this.f58087b.onError(th2);
    }

    public final void onSubscribe(z20.d dVar) {
        if (SubscriptionHelper.validate(this.f58088c, dVar)) {
            this.f58088c = dVar;
            if (dVar instanceof d) {
                this.f58089d = (d) dVar;
            }
            if (b()) {
                this.f58087b.onSubscribe(this);
                a();
            }
        }
    }

    public void request(long j11) {
        this.f58088c.request(j11);
    }
}
