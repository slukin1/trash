package com.hbg.lib.network.hbg.retrofit.service;

import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;
import rx.Observable;

public interface H5Service {
    @POST
    Observable<ResponseBody> postH5UrlRequest(@Url String str, @HeaderMap Map<String, String> map, @Body Map<String, Object> map2);

    @PUT
    Observable<ResponseBody> putH5UrlRequest(@Url String str, @HeaderMap Map<String, String> map, @Body Map<String, Object> map2);
}
