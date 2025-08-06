package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55209b;

    public /* synthetic */ e(TaskCompletionSource taskCompletionSource) {
        this.f55209b = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebaseCrashlyticsPlugin.lambda$didReinitializeFirebaseCore$12(this.f55209b);
    }
}
