package com.huobi.finance.ui;

import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class j implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbsDwActivity f47176b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f47177c;

    public /* synthetic */ j(AbsDwActivity absDwActivity, MethodChannel.Result result) {
        this.f47176b = absDwActivity;
        this.f47177c = result;
    }

    public final void call(Object obj) {
        this.f47176b.cj(this.f47177c, (List) obj);
    }
}
