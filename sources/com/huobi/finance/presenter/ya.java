package com.huobi.finance.presenter;

import com.huobi.finance.bean.PreWithdrawData;
import com.huobi.finance.bean.WithdrawInfo;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import rx.functions.Func4;

public final /* synthetic */ class ya implements Func4 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ ya f46195b = new ya();

    public final Object call(Object obj, Object obj2, Object obj3, Object obj4) {
        return UnifyWithdrawPresenter.n1((WithdrawInfo) obj, (PreWithdrawData) obj2, (UserSecurityInfoData) obj3, (SecurityStrategySet) obj4);
    }
}
