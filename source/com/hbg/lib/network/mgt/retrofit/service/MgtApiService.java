package com.hbg.lib.network.mgt.retrofit.service;

import com.hbg.lib.network.mgt.core.bean.LegalRateBean;
import com.hbg.lib.network.mgt.core.response.UcIntCodeResponse;
import com.huobi.currencyconfig.bean.StableCoinHints;
import java.util.List;
import retrofit2.http.GET;
import rx.Observable;

public interface MgtApiService {
    @GET("general/exchange_rate/list")
    Observable<UcIntCodeResponse<List<LegalRateBean>>> getCurrencyRateList();

    @GET("general/exchange_rate/v1/stableCoin/hints")
    Observable<UcIntCodeResponse<List<StableCoinHints>>> getStableCoinHints();
}
