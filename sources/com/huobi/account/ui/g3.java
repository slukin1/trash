package com.huobi.account.ui;

import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class g3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f41689b;

    public /* synthetic */ g3(MethodChannel.Result result) {
        this.f41689b = result;
    }

    public final void call(Object obj) {
        SecurityRecordActivity.Wi(this.f41689b, (Throwable) obj);
    }
}
