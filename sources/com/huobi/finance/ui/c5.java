package com.huobi.finance.ui;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class c5 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencySearchActivity f47070b;

    public /* synthetic */ c5(CurrencySearchActivity currencySearchActivity) {
        this.f47070b = currencySearchActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f47070b.ej(methodCall, result);
    }
}
