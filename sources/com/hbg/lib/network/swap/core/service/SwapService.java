package com.hbg.lib.network.swap.core.service;

import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.contract.core.bean.ReversalEstimatedLiquidationPrice;
import com.hbg.lib.network.swap.core.bean.LeverRate;
import com.hbg.lib.network.swap.core.bean.OrderInsertRspInfo;
import com.hbg.lib.network.swap.core.bean.PriceLimitInfo;
import com.hbg.lib.network.swap.core.bean.ProductInfo;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.hbg.lib.network.swap.core.bean.SwapActivityInfo;
import com.hbg.lib.network.swap.core.bean.SwapAllowLevel;
import com.hbg.lib.network.swap.core.bean.SwapAvailableLevelInfo;
import com.hbg.lib.network.swap.core.bean.SwapCancelAllResult;
import com.hbg.lib.network.swap.core.bean.SwapCancelResult;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrentOrderInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrentTrackOrderResult;
import com.hbg.lib.network.swap.core.bean.SwapFundingRate;
import com.hbg.lib.network.swap.core.bean.SwapHiddenInstruments;
import com.hbg.lib.network.swap.core.bean.SwapLightLimitLevel;
import com.hbg.lib.network.swap.core.bean.SwapOpenInterestInfo;
import com.hbg.lib.network.swap.core.bean.SwapOpenRight;
import com.hbg.lib.network.swap.core.bean.SwapOrderResult;
import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.lib.network.swap.core.bean.SwapPriceInfo;
import com.hbg.lib.network.swap.core.bean.SwapSettlementPriceInfo;
import com.hbg.lib.network.swap.core.bean.SwapTpSlOrderRspInfo;
import com.hbg.lib.network.swap.core.bean.SwapTpSlRelationOrder;
import com.hbg.lib.network.swap.core.bean.SwapTriggerOrderInfo;
import com.hbg.lib.network.swap.core.bean.SwapUserInfo;
import com.hbg.lib.network.swap.core.bean.SwapUserOrderLimit;
import com.hbg.lib.network.swap.core.response.SwapStatusResponse;
import com.huobi.contract.entity.ContractCancelOrderResult;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.contract.entity.ContractTriggerProtectInfo;
import com.huobi.contract.entity.OffSiteLimit;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface SwapService {
    @GET("swap-order/x/v1/swap_profit_ratio_rank_activity")
    Observable<SwapStatusResponse<SwapActivityInfo>> activityInfo(@Query("activity_id") String str);

    @POST("swap-order/x/v1/swap_agree_high_lever")
    Observable<SwapStatusResponse<Object>> agreeHighLever();

    @POST("swap-order/x/v1/swap_open")
    Observable<SwapStatusResponse<Void>> agreementAgree();

    @POST("swap-order/x/v1/swap_trackorder_cancel")
    Observable<SwapStatusResponse<SwapCancelResult>> cancelTrackOpenOrder(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_lever_rate")
    Observable<SwapStatusResponse<LeverRate>> checkLeverRate(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_tpsl_cancel")
    Observable<SwapStatusResponse<SwapCancelResult>> contractStopCancel(@Body Map<String, String> map);

    @POST("swap-order/x/v1/swap_triggerorder_cancel")
    Observable<SwapStatusResponse<SwapCancelResult>> contractTriggerCancel(@Body Map<String, String> map);

    @POST("swap-order/x/v1/swap_account_info")
    Observable<SwapStatusResponse<List<SwapAccountInfo>>> getAccountInfo(@Body Map<String, Object> map);

    @GET("swap-order/x/v1/swap_available_level")
    Observable<SwapStatusResponse<List<SwapAvailableLevelInfo>>> getAllowLevel(@Query("symbol") String str);

    @GET("swap-order/x/v1/swap_product_allow_maxlevel")
    Observable<SwapStatusResponse<List<SwapAllowLevel>>> getAllowMaxLevel(@Query("symbol") String str);

    @POST("swap-order/x/v1/swap_position_info")
    Observable<SwapStatusResponse<List<SwapPosition>>> getContractPosition(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_openorders")
    Observable<SwapStatusResponse<SwapOrderResult<SwapCurrentOrderInfo>>> getCurrentOrder(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_tpsl_openorders")
    Observable<SwapStatusResponse<SwapOrderResult<SwapTriggerOrderInfo>>> getCurrentStopOrder(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_open_triggerorders")
    Observable<SwapStatusResponse<SwapOrderResult<SwapTriggerOrderInfo>>> getCurrentTriggerOrder(@Body Map<String, Object> map);

    @GET("swap-order/x/v1/swap_funding_rate")
    Observable<SwapStatusResponse<SwapFundingRate>> getFunddingRate(@Query("contract_code") String str);

    @POST("swap-order/x/v1/swap_hidden_instruments")
    Observable<SwapStatusResponse<SwapHiddenInstruments>> getHiddenInstruments();

    @POST("swap-order/x/v1/swap_level_available_margin")
    Observable<SwapStatusResponse<List<LevelAvailableMarginInfo>>> getLevelAvailableMargin(@Body Map<String, Object> map);

    @GET("swap-order/x/v1/swap_lightning_limit")
    Observable<SwapStatusResponse<List<SwapLightLimitLevel>>> getLightLimitLevel(@Query("contract_code") String str);

    @GET("swap-order/x/v1/swap_mark_price")
    Observable<SwapStatusResponse<String>> getMarketPriceInfo(@Query("contract_code") String str);

    @POST("swap-order/x/v1/swap_kyc_open_right")
    Observable<SwapStatusResponse<SwapOpenRight>> getOpenRight(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_open_trackorders")
    Observable<SwapStatusResponse<SwapCurrentTrackOrderResult>> getOpenTrackOrder(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_open_order_limit")
    Observable<SwapStatusResponse<OffSiteLimit>> getOrderLimit(@Body Map<String, Object> map);

    @GET("swap-order/x/v1/swap_index")
    Observable<SwapStatusResponse<List<SwapPriceInfo>>> getPriceInfo(@Query("contract_code") String str);

    @GET("swap-order/x/v1/swap_price_limit")
    Observable<SwapStatusResponse<List<PriceLimitInfo>>> getPriceLimitLevel(@Query("contract_code") String str);

    @GET("swap-order/x/v1/swap_product_info")
    Observable<SwapStatusResponse<List<ProductInfo>>> getProductInfo(@Query("search_all") String str);

    @GET("swap-order/x/v1/swap_estimated_settlement_price")
    Observable<SwapStatusResponse<List<SwapSettlementPriceInfo>>> getSettlementPrice(@QueryMap Map<String, Object> map);

    @GET("swap-order/x/v1/swap_contract_info")
    Observable<SwapStatusResponse<List<SwapCurrencyInfo>>> getSwapCurrencyInfo(@QueryMap Map<String, Object> map);

    @GET("swap-order/x/v1/swap_opencount")
    Observable<SwapStatusResponse<ContractOpenCountInfo>> getSwapOpenCountInfo();

    @GET("swap-order/x/v1/swap_open_interest")
    Observable<SwapStatusResponse<List<SwapOpenInterestInfo>>> getSwapOpenInterest(@Query("contract_code") String str);

    @POST("swap-order/x/v1/swap_tpsl_relation_order")
    Observable<SwapStatusResponse<SwapTpSlRelationOrder>> getTpSlRelationOrder(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_user_info")
    Observable<SwapStatusResponse<SwapUserInfo.UserBean>> getUserInfo();

    @POST("swap-order/x/v1/swap_user_order_limit")
    Observable<SwapStatusResponse<List<SwapUserOrderLimit>>> getUserOrderLimit(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_cancel")
    Observable<SwapStatusResponse<SwapCancelResult>> orderCancel(@Body Map<String, String> map);

    @POST("swap-order/x/v1/swap_cancelall")
    Observable<SwapStatusResponse<SwapCancelAllResult>> orderCancelAll(@Body Map<String, Object> map);

    @GET("swap-order/x/v1/swap_query_trade_unit")
    Observable<SwapStatusResponse<Integer>> queryTradeUnit();

    @POST("swap-order/x/v1/swap_selection_cancel")
    Observable<SwapStatusResponse<ContractCancelOrderResult>> requestCancelOrderAll(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_tpsl_order")
    Observable<SwapStatusResponse<SwapTpSlOrderRspInfo>> requestContractTpSlOrder(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_tpsl_frozen_state")
    Observable<SwapStatusResponse<Boolean>> requestCurrentTpslFrozenState(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_reversal_order")
    Observable<SwapStatusResponse<OrderInsertRspInfo>> requestReversal(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_reversal_order_preview")
    Observable<SwapStatusResponse<ReversalEstimatedLiquidationPrice>> requestReversalEstimatedLiquidationPrice(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_lightning_close_position")
    Observable<SwapStatusResponse<OrderInsertRspInfo>> requestSwapLightClose(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_order")
    Observable<SwapStatusResponse<OrderInsertRspInfo>> requestSwapOrder(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_close_all_position")
    Observable<SwapStatusResponse<Object>> swapCloseAllPosition();

    @POST("swap-order/x/v1/swap_trackorder_insert")
    Observable<SwapStatusResponse<OrderInsertRspInfo>> trackOrder(@Body Map<String, Object> map);

    @POST("swap-order/x/v1/swap_triggerorder_insert")
    Observable<SwapStatusResponse<OrderInsertRspInfo>> triggerOrderInsert(@Body Map<String, Object> map);

    @GET("swap-order/x/v1/swap_trigger_protect")
    Observable<SwapStatusResponse<ContractTriggerProtectInfo>> triggerProtect(@Query("contract_code") String str);

    @POST("swap-order/x/v1/swap_update_trade_unit")
    Observable<SwapStatusResponse<Object>> updateTradeUnit(@Body Map<String, Object> map);
}
