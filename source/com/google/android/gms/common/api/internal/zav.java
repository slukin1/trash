package com.google.android.gms.common.api.internal;

final class zav implements Runnable {
    public final /* synthetic */ zaaa zaa;

    public zav(zaaa zaaa) {
        this.zaa = zaaa;
    }

    public final void run() {
        this.zaa.zam.lock();
        try {
            zaaa.zap(this.zaa);
        } finally {
            this.zaa.zam.unlock();
        }
    }
}
