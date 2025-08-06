package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EnhancedIntentService f67108b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Intent f67109c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f67110d;

    public /* synthetic */ b(EnhancedIntentService enhancedIntentService, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.f67108b = enhancedIntentService;
        this.f67109c = intent;
        this.f67110d = taskCompletionSource;
    }

    public final void run() {
        this.f67108b.lambda$processIntent$0(this.f67109c, this.f67110d);
    }
}
