package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class f0 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcPricePromptActivity f78646b;

    public /* synthetic */ f0(OtcPricePromptActivity otcPricePromptActivity) {
        this.f78646b = otcPricePromptActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78646b.Di(methodCall, result);
    }
}
