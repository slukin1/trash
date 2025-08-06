package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCorePlugin f55175b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55176c;

    public /* synthetic */ b(FlutterFirebaseCorePlugin flutterFirebaseCorePlugin, TaskCompletionSource taskCompletionSource) {
        this.f55175b = flutterFirebaseCorePlugin;
        this.f55176c = taskCompletionSource;
    }

    public final void run() {
        this.f55175b.lambda$initializeCore$3(this.f55176c);
    }
}
