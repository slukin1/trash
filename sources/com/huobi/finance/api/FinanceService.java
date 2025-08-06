package com.huobi.finance.api;

import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.network.pro.core.bean.RiskActionData;
import com.hbg.lib.network.pro.core.bean.WithdrawRiskInfo;
import com.huobi.finance.bean.AddVirtualAddressParams;
import com.huobi.finance.bean.CurrencyAddrWithTag;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.bean.InnerWithdrawAddress;
import com.huobi.finance.bean.LimitDescription;
import com.huobi.finance.bean.LoanOrderItem;
import com.huobi.finance.bean.MarginSettings;
import com.huobi.finance.bean.OneOffAddress;
import com.huobi.finance.bean.OtcFinanceRecordItem;
import com.huobi.finance.bean.OtcFinanceResponse;
import com.huobi.finance.bean.PlatformBalanceBean;
import com.huobi.finance.bean.PreWithdrawData;
import com.huobi.finance.bean.TransferOrderHistory;
import com.huobi.finance.bean.VirtualAddressInfo;
import com.huobi.finance.bean.WithdrawAuditCheck;
import java.util.ArrayList;
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

public interface FinanceService {
    @POST("v1/dw/withdraw/addresses")
    Observable<StringStatusResponse<Object>> addWithdrawAddress(@HeaderMap Map<String, Object> map, @Body VirtualAddressInfo virtualAddressInfo);

    @POST("v1/dw/withdraw/addresses-with-risk")
    Observable<StringStatusResponse<WithdrawRiskInfo>> addWithdrawAddressWithRisk(@HeaderMap Map<String, Object> map, @Body AddVirtualAddressParams addVirtualAddressParams);

    @GET("v1/dw/withdraw-virtual/addresses/count")
    Observable<StringStatusResponse<Map<String, Integer>>> addressesCount();

    @POST("v1/dw/withdraw/create-with-risk")
    Observable<StringStatusResponse<WithdrawRiskInfo>> createWithdrawOrder(@HeaderMap Map<String, Object> map, @Body Map<String, Object> map2);

    @POST("v1/dw/withdraw/addresses/{address-id}/delete")
    Observable<StringStatusResponse<String>> deleteWithdrawAddress(@Path("address-id") String str, @HeaderMap Map<String, Object> map);

    @GET("v1/dw/deposit-virtual/addresses")
    Observable<StringStatusResponse<String>> getDepositAddress(@QueryMap Map<String, Object> map);

    @GET("v1/dw/deposit-virtual/sharedAddressWithTag")
    Observable<StringStatusResponse<CurrencyAddrWithTag>> getDepositAddressWithTag(@QueryMap Map<String, Object> map);

    @GET("v1/global-exchange/get-inner-withdraw-address")
    Observable<StringStatusResponse<List<InnerWithdrawAddress>>> getInnerWithdrawAddress(@Query("currency") String str);

    @GET("v1/margin/loan-orders")
    Observable<StringStatusResponse<List<LoanOrderItem>>> getLoanOrders(@QueryMap Map<String, Object> map);

    @GET("v1/dw/withdraw/risk/actions/{order-id}/{type}")
    Observable<StringStatusResponse<RiskActionData>> getRiskActions(@Path("order-id") long j11, @Path("type") int i11);

    @GET("v1/dw/withdraw-virtual/addresses")
    Observable<StringStatusResponse<ArrayList<VirtualAddressInfo>>> getWithdrawAddress(@QueryMap Map<String, Object> map);

    @GET("v1/dw/withdraw/risk/actions/withdraw-address-order")
    Observable<StringStatusResponse<RiskActionData>> getWithdrawAddressStatus(@QueryMap Map<String, Object> map);

    @GET("v1/query/dw/withdraw-virtual/limitdetails")
    Observable<StringStatusResponse<LimitDescription>> limitdetails(@Query("currency") String str);

    @POST("v1/margin/orders")
    Observable<StringStatusResponse<Long>> loanMargin(@Body Map<String, Object> map);

    @GET("v1/margin/finances")
    Observable<StringStatusResponse<List<TransferOrderHistory>>> marginFinances(@QueryMap Map<String, Object> map);

    @GET("v1/margin/settings")
    Observable<StringStatusResponse<MarginSettings>> marginSettings(@Query("symbol") String str);

    @GET("v1/dw/deposit-virtual/oneoff-address/assign")
    Observable<StringStatusResponse<OneOffAddress>> oneOffAddressAssign(@QueryMap Map<String, Object> map);

    @GET("v1/dw/deposit-virtual/oneoff-address/query")
    Observable<StringStatusResponse<List<OneOffAddress>>> oneOffAddressQuery(@QueryMap Map<String, Object> map);

    @GET("v1/margin/platform/balance/check")
    Observable<StringStatusResponse<List<PlatformBalanceBean>>> platformBalanceCheck(@Query("symbol") String str);

    @GET("v1/dw/withdraw/get-prewithdraw")
    Observable<StringStatusResponse<PreWithdrawData>> preWithdrawData(@QueryMap Map<String, Object> map);

    @GET("v1/query/finances")
    Observable<StringStatusResponse<List<FinanceRecordItem>>> queryAllFinances(@QueryMap Map<String, Object> map);

    @GET("v1/capital/balance-list")
    Observable<OtcFinanceResponse<List<OtcFinanceRecordItem>>> queryFinances(@QueryMap Map<String, Object> map);

    @POST("v1/margin/orders/{order-id}/repay")
    Observable<StringStatusResponse<Object>> repayMargin(@Path("order-id") String str, @Body Map<String, String> map);

    @POST("v1/dw/withdraw/sync-state-after-risk-action")
    Observable<StringStatusResponse<Object>> syncStateAfterRiskAction(@Query("order-id") long j11);

    @POST("v1/dw/transfer-in/margin")
    Observable<StringStatusResponse<Object>> transferIn(@Body Map<String, Object> map);

    @POST("v1/dw/transfer-out/margin")
    Observable<StringStatusResponse<Object>> transferOut(@Body Map<String, Object> map);

    @GET("v1/dw/withdraw/audit-check")
    Observable<StringStatusResponse<WithdrawAuditCheck>> withdrawAuditCheck(@QueryMap Map<String, Object> map);

    @POST("v1/dw/withdraw-virtual/{withdraw-id}/cancel")
    Observable<StringStatusResponse<Object>> withdrawCancel(@Path("withdraw-id") long j11);

    @POST("v1/dw/withdraw/verify-identity")
    Observable<StringStatusResponse<Boolean>> withdrawVerifyIdentity(@Body Map<String, Object> map);
}
