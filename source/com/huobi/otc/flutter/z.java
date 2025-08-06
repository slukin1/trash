package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class z implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcMineFragment f78693b;

    public /* synthetic */ z(OtcMineFragment otcMineFragment) {
        this.f78693b = otcMineFragment;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78693b.Vh(methodCall, result);
    }
}
