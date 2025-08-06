package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class b1 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ P2PPayMethodRootFlutterActivity f78634b;

    public /* synthetic */ b1(P2PPayMethodRootFlutterActivity p2PPayMethodRootFlutterActivity) {
        this.f78634b = p2PPayMethodRootFlutterActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78634b.Ii(methodCall, result);
    }
}
