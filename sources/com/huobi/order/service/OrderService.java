package com.huobi.order.service;

import com.hbg.lib.core.network.response.IntStatusResponse;
import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.network.pro.core.bean.AlgoOrderMatchResult;
import com.hbg.lib.network.pro.core.response.IntCodeResponse;
import com.huobi.order.bean.OrderBean;
import com.huobi.order.bean.OrderBeanDetails;
import com.huobi.trade.bean.TradeOrderAssets;
import com.huobi.trade.bean.TradeOrderOutstanding;
import com.huobi.trade.bean.TradeOrderPositions;
import com.huobi.trade.prime.bean.TradeOrderNum;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface OrderService {
    @POST("v1/order/orders")
    Observable<StringStatusResponse<Long>> createOrder(@HeaderMap Map<String, Object> map, @Body Map<String, Object> map2);

    @GET("v1/hbg/super-margin/assets-details")
    Observable<StringStatusResponse<List<TradeOrderAssets>>> getAssets(@QueryMap Map<String, Object> map);

    @GET("v1/order/orders/{order-id}")
    Observable<StringStatusResponse<OrderBean>> getOrder(@Path("order-id") long j11);

    @GET("v1/order/orders")
    Observable<StringStatusResponse<List<OrderBean>>> getOrders(@QueryMap Map<String, Object> map);

    @GET("v1/hbg/super-margin/outstanding-details")
    Observable<StringStatusResponse<List<TradeOrderOutstanding>>> getOutstanding(@QueryMap Map<String, Object> map);

    @GET("v1/margin/accounts/assets-details")
    Observable<StringStatusResponse<List<TradeOrderPositions>>> getPositions(@QueryMap Map<String, Object> map);

    @GET("v2/algo-orders/openNums")
    Observable<IntStatusResponse<TradeOrderNum>> getTradeOrderNum(@Query("accountType") String str);

    @POST("v1/hadax/order/orders/place")
    Observable<StringStatusResponse<String>> hadaxOrderPlace(@HeaderMap Map<String, Object> map, @Body Map<String, Object> map2);

    @GET("v1/order/orders/{order-id}/matchresults")
    Observable<StringStatusResponse<List<OrderBeanDetails>>> matchResults(@Path("order-id") String str);

    @GET("v1/order/matchresults")
    Observable<StringStatusResponse<List<OrderBeanDetails>>> matchResultsList(@Query("symbols") String str, @Query("size") int i11, @Query("types") String str2, @Query("from") String str3, @Query("start-time") Long l11, @Query("end-time") Long l12);

    @GET("v2/algo-orders/periodMatchResult")
    Observable<IntCodeResponse<List<AlgoOrderMatchResult>>> matchTimeResultsList(@QueryMap Map<String, Object> map);

    @POST("v1/order/orders/place")
    Observable<StringStatusResponse<String>> proOrdersPlace(@HeaderMap Map<String, Object> map, @Body Map<String, Object> map2);

    @POST("v1/order/orders/{order-id}/submitcancel")
    Observable<StringStatusResponse<Long>> submitCancel(@Path("order-id") long j11, @Query("canceled-source") String str);

    @POST("v1/order/orders/{order-id}/place")
    Observable<StringStatusResponse<Long>> sumbitOrder(@Path("order-id") long j11);
}
