package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class b0 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcNewUserVideoTutorialActivity f78633b;

    public /* synthetic */ b0(OtcNewUserVideoTutorialActivity otcNewUserVideoTutorialActivity) {
        this.f78633b = otcNewUserVideoTutorialActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78633b.Di(methodCall, result);
    }
}
