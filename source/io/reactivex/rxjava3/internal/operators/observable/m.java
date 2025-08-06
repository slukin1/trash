package io.reactivex.rxjava3.internal.operators.observable;

public final class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final l f55585b;

    /* renamed from: c  reason: collision with root package name */
    public final long f55586c;

    public m(long j11, l lVar) {
        this.f55586c = j11;
        this.f55585b = lVar;
    }

    public void run() {
        this.f55585b.onTimeout(this.f55586c);
    }
}
