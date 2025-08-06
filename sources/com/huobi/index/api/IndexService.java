package com.huobi.index.api;

import com.hbg.lib.core.network.response.IntStatusResponse;
import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.hbg.lib.network.hbg.core.bean.HomeCommonData;
import com.hbg.lib.network.hbg.core.bean.HomePageNewHandAreaData;
import com.hbg.lib.network.hbg.core.bean.HomePageNewUserGiftBagData;
import com.hbg.lib.network.hbg.core.bean.HomePageRecommendRegionData;
import com.hbg.lib.network.hbg.core.bean.HomeTransferAmountData;
import com.hbg.lib.network.hbg.core.bean.ShareNewConfigInfo;
import com.huobi.account.entity.HomeActivityEntityResponse;
import com.huobi.entity.TopNotice;
import com.huobi.entity.UpdateResponse;
import com.huobi.index.bean.IndexFeature;
import com.huobi.index.bean.QuickAdditionFeature;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface IndexService {
    @GET("p/api/appFeatures/module/{code}")
    @Headers({"countryType:0"})
    Observable<IntStatusResponse<IndexFeature>> getAppFeatures(@Path("code") String str, @Header("HB-COUNTRY-ID") int i11, @QueryMap Map<String, Object> map);

    @GET("v1/hbg/open/message/unread-count")
    Observable<UcIntCodeResponse<Integer>> getMessageUnreadCount();

    @GET("v1/hbg/open/share/v2/config")
    Observable<IntStatusResponse<ShareNewConfigInfo>> getSharePageData(@HeaderMap Map<String, Object> map, @Query("pageId") String str, @Query("buttonId") String str2);

    @GET("p/api/contents/pro/top_notice")
    Observable<IntStatusResponse<TopNotice>> getTopNotice(@QueryMap Map<String, Object> map);

    @GET("v1/app-web-api/banner/list")
    Observable<IntStatusResponse<HomeActivityEntityResponse>> requestAdvertisements(@QueryMap Map<String, Object> map, @HeaderMap Map<String, Object> map2);

    @GET("p/api/app/update")
    Observable<UpdateResponse> requestAppUpdateInfo(@QueryMap Map<String, Object> map);

    @GET("v1/app/home/commonData")
    Observable<IntStatusResponse<HomeCommonData>> requestHomeCommonData(@HeaderMap Map<String, Object> map);

    @GET("p/api/appFeatures/module/more/{code}")
    Observable<IntStatusResponse<QuickAdditionFeature>> requestHomeFeatures(@Header("Accept-Language") String str, @Header("countryType") Integer num, @Path("code") String str2, @QueryMap Map<String, Object> map);

    @GET("v1/app/newUserHome/getTransferAmount")
    Observable<IntStatusResponse<HomeTransferAmountData>> requestHomeTransferAmountData(@HeaderMap Map<String, Object> map);

    @GET("/-/x/hbg/v1/app/new-region/data")
    Observable<IntStatusResponse<HomePageNewHandAreaData>> requestNewHandArea(@HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map2);

    @GET("v1/app/guide/queryNewUserGuide")
    Observable<IntStatusResponse<HomePageNewUserGiftBagData>> requestNewUserGiftBag(@HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map2);

    @GET("v1/app/recommend/queryRecommends")
    Observable<IntStatusResponse<HomePageRecommendRegionData>> requestRecommendRegion(@HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map2);

    @GET("p/api/appFeatures/module/cornerMark/click")
    Observable<Object> sendCornerMarkClickedMessage(@QueryMap Map<String, Object> map);

    @FormUrlEncoded
    @POST("p/api/contents/appusecount/add")
    Observable<IntStatusResponse<String>> sendUid(@FieldMap Map<String, Object> map);

    @POST("p/api/appFeatures/module/user/set")
    Observable<IntStatusResponse<String>> updateHomeFeatures(@Body Map<String, Object> map);
}
