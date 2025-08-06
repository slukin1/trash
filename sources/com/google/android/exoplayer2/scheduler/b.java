package com.google.android.exoplayer2.scheduler;

import com.google.android.exoplayer2.scheduler.RequirementsWatcher;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RequirementsWatcher.NetworkCallback f65977b;

    public /* synthetic */ b(RequirementsWatcher.NetworkCallback networkCallback) {
        this.f65977b = networkCallback;
    }

    public final void run() {
        this.f65977b.lambda$postRecheckNotMetNetworkRequirements$1();
    }
}
