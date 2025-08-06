package com.huobi.utils;

import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.utils.UserInfoUtil;
import rx.functions.Func3;

public final /* synthetic */ class b1 implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ b1 f83718b = new b1();

    public final Object call(Object obj, Object obj2, Object obj3) {
        return UserInfoUtil.c.d((UserInfoData) obj, (UserKycInfoNew) obj2, (UserVO) obj3);
    }
}
