package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class a implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbsOtcTradeFlutterActivity f78629b;

    public /* synthetic */ a(AbsOtcTradeFlutterActivity absOtcTradeFlutterActivity) {
        this.f78629b = absOtcTradeFlutterActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78629b.Ei(methodCall, result);
    }
}
