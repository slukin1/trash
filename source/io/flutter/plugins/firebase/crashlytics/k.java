package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCrashlyticsPlugin f55219b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f55220c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55221d;

    public /* synthetic */ k(FlutterFirebaseCrashlyticsPlugin flutterFirebaseCrashlyticsPlugin, Map map, TaskCompletionSource taskCompletionSource) {
        this.f55219b = flutterFirebaseCrashlyticsPlugin;
        this.f55220c = map;
        this.f55221d = taskCompletionSource;
    }

    public final void run() {
        this.f55219b.lambda$recordError$4(this.f55220c, this.f55221d);
    }
}
