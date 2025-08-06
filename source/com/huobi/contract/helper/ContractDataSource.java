package com.huobi.contract.helper;

import android.text.TextUtils;
import bj.o;
import bj.q;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.module.contract.helper.ContractRequestHelper;
import com.hbg.module.contract.service.ContractService;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.tencent.android.tpush.common.Constants;
import java.util.HashMap;
import rx.Observable;
import tq.p;

public class ContractDataSource extends ContractRequestHelper {
    public static Observable<String[]> f(String str) {
        return UserCenterRemoteDataSource.A().Q(str).compose(p.c0()).flatMap(new o(new String[2]));
    }

    public static /* synthetic */ ContractUserInfo g(Throwable th2) {
        return null;
    }

    public static /* synthetic */ String[] h(String[] strArr, LoginInfoData loginInfoData, ContractUserInfo contractUserInfo) {
        String str;
        if (!(contractUserInfo == null || contractUserInfo.getUser() == null)) {
            ContractUserInfoProvider.i().z(contractUserInfo.getUser());
        }
        if (contractUserInfo == null) {
            str = null;
        } else {
            str = contractUserInfo.getHbsession();
        }
        strArr[0] = str;
        strArr[1] = loginInfoData.getTicket();
        return strArr;
    }

    public static /* synthetic */ Observable i(String[] strArr, LoginInfoData loginInfoData) {
        if (loginInfoData == null || TextUtils.isEmpty(loginInfoData.getTicket())) {
            return Observable.just(strArr);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.FLAG_TICKET, loginInfoData.getTicket());
        return ((ContractService) ContractRetrofit.request(ContractService.class)).login(hashMap).compose(ContractRetrofit.h()).onErrorReturn(q.f12479b).map(new bj.p(strArr, loginInfoData));
    }
}
