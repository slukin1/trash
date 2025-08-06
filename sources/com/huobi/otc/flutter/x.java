package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class x implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcMakerAdsFlutterFragment f78687b;

    public /* synthetic */ x(OtcMakerAdsFlutterFragment otcMakerAdsFlutterFragment) {
        this.f78687b = otcMakerAdsFlutterFragment;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78687b.Th(methodCall, result);
    }
}
