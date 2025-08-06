package com.huobi.finance.ui;

import androidx.core.util.c;
import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class i implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbsDwActivity f47160b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f47161c;

    public /* synthetic */ i(AbsDwActivity absDwActivity, MethodChannel.Result result) {
        this.f47160b = absDwActivity;
        this.f47161c = result;
    }

    public final void call(Object obj) {
        this.f47160b.lj(this.f47161c, (c) obj);
    }
}
