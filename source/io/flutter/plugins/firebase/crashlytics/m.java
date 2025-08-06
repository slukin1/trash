package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f55225b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55226c;

    public /* synthetic */ m(Map map, TaskCompletionSource taskCompletionSource) {
        this.f55225b = map;
        this.f55226c = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebaseCrashlyticsPlugin.lambda$setUserIdentifier$8(this.f55225b, this.f55226c);
    }
}
