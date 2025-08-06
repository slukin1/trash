package com.huobi.account.ui;

import c6.c;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.huobi.account.bean.LitePersonalCenterBean;
import com.huobi.entity.UserTransInfo;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class h0 implements c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LitePersonalCenterActivity f41694a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LitePersonalCenterBean f41695b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f41696c;

    public /* synthetic */ h0(LitePersonalCenterActivity litePersonalCenterActivity, LitePersonalCenterBean litePersonalCenterBean, MethodChannel.Result result) {
        this.f41694a = litePersonalCenterActivity;
        this.f41695b = litePersonalCenterBean;
        this.f41696c = result;
    }

    public final void a(Object obj, Object obj2) {
        this.f41694a.nj(this.f41695b, this.f41696c, (UserTransInfo) obj, (UnifyKycInfo) obj2);
    }
}
