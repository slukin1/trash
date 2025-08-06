package com.huobi.login.usercenter.data.source.api;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.lib.network.uc.retrofit.bean.UcAuthorizationBean;
import com.huobi.login.bean.AccountVerifyBean;
import com.huobi.login.bean.SecurityVerifyBean;
import com.huobi.login.usercenter.data.source.bean.BrushGaVerifyData;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import com.huobi.login.usercenter.data.source.bean.CountryInfo;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.usercenter.data.source.bean.GaGenerateData;
import com.huobi.login.usercenter.data.source.bean.ImgCaptchaData;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.bean.LogoutInfoData;
import com.huobi.login.usercenter.data.source.bean.RegisterResult;
import com.huobi.login.usercenter.data.source.bean.RetreatCountryData;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.ThirdAuth;
import com.huobi.login.usercenter.data.source.bean.ThirdAuthUrl;
import com.huobi.login.usercenter.data.source.bean.ThirdInfo;
import com.huobi.login.usercenter.data.source.bean.ThirdState;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.bean.TsvTokenWrapper;
import com.huobi.login.usercenter.data.source.bean.UcAppControl;
import com.huobi.login.usercenter.data.source.bean.UserContacts;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface UserCenterService {
    @POST("uc/open/login_password_reset/account_verify/v2")
    Observable<UcIntCodeResponse<AccountVerifyBean>> accountVerify(@Body Map<String, Object> map);

    @POST("uc/open/trading_pair/multiple/add")
    Observable<UcIntCodeResponse<Object>> addMultipleTradingPair(@Body Map<String, Object> map);

    @POST("uc/open/trading_pair/add")
    Observable<UcIntCodeResponse<Object>> addTradingPair(@Body Map<String, Object> map);

    @POST("uc/open/third/bind/v2")
    Observable<UcIntCodeResponse<Object>> bindV2WithThirdAccount(@Body Map<String, Object> map);

    @POST("uc/open/third/bind")
    Observable<UcIntCodeResponse<Object>> bindWithThirdAccount(@Body Map<String, Object> map);

    @POST("uc/open/trading_pair/cancel")
    Observable<UcIntCodeResponse<Object>> cancelTradingPair(@Body Map<String, Object> map);

    @GET("uc/open/login/check")
    Observable<UcIntCodeResponse<Object>> checkLogin();

    @POST("uc/open/trading_pair/multiple/edit")
    Observable<UcIntCodeResponse<Object>> editMultipleTradingPair(@Body Map<String, Object> map);

    @POST("uc/open/trading_pair/edit")
    Observable<UcIntCodeResponse<Object>> editTradingPair(@Body Map<String, Object> map);

    @GET("uc/open/ga/generate_for_change")
    Observable<UcIntCodeResponse<GaGenerateData>> gaGenerateForChange(@Query("type") String str);

    @GET("uc/open/authorization/get")
    Observable<UcIntCodeResponse<UcAuthorizationBean>> getAuthorization(@Query("auth_use_type") String str);

    @GET("uc/open/user/contacts/get")
    Observable<UcIntCodeResponse<List<UserContacts>>> getContacts(@QueryMap Map<String, Object> map);

    @GET("uc/open/country_id/get")
    Observable<UcIntCodeResponse<CountryInfo>> getCountryIdByIP(@Query("show_region") int i11);

    @POST("uc/open/query/email/send/result")
    Observable<UcIntCodeResponse<String>> getEmailSendResult(@Body Map<String, Object> map);

    @GET("uc/open/kv_store/get")
    Observable<UcIntCodeResponse<KvStore>> getKvStore(@Query("website") String str, @Query("store_key") String str2);

    @GET("uc/open/trading_pair/multiple/list")
    Observable<UcIntCodeResponse<List<String>>> getMultipleTradingPair(@Query("websites") List<String> list);

    @GET("uc/open/email/shielding_words")
    Observable<UcIntCodeResponse<List<String>>> getRegisterShieldWords();

    @GET("uc/open/check/retreat_country")
    Observable<UcIntCodeResponse<RetreatCountryData>> getRetreatCountry();

    @GET("uc/open/security/strategy/get")
    Observable<UcIntCodeResponse<SecurityStrategySet>> getSecurityStrategyWithParams(@QueryMap Map<String, Object> map);

    @POST("uc/open/third/auth")
    Observable<UcIntCodeResponse<ThirdAuth>> getThirdAuth(@Body Map<String, Object> map);

    @POST("uc/open/third/auth_url")
    Observable<UcIntCodeResponse<ThirdAuthUrl>> getThirdAuthUrl(@Body Map<String, Object> map);

    @POST("uc/open/third/state/get")
    Observable<UcIntCodeResponse<ThirdState>> getThirdState(@Body Map<String, Object> map);

    @GET("uc/open/trading_pair/list")
    Observable<UcIntCodeResponse<List<String>>> getTradingPair(@Query("website") String str);

    @POST("uc/open/login_password/verify")
    Observable<UcIntCodeResponse<Object>> loginPasswordVerify(@Body Map<String, Object> map);

    @POST("uc/open/third/login")
    Observable<UcIntCodeResponse<LoginInfoData>> loginWithThirdAccount(@Body Map<String, Object> map);

    @POST("uc/open/kv_store/put")
    Observable<UcIntCodeResponse<Object>> putKvStore(@Body Map<String, Object> map);

    @POST("uc/open/email/rebind")
    Observable<UcIntCodeResponse<Object>> rebindEmail(@Body Map<String, Object> map);

    @POST("uc/open/asset_ga/change")
    Observable<UcIntCodeResponse<Object>> rebindGa(@Body Map<String, Object> map);

    @POST("uc/open/phone/rebind")
    Observable<UcIntCodeResponse<Object>> rebindPhone(@Body Map<String, Object> map);

    @POST("uc/open/register_code/verify")
    Observable<UcIntCodeResponse<Object>> registerCodeVerify(@Body Map<String, Object> map);

    @POST("uc/open/email/bind")
    Observable<UcIntCodeResponse<TsvTokenWrapper>> requestBindEmail(@Body Map<String, Object> map);

    @POST("uc/open/asset_ga/bind")
    Observable<UcIntCodeResponse<Object>> requestBindGa(@Body Map<String, Object> map);

    @POST("uc/open/phone/bind")
    Observable<UcIntCodeResponse<TsvTokenWrapper>> requestBindPhone(@Body Map<String, Object> map);

    @GET("uc/open/countryCode/list")
    Observable<UcIntCodeResponse<List<CountryListData>>> requestCountryCodeList();

    @GET("uc/open/country/list")
    Observable<UcIntCodeResponse<List<CountryListData>>> requestCountryList();

    @POST("uc/open/email_code/send")
    @Headers({"HUOBI-BUSINESS:PRO"})
    Observable<UcIntCodeResponse<Object>> requestEmailCode(@Body Map<String, Object> map);

    @GET("uc/open/ga/generate")
    Observable<UcIntCodeResponse<GaGenerateData>> requestGaGenerateInfo(@Query("type") String str);

    @POST("uc/open/ga/login")
    Observable<UcIntCodeResponse<LoginInfoData>> requestGaLogin(@Body Map<String, Object> map);

    @GET("uc/open/captcha_code/send")
    Observable<UcIntCodeResponse<ImgCaptchaData>> requestImgCaptcha();

    @POST("uc/open/license/agree")
    Observable<UcIntCodeResponse<Object>> requestLicenseAgree(@Body Map<String, Object> map);

    @GET("uc/open/license/state")
    Observable<UcIntCodeResponse<TradeRiskReminder>> requestLicenseState(@Query("type") String str);

    @POST("uc/open/login")
    Observable<UcIntCodeResponse<LoginInfoData>> requestLogin(@Body Map<String, Object> map);

    @POST("uc/open/2fa/login")
    Observable<UcIntCodeResponse<LoginInfoData>> requestLogin2FA(@Body Map<String, Object> map);

    @GET("uc/open/logout")
    Observable<UcIntCodeResponse<LogoutInfoData>> requestLogout();

    @GET
    Observable<Object> requestLogoutUrl(@Url String str);

    @GET("uc/open/register/phone/country/list")
    Observable<UcIntCodeResponse<List<CountryListData>>> requestRegisterCountryCodeList();

    @POST("uc/open/register")
    Observable<UcIntCodeResponse<RegisterResult>> requestRegisterUser(@Body Map<String, Object> map);

    @POST("uc/open/auth_code/register")
    Observable<UcIntCodeResponse<RegisterResult>> requestRegisterUserByAuthCode(@Body Map<String, Object> map);

    @POST("uc/open/risk/control")
    Observable<UcIntCodeResponse<RiskControl>> requestRiskControl(@Body Map<String, Object> map);

    @GET("uc/open/security/strategy/get")
    Observable<UcIntCodeResponse<SecurityStrategySet>> requestSecurityStrategy();

    @POST("uc/open/security/strategy/smart/verify")
    Observable<UcIntCodeResponse<CodeVerifyData>> requestSecurityStrategySmartVerify(@Body Map<String, Object> map);

    @POST("uc/open/security/strategy/verify")
    Observable<UcIntCodeResponse<CodeVerifyData>> requestSecurityStrategyVerify(@Body Map<String, Object> map);

    @POST("uc/open/sms_code/send")
    @Headers({"HUOBI-BUSINESS:PRO"})
    Observable<UcIntCodeResponse<Object>> requestSmsCode(@Body Map<String, Object> map);

    @POST("uc/open/security/strategy/disable")
    Observable<UcIntCodeResponse<CodeVerifyData>> requestStrategyDisable(@Body Map<String, Object> map);

    @POST("uc/open/security/strategy/enable")
    Observable<UcIntCodeResponse<Object>> requestStrategyEnable(@Body Map<String, Object> map);

    @GET("uc/open/ticket/get")
    Observable<UcIntCodeResponse<LoginInfoData>> requestTicket();

    @POST("uc/open/bitex/user/audit/ga/generate")
    Observable<UcIntCodeResponse<GaGenerateData>> requestUnLoginGaInfo(@Body Map<String, Object> map);

    @GET("uc/open/user/get")
    Observable<UcIntCodeResponse<UserInfoData>> requestUserInfo();

    @GET("uc/open/user/get_ext_info")
    Observable<UcIntCodeResponse<UserOtherInfoData>> requestUserOtherInfo();

    @GET("uc/open/security/get")
    Observable<UcIntCodeResponse<UserSecurityInfoData>> requestUserSecurityInfo();

    @POST("uc/open/bitex/user/audit/verify_ga_code")
    Observable<UcIntCodeResponse<BrushGaVerifyData>> requestVerifyBrushGaCode(@Body Map<String, Object> map);

    @POST("uc/open/email_code/verify")
    Observable<UcIntCodeResponse<CodeVerifyData>> requestVerifyEmailCode(@Body Map<String, Object> map);

    @POST("uc/open/ga_code/verify")
    Observable<UcIntCodeResponse<CodeVerifyData>> requestVerifyGaCode(@Body Map<String, Object> map);

    @POST("uc/open/sms_code/verify")
    Observable<UcIntCodeResponse<CodeVerifyData>> requestVerifySmsCode(@Body Map<String, Object> map);

    @POST("uc/open/login_password/reset")
    Observable<UcIntCodeResponse<TsvTokenWrapper>> resetPassword(@Body Map<String, Object> map);

    @POST("uc/open/security/reset_password/risk_check")
    Observable<UcIntCodeResponse<TsvTokenWrapper>> resetPasswordRiskCheck(@Body Map<String, Object> map);

    @POST("uc/open/security/risk_check")
    Observable<UcIntCodeResponse<TsvTokenWrapper>> securityRiskCheck(@Body Map<String, Object> map);

    @POST("uc/open/login_password_reset/security_verify")
    Observable<UcIntCodeResponse<SecurityVerifyBean>> securityVerify(@Body Map<String, Object> map);

    @GET("uc/open/third/list")
    Observable<UcIntCodeResponse<List<ThirdInfo>>> thirdList(@Query("way") int i11);

    @GET("uc/open/app/control")
    Observable<UcIntCodeResponse<UcAppControl>> ucAppControl();

    @POST("uc/open/user_cid/save")
    Observable<UcIntCodeResponse<Object>> userCidSave(@Body Map<String, Object> map);

    @POST("uc/open/user/statistics")
    Observable<UcIntCodeResponse<Object>> userDau(@Body Map<String, Object> map);
}
