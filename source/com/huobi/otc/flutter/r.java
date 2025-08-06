package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class r implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f78674b;

    public /* synthetic */ r(MethodChannel.Result result) {
        this.f78674b = result;
    }

    public final void call(Object obj) {
        this.f78674b.success("");
    }
}
