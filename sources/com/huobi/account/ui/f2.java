package com.huobi.account.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import rx.functions.Action1;

public final /* synthetic */ class f2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ f2 f41680b = new f2();

    public final void call(Object obj) {
        HuobiToastUtil.m(((APIStatusErrorException) obj).getErrMsg());
    }
}
