package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultHeartBeatController f67095b;

    public /* synthetic */ d(DefaultHeartBeatController defaultHeartBeatController) {
        this.f67095b = defaultHeartBeatController;
    }

    public final Object call() {
        return this.f67095b.lambda$getHeartBeatsHeader$1();
    }
}
