package com.google.firebase.messaging;

import com.google.firebase.messaging.WithinAppServiceConnection;

public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WithinAppServiceConnection.BindRequest f67126b;

    public /* synthetic */ f0(WithinAppServiceConnection.BindRequest bindRequest) {
        this.f67126b = bindRequest;
    }

    public final void run() {
        this.f67126b.lambda$arrangeTimeout$0();
    }
}
