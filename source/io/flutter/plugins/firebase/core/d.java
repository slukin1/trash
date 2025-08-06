package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCorePlugin f55179b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f55180c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55181d;

    public /* synthetic */ d(FlutterFirebaseCorePlugin flutterFirebaseCorePlugin, FirebaseApp firebaseApp, TaskCompletionSource taskCompletionSource) {
        this.f55179b = flutterFirebaseCorePlugin;
        this.f55180c = firebaseApp;
        this.f55181d = taskCompletionSource;
    }

    public final void run() {
        this.f55179b.lambda$firebaseAppToMap$0(this.f55180c, this.f55181d);
    }
}
