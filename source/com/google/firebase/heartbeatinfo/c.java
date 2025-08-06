package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultHeartBeatController f67094b;

    public /* synthetic */ c(DefaultHeartBeatController defaultHeartBeatController) {
        this.f67094b = defaultHeartBeatController;
    }

    public final Object call() {
        return this.f67094b.lambda$registerHeartBeat$0();
    }
}
