package com.hbg.lib.network.pro.retrofit;

import a9.c;
import android.content.Context;
import android.text.TextUtils;
import c9.b;
import cn.sharesdk.framework.InnerShareParams;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.network.pro.IProApi;
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
import com.hbg.lib.network.pro.core.response.StringStatusResponse;
import com.hbg.lib.network.pro.core.util.DepthType;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.core.util.TransferAccountType;
import com.hbg.lib.network.pro.retrofit.service.ProApiService;
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
import com.hbg.lib.network.pro.socket.request.KlineRequest;
import com.hbg.lib.network.pro.socket.request.TradeDetailRequest;
import com.hbg.lib.network.pro.socket.subscribe.LastKlineSub;
import com.hbg.lib.network.pro.socket.subscribe.MarketDepthSub;
import com.hbg.lib.network.pro.socket.subscribe.MarketDetailSub;
import com.hbg.lib.network.pro.socket.subscribe.MarketInfoDepthPercentSub;
import com.hbg.lib.network.pro.socket.subscribe.MarketOverviewV2Sub;
import com.hbg.lib.network.pro.socket.subscribe.TradeDetailSub;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.huobi.account.entity.AccountQueryData;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.account.entity.BalanceQueryDataV2;
import com.huobi.currencyconfig.bean.StableCoinCreate;
import com.huobi.currencyconfig.bean.StableCurrencyRateBean;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.margin.entity.OrderConfirmResponse;
import com.huobi.supermargin.bean.MarginOverview;
import com.twitter.sdk.android.core.identity.AuthHandler;
import d9.a;
import g9.a;
import g9.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.ResponseBody;

public class ProApiRetrofitImpl implements IProApi {

    /* renamed from: a  reason: collision with root package name */
    public i f70623a;

    /* renamed from: b  reason: collision with root package name */
    public b f70624b;

    /* renamed from: c  reason: collision with root package name */
    public SimpleDateFormat f70625c = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss", Locale.US);

    /* renamed from: d  reason: collision with root package name */
    public String f70626d;

    public static /* synthetic */ StringStatusResponse K(BigInterfaceResponse bigInterfaceResponse) {
        StringStatusResponse stringStatusResponse = new StringStatusResponse();
        stringStatusResponse.setStatus(bigInterfaceResponse.getStatus());
        stringStatusResponse.setErrMsg(bigInterfaceResponse.getErrMsg());
        stringStatusResponse.setErrCode(bigInterfaceResponse.getErrCode());
        stringStatusResponse.setData(bigInterfaceResponse);
        return stringStatusResponse;
    }

    public static /* synthetic */ StringStatusResponse L(BigInterfaceResponse bigInterfaceResponse) {
        StringStatusResponse stringStatusResponse = new StringStatusResponse();
        stringStatusResponse.setErrCode(bigInterfaceResponse.getErrCode());
        stringStatusResponse.setErrMsg(bigInterfaceResponse.getErrMsg());
        stringStatusResponse.setStatus(bigInterfaceResponse.getStatus());
        stringStatusResponse.setData(bigInterfaceResponse);
        return stringStatusResponse;
    }

    public static /* synthetic */ StringStatusResponse M(BigInterfaceResponse bigInterfaceResponse) {
        StringStatusResponse stringStatusResponse = new StringStatusResponse();
        stringStatusResponse.setStatus(bigInterfaceResponse.getStatus());
        stringStatusResponse.setErrMsg(bigInterfaceResponse.getErrMsg());
        stringStatusResponse.setErrCode(bigInterfaceResponse.getErrCode());
        stringStatusResponse.setData(bigInterfaceResponse);
        return stringStatusResponse;
    }

    public a<String> A(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str2);
        hashMap.put("chain", str3);
        hashMap.put(InnerShareParams.ADDRESS, str4);
        return new a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).unbindDefiBoxAddr(str, hashMap).compose(ProRetrofit.h()));
    }

    public a<CancelOpenOrdersResult> B(Long l11, String str, String str2, String str3, int i11) {
        HashMap hashMap = new HashMap();
        if (l11 != null) {
            hashMap.put("account-id", l11);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("symbol", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("types", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("side", str3);
        }
        if (i11 > 0) {
            hashMap.put("size", Integer.valueOf(i11));
        }
        hashMap.put("canceled-source", "user-actively-cancels-order-android");
        return new a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).batchCancelOpenOrders(hashMap).compose(ProRetrofit.o()));
    }

    public a<BigInterfaceResponse<List<SymbolBean>>> C(String str) {
        return new a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getSymbolsWithDiff(str).map(a9.b.f3499b).compose(ProRetrofit.o()));
    }

    public a<DefiBoxAsset> D(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str2);
        hashMap.put("chain", str3);
        hashMap.put(InnerShareParams.ADDRESS, str4);
        return new a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getDefiBoxAsset(str, hashMap).compose(ProRetrofit.h()));
    }

    public a<Object> E(String str, String str2) {
        HashMap hashMap = new HashMap(2);
        if (str != null) {
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, str.toLowerCase(Locale.US));
        }
        hashMap.put("amount", str2);
        return new a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).transferInMine(hashMap).compose(ProRetrofit.o()));
    }

    public void I() {
        RetrofitLogger.a(this.f70626d + "-->connectWebSocket");
        b bVar = this.f70624b;
        if (bVar != null) {
            String webSocketHost = bVar.getWebSocketHost();
            if (!TextUtils.isEmpty(webSocketHost)) {
                if (this.f70623a == null) {
                    this.f70623a = new i(ProRetrofit.g().getTag(), ProRetrofit.g().createSocketOkHttpClientBuilder().build(), this.f70624b);
                }
                this.f70623a.m(webSocketHost);
            }
        }
    }

    public final boolean J() {
        i iVar = this.f70623a;
        return iVar != null && iVar.q();
    }

    public final void N(boolean z11, MarketOverviewListener marketOverviewListener) {
        if (marketOverviewListener != null) {
            marketOverviewListener.j(MarketOverviewListener.OverviewVersion.VERSION_2);
        }
        if (z11 && !J()) {
            I();
        }
        i iVar = this.f70623a;
        if (iVar != null) {
            iVar.u(new MarketOverviewV2Sub(z11), marketOverviewListener);
        }
    }

    public void a(String str, Context context, b bVar) {
        this.f70626d = str;
        RetrofitLogger.a(this.f70626d + "-->init");
        this.f70624b = bVar;
        ProRetrofit.g().init(str, context, bVar);
    }

    public a<AlgoOrderResult> algoOrder(Map<String, Object> map) {
        return new a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).algoOrder(map).compose(ProRetrofit.h()));
    }

    public a<List<AlgoOrderInfo>> algoOrderHistoryQuery(Map<String, Object> map) {
        return new a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).algoOrderHistoryQuery(map).compose(ProRetrofit.h()));
    }

    public a<List<AlgoOrderInfo>> algoOrderOpeningQuery(Map<String, Object> map) {
        return new a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).algoOrderOpeningQuery(map).compose(ProRetrofit.h()));
    }

    public a<AlgoSpecificOrderInfo> algoOrderSpecific(Map<String, Object> map) {
        return new a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).algoOrderSpecific(map).compose(ProRetrofit.h()));
    }

    public void b() {
        RetrofitLogger.a(this.f70626d + "-->disconnectWebSocket");
        i iVar = this.f70623a;
        if (iVar != null) {
            iVar.n();
        }
    }

    public void c(a.d dVar) {
        RetrofitLogger.a(this.f70626d + "-->removeReconnectListener-->" + dVar);
        i iVar = this.f70623a;
        if (iVar != null) {
            iVar.r(dVar);
        }
    }

    public d9.a<Boolean> canUseIce() {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).canUseIce().compose(ProRetrofit.o()));
    }

    public d9.a<AlgoOrderCancelResult> cancelAlgoOrder(Map<String, Object> map) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).cancelAlgoOrder(map).compose(ProRetrofit.h()));
    }

    public d9.a<Boolean> checkWithdrawBlacklist() {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).checkWithdrawBlacklist().compose(ProRetrofit.o()));
    }

    public d9.a<String> checkWithdrawLimit(Map<String, Object> map) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).checkWithdrawLimit(map).compose(ProRetrofit.o()));
    }

    public d9.a<Boolean> clearSearchHistoryData(String str) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).clearSearchHistoryData(str).compose(ProRetrofit.h()));
    }

    public d9.a<StableCoinCreate> createStableCoinOrder(Map<String, Object> map) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).createStableCoinOrder(map).compose(ProRetrofit.o()));
    }

    public d9.a<String> createWithdrawOrderPhase1(Map<String, Object> map) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).createWithdrawOrderPhase1(map).compose(ProRetrofit.o()));
    }

    public void d(a.d dVar) {
        RetrofitLogger.a(this.f70626d + "-->addReconnectListener-->" + dVar);
        i iVar = this.f70623a;
        if (iVar != null) {
            iVar.h(dVar);
        }
    }

    public void e(boolean z11, MarketOverviewListener marketOverviewListener) {
        RetrofitLogger.a(this.f70626d + "-->subscribeMarketOverview--> isSubscribe=" + z11 + " listener=" + marketOverviewListener);
        N(z11, marketOverviewListener);
    }

    public void f(String str, Period period, long j11, long j12, KLineListener kLineListener) {
        Period period2 = period;
        long j13 = j11;
        long j14 = j12;
        RetrofitLogger.a(this.f70626d + "-->requestKLineList--> symbol=" + str + " period=" + period2 + " from=" + j13 + "(*1000=" + this.f70625c.format(new Date(j13 * 1000)) + ") to=" + j14 + "(*1000=" + this.f70625c.format(new Date(j14 * 1000)) + ")");
        if (!J()) {
            I();
        }
        i iVar = this.f70623a;
        if (iVar != null) {
            iVar.u(new KlineRequest(str, period2.value, j11, j12), kLineListener);
        }
    }

    public void g(boolean z11, String str, Period period, LastKlineListener lastKlineListener) {
        RetrofitLogger.a(this.f70626d + "-->subscribeLastKline--> isSubscribe=" + z11 + " symbol=" + str + " period=" + period + " listener=" + lastKlineListener);
        if (z11 && !J()) {
            I();
        }
        i iVar = this.f70623a;
        if (iVar != null) {
            iVar.u(new LastKlineSub(z11, str, period.value), lastKlineListener);
        }
    }

    public d9.a<BalanceQueryData> getAccountBalance(long j11) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getAccountBalance(j11).compose(ProRetrofit.o()));
    }

    public d9.a<BalanceQueryDataV2> getAccountBalanceV2(long j11) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getAccountBalanceV2(j11).compose(ProRetrofit.o()));
    }

    public d9.a<List<AccountQueryData>> getAccounts() {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getAccounts().compose(ProRetrofit.o()));
    }

    public d9.a<List<CurrencyRef>> getCurrenciesReference() {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getCurrenciesReference().compose(ProRetrofit.h()));
    }

    public d9.a<BigInterfaceResponse<List<CurrencyBean>>> getCurrenciesWithDiff(String str, String str2) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getCurrenciesWithDiff(str, str2).map(c.f3500b).compose(ProRetrofit.o()));
    }

    public d9.a<List<UserAddrInfo>> getDefiBoUserAddrList(String str, String str2) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getDefiBoUserAddrList(str, str2).compose(ProRetrofit.h()));
    }

    public d9.a<List<DefiChainInfo>> getDefiBoxChainList() {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getDefiBoxChainList().compose(ProRetrofit.h()));
    }

    public d9.a<CallAuction> getForeCast(String str) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getForeCast(str).compose(ProRetrofit.h()));
    }

    public d9.a<ResponseBody> getH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getH5UrlRequest(str, map, map2));
    }

    public d9.a<List<KlineInfo>> getIndexKline(String str, String str2, int i11) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getIndexKline(str, str2, i11).compose(ProRetrofit.h()));
    }

    public d9.a<List<KlineFixInfo>> getKlineFixInfo(String str, String str2) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getKlineFixInfo(str, str2).compose(ProRetrofit.o()));
    }

    public d9.a<List<MarginBalanceQueryData>> getMaginBalanceWithSymbol(String str) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getMaginBalanceWithSymbol(str).compose(ProRetrofit.o()));
    }

    public d9.a<List<MarginBalanceQueryData>> getMaginBalanceWithSymbols(String str) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getMaginBalanceWithSymbols(str).compose(ProRetrofit.o()));
    }

    public d9.a<Integer> getMarginJudgment() {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getMarginJudgment().compose(ProRetrofit.o()));
    }

    public d9.a<MarginOverview> getMarginOverview(long j11) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getMarginOverview(j11).compose(ProRetrofit.o()));
    }

    public d9.a<MarginRiskRateBean> getMarginRiskRate(String str) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getMarginRiskRate(str).compose(ProRetrofit.o()));
    }

    public d9.a<OrderConfirmResponse> getOrderConfirmInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getOrderConfirmInfo(str, str2, str3, str4, str5, str6, str7).compose(ProRetrofit.o()));
    }

    public d9.a<List<String>> getSearchHistoryData(Map<String, Object> map) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getSearchHistoryData(map).compose(ProRetrofit.h()));
    }

    public d9.a<StableCurrencyRateBean> getStableCurrencyRate() {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getStableCurrencyRate().compose(ProRetrofit.o()));
    }

    public d9.a<SuperMarginRiskRateBean> getSuperMarginRiskRate(String str) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getSuperMarginRiskRate(str).compose(ProRetrofit.o()));
    }

    public d9.a<List<SuperMarginSymbol>> getSuperMarginSymbols() {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getSuperMarginSymbols().compose(ProRetrofit.o()));
    }

    public d9.a<Map<String, DepthsInfo>> getSymbolDepthInfo() {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getSymbolDepthInfo().compose(ProRetrofit.o()));
    }

    public d9.a<List<SymbolPrice>> getSymbolPrice() {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getSymbolPrice().compose(ProRetrofit.o()));
    }

    public d9.a<SpotTimeSharingGlobalConfig> getTimeSharingGlobalConfigInfo() {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getTimeSharingGlobalConfigInfo().compose(ProRetrofit.h()));
    }

    public d9.a<Long> getTimeStamp() {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getTimeStamp().compose(ProRetrofit.o()));
    }

    public void h(boolean z11, String str, String str2, int i11, MarketDepthListener marketDepthListener) {
        RetrofitLogger.a(this.f70626d + "-->subscribeMarketDepth--> isSubscribe=" + z11 + " symbol=" + str + " step=" + str2 + " size=" + i11 + " listener=" + marketDepthListener);
        if (z11 && !J()) {
            I();
        }
        i iVar = this.f70623a;
        if (iVar != null) {
            iVar.u(new MarketDepthSub(z11, str, str2, i11), marketDepthListener);
        }
    }

    public void i(String str, RequestMarketTradeDetailListener requestMarketTradeDetailListener, int i11) {
        RetrofitLogger.a(this.f70626d + "-->requestMarketTradeDetailList--> symbol=" + str + " listener=" + requestMarketTradeDetailListener);
        if (!J()) {
            I();
        }
        i iVar = this.f70623a;
        if (iVar != null) {
            iVar.u(new TradeDetailRequest(str, i11), requestMarketTradeDetailListener);
        }
    }

    public d9.a<Object> insertSearchHistoryData(Map<String, Object> map) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).insertSearchHistoryData(map).compose(ProRetrofit.h()));
    }

    public void j(boolean z11, String str, MarketDetailListener marketDetailListener) {
        RetrofitLogger.a(this.f70626d + "-->subscribeMarketDetail--> isSubscribe=" + z11 + " symbol=" + str + " listener=" + marketDetailListener);
        if (z11 && !J()) {
            I();
        }
        i iVar = this.f70623a;
        if (iVar != null) {
            iVar.u(new MarketDetailSub(z11, str), marketDetailListener);
        }
    }

    public void k(boolean z11, String str, MarketTradeDetailListener marketTradeDetailListener) {
        RetrofitLogger.a(this.f70626d + "-->subscribeMarketTradeDetail--> isSubscribe=" + z11 + " symbol=" + str + " listener=" + marketTradeDetailListener);
        if (z11 && !J()) {
            I();
        }
        i iVar = this.f70623a;
        if (iVar != null) {
            iVar.u(new TradeDetailSub(z11, str), marketTradeDetailListener);
        }
    }

    public void l(boolean z11, String str, String str2, MarketDepthListener marketDepthListener) {
        h(z11, str, str2, 150, marketDepthListener);
    }

    public d9.a<Object> m(String str, String str2) {
        HashMap hashMap = new HashMap(2);
        if (str != null) {
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, str.toLowerCase(Locale.US));
        }
        hashMap.put("amount", str2);
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).transferOutMine(hashMap).compose(ProRetrofit.o()));
    }

    public d9.a<Long> n(TransferAccountType transferAccountType, TransferAccountType transferAccountType2, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("from", transferAccountType.type);
        hashMap.put("to", transferAccountType2.type);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, str2.toLowerCase(Locale.US));
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("tradePartition", str.toLowerCase(Locale.US));
        }
        hashMap.put("amount", str3);
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).requestAccountTransfer(hashMap).compose(ProRetrofit.h()));
    }

    public d9.a<SuperMarginTransferLimit> o(String str) {
        HashMap hashMap = new HashMap(1);
        if (str != null) {
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, str.toLowerCase(Locale.US));
        }
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getSuperMarginTransferLimit(hashMap).compose(ProRetrofit.o()));
    }

    public d9.a<PlanCancelOpenOrdersResult> p(String str, String str2, int i11) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("symbol", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("orderSide", str2);
        }
        hashMap.put("delegateType", Integer.valueOf(i11));
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).cancelOpenOrders(hashMap).compose(ProRetrofit.h()));
    }

    public d9.a<String> placeStableCoinOrder(String str) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).placeStableCoinOrder(str).compose(ProRetrofit.o()));
    }

    public d9.a<WithdrawRiskInfo> placeWithdrawOrderPhase2(Map<String, Object> map) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).placeWithdrawOrderPhase2(map).compose(ProRetrofit.o()));
    }

    public d9.a<ResponseBody> postH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).postH5UrlRequest(str, map, map2));
    }

    public d9.a<Long> q(TransferAccountType transferAccountType, TransferAccountType transferAccountType2, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("from", transferAccountType.type);
        hashMap.put("to", transferAccountType2.type);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, str.toLowerCase(Locale.US));
        }
        hashMap.put("amount", str2);
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).requestAccountTransfer(hashMap).compose(ProRetrofit.h()));
    }

    public d9.a<List<CurrencyRateBean>> r(String str) {
        RetrofitLogger.a(this.f70626d + "-->getExchangeRateList-->url=" + str);
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getCurrencyRateList(str).compose(ProRetrofit.h()));
    }

    public d9.a<Long> s(TransferAccountType transferAccountType, TransferAccountType transferAccountType2, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("from", transferAccountType.type);
        hashMap.put("to", transferAccountType2.type);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, str.toLowerCase(Locale.US));
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("margin-account", str3.toLowerCase(Locale.US));
        }
        hashMap.put("amount", str2);
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).requestAccountTransfer(hashMap).compose(ProRetrofit.h()));
    }

    public void t(boolean z11, MarketOverviewListenerV2 marketOverviewListenerV2) {
        RetrofitLogger.a(this.f70626d + "-->subscribeMarketOverviewV2--> isSubscribe=" + z11 + " listener=" + marketOverviewListenerV2);
        if (z11 && !J()) {
            I();
        }
        i iVar = this.f70623a;
        if (iVar != null) {
            iVar.u(new MarketOverviewV2Sub(z11), marketOverviewListenerV2);
        }
    }

    public d9.a<String> u(String str, String str2, List<String> list, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str2);
        hashMap.put("chains", list);
        hashMap.put(InnerShareParams.ADDRESS, str3);
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).bindDefiBoxAddr(str, hashMap).compose(ProRetrofit.h()));
    }

    public void v(boolean z11, String str, DepthType depthType, MarketDepthPercentListener marketDepthPercentListener) {
        RetrofitLogger.a(this.f70626d + "-->subscribeMarketDepthPercent--> isSubscribe=" + z11 + " symbol=" + str + " type=" + depthType + " listener=" + marketDepthPercentListener);
        if (z11 && !J()) {
            I();
        }
        i iVar = this.f70623a;
        if (iVar != null) {
            iVar.u(new MarketInfoDepthPercentSub(z11, str, depthType.step), marketDepthPercentListener);
        }
    }

    public d9.a<ExchangeSettings> w(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getCommonExchange(hashMap).compose(ProRetrofit.o()));
    }

    public d9.a<List<ExchangeOpenOrder>> x(long j11, String str, String str2, String str3, long j12, String str4, int i11, String str5) {
        HashMap hashMap = new HashMap();
        if (j11 != 0) {
            hashMap.put("account-id", Long.valueOf(j11));
        }
        hashMap.put(DevicePublicKeyStringDef.DIRECT, str4);
        hashMap.put("size", Integer.valueOf(i11));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("symbol", str);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("states", str5);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("types", str2);
        }
        if (j12 >= 0) {
            hashMap.put("from", Long.valueOf(j12));
        }
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getOpenOrders(hashMap).compose(ProRetrofit.o()));
    }

    public d9.a<BigInterfaceResponse<List<ChainInfo>>> y(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("language", str2);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(AuthHandler.EXTRA_TOKEN_SECRET, str);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("show-desc", str4);
        }
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getChainListWithDiff(hashMap).map(a9.a.f3498b).compose(ProRetrofit.o()));
    }

    public d9.a<WithdrawRiskInfo> z(Map<String, Object> map, Map<String, Object> map2) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).createHuoPayFast(map, map2).compose(ProRetrofit.o()));
    }

    public d9.a<MaxOrderAmountBean> getSuperMarginRiskRate(Map<String, Object> map) {
        return new d9.a<>(((ProApiService) ProRetrofit.request(ProApiService.class)).getSuperMarginRiskRate(map).compose(ProRetrofit.o()));
    }
}
