package com.hbg.lib.network.swap.retrofit;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.contract.core.bean.ReversalEstimatedLiquidationPrice;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.listener.KLineListener;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.listener.MarketDepthPercentListener;
import com.hbg.lib.network.pro.socket.listener.MarketDetailListener;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.listener.MarketTradeDetailListener;
import com.hbg.lib.network.pro.socket.listener.RequestMarketTradeDetailListener;
import com.hbg.lib.network.pro.socket.request.KlineRequest;
import com.hbg.lib.network.pro.socket.request.TradeDetailRequest;
import com.hbg.lib.network.pro.socket.subscribe.LastKlineSub;
import com.hbg.lib.network.pro.socket.subscribe.MarketDepthSub;
import com.hbg.lib.network.pro.socket.subscribe.MarketDetailSub;
import com.hbg.lib.network.pro.socket.subscribe.MarketInfoDepthPercentSub;
import com.hbg.lib.network.pro.socket.subscribe.MarketOverviewSub;
import com.hbg.lib.network.pro.socket.subscribe.TradeDetailSub;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.swap.core.bean.LeverRate;
import com.hbg.lib.network.swap.core.bean.OrderInsertRspInfo;
import com.hbg.lib.network.swap.core.bean.PriceLimitInfo;
import com.hbg.lib.network.swap.core.bean.ProductInfo;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.hbg.lib.network.swap.core.bean.SwapActivityInfo;
import com.hbg.lib.network.swap.core.bean.SwapAllowLevel;
import com.hbg.lib.network.swap.core.bean.SwapAvailableLevelInfo;
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
import com.hbg.lib.network.swap.core.service.SwapService;
import com.hbg.lib.network.swap.core.util.SwapDepthType;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.contract.entity.ContractCancelOrderResult;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.contract.entity.ContractTriggerProtectInfo;
import com.huobi.contract.entity.OffSiteLimit;
import com.tencent.android.tpush.common.Constants;
import d9.a;
import g9.a;
import g9.i;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import l9.b;

public class SwapApiRetrofitImpl implements b {

    /* renamed from: a  reason: collision with root package name */
    public i f70768a;

    /* renamed from: b  reason: collision with root package name */
    public c9.b f70769b;

    /* renamed from: c  reason: collision with root package name */
    public SimpleDateFormat f70770c = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss", Locale.US);

    /* renamed from: d  reason: collision with root package name */
    public String f70771d;

    public a<SwapOrderResult<SwapTriggerOrderInfo>> A(int i11, int i12, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("page_size", Integer.valueOf(i12));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("contract_code", str);
        }
        if (i11 != 0) {
            hashMap.put("page_index", Integer.valueOf(i11));
        }
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getCurrentStopOrder(hashMap).compose(SwapRetrofit.h()));
    }

    public a<OrderInsertRspInfo> B(String str, String str2, String str3, String str4, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("volume", str2);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str3);
        hashMap.put("order_price_type", str4);
        hashMap.put("check_min_volume", Integer.valueOf(i11));
        try {
            RetrofitLogger.g("反向永续闪电委托下单:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).requestSwapLightClose(hashMap).compose(SwapRetrofit.h()));
    }

    public a<SwapCurrentTrackOrderResult> C(String str, int i11, int i12, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("page_index", Integer.valueOf(i11));
        hashMap.put("page_size", Integer.valueOf(i12));
        hashMap.put("trade_type", str2);
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getOpenTrackOrder(hashMap).compose(SwapRetrofit.h()));
    }

    public a<OrderInsertRspInfo> D(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double d11) {
        String str16 = str4;
        HashMap hashMap = new HashMap();
        String str17 = str;
        hashMap.put("contract_code", str);
        String str18 = str2;
        hashMap.put(FirebaseAnalytics.Param.PRICE, str2);
        String str19 = str3;
        hashMap.put("order_price_type", str3);
        hashMap.put("volume", str4);
        String str20 = str5;
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str5);
        String str21 = str6;
        hashMap.put(Constants.FLAG_TAG_OFFSET, str6);
        String str22 = str7;
        hashMap.put("lever_rate", str7);
        hashMap.put("check_min_volume", Integer.valueOf(i11));
        if (!TextUtils.isEmpty(str8)) {
            String str23 = str8;
            hashMap.put("tp_trigger_price", str8);
            String str24 = str9;
            hashMap.put("tp_order_price", str9);
            String str25 = str10;
            hashMap.put("tp_order_price_type", str10);
            if (!TextUtils.isEmpty(str11)) {
                hashMap.put("tp_trigger_type", str11);
            }
        }
        if (!TextUtils.isEmpty(str12)) {
            hashMap.put("sl_trigger_price", str12);
            hashMap.put("sl_order_price", str13);
            hashMap.put("sl_order_price_type", str14);
            if (!TextUtils.isEmpty(str15)) {
                hashMap.put("sl_trigger_type", str15);
            }
        }
        if (d11 > 0.0d) {
            BigDecimal scale = BigDecimal.valueOf(d11).multiply(new BigDecimal(str4)).setScale(0, 1);
            if (scale.compareTo(BigDecimal.ZERO) == 0) {
                scale = BigDecimal.ONE;
            }
            hashMap.put("tpsl_volume", scale.toPlainString());
        }
        try {
            RetrofitLogger.g("反向永续限价委托下单:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).requestSwapOrder(hashMap).compose(SwapRetrofit.h()));
    }

    public a<OrderInsertRspInfo> E(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        hashMap.put(Constants.FLAG_TAG_OFFSET, str3);
        hashMap.put("lever_rate", str4);
        hashMap.put("volume", str5);
        hashMap.put("callback_rate", str6);
        hashMap.put("active_price", str7);
        hashMap.put("order_price_type", str8);
        try {
            RetrofitLogger.h("反向永续跟踪委托下单", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).trackOrder(hashMap).compose(SwapRetrofit.h()));
    }

    public void F(boolean z11, String str, SwapDepthType swapDepthType, MarketDepthListener marketDepthListener) {
        l(z11, str, swapDepthType.step, marketDepthListener);
    }

    public a<SwapOrderResult<SwapCurrentOrderInfo>> G(int i11, int i12, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("page_size", Integer.valueOf(i12));
        hashMap.put("order_type", str2);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("contract_code", str);
        }
        if (i11 != 0) {
            hashMap.put("page_index", Integer.valueOf(i11));
        }
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getCurrentOrder(hashMap).compose(SwapRetrofit.h()));
    }

    public a<SwapCancelResult> H(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("order_id", str2);
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).orderCancel(hashMap).compose(SwapRetrofit.h()));
    }

    public void I(boolean z11, String str, SwapDepthType swapDepthType, MarketDepthPercentListener marketDepthPercentListener) {
        RetrofitLogger.a(this.f70771d + "-->subscribeMarketDepthPercent--> isSubscribe=" + z11 + " symbol=" + str + " type=" + swapDepthType + " listener=" + marketDepthPercentListener);
        if (z11 && !S()) {
            R();
        }
        i iVar = this.f70768a;
        if (iVar != null) {
            iVar.u(new MarketInfoDepthPercentSub(z11, str, swapDepthType.step), marketDepthPercentListener);
        }
    }

    public a<OffSiteLimit> J(String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put(FirebaseAnalytics.Param.PRICE, str2);
        hashMap.put("volume", str3);
        hashMap.put("order_price_type", str4);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str5);
        hashMap.put(Constants.FLAG_TAG_OFFSET, str6);
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getOrderLimit(hashMap).compose(SwapRetrofit.h()));
    }

    public a<LeverRate> K(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put("lever_rate", str2);
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).checkLeverRate(hashMap).compose(SwapRetrofit.h()));
    }

    public a<List<SwapAccountInfo>> L(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            hashMap.put("contract_code", str);
        }
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getAccountInfo(hashMap).compose(SwapRetrofit.h()));
    }

    public a<SwapOrderResult<SwapTriggerOrderInfo>> M(int i11, int i12, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("page_size", Integer.valueOf(i12));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("contract_code", str);
        }
        if (i11 != 0) {
            hashMap.put("page_index", Integer.valueOf(i11));
        }
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getCurrentTriggerOrder(hashMap).compose(SwapRetrofit.h()));
    }

    public a<List<SwapSettlementPriceInfo>> N(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getSettlementPrice(hashMap).compose(SwapRetrofit.h()));
    }

    public a<List<SwapPosition>> O(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getContractPosition(hashMap).compose(SwapRetrofit.h()));
    }

    public a<OrderInsertRspInfo> P(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("trigger_type", str2);
        hashMap.put("trigger_price", str3);
        hashMap.put("order_price", str4);
        hashMap.put("order_price_type", str5);
        hashMap.put("volume", str6);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str7);
        hashMap.put(Constants.FLAG_TAG_OFFSET, str8);
        hashMap.put("lever_rate", str9);
        try {
            RetrofitLogger.g("反向永续计划委托下单:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).triggerOrderInsert(hashMap).compose(SwapRetrofit.h()));
    }

    public a<List<SwapCurrencyInfo>> Q(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("contract_code", str);
        }
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getSwapCurrencyInfo(hashMap).compose(SwapRetrofit.h()));
    }

    public void R() {
        RetrofitLogger.a(this.f70771d + "-->connectWebSocket");
        i iVar = this.f70768a;
        if (iVar != null) {
            iVar.n();
        }
        c9.b bVar = this.f70769b;
        if (bVar != null) {
            String webSocketHost = bVar.getWebSocketHost();
            if (!TextUtils.isEmpty(webSocketHost)) {
                if (this.f70768a == null) {
                    this.f70768a = new i(SwapRetrofit.d().getTag(), SwapRetrofit.d().createSocketOkHttpClientBuilder().build(), this.f70769b);
                }
                this.f70768a.m(webSocketHost);
            }
        }
    }

    public final boolean S() {
        i iVar = this.f70768a;
        return iVar != null && iVar.q();
    }

    public void a(String str, Context context, c9.b bVar) {
        this.f70771d = str;
        RetrofitLogger.a(this.f70771d + "-->init");
        this.f70769b = bVar;
        SwapRetrofit.d().init(str, context, bVar);
    }

    public a<SwapActivityInfo> activityInfo(String str) {
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).activityInfo(str).compose(SwapRetrofit.h()));
    }

    public a<Object> agreeHighLever() {
        return new a<>(((SwapService) SwapRetrofit.request(SwapService.class)).agreeHighLever().compose(SwapRetrofit.h()));
    }

    public void b() {
        RetrofitLogger.a(this.f70771d + "-->disconnectWebSocket");
        i iVar = this.f70768a;
        if (iVar != null) {
            iVar.n();
        }
    }

    public void c(a.d dVar) {
        RetrofitLogger.a(this.f70771d + "-->removeReconnectListener-->" + dVar);
        i iVar = this.f70768a;
        if (iVar != null) {
            iVar.r(dVar);
        }
    }

    public void d(a.d dVar) {
        RetrofitLogger.a(this.f70771d + "-->addReconnectListener-->" + dVar);
        i iVar = this.f70768a;
        if (iVar != null) {
            iVar.h(dVar);
        }
    }

    public void e(boolean z11, MarketOverviewListener marketOverviewListener) {
        RetrofitLogger.a(this.f70771d + "-->subscribeMarketOverview--> isSubscribe=" + z11 + " listener=" + marketOverviewListener);
        if (z11 && !S()) {
            R();
        }
        i iVar = this.f70768a;
        if (iVar != null) {
            iVar.u(new MarketOverviewSub(z11), marketOverviewListener);
        }
    }

    public void f(String str, Period period, long j11, long j12, KLineListener kLineListener) {
        Period period2 = period;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f70771d);
        sb2.append("-->requestKLineList--> symbol=");
        String str2 = str;
        sb2.append(str);
        sb2.append(" period=");
        sb2.append(period);
        sb2.append(" from=");
        sb2.append(this.f70770c.format(new Date(j11)));
        sb2.append(" to=");
        sb2.append(this.f70770c.format(new Date(j12)));
        RetrofitLogger.a(sb2.toString());
        if (!S()) {
            R();
        }
        i iVar = this.f70768a;
        if (iVar != null) {
            iVar.u(new KlineRequest(str, period2.value, j11, j12), kLineListener);
        }
    }

    public void g(boolean z11, String str, Period period, LastKlineListener lastKlineListener) {
        RetrofitLogger.a(this.f70771d + "-->subscribeLastKline--> isSubscribe=" + z11 + " symbol=" + str + " period=" + period + " listener=" + lastKlineListener);
        if (z11 && !S()) {
            R();
        }
        i iVar = this.f70768a;
        if (iVar != null) {
            iVar.u(new LastKlineSub(z11, str, period.value), lastKlineListener);
        }
    }

    public d9.a<List<SwapAvailableLevelInfo>> getAllowLevel(String str) {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getAllowLevel(str).compose(SwapRetrofit.h()));
    }

    public d9.a<List<SwapAllowLevel>> getAllowMaxLevel(String str) {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getAllowMaxLevel(str).compose(SwapRetrofit.h()));
    }

    public d9.a<SwapFundingRate> getFunddingRate(String str) {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getFunddingRate(str).compose(SwapRetrofit.h()));
    }

    public d9.a<SwapHiddenInstruments> getHiddenInstruments() {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getHiddenInstruments().compose(SwapRetrofit.h()));
    }

    public d9.a<List<SwapLightLimitLevel>> getLightLimitLevel(String str) {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getLightLimitLevel(str).compose(SwapRetrofit.h()));
    }

    public d9.a<String> getMarketPriceInfo(String str) {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getMarketPriceInfo(str).compose(SwapRetrofit.h()));
    }

    public d9.a<List<SwapPriceInfo>> getPriceInfo(String str) {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getPriceInfo(str).compose(SwapRetrofit.h()));
    }

    public d9.a<List<PriceLimitInfo>> getPriceLimitLevel(String str) {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getPriceLimitLevel(str).compose(SwapRetrofit.h()));
    }

    public d9.a<ContractOpenCountInfo> getSwapOpenCountInfo() {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getSwapOpenCountInfo().compose(SwapRetrofit.h()));
    }

    public d9.a<List<SwapOpenInterestInfo>> getSwapOpenInterest(String str) {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getSwapOpenInterest(str).compose(SwapRetrofit.h()));
    }

    public d9.a<SwapUserInfo.UserBean> getUserInfo() {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getUserInfo().compose(SwapRetrofit.h()));
    }

    public void h(boolean z11, String str, String str2, int i11, MarketDepthListener marketDepthListener) {
        RetrofitLogger.a(this.f70771d + "-->subscribeMarketDepth--> isSubscribe=" + z11 + " symbol=" + str + " step=" + str2 + " size=" + i11 + " listener=" + marketDepthListener);
        if (z11 && !S()) {
            R();
        }
        i iVar = this.f70768a;
        if (iVar != null) {
            iVar.u(new MarketDepthSub(z11, str, str2, i11), marketDepthListener);
        }
    }

    public void i(String str, RequestMarketTradeDetailListener requestMarketTradeDetailListener, int i11) {
        RetrofitLogger.a(this.f70771d + "-->requestMarketTradeDetailList--> symbol=" + str + " listener=" + requestMarketTradeDetailListener);
        if (!S()) {
            R();
        }
        i iVar = this.f70768a;
        if (iVar != null) {
            iVar.u(new TradeDetailRequest(str, i11), requestMarketTradeDetailListener);
        }
    }

    public void j(boolean z11, String str, MarketDetailListener marketDetailListener) {
        RetrofitLogger.a(this.f70771d + "-->subscribeMarketDetail--> isSubscribe=" + z11 + " symbol=" + str + " listener=" + marketDetailListener);
        if (z11 && !S()) {
            R();
        }
        i iVar = this.f70768a;
        if (iVar != null) {
            iVar.u(new MarketDetailSub(z11, str), marketDetailListener);
        }
    }

    public void k(boolean z11, String str, MarketTradeDetailListener marketTradeDetailListener) {
        RetrofitLogger.a(this.f70771d + "-->subscribeMarketTradeDetail--> isSubscribe=" + z11 + " symbol=" + str + " listener=" + marketTradeDetailListener);
        if (z11 && !S()) {
            R();
        }
        i iVar = this.f70768a;
        if (iVar != null) {
            iVar.u(new TradeDetailSub(z11, str), marketTradeDetailListener);
        }
    }

    public void l(boolean z11, String str, String str2, MarketDepthListener marketDepthListener) {
        h(z11, str, str2, 20, marketDepthListener);
    }

    public d9.a<SwapOpenRight> m(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getOpenRight(hashMap).compose(SwapRetrofit.h()));
    }

    public d9.a<Object> n(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("trade_unit", str);
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).updateTradeUnit(hashMap).compose(SwapRetrofit.h()));
    }

    public d9.a<Boolean> o(String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("volume", str3);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("tp_trigger_price", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("sl_trigger_price", str5);
        }
        try {
            RetrofitLogger.h("查询止盈止损下单冻结状态", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).requestCurrentTpslFrozenState(hashMap).compose(SwapRetrofit.h()));
    }

    public d9.a<ContractCancelOrderResult> p(HashMap<String, Object> hashMap) {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).requestCancelOrderAll(hashMap).compose(SwapRetrofit.h()));
    }

    public d9.a<SwapCancelResult> q(String str, long j11) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("order_id", Long.valueOf(j11));
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).cancelTrackOpenOrder(hashMap).compose(SwapRetrofit.h()));
    }

    public d9.a<Integer> queryTradeUnit() {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).queryTradeUnit().compose(SwapRetrofit.h()));
    }

    public d9.a<SwapTpSlOrderRspInfo> r(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("volume", str3);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("tp_trigger_price", str4);
            hashMap.put("tp_order_price", str5);
            hashMap.put("tp_order_price_type", str6);
            if (!TextUtils.isEmpty(str7)) {
                hashMap.put("tp_trigger_type", str7);
            }
        }
        if (!TextUtils.isEmpty(str8)) {
            hashMap.put("sl_trigger_price", str8);
            hashMap.put("sl_order_price", str9);
            hashMap.put("sl_order_price_type", str10);
            if (!TextUtils.isEmpty(str11)) {
                hashMap.put("sl_trigger_type", str11);
            }
        }
        try {
            RetrofitLogger.h("反向永续止盈止损委托下单", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).requestContractTpSlOrder(hashMap).compose(SwapRetrofit.h()));
    }

    public d9.a<List<LevelAvailableMarginInfo>> s(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getLevelAvailableMargin(hashMap).compose(SwapRetrofit.h()));
    }

    public d9.a<Object> swapCloseAllPosition() {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).swapCloseAllPosition().compose(SwapRetrofit.h()));
    }

    public d9.a<SwapCancelResult> t(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("order_id", str2);
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).contractTriggerCancel(hashMap).compose(SwapRetrofit.h()));
    }

    public d9.a<ContractTriggerProtectInfo> triggerProtect(String str) {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).triggerProtect(str).compose(SwapRetrofit.h()));
    }

    public d9.a<ReversalEstimatedLiquidationPrice> u(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        try {
            RetrofitLogger.g("反向永续一键反手预估强评价:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).requestReversalEstimatedLiquidationPrice(hashMap).compose(SwapRetrofit.h()));
    }

    public d9.a<List<ProductInfo>> v() {
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getProductInfo("0").compose(SwapRetrofit.h()));
    }

    public d9.a<SwapTpSlRelationOrder> w(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("order_id", str2);
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getTpSlRelationOrder(hashMap).compose(SwapRetrofit.h()));
    }

    public d9.a<OrderInsertRspInfo> x(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        try {
            RetrofitLogger.g("反向永续一键反手:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).requestReversal(hashMap).compose(SwapRetrofit.h()));
    }

    public d9.a<SwapCancelResult> y(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("order_id", str2);
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).contractStopCancel(hashMap).compose(SwapRetrofit.h()));
    }

    public d9.a<List<SwapUserOrderLimit>> z(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        return new d9.a<>(((SwapService) SwapRetrofit.request(SwapService.class)).getUserOrderLimit(hashMap).compose(SwapRetrofit.h()));
    }
}
