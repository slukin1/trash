package com.hbg.lib.network.uc.retrofit.service;

import com.hbg.lib.network.uc.core.response.UcIntCodeResponse;
import com.hbg.lib.network.uc.retrofit.bean.DynamicLangData;
import com.hbg.lib.network.uc.retrofit.bean.UcAuthorizationBean;
import com.huobi.login.usercenter.data.source.bean.AuthCodeLoginRegisterAbtestData;
import com.huobi.login.usercenter.data.source.bean.ChallengeTypeData;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import com.huobi.login.usercenter.data.source.bean.FollowTypeData;
import com.huobi.login.usercenter.data.source.bean.ImgCaptchaData;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.bean.PasskeyAbtestData;
import com.huobi.login.usercenter.data.source.bean.PasskeyListData;
import com.huobi.login.usercenter.data.source.bean.PasskeyLoginData;
import com.huobi.login.usercenter.data.source.bean.PasskeyVerifyData;
import com.huobi.login.usercenter.data.source.bean.RegisterCheckIpData;
import com.huobi.login.usercenter.data.source.bean.RegisterPreliminaryCheckData;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.login.usercenter.data.source.bean.UserSecurityLoginListData;
import com.huobi.login.usercenter.data.source.bean.VerifyAuthCodeData;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface UserCenterService {
    @POST("uc/open/auth_code_login_register/abtest")
    Observable<UcIntCodeResponse<AuthCodeLoginRegisterAbtestData>> authCodeLoginRegisterAbtest(@Body Map<String, Object> map);

    @GET("uc/open/login/check")
    Observable<UcIntCodeResponse<Object>> checkLogin();

    @POST("uc/open/passkey/create")
    Observable<UcIntCodeResponse<Object>> createPasskey(@Body Map<String, Object> map);

    @GET("uc/open/authorization/get")
    Observable<UcIntCodeResponse<UcAuthorizationBean>> getAuthorization(@Query("auth_use_type") String str);

    @POST("uc/open/passkey/get_challenge")
    Observable<UcIntCodeResponse<ChallengeTypeData>> getChallenge(@Body Map<String, Object> map);

    @GET("uc/open/dynamic_language/list")
    Observable<UcIntCodeResponse<List<DynamicLangData>>> getDynamicLanguage();

    @GET
    Observable<ResponseBody> getH5UrlRequest(@Url String str, @HeaderMap Map<String, String> map, @QueryMap Map<String, Object> map2);

    @POST("uc/open/login/flow_type")
    Observable<UcIntCodeResponse<FollowTypeData>> loginNameIsInvalid(@Body Map<String, Object> map);

    @GET("uc/open/login_token/get")
    Observable<UcIntCodeResponse<String>> loginTokenGet(@Query("way") String str);

    @GET("uc/open/passkey/abtest")
    Observable<UcIntCodeResponse<PasskeyAbtestData>> passkeyABTest();

    @POST("uc/open/passkey/delete")
    Observable<UcIntCodeResponse<Object>> passkeyDelete(@Body Map<String, Object> map);

    @GET("uc/open/passkey/list")
    Observable<UcIntCodeResponse<PasskeyListData>> passkeyList();

    @POST("uc/open/passkey/login")
    Observable<UcIntCodeResponse<PasskeyLoginData>> passkeyLogin(@Body Map<String, Object> map);

    @POST("uc/open/passkey/update/remark")
    Observable<UcIntCodeResponse<Object>> passkeyUpdateRemark(@Body Map<String, Object> map);

    @GET("uc/open/passkey/verify_2fa/switch")
    Observable<UcIntCodeResponse<PasskeyVerifyData>> passkeyVerify();

    @POST
    Observable<ResponseBody> postH5UrlRequest(@Url String str, @HeaderMap Map<String, String> map, @Body Map<String, Object> map2);

    @GET("uc/open/register/check_ip")
    Observable<UcIntCodeResponse<RegisterCheckIpData>> registerCheckIp();

    @POST("uc/open/register/preliminary/check")
    Observable<UcIntCodeResponse<RegisterPreliminaryCheckData>> registerPreliminaryCheck(@Body Map<String, Object> map);

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

    @POST("uc/open/risk/control")
    Observable<UcIntCodeResponse<RiskControl>> requestRiskControl(@Body Map<String, Object> map);

    @GET("uc/open/security/strategy/get")
    Observable<UcIntCodeResponse<SecurityStrategySet>> requestSecurityStrategy();

    @GET("uc/open/ticket/get")
    Observable<UcIntCodeResponse<LoginInfoData>> requestTicket();

    @GET("uc/open/security/get")
    Observable<UcIntCodeResponse<UserSecurityInfoData>> requestUserSecurityInfo();

    @GET("uc/open/login_log/list")
    Observable<UcIntCodeResponse<List<UserSecurityLoginListData>>> requestUserSecurityLoginListData(@Query("offset") int i11, @Query("limit") int i12);

    @POST("uc/open/sms_code/verify")
    Observable<UcIntCodeResponse<CodeVerifyData>> requestVerifySmsCode(@Body Map<String, Object> map);

    @POST("uc/open/record/Login_history")
    Observable<UcIntCodeResponse<String>> uploadLoginHistory(@Body Map<String, Object> map);

    @POST("uc/open/login_register/verify_auth_code")
    Observable<UcIntCodeResponse<VerifyAuthCodeData>> verifyAuthCode(@Body Map<String, Object> map);
}
