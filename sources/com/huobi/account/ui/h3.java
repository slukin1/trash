package com.huobi.account.ui;

import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class h3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f41699b;

    public /* synthetic */ h3(MethodChannel.Result result) {
        this.f41699b = result;
    }

    public final void call(Object obj) {
        SecurityRecordActivity.aj(this.f41699b, (Throwable) obj);
    }
}
