package com.huobi.account.api;

import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.huobi.account.entity.RateList;
import com.huobi.account.entity.StepUserRateInfo;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface StepRateService {
    @GET("v1/step-rate/user-rate/info")
    Observable<StringStatusResponse<StepUserRateInfo>> getUserRateInfo(@Query("business-type") String str);

    @GET("v1/step-rate/user-step-rate/info")
    Observable<StringStatusResponse<RateList>> getUserStepRate();

    @POST("/-/x/hbg/v1/fee/switch")
    Observable<UcIntCodeResponse<Boolean>> updateRateSwitch(@Body Map<String, Object> map);

    @POST("v1/step-rate/update-switch")
    Observable<StringStatusResponse<Boolean>> updateStepRateSwitch(@Body Map<String, Object> map);
}
