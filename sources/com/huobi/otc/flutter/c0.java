package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class c0 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcOrderInfoActivity f78636b;

    public /* synthetic */ c0(OtcOrderInfoActivity otcOrderInfoActivity) {
        this.f78636b = otcOrderInfoActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78636b.Fi(methodCall, result);
    }
}
