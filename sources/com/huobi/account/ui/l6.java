package com.huobi.account.ui;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class l6 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserNftSettingActivity f41746b;

    public /* synthetic */ l6(UserNftSettingActivity userNftSettingActivity) {
        this.f41746b = userNftSettingActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f41746b.Si(methodCall, result);
    }
}
