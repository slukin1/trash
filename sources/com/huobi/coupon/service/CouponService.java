package com.huobi.coupon.service;

import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.huobi.coupon.bean.Coupon;
import com.huobi.coupon.bean.CouponBannerInfo;
import com.huobi.coupon.bean.CouponCheck;
import com.huobi.coupon.bean.CouponNoticeInfo;
import com.huobi.coupon.bean.CouponReturnContainer;
import com.huobi.coupon.bean.CouponsData;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface CouponService {
    @GET("v1/hbg/open/coupon/check/new")
    Observable<HbgIntCodeResponse<CouponCheck>> couponCheck();

    @POST("v1/hbg/open/coupon/luckyDraw")
    Observable<HbgIntCodeResponse<Coupon>> couponLuckyDraw(@Body Map<String, Object> map);

    @GET("/-/x/hbg/v1/open/voucher/user/notice")
    Observable<HbgIntCodeResponse<CouponNoticeInfo>> couponNotice(@Query("types") String str);

    @POST("/-/x/hbg/v1/hbg/open/coupon/user/gettable/get")
    Observable<HbgIntCodeResponse<Object>> getCoupon(@Body Map<String, Object> map);

    @GET("v1/hbg/open/coupon/banner/get")
    Observable<HbgIntCodeResponse<CouponBannerInfo>> getCouponBanner();

    @GET("v1/hbg/open/coupon/user/otc")
    Observable<HbgIntCodeResponse<Coupon>> getCouponUserOtc();

    @GET("/-/x/hbg/v1/open/voucher/user/list")
    Observable<HbgIntCodeResponse<CouponReturnContainer>> getReturnCoupon(@QueryMap Map<String, Object> map);

    @GET("/-/x/hbg/v1/hbg/open/coupon/user/gettable")
    Observable<HbgIntCodeResponse<CouponsData>> getUnclaimedCoupon(@QueryMap Map<String, Object> map);

    @GET("/-/x/hbg/v1/hbg/open/coupon/user/list")
    Observable<HbgIntCodeResponse<CouponsData>> getUserCoupon(@QueryMap Map<String, Object> map);

    @POST("/-/x/hbg/v1/hbg/open/coupon/convert")
    Observable<HbgIntCodeResponse<Object>> trailVoucher(@Body Map<String, Object> map);
}
