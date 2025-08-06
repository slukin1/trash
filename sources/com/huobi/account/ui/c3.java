package com.huobi.account.ui;

import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class c3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityRecordActivity f41656b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f41657c;

    public /* synthetic */ c3(SecurityRecordActivity securityRecordActivity, MethodChannel.Result result) {
        this.f41656b = securityRecordActivity;
        this.f41657c = result;
    }

    public final void call(Object obj) {
        this.f41656b.Yi(this.f41657c, (SecurityStrategySet) obj);
    }
}
