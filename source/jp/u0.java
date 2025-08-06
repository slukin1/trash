package jp;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class u0 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v0 f56064b;

    public /* synthetic */ u0(v0 v0Var) {
        this.f56064b = v0Var;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f56064b.s(methodCall, result);
    }
}
