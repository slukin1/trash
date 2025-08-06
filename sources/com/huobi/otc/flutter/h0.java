package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class h0 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcQuickTradeQuoteActivity f78650b;

    public /* synthetic */ h0(OtcQuickTradeQuoteActivity otcQuickTradeQuoteActivity) {
        this.f78650b = otcQuickTradeQuoteActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78650b.Ji(methodCall, result);
    }
}
