package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55194b;

    public /* synthetic */ i(TaskCompletionSource taskCompletionSource) {
        this.f55194b = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebasePluginRegistry.lambda$didReinitializeFirebaseCore$1(this.f55194b);
    }
}
