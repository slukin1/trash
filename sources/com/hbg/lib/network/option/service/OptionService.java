package com.hbg.lib.network.option.service;

import com.hbg.lib.network.option.core.bean.OptionAccountInfo;
import com.hbg.lib.network.option.core.bean.OptionCancelInfo;
import com.hbg.lib.network.option.core.bean.OptionCurrencyInfo;
import com.hbg.lib.network.option.core.bean.OptionDeliveryPriceInfo;
import com.hbg.lib.network.option.core.bean.OptionFinancialRecordResponse;
import com.hbg.lib.network.option.core.bean.OptionIndexInfo;
import com.hbg.lib.network.option.core.bean.OptionLightningClosePositionResult;
import com.hbg.lib.network.option.core.bean.OptionLightningLimitInfo;
import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import com.hbg.lib.network.option.core.bean.OptionOpenOrdersResult;
import com.hbg.lib.network.option.core.bean.OptionOpenTriggerOrdersResult;
import com.hbg.lib.network.option.core.bean.OptionOrderInfo;
import com.hbg.lib.network.option.core.bean.OptionOrderResult;
import com.hbg.lib.network.option.core.bean.OptionPlatformPositionInfo;
import com.hbg.lib.network.option.core.bean.OptionPositionInfo;
import com.hbg.lib.network.option.core.bean.OptionProductInfo;
import com.hbg.lib.network.option.core.bean.OptionUserInfo;
import com.hbg.lib.network.option.core.bean.OptionUserTradeFeeInfo;
import com.hbg.lib.network.option.core.bean.PriceLimitInfo;
import com.hbg.lib.network.option.response.OptionStatusResponse;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface OptionService {
    @POST("option-order/x/v1/option_account_info")
    Observable<OptionStatusResponse<List<OptionAccountInfo>>> getAccountInfo(@Body Map<String, Object> map);

    @POST("option-order/x/v1/option_account_action")
    Observable<OptionStatusResponse<OptionFinancialRecordResponse>> getFinancialRecord(@Body Map<String, Object> map);

    @GET("option-order/x/v1/option_contract_info")
    Observable<OptionStatusResponse<List<OptionCurrencyInfo>>> getOptionCurrencyInfo(@QueryMap Map<String, Object> map);

    @GET("option-order/x/v1/option_delivery_price")
    Observable<OptionStatusResponse<OptionDeliveryPriceInfo>> getOptionDeliveryPrice(@QueryMap Map<String, Object> map);

    @GET("option-order/x/v1/option_index")
    Observable<OptionStatusResponse<List<OptionIndexInfo>>> getOptionIndexInfo(@QueryMap Map<String, Object> map);

    @GET("option-order/x/v1/option_lightning_limit")
    Observable<OptionStatusResponse<List<OptionLightningLimitInfo>>> getOptionLightningLimit(@Query("contract_code") String str);

    @POST("option-order/x/v1/option_position_info")
    Observable<OptionStatusResponse<List<OptionPositionInfo>>> getOptionPositionInfo(@Body Map<String, Object> map);

    @POST("option-order/x/v1/option_risk_position_view")
    Observable<OptionStatusResponse<List<OptionPlatformPositionInfo>>> getOptionRiskPositionView(@Body Map<String, Object> map);

    @GET("option-order/x/v1/option_price_limit")
    Observable<OptionStatusResponse<List<PriceLimitInfo>>> getPriceLimitLevel(@Query("contract_code") String str);

    @GET("option-order/x/v1/option_product_info")
    Observable<OptionStatusResponse<List<OptionProductInfo>>> getProductInfo(@QueryMap Map<String, Object> map);

    @POST("option-order/x/v1/option_user_info")
    Observable<OptionStatusResponse<OptionUserInfo>> getUserInfo(@Body Map<String, Object> map);

    @GET("option-order/x/v1/option_market_index")
    Observable<OptionStatusResponse<List<OptionMarketIndexInfo>>> optionMarketIndex(@QueryMap Map<String, Object> map);

    @GET("option-order/x/v1/option_query_trade_unit")
    Observable<OptionStatusResponse<Integer>> queryTradeUnit();

    @POST("option-order/x/v1/option_cancel")
    Observable<OptionStatusResponse<OptionCancelInfo>> requestOptionCancel(@Body Map<String, Object> map);

    @POST("option-order/x/v1/option_cancelall")
    Observable<OptionStatusResponse<OptionCancelInfo>> requestOptionCancelAll(@Body Map<String, Object> map);

    @POST("option-order/x/v1/option_lightning_close_position")
    Observable<OptionStatusResponse<OptionLightningClosePositionResult>> requestOptionLightningClosePosition(@Body Map<String, Object> map);

    @POST("option-order/x/v1/option_openorders")
    Observable<OptionStatusResponse<OptionOpenOrdersResult>> requestOptionOpenOrders(@Body Map<String, Object> map);

    @POST("option-order/x/v1/option_open_triggerorders")
    Observable<OptionStatusResponse<OptionOpenTriggerOrdersResult>> requestOptionOpenTriggerOrders(@Body Map<String, Object> map);

    @POST("option-order/x/v1/option_order")
    Observable<OptionStatusResponse<OptionOrderResult>> requestOptionOrder(@Body Map<String, Object> map);

    @POST("option-order/x/v1/option_order_info")
    Observable<OptionStatusResponse<OptionOrderInfo>> requestOptionOrderInfo(@Body Map<String, Object> map);

    @POST("option-order/x/v1/option_triggerorder_cancel")
    Observable<OptionStatusResponse<OptionCancelInfo>> requestOptionTriggerOrderCancel(@Body Map<String, Object> map);

    @POST("option-order/x/v1/option_triggerorder_cancelall")
    Observable<OptionStatusResponse<OptionCancelInfo>> requestOptionTriggerOrderCancelAll(@Body Map<String, Object> map);

    @POST("option-order/x/v1/option_triggerorder_insert")
    Observable<OptionStatusResponse<OptionOrderResult>> requestOptionTriggerOrderInsert(@Body Map<String, Object> map);

    @GET("option-order/x/v1/option_user_trade_fee")
    Observable<OptionStatusResponse<List<OptionUserTradeFeeInfo>>> requestOptionUserTradeFee(@Query("symbol") String str);

    @POST("option-order/x/v1/option_update_trade_unit")
    Observable<OptionStatusResponse<Object>> updateTradeUnit(@Body Map<String, Object> map);
}
