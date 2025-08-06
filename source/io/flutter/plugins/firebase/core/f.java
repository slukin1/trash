package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f55186b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55187c;

    public /* synthetic */ f(String str, TaskCompletionSource taskCompletionSource) {
        this.f55186b = str;
        this.f55187c = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebaseCorePlugin.lambda$delete$7(this.f55186b, this.f55187c);
    }
}
