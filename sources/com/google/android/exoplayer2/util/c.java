package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.NetworkTypeObserver;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NetworkTypeObserver f66087b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NetworkTypeObserver.Listener f66088c;

    public /* synthetic */ c(NetworkTypeObserver networkTypeObserver, NetworkTypeObserver.Listener listener) {
        this.f66087b = networkTypeObserver;
        this.f66088c = listener;
    }

    public final void run() {
        this.f66087b.lambda$register$0(this.f66088c);
    }
}
