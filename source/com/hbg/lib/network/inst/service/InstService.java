package com.hbg.lib.network.inst.service;

import com.hbg.lib.network.inst.bean.InstStateInfo;
import com.hbg.lib.network.inst.bean.InstTokenInfo;
import com.hbg.lib.network.inst.response.InstCodeResponse;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface InstService {
    @GET("onboard/v1/hbg/open/inst/application/state")
    Observable<InstCodeResponse<InstStateInfo>> getInstStateInfo();

    @GET("auth/getToken")
    Observable<InstCodeResponse<InstTokenInfo>> userLogin(@QueryMap Map<String, Object> map);
}
