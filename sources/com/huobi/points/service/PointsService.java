package com.huobi.points.service;

import com.hbg.lib.core.network.response.AliTokenStringStatusResponse;
import com.hbg.lib.core.network.response.StringStatusResponse;
import com.huobi.points.entity.Points;
import com.huobi.points.entity.PointsAction;
import com.huobi.points.entity.PointsPack;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface PointsService {
    @POST("v1/points/transfer/{transfer-id}/accept")
    Observable<StringStatusResponse<Long>> acceptPointsTransfer(@Path("transfer-id") long j11, @Query("auth-token") String str);

    @POST("v1/points/transfer/{transfer-id}/cancel")
    Observable<StringStatusResponse<Long>> cancelPointsTransfer(@Path("transfer-id") long j11);

    @GET("v1/points/pack/list")
    Observable<StringStatusResponse<List<PointsPack>>> getPackList(@QueryMap Map<String, Object> map);

    @GET("v1/points/actions")
    Observable<StringStatusResponse<List<PointsAction>>> getPointsActions(@QueryMap Map<String, Object> map);

    @GET("v1/points/orders")
    Observable<StringStatusResponse<List<Points>>> getPointsOrders(@QueryMap Map<String, Object> map);

    @POST("v1/points/order/create")
    Observable<AliTokenStringStatusResponse<Points>> orderCreate(@Body Map<String, Object> map);

    @GET("v1/points/order/{order-id}")
    Observable<StringStatusResponse<Points>> pointsOrderDetail(@Path("order-id") long j11);

    @POST("v1/points/order/{order-id}/place")
    Observable<StringStatusResponse<Long>> pointsOrderPlace(@Path("order-id") long j11, @Body Map<String, Object> map);

    @GET("v1/points/transfer-in/count")
    Observable<StringStatusResponse<Long>> pointsTransferInCount();

    @POST("v1/points/transfer/{transfer-id}/reject")
    Observable<StringStatusResponse<Long>> rejectPointsTransfer(@Path("transfer-id") long j11);

    @POST("v1/points/transfer/create")
    Observable<StringStatusResponse<Long>> requestPointsTransfer(@Query("auth-token") String str, @Body Map<String, Object> map);
}
