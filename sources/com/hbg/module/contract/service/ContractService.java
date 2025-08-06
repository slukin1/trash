package com.hbg.module.contract.service;

import com.hbg.lib.network.contract.core.bean.ContractHoldAmount;
import com.hbg.lib.network.contract.core.response.ContractStatusResponse;
import com.huobi.contract.entity.ContractActivityInfo;
import com.huobi.contract.entity.ContractCancelAllResult;
import com.huobi.contract.entity.ContractCancelResult;
import com.huobi.contract.entity.ContractCurrentOrderResult;
import com.huobi.contract.entity.ContractCurrentTriggerOrderResult;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.entity.ContractHistoryOrderResult;
import com.huobi.contract.entity.ContractHistoryTriggerOrderResult;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.contract.entity.ContractOrderDetailResult;
import com.huobi.contract.entity.ContractOrderRspInfo;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.contract.entity.ContractPriceInfo;
import com.huobi.contract.entity.ContractProBalanceInfo;
import com.huobi.contract.entity.ContractTriggerProtectInfo;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.finance.bean.ContractRecordWrapper;
import com.huobi.finance.bean.ContractTransferResult;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface ContractService {
    @GET("contract-order/x/v1/profit_ratio_rank_activity")
    Observable<ContractStatusResponse<ContractActivityInfo>> activityInfo(@Query("activity_id") String str);

    @POST("contract-order/x/v1/contract_cancel")
    Observable<ContractStatusResponse<ContractCancelResult>> contractCancel(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_cancelall")
    Observable<ContractStatusResponse<ContractCancelAllResult>> contractCancelAll(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_order_detail")
    Observable<ContractStatusResponse<ContractOrderDetailResult>> contractOrderInfo(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/triggerorder_cancel")
    Observable<ContractStatusResponse<ContractCancelResult>> contractTriggerCancel(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/triggerorder_cancelall")
    Observable<ContractStatusResponse<ContractCancelAllResult>> contractTriggerCancelAll(@Body Map<String, Object> map);

    @GET("contract-order/x/v1/contract_open_interest")
    Observable<ContractStatusResponse<List<ContractHoldAmount>>> getContractHoldAmount(@QueryMap Map<String, Object> map);

    @GET("contract-order/x/v1/contract_opencount")
    Observable<ContractStatusResponse<ContractOpenCountInfo>> getContractOpenCountInfo();

    @POST("contract-order/x/v1/contract_position_info_data")
    Observable<ContractStatusResponse<List<ContractPosition>>> getContractPosition(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_openorders")
    Observable<ContractStatusResponse<ContractCurrentOrderResult>> getCurrentOrder(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_open_triggerorders")
    Observable<ContractStatusResponse<ContractCurrentTriggerOrderResult>> getCurrentTriggerOrder(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_account_action")
    Observable<ContractStatusResponse<ContractRecordWrapper>> getFinanceRecord(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_hisorders")
    Observable<ContractStatusResponse<ContractHistoryOrderResult>> getHistoryOrder(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_his_triggerorders")
    Observable<ContractStatusResponse<ContractHistoryTriggerOrderResult>> getHistoryTriggerOrder(@Body Map<String, Object> map);

    @GET("contract-order/x/v1/contract_mark_price")
    Observable<ContractStatusResponse<String>> getMarketPriceInfo(@Query("contract_code") String str);

    @GET("contract-order/x/v1/contract_index")
    Observable<ContractStatusResponse<List<ContractPriceInfo>>> getPriceInfo();

    @POST("contract-order/x/v1/contract_spotaccount_info")
    Observable<ContractStatusResponse<List<ContractProBalanceInfo>>> getProBalanceInfo(@Body Map<String, Object> map);

    @POST("contract-center-order/x/v1/center_login")
    Observable<ContractStatusResponse<ContractUserInfo>> login(@Body Map<String, Object> map);

    @POST("contract-order/x/v1/contract_order_info")
    Observable<ContractStatusResponse<List<ContractOrderRspInfo>>> requestContractOrderInfo(@Body Map<String, Object> map);

    @GET("heartbeat/")
    Observable<ContractStatusResponse<ContractHeartBeat>> systemStatus();

    @POST("contract-order/x/v1/contract_transfer")
    Observable<ContractStatusResponse<ContractTransferResult>> transferCurrency(@Header("HB-PRO-TOKEN") String str, @Body Map<String, Object> map);

    @GET("contract-order/x/v1/contract_trigger_protect")
    Observable<ContractStatusResponse<ContractTriggerProtectInfo>> triggerProtect(@Query("contract_code") String str);

    @POST("contract-order/x/v1/contract_user_info")
    Observable<ContractStatusResponse<ContractUserInfo.UserBean>> userInfo();
}
