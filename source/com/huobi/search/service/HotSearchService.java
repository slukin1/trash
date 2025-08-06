package com.huobi.search.service;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.huobi.search.bean.HotSearchInfo;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

public interface HotSearchService {
    @POST("v1/hbg/open/invite/appSearch/collect")
    Observable<UcIntCodeResponse<Object>> collectHotSearch(@Body Map<String, Object> map);

    @GET("v1/hbg/open/invite/appSearch/list")
    Observable<UcIntCodeResponse<HotSearchInfo>> getHotSearchList();
}
