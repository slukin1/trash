package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class k implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcAdPublishEditActivity f78655b;

    public /* synthetic */ k(OtcAdPublishEditActivity otcAdPublishEditActivity) {
        this.f78655b = otcAdPublishEditActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78655b.Ki(methodCall, result);
    }
}
