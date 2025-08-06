package com.huobi.finance.ui;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class e3 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CcRecordHomeActivity f47099b;

    public /* synthetic */ e3(CcRecordHomeActivity ccRecordHomeActivity) {
        this.f47099b = ccRecordHomeActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f47099b.Di(methodCall, result);
    }
}
