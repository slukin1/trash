package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class y implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcMerchantProfileActivity f78690b;

    public /* synthetic */ y(OtcMerchantProfileActivity otcMerchantProfileActivity) {
        this.f78690b = otcMerchantProfileActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78690b.Gi(methodCall, result);
    }
}
