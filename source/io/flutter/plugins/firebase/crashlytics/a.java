package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class a implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f55203a;

    public /* synthetic */ a(MethodChannel.Result result) {
        this.f55203a = result;
    }

    public final void onComplete(Task task) {
        FlutterFirebaseCrashlyticsPlugin.lambda$onMethodCall$10(this.f55203a, task);
    }
}
