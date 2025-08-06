package com.huobi.account.ui;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class e6 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserGroupSettingActivity f41676b;

    public /* synthetic */ e6(UserGroupSettingActivity userGroupSettingActivity) {
        this.f41676b = userGroupSettingActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f41676b.Di(methodCall, result);
    }
}
