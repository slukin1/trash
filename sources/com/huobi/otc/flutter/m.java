package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class m implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcAdvertPrivilegeHomeFlutterActivity f78659b;

    public /* synthetic */ m(OtcAdvertPrivilegeHomeFlutterActivity otcAdvertPrivilegeHomeFlutterActivity) {
        this.f78659b = otcAdvertPrivilegeHomeFlutterActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78659b.Ei(methodCall, result);
    }
}
