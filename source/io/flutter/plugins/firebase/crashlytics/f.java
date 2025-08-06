package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55210b;

    public /* synthetic */ f(TaskCompletionSource taskCompletionSource) {
        this.f55210b = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebaseCrashlyticsPlugin.lambda$sendUnsentReports$6(this.f55210b);
    }
}
