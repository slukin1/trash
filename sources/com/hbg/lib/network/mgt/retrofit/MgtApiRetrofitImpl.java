package com.hbg.lib.network.mgt.retrofit;

import android.content.Context;
import com.hbg.lib.network.mgt.core.bean.LegalRateBean;
import com.hbg.lib.network.mgt.retrofit.service.MgtApiService;
import com.huobi.currencyconfig.bean.StableCoinHints;
import d9.a;
import java.util.List;
import l8.b;

public class MgtApiRetrofitImpl implements b {
    public void a(String str, Context context, c9.b bVar) {
        MgtRetrofit.d().init(str, context, bVar);
    }

    public a<List<LegalRateBean>> getCurrencyRateList() {
        return new a<>(((MgtApiService) MgtRetrofit.request(MgtApiService.class)).getCurrencyRateList().compose(MgtRetrofit.h()));
    }

    public a<List<StableCoinHints>> getStableCoinHints() {
        return new a<>(((MgtApiService) MgtRetrofit.request(MgtApiService.class)).getStableCoinHints().compose(MgtRetrofit.h()));
    }
}
