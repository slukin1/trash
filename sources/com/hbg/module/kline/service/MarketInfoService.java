package com.hbg.module.kline.service;

import com.hbg.lib.network.pro.core.response.IntCodeResponse;
import com.hbg.module.kline.bean.EtfInfo;
import com.hbg.module.kline.bean.EtfIngredient;
import com.hbg.module.kline.bean.IndexDetail;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MarketInfoService {
    @GET("open/etf/info")
    Observable<IntCodeResponse<EtfInfo>> getEtfInfo(@Query("etf_name") String str);

    @GET("open/etf/account/info")
    Observable<IntCodeResponse<List<EtfIngredient>>> getEtfIngredient(@Query("etf_name") String str);

    @GET("general/index/constituent_symbol/detail")
    Observable<IntCodeResponse<IndexDetail>> getIndexIngredient();
}
