package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

abstract class zabg {
    private final zabf zaa;

    public zabg(zabf zabf) {
        this.zaa = zabf;
    }

    public abstract void zaa();

    public final void zab(zabi zabi) {
        Lock zah;
        zabi.zai.lock();
        try {
            if (zabi.zan != this.zaa) {
                zah = zabi.zai;
            } else {
                zaa();
                zah = zabi.zai;
            }
            zah.unlock();
        } catch (Throwable th2) {
            zabi.zai.unlock();
            throw th2;
        }
    }
}
