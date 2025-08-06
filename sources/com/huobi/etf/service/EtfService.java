package com.huobi.etf.service;

import com.hbg.lib.core.network.response.EtfCodeResponse;
import com.huobi.etf.entity.EtfToken;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface EtfService {
    @GET("open/login")
    Observable<EtfCodeResponse<EtfToken>> getEtfToken(@Query("ticket") String str);
}
