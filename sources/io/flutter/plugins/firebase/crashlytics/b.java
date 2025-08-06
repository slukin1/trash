package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f55204b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f55205c;

    public /* synthetic */ b(Map map, TaskCompletionSource taskCompletionSource) {
        this.f55204b = map;
        this.f55205c = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebaseCrashlyticsPlugin.lambda$log$5(this.f55204b, this.f55205c);
    }
}
