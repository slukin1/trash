package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;

public final /* synthetic */ class a implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidFirebaseCore.Result f55174a;

    public /* synthetic */ a(GeneratedAndroidFirebaseCore.Result result) {
        this.f55174a = result;
    }

    public final void onComplete(Task task) {
        FlutterFirebaseCorePlugin.lambda$listenToResponse$1(this.f55174a, task);
    }
}
