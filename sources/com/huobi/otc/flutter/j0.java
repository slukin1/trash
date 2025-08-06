package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class j0 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcTradePayingAndSuccessActivity f78654b;

    public /* synthetic */ j0(OtcTradePayingAndSuccessActivity otcTradePayingAndSuccessActivity) {
        this.f78654b = otcTradePayingAndSuccessActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78654b.Mi(methodCall, result);
    }
}
