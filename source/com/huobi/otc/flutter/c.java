package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class c implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DepositCurrencySearchFragment f78635b;

    public /* synthetic */ c(DepositCurrencySearchFragment depositCurrencySearchFragment) {
        this.f78635b = depositCurrencySearchFragment;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f78635b.ki(methodCall, result);
    }
}
