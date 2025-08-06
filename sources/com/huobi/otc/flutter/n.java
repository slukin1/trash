package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class n implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcC2cOrderActivity f78662b;

    public /* synthetic */ n(OtcC2cOrderActivity otcC2cOrderActivity) {
        this.f78662b = otcC2cOrderActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78662b.Ki(methodCall, result);
    }
}
