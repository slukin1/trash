package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class d0 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcOrderTransConfirmFlutterFragemnt f78640b;

    public /* synthetic */ d0(OtcOrderTransConfirmFlutterFragemnt otcOrderTransConfirmFlutterFragemnt) {
        this.f78640b = otcOrderTransConfirmFlutterFragemnt;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78640b.Wh(methodCall, result);
    }
}
