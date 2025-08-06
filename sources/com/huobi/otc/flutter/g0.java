package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class g0 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcQuickHomeFlutterFragment f78648b;

    public /* synthetic */ g0(OtcQuickHomeFlutterFragment otcQuickHomeFlutterFragment) {
        this.f78648b = otcQuickHomeFlutterFragment;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78648b.Th(methodCall, result);
    }
}
