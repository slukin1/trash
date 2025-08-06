package com.huobi.utils;

import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import rx.functions.Func5;

public final /* synthetic */ class z0 implements Func5 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ z0 f83801b = new z0();

    public final Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return UserInfoUtil.f((UserInfoData) obj, (UserKycInfoNew) obj2, (UnifyKycInfo) obj3, (Boolean) obj4, (UserOtherInfoData) obj5);
    }
}
