package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f67130b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f67131c;

    public /* synthetic */ i(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.f67130b = firebaseMessaging;
        this.f67131c = taskCompletionSource;
    }

    public final void run() {
        this.f67130b.lambda$deleteToken$6(this.f67131c);
    }
}
