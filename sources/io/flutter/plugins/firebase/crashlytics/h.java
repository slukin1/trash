package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCrashlyticsPlugin f55212b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55213c;

    public /* synthetic */ h(FlutterFirebaseCrashlyticsPlugin flutterFirebaseCrashlyticsPlugin, TaskCompletionSource taskCompletionSource) {
        this.f55212b = flutterFirebaseCrashlyticsPlugin;
        this.f55213c = taskCompletionSource;
    }

    public final void run() {
        this.f55212b.lambda$didCrashOnPreviousExecution$3(this.f55213c);
    }
}
