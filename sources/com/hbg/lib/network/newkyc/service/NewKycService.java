package com.hbg.lib.network.newkyc.service;

import com.hbg.lib.network.newkyc.bean.AuthUserLevelInfo;
import com.hbg.lib.network.newkyc.bean.DominicaKycPageInfo;
import com.hbg.lib.network.newkyc.bean.KycCountryInfo;
import com.hbg.lib.network.newkyc.bean.KycSDKTokenInfo;
import com.hbg.lib.network.newkyc.bean.KycTicketInfo;
import com.hbg.lib.network.newkyc.bean.KycTokenInfo;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.newkyc.response.NewKycCodeResponse;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface NewKycService {
    @GET("v1/public/kyc/auth/step/get_ticket")
    Observable<NewKycCodeResponse<KycSDKTokenInfo>> fetchAuthToken(@QueryMap(encoded = true) Map<String, Object> map);

    @GET("v1/public/kyc/auth/step/get_ticket_v2")
    Observable<NewKycCodeResponse<KycSDKTokenInfo>> fetchAuthTokenV2(@QueryMap(encoded = true) Map<String, Object> map);

    @GET("v1/public/kyc/auth/get_auth_info")
    Observable<NewKycCodeResponse<UserKycInfoNew>> getAuthInfo();

    @GET("v1/public/kyc/auth/user/level")
    Observable<NewKycCodeResponse<AuthUserLevelInfo>> getAuthUserLevel();

    @GET("v1/public/kyc/digital/user/info")
    Observable<NewKycCodeResponse<DominicaKycPageInfo>> getDominicaKycPageInfo();

    @GET("v1/public/kyc/auth/country/list")
    Observable<NewKycCodeResponse<List<KycCountryInfo>>> getKycCountryList();

    @GET("v1/public/kyc/living_face/get_ticket")
    Observable<NewKycCodeResponse<KycTicketInfo>> getTicket(@QueryMap(encoded = true) Map<String, Object> map);

    @GET("v1/public/kyc/auth/info/get_v2")
    Observable<NewKycCodeResponse<UnifyKycInfo>> getUnifyKycInfoV2();

    @POST("v1/public/kyc/auth/jumio_submit/trigger")
    Observable<NewKycCodeResponse<String>> jumioKycSuccess(@Body Map<String, Object> map);

    @POST("v1/public/kyc/auth/submit/trigger")
    Observable<NewKycCodeResponse<String>> submitAuth(@Body Map<String, Object> map);

    @POST("/v1/public/kyc/living_face/submit")
    Observable<NewKycCodeResponse<String>> submitLiveness(@Body Map<String, Object> map);

    @POST("v1/public/kyc/auth/identity_self/living/submit")
    Observable<NewKycCodeResponse<String>> submitLivingIdentitySelf(@Body Map<String, Object> map);

    @POST("v1/public/common/uc/token/login")
    Observable<NewKycCodeResponse<KycTokenInfo>> userLogin(@Body Map<String, Object> map);
}
