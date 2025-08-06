package com.huobi.home.api;

import com.hbg.lib.core.network.response.IntStatusResponse;
import com.huobi.home.data.HomepageConfig;
import com.huobi.home.data.TransferAmountInfo;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import rx.Observable;

public interface HomeService {
    @GET("/-/x/hbg/v1/app/home/queryHomeModules")
    Observable<IntStatusResponse<HomepageConfig>> getHomeConfigList(@HeaderMap Map<String, Object> map);

    @GET("/-/x/hbg/v1/app/guide/getTransferAmountInfo")
    Observable<IntStatusResponse<TransferAmountInfo>> getTransferAmountInfo(@HeaderMap Map<String, Object> map);
}
