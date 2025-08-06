package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f55188b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Boolean f55189c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55190d;

    public /* synthetic */ g(String str, Boolean bool, TaskCompletionSource taskCompletionSource) {
        this.f55188b = str;
        this.f55189c = bool;
        this.f55190d = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebaseCorePlugin.lambda$setAutomaticDataCollectionEnabled$5(this.f55188b, this.f55189c, this.f55190d);
    }
}
