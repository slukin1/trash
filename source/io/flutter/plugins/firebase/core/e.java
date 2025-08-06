package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCorePlugin f55182b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidFirebaseCore.PigeonFirebaseOptions f55183c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f55184d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55185e;

    public /* synthetic */ e(FlutterFirebaseCorePlugin flutterFirebaseCorePlugin, GeneratedAndroidFirebaseCore.PigeonFirebaseOptions pigeonFirebaseOptions, String str, TaskCompletionSource taskCompletionSource) {
        this.f55182b = flutterFirebaseCorePlugin;
        this.f55183c = pigeonFirebaseOptions;
        this.f55184d = str;
        this.f55185e = taskCompletionSource;
    }

    public final void run() {
        this.f55182b.lambda$initializeApp$2(this.f55183c, this.f55184d, this.f55185e);
    }
}
