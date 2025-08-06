package com.huobi.staring.service;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.huobi.staring.bean.AllRulesResult;
import com.huobi.staring.bean.CustomRuleListResult;
import com.huobi.staring.bean.CustomSaveResult;
import com.huobi.staring.bean.RemindCustomSub;
import com.huobi.staring.bean.RuleConfigResult;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface StaringRemindService {
    @GET("uc/open/custom_rule/sub_list")
    Observable<UcIntCodeResponse<CustomRuleListResult>> requestAllCustomSubRules(@Query("type") int i11);

    @GET("uc/open/symbol_rule/sub_list")
    Observable<UcIntCodeResponse<CustomRuleListResult>> requestAllRules(@Query("type") int i11);

    @GET("uc/open/rule/list")
    Observable<UcIntCodeResponse<AllRulesResult>> requestAllRulesBySymbol(@Query("symbol") String str, @Query("type") int i11);

    @POST("uc/open/symbol_rule/all_unsub")
    Observable<UcIntCodeResponse<Object>> requestCancelAllRules(@Body Map<String, Object> map);

    @GET("uc/open/rule/sub_check")
    Observable<UcIntCodeResponse<RemindCustomSub>> requestCustomSub(@Query("symbol") String str, @Query("type") int i11);

    @POST("uc/open/custom_rule/price/del")
    Observable<UcIntCodeResponse<Object>> requestDeleteCustomRule(@Body Map<String, Object> map);

    @GET("uc/open/rule/config")
    Observable<UcIntCodeResponse<RuleConfigResult>> requestRuleConfigList(@Query("type") int i11);

    @POST("uc/open/custom_rule/price/save")
    Observable<UcIntCodeResponse<CustomSaveResult>> requestSaveCustomRule(@Body Map<String, Object> map);
}
