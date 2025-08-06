package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f67143b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f67144c;

    public /* synthetic */ q(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.f67143b = firebaseMessaging;
        this.f67144c = taskCompletionSource;
    }

    public final void run() {
        this.f67143b.lambda$deleteToken$5(this.f67144c);
    }
}
