package com.huobi.statistics.hbg.api;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

public interface HbgAnalyticsService {
    @POST("v1/hbg/open/data/collection")
    Observable<UcIntCodeResponse<Object>> collectionData(@Body Map<String, Object> map);

    @POST
    Observable<UcIntCodeResponse<Object>> reportData(@Url String str, @Body Map<String, Object> map);
}
