package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class l implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcAdPublishEditActivity f78657b;

    public /* synthetic */ l(OtcAdPublishEditActivity otcAdPublishEditActivity) {
        this.f78657b = otcAdPublishEditActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78657b.Li(methodCall, result);
    }
}
