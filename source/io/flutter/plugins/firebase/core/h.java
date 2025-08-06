package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f55191b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Boolean f55192c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55193d;

    public /* synthetic */ h(String str, Boolean bool, TaskCompletionSource taskCompletionSource) {
        this.f55191b = str;
        this.f55192c = bool;
        this.f55193d = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebaseCorePlugin.lambda$setAutomaticResourceManagementEnabled$6(this.f55191b, this.f55192c, this.f55193d);
    }
}
