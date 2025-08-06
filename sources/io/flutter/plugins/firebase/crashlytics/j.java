package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCrashlyticsPlugin f55216b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55217c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f55218d;

    public /* synthetic */ j(FlutterFirebaseCrashlyticsPlugin flutterFirebaseCrashlyticsPlugin, TaskCompletionSource taskCompletionSource, FirebaseApp firebaseApp) {
        this.f55216b = flutterFirebaseCrashlyticsPlugin;
        this.f55217c = taskCompletionSource;
        this.f55218d = firebaseApp;
    }

    public final void run() {
        this.f55216b.lambda$getPluginConstantsForFirebaseApp$11(this.f55217c, this.f55218d);
    }
}
