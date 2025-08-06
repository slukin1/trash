package com.huobi.account.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class d3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f41665b;

    public /* synthetic */ d3(MethodChannel.Result result) {
        this.f41665b = result;
    }

    public final void call(Object obj) {
        SecurityRecordActivity.Vi(this.f41665b, (APIStatusErrorException) obj);
    }
}
