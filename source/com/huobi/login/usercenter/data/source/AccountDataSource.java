package com.huobi.login.usercenter.data.source;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.huobi.login.bean.AccountVerifyBean;
import com.huobi.login.bean.SecurityVerifyBean;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import com.huobi.login.usercenter.data.source.bean.GaGenerateData;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.bean.TsvTokenWrapper;
import com.huobi.login.usercenter.data.source.bean.UserContacts;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface AccountDataSource {
    Observable<UcIntCodeResponse<AccountVerifyBean>> accountVerify(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<Object>> addMultipleTradingPair(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<Object>> addTradingPair(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<TsvTokenWrapper>> bindEmail(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<Object>> bindGa(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<TsvTokenWrapper>> bindPhone(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<Object>> cancelTradingPair(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<Object>> editTradingPair(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<List<UserContacts>>> getContacts(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<String>> getEmailSendResult(@Body Map<String, Object> map);

    Observable<KvStore> getKvStore(@Query("website") String str, @Query("store_key") String str2);

    @GET("uc/open/email/shielding_words")
    Observable<UcIntCodeResponse<List<String>>> getRegisterShieldWords();

    Observable<UcIntCodeResponse<CodeVerifyData>> getSecurityStrategySmartVerify(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<CodeVerifyData>> getSecurityStrategyVerify(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<SecurityStrategySet>> getSecurityStrategyWithParams(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<List<String>>> getTradingPair(@Query("website") String str);

    Observable<UcIntCodeResponse<CodeVerifyData>> getVerifyEmailCode(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<CodeVerifyData>> getVerifyGaCode(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<CodeVerifyData>> getVerifySmsCode(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<Object>> loginPasswordVerify(@Body Map<String, Object> map);

    Observable<Object> putKvStore(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<Object>> rebindEmail(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<Object>> rebindGa(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<Object>> rebindPhone(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<Object>> registerCodeVerify(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<GaGenerateData>> requestGaGenerateInfo(@Query("type") String str);

    Observable<UcIntCodeResponse<Object>> requestLicenseAgree(@Body Map<String, Object> map);

    Observable<TradeRiskReminder> requestLicenseState(@Query("type") String str, boolean z11);

    Observable<UcIntCodeResponse<RiskControl>> requestRiskControl(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<TsvTokenWrapper>> resetPassword(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<SecurityVerifyBean>> securityVerify(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<CodeVerifyData>> strategyDisable(@Body Map<String, Object> map);

    Observable<UcIntCodeResponse<Object>> strategyEnable(@Body Map<String, Object> map);
}
