package com.huobi.account.ui;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class c0 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KycAuthInfoActivity f41653b;

    public /* synthetic */ c0(KycAuthInfoActivity kycAuthInfoActivity) {
        this.f41653b = kycAuthInfoActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f41653b.Ki(methodCall, result);
    }
}
