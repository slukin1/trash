package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class a0 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcMyFollowedFlutterActivity f78630b;

    public /* synthetic */ a0(OtcMyFollowedFlutterActivity otcMyFollowedFlutterActivity) {
        this.f78630b = otcMyFollowedFlutterActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78630b.Di(methodCall, result);
    }
}
