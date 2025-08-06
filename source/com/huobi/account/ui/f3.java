package com.huobi.account.ui;

import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class f3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f41681b;

    public /* synthetic */ f3(MethodChannel.Result result) {
        this.f41681b = result;
    }

    public final void call(Object obj) {
        SecurityRecordActivity.Ui(this.f41681b, (String) obj);
    }
}
