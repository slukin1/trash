package com.huobi.utils;

import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.utils.UserInfoUtil;
import rx.functions.Func2;

public final /* synthetic */ class a1 implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ a1 f83716b = new a1();

    public final Object call(Object obj, Object obj2) {
        return UserInfoUtil.c.e((UserInfoData) obj, (UserKycInfoNew) obj2);
    }
}
