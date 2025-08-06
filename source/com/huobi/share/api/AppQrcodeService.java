package com.huobi.share.api;

import com.hbg.lib.core.network.response.IntStatusResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface AppQrcodeService {
    @GET("p/api/app/last/version")
    Observable<IntStatusResponse<String>> fetchAppQrcdeLink(@Query("agent") String str);
}
