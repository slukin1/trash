package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class u0 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcWordAdSearchActivity f78681b;

    public /* synthetic */ u0(OtcWordAdSearchActivity otcWordAdSearchActivity) {
        this.f78681b = otcWordAdSearchActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78681b.Ii(methodCall, result);
    }
}
