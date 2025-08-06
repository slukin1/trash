package com.huobi.otc.service;

import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.network.otc.core.OTCPageListExtendResponse;
import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import com.hbg.lib.network.otc.core.OTCStatusResponse;
import com.hbg.lib.network.otc.core.OTCStatusStringExtendResponse;
import com.huobi.account.entity.LegalQueryData;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.bean.MakerAdsHeader;
import com.huobi.otc.bean.MarketCoin;
import com.huobi.otc.bean.OtcAdvertLabelBean;
import com.huobi.otc.bean.OtcChatContentList;
import com.huobi.otc.bean.OtcNewOrderInfo;
import com.huobi.otc.bean.ReminderData;
import com.huobi.otc.bean.UserPayMethodBean;
import com.huobi.otc.bean.VoiceInfo;
import com.huobi.otc.bean.VoiceSignInfo;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface OTCService {
    @POST("v1/user/merchant/sea-view-room/advertise-up")
    Observable<OTCStatusResponse<Object>> addSeaViewRoom(@Body Map<String, Object> map);

    @FormUrlEncoded
    @POST("v1/trade/order/negotiation/cancel/confirm")
    Observable<OTCStatusResponse<Boolean>> cancelConfirm(@FieldMap Map<String, Object> map);

    @POST("v1/otc/trade/{tradeId}/close")
    Observable<OTCStatusResponse<Object>> closeMakerAds(@Path("tradeId") String str);

    @POST("v1/user/notice/switch/app_advert/off")
    Observable<OTCStatusResponse<Object>> closeMakerStatus();

    @POST("v1/otc/trade/{tradeId}/delete")
    Observable<OTCStatusResponse<Object>> deleteMakerAds(@Path("tradeId") String str);

    @POST("v1/user/merchant/sea-view-room/advertise-down")
    Observable<OTCStatusResponse<Object>> downSeaViewRoom(@Body Map<String, Object> map);

    @GET("v1/chat/{orderId}")
    Observable<OTCStatusResponse<OtcChatContentList>> getChatList(@Path("orderId") String str, @QueryMap Map<String, Object> map);

    @GET("v1/data/trade-list/app")
    Observable<OTCStatusResponse<List<Ads>>> getMakerAdsList(@QueryMap Map<String, String> map);

    @GET("v1/data/config-list?type=coin")
    Observable<OTCStatusResponse<MarketCoin>> getMarketCoinList();

    @GET("v1/data/trade-list/{uid}")
    Observable<OTCStatusResponse<List<Ads>>> getMercOnlineBuySellList(@Path("uid") long j11, @QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST("v1/trade/merchant/order/list/refresh")
    Observable<OTCStatusResponse<OtcNewOrderInfo>> getNewOrder(@FieldMap Map<String, Object> map);

    @GET("v1/trade/order/buoy-remind")
    Observable<OTCStatusResponse<ReminderData>> getOrderFloatInfo();

    @GET("v1/user/receipt-account")
    Observable<OTCStatusResponse<List<UserPayMethodBean>>> getPayMethods();

    @GET("v1/data/trade-market")
    Observable<OTCPageListExtendResponse<List<Ads>, List<OtcAdvertLabelBean>>> getPublicAds(@Query("coinId") int i11, @Query("tradeType") String str, @QueryMap Map<String, String> map);

    @POST("v1/otc/transfer")
    Observable<StringStatusResponse<String>> getTransferResult(@Body Map<String, Object> map);

    @GET("v1/chat/voice/info")
    Observable<OTCStatusResponse<VoiceInfo>> getVoiceInfo(@QueryMap Map<String, Object> map);

    @GET("v1//chat/voice/sign")
    Observable<OTCStatusResponse<VoiceSignInfo>> getVoiceSign(@QueryMap Map<String, Object> map);

    @GET("v1/capital/balance/{coinId}")
    Observable<OTCStatusResponse<LegalQueryData>> getWalletByCoinId(@Path("coinId") int i11);

    @GET("v1/otc/trade/watchword/search")
    Observable<OTCStatusStringExtendResponse<Ads>> getWordAd(@Query("text") String str);

    @FormUrlEncoded
    @POST("v1/otc/trade/{tradeId}/open")
    Observable<OTCStatusExtendResponse<Object>> openMakerAds(@Path("tradeId") String str, @Field("tradeCount") String str2, @Header("x-dialog-trace-id") String str3);

    @POST("v1/user/notice/switch/app_advert/on")
    Observable<OTCStatusResponse<Object>> openMakerStatus();

    @GET("v1/user/notice/switch")
    Observable<OTCStatusResponse<MakerAdsHeader>> queryMakerStatus();

    @GET("v1/user/merchant/sea-view-room/up")
    Observable<OTCStatusResponse<Boolean>> querySeaViewRoomStatus();

    @FormUrlEncoded
    @POST("v1/trade/instruction/initiate")
    Observable<OTCStatusResponse<Boolean>> requestC2cOrderTransConfirm(@FieldMap Map<String, Object> map);

    @POST("v1/chat/voice/message")
    Observable<OTCStatusResponse<Boolean>> voiceCallBack(@Body Map<String, Object> map);
}
