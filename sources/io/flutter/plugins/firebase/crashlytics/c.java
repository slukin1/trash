package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f55206b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55207c;

    public /* synthetic */ c(Map map, TaskCompletionSource taskCompletionSource) {
        this.f55206b = map;
        this.f55207c = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebaseCrashlyticsPlugin.lambda$setCustomKey$9(this.f55206b, this.f55207c);
    }
}
