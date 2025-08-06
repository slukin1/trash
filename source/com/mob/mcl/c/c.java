package com.mob.mcl.c;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public class c implements Future<e> {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f27455a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<e> f27456b = new AtomicReference<>();

    /* renamed from: a */
    public e get() throws InterruptedException, ExecutionException {
        this.f27455a.await();
        return this.f27456b.get();
    }

    public boolean cancel(boolean z11) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return this.f27455a.getCount() == 0;
    }

    /* renamed from: a */
    public e get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (this.f27455a.await(j11, timeUnit)) {
            return this.f27456b.get();
        }
        throw new TimeoutException("tcp get msg timeout");
    }

    public void a(e eVar) {
        synchronized (this.f27455a) {
            this.f27456b.set(eVar);
            this.f27455a.countDown();
        }
    }
}
