package com.hbg.lib.network.pro;

import android.content.Context;
import c9.b;
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
import com.hbg.lib.network.pro.core.util.DepthType;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.core.util.TransferAccountType;
import com.hbg.lib.network.pro.socket.bean.KlineFixInfo;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.listener.KLineListener;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.listener.MarketDepthPercentListener;
import com.hbg.lib.network.pro.socket.listener.MarketDetailListener;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListenerV2;
import com.hbg.lib.network.pro.socket.listener.MarketTradeDetailListener;
import com.hbg.lib.network.pro.socket.listener.RequestMarketTradeDetailListener;
import com.huobi.account.entity.AccountQueryData;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.account.entity.BalanceQueryDataV2;
import com.huobi.currencyconfig.bean.StableCoinCreate;
import com.huobi.currencyconfig.bean.StableCurrencyRateBean;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.margin.entity.OrderConfirmResponse;
import com.huobi.supermargin.bean.MarginOverview;
import d9.a;
import g9.a;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.http.QueryMap;

public interface IProApi {
    a<String> A(String str, String str2, String str3, String str4);

    a<CancelOpenOrdersResult> B(Long l11, String str, String str2, String str3, int i11);

    a<BigInterfaceResponse<List<SymbolBean>>> C(String str);

    a<DefiBoxAsset> D(String str, String str2, String str3, String str4);

    a<Object> E(String str, String str2);

    void a(String str, Context context, b bVar);

    a<AlgoOrderResult> algoOrder(Map<String, Object> map);

    a<List<AlgoOrderInfo>> algoOrderHistoryQuery(@QueryMap Map<String, Object> map);

    a<List<AlgoOrderInfo>> algoOrderOpeningQuery(@QueryMap Map<String, Object> map);

    a<AlgoSpecificOrderInfo> algoOrderSpecific(@QueryMap Map<String, Object> map);

    void b();

    void c(a.d dVar);

    d9.a<Boolean> canUseIce();

    d9.a<AlgoOrderCancelResult> cancelAlgoOrder(Map<String, Object> map);

    d9.a<Boolean> checkWithdrawBlacklist();

    d9.a<String> checkWithdrawLimit(Map<String, Object> map);

    d9.a<Boolean> clearSearchHistoryData(String str);

    d9.a<StableCoinCreate> createStableCoinOrder(Map<String, Object> map);

    d9.a<String> createWithdrawOrderPhase1(Map<String, Object> map);

    void d(a.d dVar);

    void e(boolean z11, MarketOverviewListener marketOverviewListener);

    void f(String str, Period period, long j11, long j12, KLineListener kLineListener);

    void g(boolean z11, String str, Period period, LastKlineListener lastKlineListener);

    d9.a<BalanceQueryData> getAccountBalance(long j11);

    d9.a<BalanceQueryDataV2> getAccountBalanceV2(long j11);

    d9.a<List<AccountQueryData>> getAccounts();

    d9.a<List<CurrencyRef>> getCurrenciesReference();

    d9.a<BigInterfaceResponse<List<CurrencyBean>>> getCurrenciesWithDiff(String str, String str2);

    d9.a<List<UserAddrInfo>> getDefiBoUserAddrList(String str, String str2);

    d9.a<List<DefiChainInfo>> getDefiBoxChainList();

    d9.a<CallAuction> getForeCast(String str);

    d9.a<ResponseBody> getH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2);

    d9.a<List<KlineInfo>> getIndexKline(String str, String str2, int i11);

    d9.a<List<KlineFixInfo>> getKlineFixInfo(String str, String str2);

    d9.a<List<MarginBalanceQueryData>> getMaginBalanceWithSymbol(String str);

    d9.a<List<MarginBalanceQueryData>> getMaginBalanceWithSymbols(String str);

    d9.a<Integer> getMarginJudgment();

    d9.a<MarginOverview> getMarginOverview(long j11);

    d9.a<MarginRiskRateBean> getMarginRiskRate(String str);

    d9.a<OrderConfirmResponse> getOrderConfirmInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    d9.a<List<String>> getSearchHistoryData(Map<String, Object> map);

    d9.a<StableCurrencyRateBean> getStableCurrencyRate();

    d9.a<SuperMarginRiskRateBean> getSuperMarginRiskRate(String str);

    d9.a<MaxOrderAmountBean> getSuperMarginRiskRate(Map<String, Object> map);

    d9.a<List<SuperMarginSymbol>> getSuperMarginSymbols();

    d9.a<Map<String, DepthsInfo>> getSymbolDepthInfo();

    d9.a<List<SymbolPrice>> getSymbolPrice();

    d9.a<SpotTimeSharingGlobalConfig> getTimeSharingGlobalConfigInfo();

    d9.a<Long> getTimeStamp();

    void h(boolean z11, String str, String str2, int i11, MarketDepthListener marketDepthListener);

    void i(String str, RequestMarketTradeDetailListener requestMarketTradeDetailListener, int i11);

    d9.a<Object> insertSearchHistoryData(Map<String, Object> map);

    void j(boolean z11, String str, MarketDetailListener marketDetailListener);

    void k(boolean z11, String str, MarketTradeDetailListener marketTradeDetailListener);

    void l(boolean z11, String str, String str2, MarketDepthListener marketDepthListener);

    d9.a<Object> m(String str, String str2);

    d9.a<Long> n(TransferAccountType transferAccountType, TransferAccountType transferAccountType2, String str, String str2, String str3);

    d9.a<SuperMarginTransferLimit> o(String str);

    d9.a<PlanCancelOpenOrdersResult> p(String str, String str2, int i11);

    d9.a<String> placeStableCoinOrder(String str);

    d9.a<WithdrawRiskInfo> placeWithdrawOrderPhase2(Map<String, Object> map);

    d9.a<ResponseBody> postH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2);

    d9.a<Long> q(TransferAccountType transferAccountType, TransferAccountType transferAccountType2, String str, String str2);

    d9.a<List<CurrencyRateBean>> r(String str);

    d9.a<Long> s(TransferAccountType transferAccountType, TransferAccountType transferAccountType2, String str, String str2, String str3);

    void t(boolean z11, MarketOverviewListenerV2 marketOverviewListenerV2);

    d9.a<String> u(String str, String str2, List<String> list, String str3);

    void v(boolean z11, String str, DepthType depthType, MarketDepthPercentListener marketDepthPercentListener);

    d9.a<ExchangeSettings> w(String str);

    d9.a<List<ExchangeOpenOrder>> x(long j11, String str, String str2, String str3, long j12, String str4, int i11, String str5);

    d9.a<BigInterfaceResponse<List<ChainInfo>>> y(String str, String str2, String str3, String str4);

    d9.a<WithdrawRiskInfo> z(Map<String, Object> map, Map<String, Object> map2);
}
