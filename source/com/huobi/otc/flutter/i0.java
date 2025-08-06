package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class i0 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcTagManagerActivity f78652b;

    public /* synthetic */ i0(OtcTagManagerActivity otcTagManagerActivity) {
        this.f78652b = otcTagManagerActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78652b.Di(methodCall, result);
    }
}
