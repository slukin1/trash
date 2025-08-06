package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class e0 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcPriceCreateActivity f78643b;

    public /* synthetic */ e0(OtcPriceCreateActivity otcPriceCreateActivity) {
        this.f78643b = otcPriceCreateActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78643b.Di(methodCall, result);
    }
}
