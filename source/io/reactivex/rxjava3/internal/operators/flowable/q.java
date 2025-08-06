package io.reactivex.rxjava3.internal.operators.flowable;

public final class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final p f55524b;

    /* renamed from: c  reason: collision with root package name */
    public final long f55525c;

    public q(long j11, p pVar) {
        this.f55525c = j11;
        this.f55524b = pVar;
    }

    public void run() {
        this.f55524b.onTimeout(this.f55525c);
    }
}
