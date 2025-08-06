package com.hbg.lib.network.php.retrofit.service;

import com.hbg.lib.network.php.core.bean.CurrencyIntro;
import com.hbg.lib.network.php.core.bean.IndexMidSymbol;
import com.hbg.lib.network.php.core.bean.ZendeskTopNotice;
import com.hbg.lib.network.php.core.response.IntStatusResponse;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface PhpService {
    @GET("p/api/contents/app_index_symbols_v2")
    Observable<IntStatusResponse<List<IndexMidSymbol>>> getAppIndexSymbols();

    @GET("p/api/contents/pro/currency_introduction")
    Observable<IntStatusResponse<CurrencyIntro>> getCurrencyIntro(@QueryMap Map<String, Object> map);

    @GET
    Observable<ResponseBody> getH5UrlRequest(@Url String str, @HeaderMap Map<String, String> map, @QueryMap Map<String, Object> map2);

    @GET("p/api/contents/zendesk/json/articles")
    Observable<ZendeskTopNotice> getZendeskTopNotice(@QueryMap Map<String, String> map);

    @POST
    Observable<ResponseBody> postH5UrlRequest(@Url String str, @HeaderMap Map<String, String> map, @Body Map<String, Object> map2);
}
