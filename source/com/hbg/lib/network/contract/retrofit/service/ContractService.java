package com.hbg.lib.network.contract.retrofit.service;

import com.hbg.lib.network.contract.core.bean.CenterMarketConfigContracts;
import com.hbg.lib.network.contract.core.bean.CenterMarketConfigInfo;
import com.hbg.lib.network.contract.core.bean.ContractAllowLevel;
import com.hbg.lib.network.contract.core.bean.ContractAvailableLevelInfo;
import com.hbg.lib.network.contract.core.bean.ContractClearDialogConfig;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.bean.ContractHiddenInstruments;
import com.hbg.lib.network.contract.core.bean.ContractHoldAmount;
import com.hbg.lib.network.contract.core.bean.ContractOpenRight;
import com.hbg.lib.network.contract.core.bean.ContractOrderInsertRspInfo;
import com.hbg.lib.network.contract.core.bean.ContractSettlementPrice;
import com.hbg.lib.network.contract.core.bean.ContractTagInfo;
import com.hbg.lib.network.contract.core.bean.ContractTpSlOrderRspInfo;
import com.hbg.lib.network.contract.core.bean.ContractUserOrderLimit;
import com.hbg.lib.network.contract.core.bean.KycCountryBean;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.contract.core.bean.PopupInfo;
import com.hbg.lib.network.contract.core.bean.PopupSetInfo;
import com.hbg.lib.network.contract.core.bean.PriceLimitInfo;
import com.hbg.lib.network.contract.core.bean.ReversalEstimatedLiquidationPrice;
import com.hbg.lib.network.contract.core.bean.StopOrderRspResult;
import com.hbg.lib.network.contract.core.response.ContractStatusResponse;
import com.huobi.contract.entity.ContractCalmPeriodInfo;
import com.huobi.contract.entity.ContractCancelOrderResult;
import com.huobi.contract.entity.ContractCancelResult;
import com.huobi.contract.entity.ContractCoinInfo;
import com.huobi.contract.entity.ContractCurrentTrackOrderResult;
import com.huobi.contract.entity.ContractDeliveryPrice;
import com.huobi.contract.entity.ContractLeverrate;
import com.huobi.contract.entity.ContractLightLimitLevel;
import com.huobi.contract.entity.ContractPriceLimits;
import com.huobi.contract.entity.ContractPriceProtectionInfo;
import com.huobi.contract.entity.ContractTpSlRelationOrder;
import com.huobi.contract.entity.ContractTradeStatus;
import com.huobi.contract.entity.ContractUserInfoActive;
import com.huobi.contract.entity.OffSiteLimit;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface ContractService {
    @POST("contract-order/x/v1/contract_agree_high_lever")
    Observable<ContractStatusResponse<Object>> agreeHighLever();

    @POST("contract-order/x/v1/contract_agreement_agree")
    Observable<ContractStatusResponse<Void>> agreementAgree();

    @POST("contract-order/x/v1/contract_tpsl_cancel")
    Observable<ContractStatusResponse<ContractCancelResult>> cancelStopOpenOrder(@Body Map<String, String> map);

    @POST("contract-order/x/v1/contract_trackorder_cancel")
    Observable<ContractStatusResponse<ContractCancelResult>> cancelTrackOpenOrder(@Body Map<String, Object> map);

    @GET("contract-center-order/x/v1/center_market_config_check")
    Observable<ContractStatusResponse<Integer>> centerMarketConfigCheck(@Query("symbol") String str, @Query("contract_type") int i11);

    @GET("contract-center-order/x/v1/center_market_config_contracts")
    Observable<ContractStatusResponse<CenterMarketConfigContracts>> centerMarketConfigContracts();

    @POST("contract-center-order/x/v1/center_market_config_delete")
    Observable<ContractStatusResponse<List<Integer>>> centerMarketConfigDelete(@Body Map<String, Object> map);

    @GET("contract-center-order/x/v1/center_market_config_info")
    Observable<ContractStatusResponse<List<CenterMarketConfigInfo>>> centerMarketConfigInfo(@QueryMap Map<String, Object> map);

    @POST("contract-center-order/x/v1/center_market_config_save")
    Observable<ContractStatusResponse<Integer>> centerMarketConfigSave(@Body Map<String, Object> map);

    @POST("contract-center-order/x/v1/contract_close_all_position")
    Observable<ContractStatusResponse<Object>> contractCloseAllPosition();

    @GET("contract-order/x/v1/contract_lightning_limit")
    Observable<ContractStatusResponse<List<ContractLightLimitLevel>>> contractLightLimitLevel();

    @POST("contract-center-order/x/v1/center_user_info")
    Observable<ContractStatusResponse<ContractUserInfoActive>> fetchUserInfoActive();

    @GET("contract-order/x/v1/contract_product_allow_maxlevel")
    Observable<ContractStatusResponse<List<ContractAllowLevel>>> getAllowMaxLevel(@Query("symbol") String str);

    @GET("contract-order/x/v1/contract_available_level")
    Observable<ContractStatusResponse<List<ContractAvailableLevelInfo>>> getAvailableLevel(@Query("symbol") String str);

    @POST("contract-center-order/x/v1/center_discharge_config")
    Observable<ContractStatusResponse<ContractClearDialogConfig>> getClearDialogConfig();

    @GET("contract-order/x/v1/contract_product_info")
    Observable<ContractStatusResponse<List<ContractCoinInfo>>> getCoinInfo(@Query("search_all") String str);

    @GET("contract-order/x/v1/contract_contract_info_data")
    Observable<ContractStatusResponse<List<ContractCurrencyInfo>>> getContractCurrencyAllInfo();

    @GET("contract-order/x/v1/contract_delivery_price")
    Observable<ContractStatusResponse<ContractDeliveryPrice>> getContractDeliveryPrice(@QueryMap Map<String, Object> map);

    @GET("contract-order/x/v1/contract_open_interest")
    Observable<ContractStatusResponse<List<ContractHoldAmount>>> getContractHoldAmount(@QueryMap Map<String, Object> map);

    @POST("contract-order/x/v1/contract_lever_address")
    Observable<ContractStatusResponse<String>> getContractLerverAddress();

    @POST("contract-order/x/v1/contract_lever_rate")
    Observable<ContractStatusResponse<ContractLeverrate>> getContractLeverrate(@Body Map<String, Object> map);

    @GET("contract-order/x/v1/contract_country_tradingright")
    Observable<ContractStatusResponse<List<KycCountryBean>>> getContractOrderForbiddenCountry();

    @GET("contract-order/x/v1/contract_price_limit")
    Observable<ContractStatusResponse<ContractPriceLimits>> getContractPriceLimit(@QueryMap Map<String, Object> map);

    @POST("contract-center-order/x/v1/center_query_quick_order_setting")
    Observable<ContractStatusResponse<ContractPriceProtectionInfo>> getContractPriceProtection();

    @GET("contract-order/x/v1/contract_estimated_settlement_price")
    Observable<ContractStatusResponse<List<ContractSettlementPrice>>> getContractSettlementPrice(@QueryMap Map<String, Object> map);

    @GET("contract-center-order/x/v1/center_tag")
    Observable<ContractStatusResponse<ContractTagInfo>> getContractTagInfo();

    @GET("contract-order/x/v1/contract_trade_status")
    Observable<ContractStatusResponse<List<ContractTradeStatus>>> getContractTradeStatus();

    @GET("contract-center-order/x/v1/cooling_off_period_info")
    Observable<ContractStatusResponse<ContractCalmPeriodInfo>> getCoolingOffPeriodInfo();

    @POST("contract-order/x/v1/contract_hidden_products")
    Observable<ContractStatusResponse<ContractHiddenInstruments>> getHiddenInstruments();

    @POST("contract-order/x/v1/contract_level_available_margin")
    Observable<ContractStatusResponse<List<LevelAvailableMarginInfo>>> getLevelAvailableMargin(@Body Map<String, Object> map);

    @GET("linear-swap-order/x/v1/linear_swap_country_tradingright")
    Observable<ContractStatusResponse<List<KycCountryBean>>> getLinearSwapOrderForbiddenCountry();

    @POST("contract-order/x/v1/contract_kyc_open_right")
    Observable<ContractStatusResponse<ContractOpenRight>> getOpenRight(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_open_trackorders")
    Observable<ContractStatusResponse<ContractCurrentTrackOrderResult>> getOpenTrackOrder(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_open_order_limit")
    Observable<ContractStatusResponse<OffSiteLimit>> getOrderLimit(@Body Map<String, Object> map);

    @GET("contract-order/x/v1/contract_price_limit")
    Observable<ContractStatusResponse<List<PriceLimitInfo>>> getPriceLimitLevel(@Query("contract_code") String str);

    @POST("contract-order/x/v1/contract_tpsl_openorders")
    Observable<ContractStatusResponse<StopOrderRspResult>> getStopOpenOrders(@Body Map<String, Object> map);

    @GET("swap-order/x/v1/swap_country_tradingright")
    Observable<ContractStatusResponse<List<KycCountryBean>>> getSwapOrderForbiddenCountry();

    @POST("contract-order/x/v1/contract_tpsl_relation_order")
    Observable<ContractStatusResponse<ContractTpSlRelationOrder>> getTpSlRelationOrder(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_user_order_limit")
    Observable<ContractStatusResponse<List<ContractUserOrderLimit>>> getUserOrderLimit(@Body Map<String, Object> map);

    @GET("contract-center-order/x/v1/isPopup")
    Observable<ContractStatusResponse<PopupInfo>> isKeyDialogIsPop(@Query("windowType") String str);

    @POST("contract-order/x/v1/lightning_close_position")
    Observable<ContractStatusResponse<Object>> lightningClosePosition(@Body Map<String, Object> map);

    @GET("contract-order/x/v1/contract_query_trade_unit")
    Observable<ContractStatusResponse<Integer>> queryTradeUnit();

    @POST("contract-order/x/v1/contract_selection_cancel")
    Observable<ContractStatusResponse<ContractCancelOrderResult>> requestCancelOrderAll(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_order")
    Observable<ContractStatusResponse<ContractOrderInsertRspInfo>> requestContractOrder(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_tpsl_order")
    Observable<ContractStatusResponse<ContractTpSlOrderRspInfo>> requestContractTpSlOrder(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_tpsl_frozen_state")
    Observable<ContractStatusResponse<Boolean>> requestCurrentTpslFrozenState(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_reversal_order")
    Observable<ContractStatusResponse<ContractOrderInsertRspInfo>> requestReversal(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_reversal_order_preview")
    Observable<ContractStatusResponse<ReversalEstimatedLiquidationPrice>> requestReversalEstimatedLiquidationPrice(@Body Map<String, Object> map);

    @POST("contract-center-order/x/v1/center_quick_order_setting")
    Observable<ContractStatusResponse<Void>> setContractPriceProtection(@Body Map<String, Integer> map);

    @POST("contract-center-order/x/v1/cooling_off_period")
    Observable<ContractStatusResponse<Void>> setCoolingOffPeriod(@Body Map<String, Long> map);

    @POST("contract-center-order/x/v1/saveWindowInfo")
    Observable<ContractStatusResponse<PopupSetInfo>> setKeyDialogIsPop(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_trackorder_insert")
    Observable<ContractStatusResponse<ContractOrderInsertRspInfo>> trackOrder(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/triggerorder_insert")
    Observable<ContractStatusResponse<ContractOrderInsertRspInfo>> triggerOrderInsert(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_update_trade_unit")
    Observable<ContractStatusResponse<Object>> updateTradeUnit(@Body Map<String, Object> map);
}
