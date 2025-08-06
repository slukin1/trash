package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f67145b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f67146c;

    public /* synthetic */ s(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.f67145b = firebaseMessaging;
        this.f67146c = taskCompletionSource;
    }

    public final void run() {
        this.f67145b.lambda$getToken$4(this.f67146c);
    }
}
