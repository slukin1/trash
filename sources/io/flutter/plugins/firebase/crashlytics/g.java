package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55211b;

    public /* synthetic */ g(TaskCompletionSource taskCompletionSource) {
        this.f55211b = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebaseCrashlyticsPlugin.lambda$deleteUnsentReports$2(this.f55211b);
    }
}
