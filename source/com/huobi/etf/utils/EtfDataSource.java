package com.huobi.etf.utils;

import com.huobi.etf.entity.EtfToken;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import kk.a;
import rx.Observable;
import tq.p;

public class EtfDataSource {
    public static Observable<EtfToken> b() {
        return UserCenterRemoteDataSource.A().Q("ETF").compose(p.c0()).flatMap(a.f56584b).compose(p.B());
    }
}
