package com.huobi.finance.presenter;

import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.module.contract.service.ContractService;
import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import java.util.Map;
import rx.functions.Func1;

public final /* synthetic */ class o9 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f46042b;

    public /* synthetic */ o9(Map map) {
        this.f46042b = map;
    }

    public final Object call(Object obj) {
        return ((ContractService) ContractRetrofit.request(ContractService.class)).transferCurrency(((ProUserToken) obj).getToken(), this.f46042b).compose(ContractRetrofit.h());
    }
}
