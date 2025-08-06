package com.huobi.compliance;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import retrofit2.http.GET;
import rx.Observable;

public interface ComplianceService {
    @GET("v1/hbg/open/limitUSA/getLimitCode")
    Observable<UcIntCodeResponse<Integer>> getLimitCode();
}
