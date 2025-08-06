package io.reactivex.rxjava3.internal.util;

import j00.a;
import j00.g;
import java.util.concurrent.CountDownLatch;

public final class BlockingIgnoringReceiver extends CountDownLatch implements g<Throwable>, a {

    /* renamed from: b  reason: collision with root package name */
    public Throwable f55701b;

    public BlockingIgnoringReceiver() {
        super(1);
    }

    /* renamed from: a */
    public void accept(Throwable th2) {
        this.f55701b = th2;
        countDown();
    }

    public void run() {
        countDown();
    }
}
