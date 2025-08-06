package com.hbg.lib.network.contract.retrofit;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.network.contract.core.bean.CenterMarketConfigContracts;
import com.hbg.lib.network.contract.core.bean.CenterMarketConfigInfo;
import com.hbg.lib.network.contract.core.bean.ContractAllowLevel;
import com.hbg.lib.network.contract.core.bean.ContractAvailableLevelInfo;
import com.hbg.lib.network.contract.core.bean.ContractClearDialogConfig;
import com.hbg.lib.network.contract.core.bean.ContractHiddenInstruments;
import com.hbg.lib.network.contract.core.bean.ContractHoldAmount;
import com.hbg.lib.network.contract.core.bean.ContractOpenRight;
import com.hbg.lib.network.contract.core.bean.ContractOrderInsertRspInfo;
import com.hbg.lib.network.contract.core.bean.ContractSettlementPrice;
import com.hbg.lib.network.contract.core.bean.ContractTagInfo;
import com.hbg.lib.network.contract.core.bean.ContractTpSlOrderRspInfo;
import com.hbg.lib.network.contract.core.bean.ContractUserOrderLimit;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.contract.core.bean.PopupSetInfo;
import com.hbg.lib.network.contract.core.bean.PriceLimitInfo;
import com.hbg.lib.network.contract.core.bean.ReversalEstimatedLiquidationPrice;
import com.hbg.lib.network.contract.core.bean.StopOrderRspResult;
import com.hbg.lib.network.contract.core.util.ContractDepthType;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.hbg.lib.network.contract.core.util.RemindTriggerType;
import com.hbg.lib.network.contract.retrofit.service.ContractService;
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
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.contract.entity.ContractCalmPeriodInfo;
import com.huobi.contract.entity.ContractCancelOrderResult;
import com.huobi.contract.entity.ContractCancelResult;
import com.huobi.contract.entity.ContractCurrentTrackOrderResult;
import com.huobi.contract.entity.ContractPriceProtectionInfo;
import com.huobi.contract.entity.ContractTpSlRelationOrder;
import com.huobi.contract.entity.ContractUserInfoActive;
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
import q7.b;

public class ContractApiRetrofitImpl implements b {

    /* renamed from: a  reason: collision with root package name */
    public i f69235a;

    /* renamed from: b  reason: collision with root package name */
    public c9.b f69236b;

    /* renamed from: c  reason: collision with root package name */
    public SimpleDateFormat f69237c = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss", Locale.US);

    /* renamed from: d  reason: collision with root package name */
    public String f69238d;

    public a<ContractCancelResult> A(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put("order_id", str2);
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).cancelStopOpenOrder(hashMap).compose(ContractRetrofit.h()));
    }

    public void B(boolean z11, String str, ContractDepthType contractDepthType, MarketDepthListener marketDepthListener) {
        l(z11, str, contractDepthType.step, marketDepthListener);
    }

    public void C(boolean z11, String str, ContractDepthType contractDepthType, MarketDepthPercentListener marketDepthPercentListener) {
        RetrofitLogger.a(this.f69238d + "-->subscribeMarketDepthPercent--> isSubscribe=" + z11 + " symbol=" + str + " type=" + contractDepthType + " listener=" + marketDepthPercentListener);
        if (z11 && !S()) {
            R();
        }
        i iVar = this.f69235a;
        if (iVar != null) {
            iVar.u(new MarketInfoDepthPercentSub(z11, str, contractDepthType.step), marketDepthPercentListener);
        }
    }

    public a<Void> D(int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("price_protect_switch", Integer.valueOf(i11));
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).setContractPriceProtection(hashMap).compose(ContractRetrofit.h()));
    }

    public a<OffSiteLimit> E(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("contract_type", str2);
        hashMap.put(FirebaseAnalytics.Param.PRICE, str3);
        hashMap.put("volume", str4);
        hashMap.put("order_price_type", str5);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str6);
        hashMap.put(Constants.FLAG_TAG_OFFSET, str7);
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getOrderLimit(hashMap).compose(ContractRetrofit.h()));
    }

    public a<ContractOrderInsertRspInfo> F(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put("contract_type", str2);
        hashMap.put("contract_code", str3);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str4);
        hashMap.put(Constants.FLAG_TAG_OFFSET, str5);
        hashMap.put("lever_rate", str6);
        hashMap.put("volume", str7);
        hashMap.put("callback_rate", str8);
        hashMap.put("active_price", str9);
        hashMap.put("order_price_type", str10);
        try {
            RetrofitLogger.h("合约跟踪委托下单", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).trackOrder(hashMap).compose(ContractRetrofit.h()));
    }

    public a<ContractCurrentTrackOrderResult> G(String str, String str2, int i11, int i12, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put("contract_code", str2);
        hashMap.put("page_index", Integer.valueOf(i11));
        hashMap.put("page_size", Integer.valueOf(i12));
        hashMap.put("trade_type", str3);
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getOpenTrackOrder(hashMap).compose(ContractRetrofit.h()));
    }

    public a<Integer> H(String str, RemindContractType remindContractType) {
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).centerMarketConfigCheck(str, remindContractType.type).compose(ContractRetrofit.h()));
    }

    public a<ContractOrderInsertRspInfo> I(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i11, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, double d11) {
        String str18 = str6;
        HashMap hashMap = new HashMap();
        String str19 = str;
        hashMap.put("symbol", str);
        String str20 = str2;
        hashMap.put("contract_type", str2);
        String str21 = str3;
        hashMap.put("contract_code", str3);
        hashMap.put("volume", str6);
        String str22 = str7;
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str7);
        String str23 = str8;
        hashMap.put(Constants.FLAG_TAG_OFFSET, str8);
        String str24 = str9;
        hashMap.put("lever_rate", str9);
        String str25 = str5;
        hashMap.put("order_price_type", str5);
        String str26 = str4;
        hashMap.put(FirebaseAnalytics.Param.PRICE, str4);
        hashMap.put("check_min_volume", Integer.valueOf(i11));
        if (!TextUtils.isEmpty(str10)) {
            String str27 = str10;
            hashMap.put("tp_trigger_price", str10);
            hashMap.put("tp_order_price", str11);
            hashMap.put("tp_order_price_type", str12);
            if (!TextUtils.isEmpty(str13)) {
                hashMap.put("tp_trigger_type", str13);
            }
        }
        if (!TextUtils.isEmpty(str14)) {
            hashMap.put("sl_trigger_price", str14);
            hashMap.put("sl_order_price", str15);
            hashMap.put("sl_order_price_type", str16);
            if (!TextUtils.isEmpty(str17)) {
                hashMap.put("sl_trigger_type", str17);
            }
        }
        if (d11 > 0.0d) {
            BigDecimal scale = BigDecimal.valueOf(d11).multiply(new BigDecimal(str6)).setScale(0, 1);
            if (scale.compareTo(BigDecimal.ZERO) == 0) {
                scale = BigDecimal.ONE;
            }
            hashMap.put("tpsl_volume", scale.toPlainString());
        }
        try {
            RetrofitLogger.h("合约限价委托下单", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).requestContractOrder(hashMap).compose(ContractRetrofit.h()));
    }

    public a<List<ContractHoldAmount>> J(String str) {
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getContractHoldAmount(MapParamsBuilder.c().a("contract_code", str).b()).compose(ContractRetrofit.h()));
    }

    public a<Integer> K(RemindBusinessType remindBusinessType, String str, RemindContractType remindContractType, RemindTriggerType remindTriggerType, String str2) {
        HashMap hashMap = new HashMap();
        if (remindBusinessType != null) {
            hashMap.put("business_type", Integer.valueOf(remindBusinessType.type));
        }
        hashMap.put("symbol", str);
        if (remindContractType != null) {
            hashMap.put("contract_type", Integer.valueOf(remindContractType.type));
        }
        if (remindTriggerType != null) {
            hashMap.put("trigger_type", Integer.valueOf(remindTriggerType.type));
        }
        hashMap.put("trigger_price", str2);
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).centerMarketConfigSave(hashMap).compose(ContractRetrofit.h()));
    }

    public a<List<Integer>> L(List<Long> list) {
        HashMap hashMap = new HashMap();
        hashMap.put("price_ids", list);
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).centerMarketConfigDelete(hashMap).compose(ContractRetrofit.h()));
    }

    public a<Void> M(long j11, long j12) {
        HashMap hashMap = new HashMap();
        hashMap.put("cooling_off_begin_time", Long.valueOf(j11));
        hashMap.put("cooling_off_end_time", Long.valueOf(j12));
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).setCoolingOffPeriod(hashMap).compose(ContractRetrofit.h()));
    }

    public a<ContractTpSlOrderRspInfo> N(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put("contract_type", str2);
        hashMap.put("contract_code", str3);
        hashMap.put("volume", str5);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str4);
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("tp_trigger_price", str6);
            hashMap.put("tp_order_price", str7);
            hashMap.put("tp_order_price_type", str8);
            if (!TextUtils.isEmpty(str9)) {
                hashMap.put("tp_trigger_type", str9);
            }
        }
        if (!TextUtils.isEmpty(str10)) {
            hashMap.put("sl_trigger_price", str10);
            hashMap.put("sl_order_price", str11);
            hashMap.put("sl_order_price_type", str12);
            if (!TextUtils.isEmpty(str13)) {
                hashMap.put("sl_trigger_type", str13);
            }
        }
        try {
            RetrofitLogger.h("合约止盈止损委托下单", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).requestContractTpSlOrder(hashMap).compose(ContractRetrofit.h()));
    }

    public a<List<CenterMarketConfigInfo>> O(String str, RemindContractType remindContractType) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("symbol", str);
        }
        if (remindContractType != null) {
            hashMap.put("contract_type", Integer.valueOf(remindContractType.type));
        }
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).centerMarketConfigInfo(hashMap).compose(ContractRetrofit.h()));
    }

    public a<StopOrderRspResult> P(String str, String str2, int i11, int i12, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put("contract_code", str2);
        hashMap.put("page_index", Integer.valueOf(i11));
        hashMap.put("page_size", Integer.valueOf(i12));
        hashMap.put("trade_type", str3);
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getStopOpenOrders(hashMap).compose(ContractRetrofit.h()));
    }

    public a<List<ContractSettlementPrice>> Q(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getContractSettlementPrice(hashMap).compose(ContractRetrofit.h()));
    }

    public void R() {
        RetrofitLogger.a(this.f69238d + "-->connectWebSocket");
        i iVar = this.f69235a;
        if (iVar != null) {
            iVar.n();
        }
        c9.b bVar = this.f69236b;
        if (bVar != null) {
            String webSocketHost = bVar.getWebSocketHost();
            if (!TextUtils.isEmpty(webSocketHost)) {
                if (this.f69235a == null) {
                    this.f69235a = new i(ContractRetrofit.i().getTag(), ContractRetrofit.i().createSocketOkHttpClientBuilder().build(), this.f69236b);
                }
                this.f69235a.m(webSocketHost);
            }
        }
    }

    public final boolean S() {
        i iVar = this.f69235a;
        return iVar != null && iVar.q();
    }

    public void a(String str, Context context, c9.b bVar) {
        this.f69238d = str;
        RetrofitLogger.a(this.f69238d + "-->init");
        this.f69236b = bVar;
        ContractRetrofit.i().init(str, context, bVar);
    }

    public a<Object> agreeHighLever() {
        return new a<>(((ContractService) ContractRetrofit.request(ContractService.class)).agreeHighLever().compose(ContractRetrofit.h()));
    }

    public void b() {
        RetrofitLogger.a(this.f69238d + "-->disconnectWebSocket");
        i iVar = this.f69235a;
        if (iVar != null) {
            iVar.n();
        }
    }

    public void c(a.d dVar) {
        RetrofitLogger.a(this.f69238d + "-->removeReconnectListener-->" + dVar);
        i iVar = this.f69235a;
        if (iVar != null) {
            iVar.r(dVar);
        }
    }

    public d9.a<Object> contractCloseAllPosition() {
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).contractCloseAllPosition().compose(ContractRetrofit.h()));
    }

    public void d(a.d dVar) {
        RetrofitLogger.a(this.f69238d + "-->addReconnectListener-->" + dVar);
        i iVar = this.f69235a;
        if (iVar != null) {
            iVar.h(dVar);
        }
    }

    public void e(boolean z11, MarketOverviewListener marketOverviewListener) {
        RetrofitLogger.a(this.f69238d + "-->subscribeMarketOverview--> isSubscribe=" + z11 + " listener=" + marketOverviewListener);
        if (z11 && !S()) {
            R();
        }
        i iVar = this.f69235a;
        if (iVar != null) {
            iVar.u(new MarketOverviewSub(z11), marketOverviewListener);
        }
    }

    public void f(String str, Period period, long j11, long j12, KLineListener kLineListener) {
        Period period2 = period;
        long j13 = j11;
        long j14 = j12;
        RetrofitLogger.a(this.f69238d + "-->requestKLineList--> symbol=" + str + " period=" + period2 + " from=" + j13 + "(*1000=" + this.f69237c.format(new Date(j13 * 1000)) + ") to=" + j14 + "(*1000=" + this.f69237c.format(new Date(j14 * 1000)) + ")");
        if (!S()) {
            R();
        }
        i iVar = this.f69235a;
        if (iVar != null) {
            iVar.u(new KlineRequest(str, period2.value, j11, j12), kLineListener);
        }
    }

    public d9.a<ContractUserInfoActive> fetchUserInfoActive() {
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).fetchUserInfoActive().compose(ContractRetrofit.h()));
    }

    public void g(boolean z11, String str, Period period, LastKlineListener lastKlineListener) {
        RetrofitLogger.a(this.f69238d + "-->subscribeLastKline--> isSubscribe=" + z11 + " symbol=" + str + " period=" + period + " listener=" + lastKlineListener);
        if (z11 && !S()) {
            R();
        }
        i iVar = this.f69235a;
        if (iVar != null) {
            iVar.u(new LastKlineSub(z11, str, period.value), lastKlineListener);
        }
    }

    public d9.a<List<ContractAvailableLevelInfo>> getAllowLevel(String str) {
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getAvailableLevel(str).compose(ContractRetrofit.h()));
    }

    public d9.a<List<ContractAllowLevel>> getAllowMaxLevel(String str) {
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getAllowMaxLevel(str).compose(ContractRetrofit.h()));
    }

    public d9.a<ContractClearDialogConfig> getClearDialogConfig() {
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getClearDialogConfig().compose(ContractRetrofit.h()));
    }

    public d9.a<ContractPriceProtectionInfo> getContractPriceProtection() {
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getContractPriceProtection().compose(ContractRetrofit.h()));
    }

    public d9.a<ContractTagInfo> getContractTagInfo() {
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getContractTagInfo().compose(ContractRetrofit.h()));
    }

    public d9.a<ContractCalmPeriodInfo> getCoolingOffPeriodInfo() {
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getCoolingOffPeriodInfo().compose(ContractRetrofit.h()));
    }

    public d9.a<ContractHiddenInstruments> getHiddenInstruments() {
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getHiddenInstruments().compose(ContractRetrofit.h()));
    }

    public d9.a<List<PriceLimitInfo>> getPriceLimitLevel(String str) {
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getPriceLimitLevel(str).compose(ContractRetrofit.h()));
    }

    public void h(boolean z11, String str, String str2, int i11, MarketDepthListener marketDepthListener) {
        RetrofitLogger.a(this.f69238d + "-->subscribeMarketDepth--> isSubscribe=" + z11 + " symbol=" + str + " step=" + str2 + " size=" + i11 + " listener=" + marketDepthListener);
        if (z11 && !S()) {
            R();
        }
        i iVar = this.f69235a;
        if (iVar != null) {
            iVar.u(new MarketDepthSub(z11, str, str2, i11), marketDepthListener);
        }
    }

    public void i(String str, RequestMarketTradeDetailListener requestMarketTradeDetailListener, int i11) {
        RetrofitLogger.a(this.f69238d + "-->requestMarketTradeDetailList--> symbol=" + str + " listener=" + requestMarketTradeDetailListener);
        if (!S()) {
            R();
        }
        i iVar = this.f69235a;
        if (iVar != null) {
            iVar.u(new TradeDetailRequest(str, i11), requestMarketTradeDetailListener);
        }
    }

    public void j(boolean z11, String str, MarketDetailListener marketDetailListener) {
        RetrofitLogger.a(this.f69238d + "-->subscribeMarketDetail--> isSubscribe=" + z11 + " symbol=" + str + " listener=" + marketDetailListener);
        if (z11 && !S()) {
            R();
        }
        i iVar = this.f69235a;
        if (iVar != null) {
            iVar.u(new MarketDetailSub(z11, str), marketDetailListener);
        }
    }

    public void k(boolean z11, String str, MarketTradeDetailListener marketTradeDetailListener) {
        RetrofitLogger.a(this.f69238d + "-->subscribeMarketTradeDetail--> isSubscribe=" + z11 + " symbol=" + str + " listener=" + marketTradeDetailListener);
        if (z11 && !S()) {
            R();
        }
        i iVar = this.f69235a;
        if (iVar != null) {
            iVar.u(new TradeDetailSub(z11, str), marketTradeDetailListener);
        }
    }

    public void l(boolean z11, String str, String str2, MarketDepthListener marketDepthListener) {
        h(z11, str, str2, 20, marketDepthListener);
    }

    public d9.a<ContractOpenRight> m(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getOpenRight(hashMap).compose(ContractRetrofit.h()));
    }

    public d9.a<Object> n(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("trade_unit", str);
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).updateTradeUnit(hashMap).compose(ContractRetrofit.h()));
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
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).requestCurrentTpslFrozenState(hashMap).compose(ContractRetrofit.h()));
    }

    public d9.a<ContractCancelOrderResult> p(HashMap<String, Object> hashMap) {
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).requestCancelOrderAll(hashMap).compose(ContractRetrofit.h()));
    }

    public d9.a<ContractCancelResult> q(String str, long j11) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put("order_id", Long.valueOf(j11));
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).cancelTrackOpenOrder(hashMap).compose(ContractRetrofit.h()));
    }

    public d9.a<Integer> queryTradeUnit() {
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).queryTradeUnit().compose(ContractRetrofit.h()));
    }

    public d9.a<CenterMarketConfigContracts> r() {
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).centerMarketConfigContracts().compose(ContractRetrofit.h()));
    }

    public d9.a<List<LevelAvailableMarginInfo>> s(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getLevelAvailableMargin(hashMap).compose(ContractRetrofit.h()));
    }

    public d9.a<Object> t(String str, String str2, String str3, String str4, String str5, String str6, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put("contract_type", str2);
        hashMap.put("contract_code", str3);
        hashMap.put("volume", str4);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str5);
        hashMap.put("order_price_type", str6);
        hashMap.put("check_min_volume", Integer.valueOf(i11));
        try {
            RetrofitLogger.h("合约闪电平仓下单", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).lightningClosePosition(hashMap).compose(ContractRetrofit.h()));
    }

    public d9.a<ReversalEstimatedLiquidationPrice> u(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        try {
            RetrofitLogger.h("合约一键反手预估爆仓价", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).requestReversalEstimatedLiquidationPrice(hashMap).compose(ContractRetrofit.h()));
    }

    public d9.a<PopupSetInfo> v(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("windowType", str);
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).setKeyDialogIsPop(hashMap).compose(ContractRetrofit.h()));
    }

    public d9.a<ContractTpSlRelationOrder> w(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put("order_id", str2);
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getTpSlRelationOrder(hashMap).compose(ContractRetrofit.h()));
    }

    public d9.a<ContractOrderInsertRspInfo> x(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        try {
            RetrofitLogger.h("合约一键反手", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).requestReversal(hashMap).compose(ContractRetrofit.h()));
    }

    public d9.a<ContractOrderInsertRspInfo> y(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put("contract_type", str2);
        hashMap.put("contract_code", str3);
        hashMap.put("volume", str6);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str7);
        hashMap.put(Constants.FLAG_TAG_OFFSET, str8);
        hashMap.put("lever_rate", str9);
        hashMap.put("order_price_type", str5);
        hashMap.put("order_price", str4);
        hashMap.put("trigger_type", str10);
        hashMap.put("trigger_price", str11);
        try {
            RetrofitLogger.h("合约计划委托下单", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).triggerOrderInsert(hashMap).compose(ContractRetrofit.h()));
    }

    public d9.a<List<ContractUserOrderLimit>> z(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        return new d9.a<>(((ContractService) ContractRetrofit.request(ContractService.class)).getUserOrderLimit(hashMap).compose(ContractRetrofit.h()));
    }
}
