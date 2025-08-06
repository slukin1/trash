package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCrashlyticsPlugin f55214b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55215c;

    public /* synthetic */ i(FlutterFirebaseCrashlyticsPlugin flutterFirebaseCrashlyticsPlugin, TaskCompletionSource taskCompletionSource) {
        this.f55214b = flutterFirebaseCrashlyticsPlugin;
        this.f55215c = taskCompletionSource;
    }

    public final void run() {
        this.f55214b.lambda$checkForUnsentReports$0(this.f55215c);
    }
}
