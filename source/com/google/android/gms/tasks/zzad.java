package com.google.android.gms.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzad<T> implements zzae<T> {
    private final CountDownLatch zza = new CountDownLatch(1);

    private zzad() {
    }

    public final void onCanceled() {
        this.zza.countDown();
    }

    public final void onFailure(Exception exc) {
        this.zza.countDown();
    }

    public final void onSuccess(T t11) {
        this.zza.countDown();
    }

    public final void zza() throws InterruptedException {
        this.zza.await();
    }

    public final boolean zzb(long j11, TimeUnit timeUnit) throws InterruptedException {
        return this.zza.await(j11, timeUnit);
    }

    public /* synthetic */ zzad(zzac zzac) {
    }
}
