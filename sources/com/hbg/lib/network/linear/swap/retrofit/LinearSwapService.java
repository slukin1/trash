package com.hbg.lib.network.linear.swap.retrofit;

import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.contract.core.bean.ReversalEstimatedLiquidationPrice;
import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import com.hbg.lib.network.linear.swap.core.bean.LinearOrderInsertRspInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAllowLevel;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAvailableLevelInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapBondAdjustDetail;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapBondAdjustResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCancelAllResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContactConfigInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCrossAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCurrentOrderInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapExperienceFundQueryResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapFinancialRecord;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapFundingRate;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapHiddenInstruments;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapLeverRate;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapLightLimitLevel;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOpenInterestInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOpenRight;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOrderInsertRspInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOrderResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOrderTimeSharingRspInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPositionModeQueryRespInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPositionModeSwitchRespInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPriceLimitInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapProductInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapSettlementPriceInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTimeOrderInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTimeOrderResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTimeSharingGlobalConfig;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTpSlOrderRspInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTpSlRelationOrder;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTrackOrderInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTriggerOrderInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserOrderLimit;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapWhiteList;
import com.hbg.lib.network.linear.swap.core.bean.UnionModeData;
import com.hbg.lib.network.linear.swap.core.bean.UnionModeWhiteListInfo;
import com.hbg.lib.network.linear.swap.core.bean.UnionSupportCurrency;
import com.hbg.lib.network.linear.swap.core.response.LinearSwapStatusResponse;
import com.huobi.contract.entity.ContractCancelOrderResult;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.contract.entity.ContractPositionLimit;
import com.huobi.contract.entity.ContractTriggerProtectInfo;
import com.huobi.contract.entity.OffSiteLimit;
import com.huobi.contract.entity.PositionSlippageInfo;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface LinearSwapService {
    @POST("linear-swap-order/x/v1/linear_swap_transfer_out_in")
    Observable<LinearSwapStatusResponse<LinearSwapBondAdjustResult>> adjustBond(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_adjust_position_limit")
    Observable<LinearSwapStatusResponse<Void>> adjustPositionLimit();

    @POST("linear-swap-order/x/v1/linear_swap_agree_high_lever")
    Observable<LinearSwapStatusResponse<Object>> agreeHighLever();

    @POST("linear-swap-order/x/v1/linear_swap_cross_trackorder_cancel")
    Observable<LinearSwapStatusResponse<LinearSwapCancelAllResult>> cancelCrossTrackOpenOrder(@Body Map<String, Object> map);

    @POST("v5/trade/position/close")
    Observable<LinearSwapStatusResponse<ContractCancelOrderResult>> cancelOrderAllV5(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/time_weighted_trigger_order_stop")
    Observable<LinearSwapStatusResponse<LinearSwapCancelAllResult>> cancelTimeOpenOrder(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1//linear_swap_trackorder_cancel")
    Observable<LinearSwapStatusResponse<LinearSwapCancelAllResult>> cancelTrackOpenOrder(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_cross_lever_rate")
    Observable<LinearSwapStatusResponse<LinearSwapLeverRate>> checkCrossLeverRate(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_lever_rate")
    Observable<LinearSwapStatusResponse<LinearSwapLeverRate>> checkLeverRate(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_cross_tpsl_cancel")
    Observable<LinearSwapStatusResponse<LinearSwapCancelAllResult>> contractCrossStopCancel(@Body Map<String, String> map);

    @POST("linear-swap-order/x/v1/linear_swap_cross_triggerorder_cancel")
    Observable<LinearSwapStatusResponse<LinearSwapCancelAllResult>> contractCrossTriggerCancel(@Body Map<String, String> map);

    @POST("linear-swap-order/x/v1/linear_swap_tpsl_cancel")
    Observable<LinearSwapStatusResponse<LinearSwapCancelAllResult>> contractStopCancel(@Body Map<String, String> map);

    @POST("linear-swap-order/x/v1/linear_swap_triggerorder_cancel")
    Observable<LinearSwapStatusResponse<LinearSwapCancelAllResult>> contractTriggerCancel(@Body Map<String, String> map);

    @POST("linear-swap-order/x/v1/linear_swap_cross_cancel")
    Observable<LinearSwapStatusResponse<LinearSwapCancelAllResult>> crossOrderCancel(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_cross_trackorder_insert")
    Observable<LinearSwapStatusResponse<LinearOrderInsertRspInfo>> crossTrackOrder(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_cross_triggerorder_insert")
    Observable<LinearSwapStatusResponse<LinearSwapOrderInsertRspInfo>> crossTriggerOrderInsert(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_account_info")
    Observable<LinearSwapStatusResponse<List<LinearSwapAccountInfo>>> getAccountInfo(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_all_position")
    Observable<LinearSwapStatusResponse<List<LinearSwapPosition>>> getAllContractPosition(@Body Map<String, Object> map);

    @POST("unified/v5/trade/position/opens")
    Observable<LinearSwapStatusResponse<List<LinearSwapPosition>>> getAllContractPositionWhenUnitDeposit(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_all_openorders")
    Observable<LinearSwapStatusResponse<LinearSwapOrderResult<LinearSwapCurrentOrderInfo>>> getAllCurrentOrder(@Body Map<String, Object> map);

    @POST("unified/v5/trade/order/opens")
    Observable<LinearSwapStatusResponse<LinearSwapOrderResult<LinearSwapCurrentOrderInfo>>> getAllCurrentOrderV5(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_all_tpsl_openorders")
    Observable<LinearSwapStatusResponse<LinearSwapOrderResult<LinearSwapTriggerOrderInfo>>> getAllCurrentStopOrder(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_all_open_triggerorders")
    Observable<LinearSwapStatusResponse<LinearSwapOrderResult<LinearSwapTriggerOrderInfo>>> getAllCurrentTriggerOrder(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1//linear_swap_all_open_trackorders")
    Observable<LinearSwapStatusResponse<LinearSwapOrderResult<LinearSwapTrackOrderInfo>>> getAllOpenTrackOrder(@Body Map<String, Object> map);

    @GET("linear-swap-order/x/v1/linear_swap_available_level")
    Observable<LinearSwapStatusResponse<List<LinearSwapAvailableLevelInfo>>> getAllowLevel(@Query("contract_code") String str, @Query("trade_partition") String str2);

    @GET("unified/v5/position/level/available")
    Observable<LinearSwapStatusResponse<List<LinearSwapAvailableLevelInfo>>> getAllowLevelV5(@Query("contract_code") String str, @Query("trade_partition") String str2, @Query("margin_mode") String str3);

    @GET("linear-swap-order/x/v1/linear_swap_product_allow_maxlevel")
    Observable<LinearSwapStatusResponse<List<LinearSwapAllowLevel>>> getAllowMaxLevel(@Query("contract_code") String str);

    @POST("linear-swap-order/x/v1/linear_swap_fixed_account_detail")
    Observable<LinearSwapStatusResponse<LinearSwapBondAdjustDetail>> getBondAdjustDetail(@Body Map<String, Object> map);

    @GET("linear-swap-order/x/v1/linear_swap_grid_all_contract")
    Observable<LinearSwapStatusResponse<List<LinearSwapContactConfigInfo>>> getContractConfigInfo();

    @POST("linear-swap-order/x/v1/linear_swap_position_info")
    Observable<LinearSwapStatusResponse<List<LinearSwapPosition>>> getContractPosition(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_cross_account_info")
    Observable<LinearSwapStatusResponse<List<LinearSwapCrossAccountInfo>>> getCrossAccountInfo(@Body Map<String, Object> map);

    @GET("linear-swap-order/x/v1/linear_swap_cross_available_level")
    Observable<LinearSwapStatusResponse<List<LinearSwapAvailableLevelInfo>>> getCrossAllowLevel(@Query("contract_code") String str, @Query("trade_partition") String str2);

    @POST("linear-swap-order/x/v1/linear_swap_cross_level_available_margin")
    Observable<LinearSwapStatusResponse<List<LevelAvailableMarginInfo>>> getCrossLevelAvailableMargin(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_cross_open_trackorders")
    Observable<LinearSwapStatusResponse<LinearSwapOrderResult<LinearSwapTrackOrderInfo>>> getCrossOpenTrackOrder(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_cross_tpsl_relation_order")
    Observable<LinearSwapStatusResponse<LinearSwapTpSlRelationOrder>> getCrossTpSlRelationOrder(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/time_weighted_trigger_orders")
    Observable<LinearSwapStatusResponse<LinearSwapTimeOrderResult<LinearSwapTimeOrderInfo>>> getCurrentTimeOrder(@Body Map<String, Object> map);

    @GET("linear-swap-order/x/v1/linear_swap_cross_user_voucher_tips")
    Observable<LinearSwapStatusResponse<LinearSwapExperienceFundQueryResult>> getExperienceFundQuery();

    @GET("linear-swap-order/x/v1/linear_swap_funding_rate")
    Observable<LinearSwapStatusResponse<LinearSwapFundingRate>> getFundingRate(@Query("contract_code") String str, @Query("trade_partition") String str2);

    @POST("linear-swap-order/x/v1/linear_swap_grid_order_exists")
    Observable<LinearSwapStatusResponse<String>> getGridOrderExists(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_hidden_instruments")
    Observable<LinearSwapStatusResponse<LinearSwapHiddenInstruments>> getHiddenInstruments();

    @POST("linear-swap-order/x/v1/linear_swap_level_available_margin")
    Observable<LinearSwapStatusResponse<List<LevelAvailableMarginInfo>>> getLevelAvailableMargin(@Body Map<String, Object> map);

    @GET("linear-swap-order/x/v1/linear_swap_lightning_limit")
    Observable<LinearSwapStatusResponse<List<LinearSwapLightLimitLevel>>> getLightLimitLevel(@Query("contract_code") String str);

    @GET("linear-swap-order/x/v1/linear_swap_opencount")
    Observable<LinearSwapStatusResponse<ContractOpenCountInfo>> getLinearSwapOpenCountInfo();

    @POST("linear-swap-order/x/v1/linear_swap_kyc_open_right")
    Observable<LinearSwapStatusResponse<LinearSwapOpenRight>> getOpenRight(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_open_trackorders")
    Observable<LinearSwapStatusResponse<LinearSwapOrderResult<LinearSwapTrackOrderInfo>>> getOpenTrackOrder(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_open_order_limit")
    Observable<LinearSwapStatusResponse<OffSiteLimit>> getOrderLimit(@Body Map<String, Object> map);

    @GET("linear-swap-order/x/v1/linear_swap_mark_price")
    Observable<LinearSwapStatusResponse<String>> getPriceInfo(@Query("contract_code") String str);

    @GET("linear-swap-order/x/v1/linear_swap_price_limit")
    Observable<LinearSwapStatusResponse<List<LinearSwapPriceLimitInfo>>> getPriceLimitLevel(@Query("contract_code") String str, @Query("trade_partition") String str2, @Query("business_type") String str3);

    @GET("linear-swap-order/x/v1/linear_swap_product_info")
    Observable<LinearSwapStatusResponse<List<LinearSwapProductInfo>>> getProductInfo(@Query("search_all") String str, @Query("include_quote") String str2, @Query("trade_partition") String str3);

    @GET("linear-swap-order/x/v1/linear_swap_estimated_settlement_price")
    Observable<LinearSwapStatusResponse<List<LinearSwapSettlementPriceInfo>>> getSettlementPrice(@QueryMap Map<String, Object> map);

    @GET("linear-swap-order/x/v1/linear_swap_contract_info")
    Observable<LinearSwapStatusResponse<List<LinearSwapContractInfo>>> getSwapCurrencyInfo(@QueryMap Map<String, Object> map);

    @GET("linear-swap-order/x/v1/linear_swap_open_interest")
    Observable<LinearSwapStatusResponse<List<LinearSwapOpenInterestInfo>>> getSwapOpenInterest(@Query("contract_code") String str, @Query("trade_partition") String str2, @Query("business_type") String str3);

    @GET("linear-swap-order/x/v1/trigger_mgt_config")
    Observable<LinearSwapStatusResponse<LinearSwapTimeSharingGlobalConfig>> getTimeSharingGlobalConfigInfo();

    @POST("linear-swap-order/x/v1/linear_swap_tpsl_relation_order")
    Observable<LinearSwapStatusResponse<LinearSwapTpSlRelationOrder>> getTpSlRelationOrder(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_user_info")
    Observable<LinearSwapStatusResponse<LinearSwapUserInfo>> getUserInfo();

    @POST("linear-swap-order/x/v1/linear_swap_user_order_limit")
    Observable<LinearSwapStatusResponse<List<LinearSwapUserOrderLimit>>> getUserOrderLimit(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_user_position_limit_list")
    Observable<LinearSwapStatusResponse<ContractPositionLimit>> getUserPositionLimitList();

    @POST("linear-swap-order/x/v1/linear_close_all_position")
    Observable<LinearSwapStatusResponse<Object>> linearCloseAllPosition();

    @POST("unified/v5/trade/position/closeAll")
    Observable<LinearSwapStatusResponse<Object>> linearCloseAllPositionV5();

    @POST("linear-swap-order/x/v1/linear_swap_cancel")
    Observable<LinearSwapStatusResponse<LinearSwapCancelAllResult>> orderCancel(@Body Map<String, Object> map);

    @POST("unified/v5/trade/order/cancel")
    Observable<LinearSwapStatusResponse<LinearSwapCancelAllResult>> orderCancelV5(@Body Map<String, Object> map);

    @GET("unified/v5/account/balance")
    Observable<LinearSwapStatusResponse<AccountBalanceInfoV5>> queryAccountBalance();

    @GET("unified/v5/account/assets_mode")
    Observable<LinearSwapStatusResponse<UnionModeData>> queryAssetMode();

    @GET("unified/v5/position/lever")
    Observable<LinearSwapStatusResponse<LinearSwapLeverRate>> queryLeverRateV5(@Query("contract_code") String str, @Query("margin_mode") String str2);

    @POST("linear-swap-order/x/v1/linear_swap_is_single_side_mode")
    Observable<LinearSwapStatusResponse<LinearSwapPositionModeQueryRespInfo>> queryPositionMode();

    @GET("unified/v5/position/mode")
    Observable<LinearSwapStatusResponse<LinearSwapPositionModeSwitchRespInfo>> queryPositionModeWhenUnitDeposit();

    @POST("/linear-swap-order/x/v1/linear_swap_position_slippage")
    Observable<LinearSwapStatusResponse<PositionSlippageInfo>> queryPositionSlippage(@Body Map<String, Object> map);

    @GET("linear-swap-order/x/v1/linear_swap_effectual_tradePartition")
    Observable<LinearSwapStatusResponse<List<String>>> queryTradePartition();

    @GET("linear-swap-order/x/v1/linear_swap_query_trade_unit")
    Observable<LinearSwapStatusResponse<Integer>> queryTradeUnit();

    @GET("unified/v5/account/currency/list")
    Observable<LinearSwapStatusResponse<UnionSupportCurrency>> queryUnionModeSupportCurrency();

    @GET("unified/v5/common/union_account_setting")
    Observable<LinearSwapStatusResponse<UnionModeWhiteListInfo>> queryUnionWhiteList();

    @POST("linear-swap-order/x/v1/linear_swap_user_ishit")
    Observable<LinearSwapStatusResponse<List<LinearSwapWhiteList>>> queryUserIshit(@Body Map<String, String> map);

    @POST("linear-swap-order/x/v1/linear_swap_selection_cancel")
    Observable<LinearSwapStatusResponse<ContractCancelOrderResult>> requestCancelOrderAll(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_cross_tpsl_order")
    Observable<LinearSwapStatusResponse<LinearSwapTpSlOrderRspInfo>> requestContractCrossTpSlOrder(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_tpsl_order")
    Observable<LinearSwapStatusResponse<LinearSwapTpSlOrderRspInfo>> requestContractTpSlOrder(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_cross_tpsl_frozen_state")
    Observable<LinearSwapStatusResponse<Boolean>> requestCurrentCrossTpslFrozenState(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_tpsl_frozen_state")
    Observable<LinearSwapStatusResponse<Boolean>> requestCurrentTpslFrozenState(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_reversal_order")
    Observable<LinearSwapStatusResponse<LinearOrderInsertRspInfo>> requestReversal(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_cross_reversal_order")
    Observable<LinearSwapStatusResponse<LinearOrderInsertRspInfo>> requestReversalCross(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_reversal_order_preview")
    Observable<LinearSwapStatusResponse<ReversalEstimatedLiquidationPrice>> requestReversalEstimatedLiquidationPrice(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_reversal_cross_order_preview")
    Observable<LinearSwapStatusResponse<ReversalEstimatedLiquidationPrice>> requestReversalEstimatedLiquidationPriceCross(@Body Map<String, Object> map);

    @POST("/v5/trade/reverseOrder/preview")
    Observable<LinearSwapStatusResponse<ReversalEstimatedLiquidationPrice>> requestReversalEstimatedLiquidationPriceV5(@Body Map<String, Object> map);

    @POST("unified/v5/trade/order/reverse")
    Observable<LinearSwapStatusResponse<LinearOrderInsertRspInfo>> requestReversalV5(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_cross_lightning_close_position")
    Observable<LinearSwapStatusResponse<LinearOrderInsertRspInfo>> requestSwapCrossLightClose(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_cross_order")
    Observable<LinearSwapStatusResponse<LinearSwapOrderInsertRspInfo>> requestSwapCrossOrder(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_lightning_close_position")
    Observable<LinearSwapStatusResponse<LinearOrderInsertRspInfo>> requestSwapLightClose(@Body Map<String, Object> map);

    @POST("unified/v5/trade/position/close")
    Observable<LinearSwapStatusResponse<LinearOrderInsertRspInfo>> requestSwapLightCloseV5(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_order")
    Observable<LinearSwapStatusResponse<LinearSwapOrderInsertRspInfo>> requestSwapOrder(@Body Map<String, Object> map);

    @POST("unified/v5/trade/order")
    Observable<LinearSwapStatusResponse<LinearSwapOrderInsertRspInfo>> requestSwapOrderV5(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/time_weighted_trigger_order_insert")
    Observable<LinearSwapStatusResponse<LinearSwapOrderTimeSharingRspInfo>> requestTimeSharingOrder(@Body Map<String, Object> map);

    @POST("unified/v5/account/assets_mode")
    Observable<LinearSwapStatusResponse<Object>> switchAssetMode(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_cross_switch_position_mode")
    Observable<LinearSwapStatusResponse<LinearSwapPositionModeSwitchRespInfo>> switchPositionModeWhenQuanCang(@Body Map<String, Object> map);

    @POST("unified/v5/position/mode")
    Observable<LinearSwapStatusResponse<LinearSwapPositionModeSwitchRespInfo>> switchPositionModeWhenUnitDeposit(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_switch_position_mode")
    Observable<LinearSwapStatusResponse<LinearSwapPositionModeSwitchRespInfo>> switchPositionModeWhenZhuCang(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_trackorder_insert")
    Observable<LinearSwapStatusResponse<LinearOrderInsertRspInfo>> trackOrder(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_list_apply_trail_voucher")
    Observable<LinearSwapStatusResponse<Object>> trailVoucher(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_transfer_inner")
    Observable<LinearSwapStatusResponse<Object>> transferInner(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_transfer_inner_record")
    Observable<LinearSwapStatusResponse<LinearSwapFinancialRecord>> transferInnerHistory(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_triggerorder_insert")
    Observable<LinearSwapStatusResponse<LinearSwapOrderInsertRspInfo>> triggerOrderInsert(@Body Map<String, Object> map);

    @GET("linear-swap-order/x/v1/linear_swap_trigger_protect")
    Observable<LinearSwapStatusResponse<ContractTriggerProtectInfo>> triggerProtect(@Query("contract_code") String str);

    @POST("unified/v5/position/lever")
    Observable<LinearSwapStatusResponse<LinearSwapLeverRate>> updateLeverRateV5(@Body Map<String, Object> map);

    @POST("linear-swap-order/x/v1/linear_swap_update_trade_unit")
    Observable<LinearSwapStatusResponse<Object>> updateTradeUnit(@Body Map<String, Object> map);
}
