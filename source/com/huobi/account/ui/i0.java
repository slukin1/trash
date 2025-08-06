package com.huobi.account.ui;

import c6.c;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.huobi.entity.UserTransInfo;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class i0 implements c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LitePersonalCenterActivity f41707a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f41708b;

    public /* synthetic */ i0(LitePersonalCenterActivity litePersonalCenterActivity, MethodChannel.Result result) {
        this.f41707a = litePersonalCenterActivity;
        this.f41708b = result;
    }

    public final void a(Object obj, Object obj2) {
        this.f41707a.oj(this.f41708b, (UserTransInfo) obj, (UnifyKycInfo) obj2);
    }
}
