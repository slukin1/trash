package com.google.android.gms.common.api.internal;

final class zabo implements Runnable {
    public final /* synthetic */ zabp zaa;

    public zabo(zabp zabp) {
        this.zaa = zabp;
    }

    public final void run() {
        zabq zabq = this.zaa.zaa;
        zabq.zac.disconnect(zabq.zac.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
