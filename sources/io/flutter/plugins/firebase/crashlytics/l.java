package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCrashlyticsPlugin f55222b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f55223c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55224d;

    public /* synthetic */ l(FlutterFirebaseCrashlyticsPlugin flutterFirebaseCrashlyticsPlugin, Map map, TaskCompletionSource taskCompletionSource) {
        this.f55222b = flutterFirebaseCrashlyticsPlugin;
        this.f55223c = map;
        this.f55224d = taskCompletionSource;
    }

    public final void run() {
        this.f55222b.lambda$setCrashlyticsCollectionEnabled$7(this.f55223c, this.f55224d);
    }
}
