package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCorePlugin f55177b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55178c;

    public /* synthetic */ c(FlutterFirebaseCorePlugin flutterFirebaseCorePlugin, TaskCompletionSource taskCompletionSource) {
        this.f55177b = flutterFirebaseCorePlugin;
        this.f55178c = taskCompletionSource;
    }

    public final void run() {
        this.f55177b.lambda$optionsFromResource$4(this.f55178c);
    }
}
