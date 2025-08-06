package com.google.firebase.messaging;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f67153b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f67154c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f67155d;

    public /* synthetic */ y(Context context, boolean z11, TaskCompletionSource taskCompletionSource) {
        this.f67153b = context;
        this.f67154c = z11;
        this.f67155d = taskCompletionSource;
    }

    public final void run() {
        ProxyNotificationInitializer.lambda$setEnableProxyNotification$0(this.f67153b, this.f67154c, this.f67155d);
    }
}
