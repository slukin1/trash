package com.huobi.kyc.service;

import com.hbg.lib.core.network.response.StringStatusResponse;
import com.huobi.kyc.bean.CountryKyc;
import com.huobi.kyc.bean.PhpLogin;
import java.util.List;
import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

public interface KycService {
    @POST("api/user_auth.php")
    @Headers({"Referer:https://www.huobi.com"})
    Observable<StringStatusResponse<String>> chineseAuth(@Body Map<String, Object> map);

    @POST("api/user_auth.php")
    @Headers({"Referer:https://www.huobi.com"})
    Observable<StringStatusResponse<String>> doAuthPro(@Body Map<String, Object> map);

    @Multipart
    @POST("api/user_auth.php")
    @Headers({"Referer:https://www.huobi.com"})
    Observable<StringStatusResponse<String>> doUploadPic(@Part("method") RequestBody requestBody, @Part("auth_type") RequestBody requestBody2, @Part("index") RequestBody requestBody3, @Part MultipartBody.Part part);

    @POST("api/user_auth.php")
    @Headers({"Referer:https://www.huobi.com"})
    Observable<StringStatusResponse<List<CountryKyc>>> getCountryList(@Body Map<String, Object> map);

    @POST("api/uc.php")
    @Headers({"Referer:https://www.huobi.com"})
    Observable<StringStatusResponse<PhpLogin>> ucLogin(@Body Map<String, Object> map);
}
