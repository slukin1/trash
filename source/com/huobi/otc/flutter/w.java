package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class w implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcFlutterVideoActivity f78685b;

    public /* synthetic */ w(OtcFlutterVideoActivity otcFlutterVideoActivity) {
        this.f78685b = otcFlutterVideoActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78685b.Di(methodCall, result);
    }
}
