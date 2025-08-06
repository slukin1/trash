package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class c1 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PaymentMethodRootFlutterFragment f78637b;

    public /* synthetic */ c1(PaymentMethodRootFlutterFragment paymentMethodRootFlutterFragment) {
        this.f78637b = paymentMethodRootFlutterFragment;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78637b.Uh(methodCall, result);
    }
}
