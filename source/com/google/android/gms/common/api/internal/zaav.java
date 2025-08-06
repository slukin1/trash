package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

abstract class zaav implements Runnable {
    public final /* synthetic */ zaaw zab;

    public /* synthetic */ zaav(zaaw zaaw, zaau zaau) {
        this.zab = zaaw;
    }

    public final void run() {
        Lock zap;
        this.zab.zab.lock();
        try {
            if (Thread.interrupted()) {
                zap = this.zab.zab;
            } else {
                zaa();
                zap = this.zab.zab;
            }
        } catch (RuntimeException e11) {
            this.zab.zaa.zam(e11);
            zap = this.zab.zab;
        } catch (Throwable th2) {
            this.zab.zab.unlock();
            throw th2;
        }
        zap.unlock();
    }

    public abstract void zaa();
}
