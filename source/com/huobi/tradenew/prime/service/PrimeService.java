package com.huobi.tradenew.prime.service;

import com.google.gson.JsonObject;
import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.hbg.lib.data.symbol.PrimeInfo;
import com.hbg.lib.network.hbg.prime.PrimeResult;
import com.huobi.trade.prime.bean.AliToken;
import com.huobi.trade.prime.bean.AvailableLimit;
import com.huobi.trade.prime.bean.PrimeAveragePosition;
import com.huobi.trade.prime.bean.PrimeBidOrderPlaceResult;
import com.huobi.trade.prime.bean.PrimeOrderBean;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface PrimeService {
    @POST("prime/v1/bid/order/orders/{order-id}/submitcancel")
    Observable<UcIntCodeResponse<String>> bidCancelLuckyOrder(@Path("order-id") long j11);

    @POST("prime/v1/bid/order/place")
    Observable<UcIntCodeResponse<PrimeBidOrderPlaceResult>> bidOrderPlace(@Body Map<String, Object> map);

    @POST("prime/v1/po/order/orders/{order-id}/submitcancel")
    Observable<UcIntCodeResponse<String>> cancelLuckyOrder(@Path("order-id") long j11);

    @GET("prime/v1/slider/alitoken")
    Observable<UcIntCodeResponse<AliToken>> getAliToken();

    @GET("prime/v1/user/availableLimit")
    Observable<UcIntCodeResponse<AvailableLimit>> getAvailableLimit();

    @GET("prime/v1/averagePosition/get")
    Observable<UcIntCodeResponse<PrimeAveragePosition>> getAveragePosition();

    @GET("prime/v1/averagePosition/list")
    Observable<JsonObject> getAveragePositionListStr();

    @GET("prime/v1/averagePosition/get")
    Observable<JsonObject> getAveragePositionStr();

    @GET("prime/v1/bid/order/orders")
    Observable<UcIntCodeResponse<List<PrimeOrderBean>>> getPrimeBidOrders(@QueryMap Map<String, Object> map);

    @GET("prime/v1/bid/result")
    Observable<UcIntCodeResponse<PrimeResult>> getPrimeBidResult();

    @GET("prime/v1/get")
    Observable<UcIntCodeResponse<PrimeInfo>> getPrimeInfo();

    @GET("prime/v1/user/limit")
    Observable<UcIntCodeResponse<String>> getPrimeLimit();

    @GET("prime/v1/po/order/orders")
    Observable<UcIntCodeResponse<List<PrimeOrderBean>>> getPrimeOrders(@QueryMap Map<String, Object> map);

    @GET("prime/v1/po/result")
    Observable<UcIntCodeResponse<PrimeResult>> getPrimeResult();

    @POST("prime/v1/po/order/place")
    Observable<UcIntCodeResponse<String>> luckyOrderPlace(@Body Map<String, Object> map);

    @POST("prime/v1/order/place")
    Observable<UcIntCodeResponse<String>> orderPlace(@Body Map<String, Object> map);

    @POST("prime/v1/app/login/check")
    Observable<UcIntCodeResponse<Object>> sendDeviceInfo2Hbg(@Body Map<String, String> map);
}
