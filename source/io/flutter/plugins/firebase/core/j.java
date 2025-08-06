package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f55195b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55196c;

    public /* synthetic */ j(FirebaseApp firebaseApp, TaskCompletionSource taskCompletionSource) {
        this.f55195b = firebaseApp;
        this.f55196c = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebasePluginRegistry.lambda$getPluginConstantsForFirebaseApp$0(this.f55195b, this.f55196c);
    }
}
