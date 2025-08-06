package com.google.firebase.messaging;

import android.content.Intent;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FcmLifecycleCallbacks f67127b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Intent f67128c;

    public /* synthetic */ g(FcmLifecycleCallbacks fcmLifecycleCallbacks, Intent intent) {
        this.f67127b = fcmLifecycleCallbacks;
        this.f67128c = intent;
    }

    public final void run() {
        this.f67127b.lambda$onActivityCreated$0(this.f67128c);
    }
}
