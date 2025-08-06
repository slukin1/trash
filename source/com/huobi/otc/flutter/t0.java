package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class t0 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcVideoTutorialActivity f78679b;

    public /* synthetic */ t0(OtcVideoTutorialActivity otcVideoTutorialActivity) {
        this.f78679b = otcVideoTutorialActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78679b.Di(methodCall, result);
    }
}
