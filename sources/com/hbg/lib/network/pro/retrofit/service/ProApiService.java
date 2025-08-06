package com.hbg.lib.network.pro.retrofit.service;

import com.hbg.lib.network.pro.core.bean.AlgoOrderCancelResult;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.hbg.lib.network.pro.core.bean.AlgoOrderResult;
import com.hbg.lib.network.pro.core.bean.AlgoSpecificOrderInfo;
import com.hbg.lib.network.pro.core.bean.CallAuction;
import com.hbg.lib.network.pro.core.bean.CancelOpenOrdersResult;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.bean.CurrencyRateBean;
import com.hbg.lib.network.pro.core.bean.CurrencyRef;
import com.hbg.lib.network.pro.core.bean.DefiBoxAsset;
import com.hbg.lib.network.pro.core.bean.DefiChainInfo;
import com.hbg.lib.network.pro.core.bean.DepthsInfo;
import com.hbg.lib.network.pro.core.bean.ExchangeOpenOrder;
import com.hbg.lib.network.pro.core.bean.ExchangeSettings;
import com.hbg.lib.network.pro.core.bean.MarginRiskRateBean;
import com.hbg.lib.network.pro.core.bean.MaxOrderAmountBean;
import com.hbg.lib.network.pro.core.bean.PlanCancelOpenOrdersResult;
import com.hbg.lib.network.pro.core.bean.SpotTimeSharingGlobalConfig;
import com.hbg.lib.network.pro.core.bean.SuperMarginRiskRateBean;
import com.hbg.lib.network.pro.core.bean.SuperMarginSymbol;
import com.hbg.lib.network.pro.core.bean.SuperMarginTransferLimit;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.core.bean.UserAddrInfo;
import com.hbg.lib.network.pro.core.bean.WithdrawRiskInfo;
import com.hbg.lib.network.pro.core.response.BigInterfaceResponse;
import com.hbg.lib.network.pro.core.response.IntCodeResponse;
import com.hbg.lib.network.pro.core.response.StringStatusResponse;
import com.hbg.lib.network.pro.socket.bean.FundSituationBean;
import com.hbg.lib.network.pro.socket.bean.KlineFixInfo;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.account.entity.AccountQueryData;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.account.entity.BalanceQueryDataV2;
import com.huobi.currencyconfig.bean.StableCoinCreate;
import com.huobi.currencyconfig.bean.StableCurrencyRateBean;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.margin.entity.OrderConfirmResponse;
import com.huobi.supermargin.bean.MarginOverview;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface ProApiService {
    @POST("v2/algo-orders")
    Observable<IntCodeResponse<AlgoOrderResult>> algoOrder(@Body Map<String, Object> map);

    @GET("v2/algo-orders/historyQuery")
    Observable<IntCodeResponse<List<AlgoOrderInfo>>> algoOrderHistoryQuery(@QueryMap Map<String, Object> map);

    @GET("v2/algo-orders/openingQuery")
    Observable<IntCodeResponse<List<AlgoOrderInfo>>> algoOrderOpeningQuery(@QueryMap Map<String, Object> map);

    @GET("v2/algo-orders/specific")
    Observable<IntCodeResponse<AlgoSpecificOrderInfo>> algoOrderSpecific(@QueryMap Map<String, Object> map);

    @POST("v1/order/orders/batchCancelOpenOrders")
    Observable<StringStatusResponse<CancelOpenOrdersResult>> batchCancelOpenOrders(@Body Map<String, Object> map);

    @POST("v1/defibox/gheco/user/address/bind")
    Observable<IntCodeResponse<String>> bindDefiBoxAddr(@Header("HB-UC-TOKEN") String str, @Body Map<String, Object> map);

    @GET("v1/order/common/canUseIce")
    Observable<StringStatusResponse<Boolean>> canUseIce();

    @POST("v2/algo-orders/cancellation")
    Observable<IntCodeResponse<AlgoOrderCancelResult>> cancelAlgoOrder(@Body Map<String, Object> map);

    @POST("v2/algo-orders/cancelOpenOrders")
    Observable<IntCodeResponse<PlanCancelOpenOrdersResult>> cancelOpenOrders(@Body Map<String, Object> map);

    @GET("v1/dw/withdraw/blacklist/check")
    Observable<StringStatusResponse<Boolean>> checkWithdrawBlacklist();

    @POST("v1/dw/withdraw/check-limit")
    Observable<StringStatusResponse<String>> checkWithdrawLimit(@Body Map<String, Object> map);

    @GET("v1/search/app/search/symbol/history/del")
    Observable<IntCodeResponse<Boolean>> clearSearchHistoryData(@Query("type") String str);

    @POST("v1/dw/withdraw/global-huopay-fast/create")
    Observable<StringStatusResponse<WithdrawRiskInfo>> createHuoPayFast(@HeaderMap Map<String, Object> map, @Body Map<String, Object> map2);

    @POST("v1/hbg/exchangeOrder/create")
    Observable<StringStatusResponse<StableCoinCreate>> createStableCoinOrder(@Body Map<String, Object> map);

    @POST("v1/dw/withdraw/create-2phase")
    Observable<StringStatusResponse<String>> createWithdrawOrderPhase1(@Body Map<String, Object> map);

    @GET("v1/account/accounts/{accountId}/balance")
    Observable<StringStatusResponse<BalanceQueryData>> getAccountBalance(@Path("accountId") long j11);

    @GET("v2/account/accounts/{accountId}/balance")
    Observable<StringStatusResponse<BalanceQueryDataV2>> getAccountBalanceV2(@Path("accountId") long j11);

    @GET("v1/account/accounts")
    Observable<StringStatusResponse<List<AccountQueryData>>> getAccounts();

    @GET("v1/settings/common/chains")
    Observable<BigInterfaceResponse<List<ChainInfo>>> getChainListWithDiff(@QueryMap Map<String, Object> map);

    @GET("v1/common/exchange")
    Observable<StringStatusResponse<ExchangeSettings>> getCommonExchange(@QueryMap Map<String, Object> map);

    @GET("v2/reference/currencies")
    Observable<IntCodeResponse<List<CurrencyRef>>> getCurrenciesReference();

    @GET("v2/settings/common/currencies")
    Observable<BigInterfaceResponse<List<CurrencyBean>>> getCurrenciesWithDiff(@Query("language") String str, @Query("ts") String str2);

    @GET
    Observable<IntCodeResponse<List<CurrencyRateBean>>> getCurrencyRateList(@Url String str);

    @GET("v1/defibox/gheco/user/address")
    Observable<IntCodeResponse<List<UserAddrInfo>>> getDefiBoUserAddrList(@Header("HB-UC-TOKEN") String str, @Query("uid") String str2);

    @GET("v1/defibox/gheco/address/asset")
    Observable<IntCodeResponse<DefiBoxAsset>> getDefiBoxAsset(@Header("HB-UC-TOKEN") String str, @QueryMap Map<String, Object> map);

    @GET("v1/defibox/gheco/chain/list")
    Observable<IntCodeResponse<List<DefiChainInfo>>> getDefiBoxChainList();

    @GET("/-/x/qs/summary/forecast")
    Observable<IntCodeResponse<CallAuction>> getForeCast(@Query("symbol") String str);

    @GET
    Observable<ResponseBody> getH5UrlRequest(@Url String str, @HeaderMap Map<String, String> map, @QueryMap Map<String, Object> map2);

    @GET("/-/x/qs/summary/history")
    Observable<IntCodeResponse<List<FundSituationBean.FundSituationItem>>> getHistoryFundSituation(@Query("symbol") String str, @Query("period") String str2, @Query("size") int i11);

    @GET("quotation/market/history/kline")
    Observable<IntCodeResponse<List<KlineInfo>>> getIndexKline(@Query("symbol") String str, @Query("period") String str2, @Query("limit") int i11);

    @GET("/-/x/qs/summary/kline/update")
    Observable<StringStatusResponse<List<KlineFixInfo>>> getKlineFixInfo(@Query("symbol") String str, @Query("period") String str2);

    @GET("/-/x/qs/summary/latest")
    Observable<IntCodeResponse<FundSituationBean>> getLastFundSituation(@Query("symbol") String str);

    @GET("v1/margin/accounts/balance")
    Observable<StringStatusResponse<List<MarginBalanceQueryData>>> getMaginBalanceWithSymbol(@Query("symbol") String str);

    @GET("v1/margin/accounts/balance")
    Observable<StringStatusResponse<List<MarginBalanceQueryData>>> getMaginBalanceWithSymbols(@Query("symbols") String str);

    @GET("v1/margin/judgment")
    Observable<StringStatusResponse<Integer>> getMarginJudgment();

    @GET("v1/hbg/super-margin/margin-overview")
    Observable<StringStatusResponse<MarginOverview>> getMarginOverview(@Query("account-id") long j11);

    @GET("v1/margin/riskRate")
    Observable<StringStatusResponse<MarginRiskRateBean>> getMarginRiskRate(@Query("symbol") String str);

    @GET("v1/order/openOrders")
    Observable<StringStatusResponse<List<ExchangeOpenOrder>>> getOpenOrders(@QueryMap Map<String, Object> map);

    @GET("v1/order/orders/confirm")
    Observable<StringStatusResponse<OrderConfirmResponse>> getOrderConfirmInfo(@Query("account-id") String str, @Query("symbol") String str2, @Query("order-type") String str3, @Query("order-side") String str4, @Query("amount") String str5, @Query("margin-amount") String str6, @Query("price") String str7);

    @GET("v1/search/app/search/symbol/history/get")
    Observable<IntCodeResponse<List<String>>> getSearchHistoryData(@QueryMap Map<String, Object> map);

    @GET("v1/hbg/stableCoin/info")
    Observable<StringStatusResponse<StableCurrencyRateBean>> getStableCurrencyRate();

    @GET("v1/hbg/super-margin/riskRate")
    Observable<StringStatusResponse<SuperMarginRiskRateBean>> getSuperMarginRiskRate(@Query("currency") String str);

    @POST("v1/margin/order/max-order-amount")
    Observable<StringStatusResponse<MaxOrderAmountBean>> getSuperMarginRiskRate(@Body Map<String, Object> map);

    @GET("v1/hbg/super-margin/symbols")
    Observable<StringStatusResponse<List<SuperMarginSymbol>>> getSuperMarginSymbols();

    @GET("v1/hbg/super-margin/currency-transfer-limit/prompt")
    Observable<StringStatusResponse<SuperMarginTransferLimit>> getSuperMarginTransferLimit(@QueryMap Map<String, Object> map);

    @GET("market/symbols")
    Observable<StringStatusResponse<Map<String, DepthsInfo>>> getSymbolDepthInfo();

    @GET("market/overview")
    Observable<StringStatusResponse<List<SymbolPrice>>> getSymbolPrice();

    @GET("v2/settings/common/symbols")
    Observable<BigInterfaceResponse<List<SymbolBean>>> getSymbolsWithDiff(@Query("ts") String str);

    @GET("v2/algo-orders/period")
    Observable<IntCodeResponse<SpotTimeSharingGlobalConfig>> getTimeSharingGlobalConfigInfo();

    @GET("v1/common/timestamp")
    Observable<StringStatusResponse<Long>> getTimeStamp();

    @POST("v1/search/app/search/symbol/collect")
    Observable<IntCodeResponse<Object>> insertSearchHistoryData(@Body Map<String, Object> map);

    @POST("v1/hbg/exchangeOrder/place/{orderId}")
    Observable<StringStatusResponse<String>> placeStableCoinOrder(@Path("orderId") String str);

    @POST("v1/dw/withdraw/place-2phase")
    Observable<StringStatusResponse<WithdrawRiskInfo>> placeWithdrawOrderPhase2(@Body Map<String, Object> map);

    @POST
    Observable<ResponseBody> postH5UrlRequest(@Url String str, @HeaderMap Map<String, String> map, @Body Map<String, Object> map2);

    @POST("v2/account/transfer")
    Observable<IntCodeResponse<Long>> requestAccountTransfer(@Body Map<String, Object> map);

    @POST("v1/minepool/transfer-in")
    Observable<StringStatusResponse<Object>> transferInMine(@Body Map<String, Object> map);

    @POST("v1/minepool/transfer-out")
    Observable<StringStatusResponse<Object>> transferOutMine(@Body Map<String, Object> map);

    @POST("v1/defibox/gheco/user/address/unbind")
    Observable<IntCodeResponse<String>> unbindDefiBoxAddr(@Header("HB-UC-TOKEN") String str, @Body Map<String, Object> map);
}
