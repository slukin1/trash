package com.huobi.control.api;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.core.bean.TeachConfig;
import com.huobi.control.bean.ABTestConfig;
import com.huobi.control.bean.BizControlConfig;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ControlConfigService {
    @GET("v1/integration/ab/test/get")
    Observable<UcIntCodeResponse<ABTestConfig>> getABTestConfig(@Query("uniqueId") String str);

    @GET("v1/hbg/open/biz/control/config")
    Observable<HbgIntCodeResponse<BizControlConfig>> getBizControlConfig();

    @GET("v1/hbg/open/teach/config")
    Observable<UcIntCodeResponse<TeachConfig>> getTeachConfig();
}
