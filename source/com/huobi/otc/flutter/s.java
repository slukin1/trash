package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class s implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f78676b;

    public /* synthetic */ s(MethodChannel.Result result) {
        this.f78676b = result;
    }

    public final void call(Object obj) {
        this.f78676b.success("");
    }
}
