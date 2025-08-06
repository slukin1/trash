package com.hbg.lib.network.option.retrofit;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.network.option.core.bean.OptionAccountInfo;
import com.hbg.lib.network.option.core.bean.OptionCurrencyInfo;
import com.hbg.lib.network.option.core.bean.OptionFinancialRecordResponse;
import com.hbg.lib.network.option.core.bean.OptionIndexInfo;
import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import com.hbg.lib.network.option.core.bean.OptionProductInfo;
import com.hbg.lib.network.option.core.bean.OptionUserInfo;
import com.hbg.lib.network.option.core.bean.PriceLimitInfo;
import com.hbg.lib.network.option.core.util.OptionDepthType;
import com.hbg.lib.network.option.service.OptionService;
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
import g9.a;
import g9.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import p8.b;

public class OptionApiRetrofitImpl implements b {

    /* renamed from: a  reason: collision with root package name */
    public i f69260a;

    /* renamed from: b  reason: collision with root package name */
    public c9.b f69261b;

    /* renamed from: c  reason: collision with root package name */
    public SimpleDateFormat f69262c = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss", Locale.US);

    /* renamed from: d  reason: collision with root package name */
    public String f69263d;

    public void a(String str, Context context, c9.b bVar) {
        this.f69263d = str;
        RetrofitLogger.a(this.f69263d + "-->init");
        this.f69261b = bVar;
        OptionRetrofit.d().init(str, context, bVar);
    }

    public void b() {
        RetrofitLogger.a(this.f69263d + "-->disconnectWebSocket");
        i iVar = this.f69260a;
        if (iVar != null) {
            iVar.n();
        }
    }

    public void c(a.d dVar) {
        RetrofitLogger.a(this.f69263d + "-->removeReconnectListener-->" + dVar);
        i iVar = this.f69260a;
        if (iVar != null) {
            iVar.r(dVar);
        }
    }

    public void d(a.d dVar) {
        RetrofitLogger.a(this.f69263d + "-->addReconnectListener-->" + dVar);
        i iVar = this.f69260a;
        if (iVar != null) {
            iVar.h(dVar);
        }
    }

    public void e(boolean z11, MarketOverviewListener marketOverviewListener) {
        RetrofitLogger.a(this.f69263d + "-->subscribeMarketOverview--> isSubscribe=" + z11 + " listener=" + marketOverviewListener);
        if (z11 && !r()) {
            q();
        }
        i iVar = this.f69260a;
        if (iVar != null) {
            iVar.u(new MarketOverviewSub(z11), marketOverviewListener);
        }
    }

    public void f(String str, Period period, long j11, long j12, KLineListener kLineListener) {
        Period period2 = period;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f69263d);
        sb2.append("-->requestKLineList--> symbol=");
        String str2 = str;
        sb2.append(str);
        sb2.append(" period=");
        sb2.append(period);
        sb2.append(" from=");
        sb2.append(this.f69262c.format(new Date(j11)));
        sb2.append(" to=");
        sb2.append(this.f69262c.format(new Date(j12)));
        RetrofitLogger.a(sb2.toString());
        if (!r()) {
            q();
        }
        i iVar = this.f69260a;
        if (iVar != null) {
            iVar.u(new KlineRequest(str, period2.value, j11, j12), kLineListener);
        }
    }

    public void g(boolean z11, String str, Period period, LastKlineListener lastKlineListener) {
        RetrofitLogger.a(this.f69263d + "-->subscribeLastKline--> isSubscribe=" + z11 + " symbol=" + str + " period=" + period + " listener=" + lastKlineListener);
        if (z11 && !r()) {
            q();
        }
        i iVar = this.f69260a;
        if (iVar != null) {
            iVar.u(new LastKlineSub(z11, str, period.value), lastKlineListener);
        }
    }

    public d9.a<List<PriceLimitInfo>> getPriceLimitLevel(String str) {
        return new d9.a<>(((OptionService) OptionRetrofit.request(OptionService.class)).getPriceLimitLevel(str).compose(OptionRetrofit.h()));
    }

    public d9.a<List<OptionProductInfo>> getProductInfo(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("symbol", str);
        }
        return new d9.a<>(((OptionService) OptionRetrofit.request(OptionService.class)).getProductInfo(hashMap).compose(OptionRetrofit.h()));
    }

    public d9.a<OptionUserInfo> getUserInfo() {
        return new d9.a<>(((OptionService) OptionRetrofit.request(OptionService.class)).getUserInfo(new HashMap()).compose(OptionRetrofit.h()));
    }

    public void h(boolean z11, String str, String str2, int i11, MarketDepthListener marketDepthListener) {
        RetrofitLogger.a(this.f69263d + "-->subscribeMarketDepth--> isSubscribe=" + z11 + " symbol=" + str + " step=" + str2 + " size=" + i11 + " listener=" + marketDepthListener);
        if (z11 && !r()) {
            q();
        }
        i iVar = this.f69260a;
        if (iVar != null) {
            iVar.u(new MarketDepthSub(z11, str, str2, i11), marketDepthListener);
        }
    }

    public void i(String str, RequestMarketTradeDetailListener requestMarketTradeDetailListener, int i11) {
        RetrofitLogger.a(this.f69263d + "-->requestMarketTradeDetailList--> symbol=" + str + " listener=" + requestMarketTradeDetailListener);
        if (!r()) {
            q();
        }
        i iVar = this.f69260a;
        if (iVar != null) {
            iVar.u(new TradeDetailRequest(str, i11), requestMarketTradeDetailListener);
        }
    }

    public void j(boolean z11, String str, MarketDetailListener marketDetailListener) {
        RetrofitLogger.a(this.f69263d + "-->subscribeMarketDetail--> isSubscribe=" + z11 + " symbol=" + str + " listener=" + marketDetailListener);
        if (z11 && !r()) {
            q();
        }
        i iVar = this.f69260a;
        if (iVar != null) {
            iVar.u(new MarketDetailSub(z11, str), marketDetailListener);
        }
    }

    public void k(boolean z11, String str, MarketTradeDetailListener marketTradeDetailListener) {
        RetrofitLogger.a(this.f69263d + "-->subscribeMarketTradeDetail--> isSubscribe=" + z11 + " symbol=" + str + " listener=" + marketTradeDetailListener);
        if (z11 && !r()) {
            q();
        }
        i iVar = this.f69260a;
        if (iVar != null) {
            iVar.u(new TradeDetailSub(z11, str), marketTradeDetailListener);
        }
    }

    public void l(boolean z11, String str, OptionDepthType optionDepthType, MarketDepthPercentListener marketDepthPercentListener) {
        RetrofitLogger.a(this.f69263d + "-->subscribeMarketDepthPercent--> isSubscribe=" + z11 + " symbol=" + str + " type=" + optionDepthType + " listener=" + marketDepthPercentListener);
        if (z11 && !r()) {
            q();
        }
        i iVar = this.f69260a;
        if (iVar != null) {
            iVar.u(new MarketInfoDepthPercentSub(z11, str, optionDepthType.step), marketDepthPercentListener);
        }
    }

    public d9.a<List<OptionMarketIndexInfo>> m(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("symbol", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("contract_type", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("contract_code", str3);
        }
        return new d9.a<>(((OptionService) OptionRetrofit.request(OptionService.class)).optionMarketIndex(hashMap).compose(OptionRetrofit.h()));
    }

    public d9.a<OptionFinancialRecordResponse> n(String str, String str2, String str3, int i11, int i12) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("symbol", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("trade_partition", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("money_type", str3);
        }
        hashMap.put("page_index", Integer.valueOf(i11));
        hashMap.put("page_size", Integer.valueOf(i12));
        hashMap.put("create_date", "90");
        return new d9.a<>(((OptionService) OptionRetrofit.request(OptionService.class)).getFinancialRecord(hashMap).compose(OptionRetrofit.h()));
    }

    public d9.a<List<OptionCurrencyInfo>> o(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("symbol", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("contract_code", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("trade_partition", "tradePartition");
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("contract_type", str4);
        }
        return new d9.a<>(((OptionService) OptionRetrofit.request(OptionService.class)).getOptionCurrencyInfo(hashMap).compose(OptionRetrofit.h()));
    }

    public d9.a<List<OptionIndexInfo>> p(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("symbol", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("trade_partition", str2);
        }
        return new d9.a<>(((OptionService) OptionRetrofit.request(OptionService.class)).getOptionIndexInfo(hashMap).compose(OptionRetrofit.h()));
    }

    public void q() {
        RetrofitLogger.a(this.f69263d + "-->connectWebSocket");
        i iVar = this.f69260a;
        if (iVar != null) {
            iVar.n();
        }
        c9.b bVar = this.f69261b;
        if (bVar != null) {
            String webSocketHost = bVar.getWebSocketHost();
            if (!TextUtils.isEmpty(webSocketHost)) {
                if (this.f69260a == null) {
                    this.f69260a = new i(OptionRetrofit.d().getTag(), OptionRetrofit.d().createSocketOkHttpClientBuilder().build(), this.f69261b);
                }
                this.f69260a.m(webSocketHost);
            }
        }
    }

    public final boolean r() {
        i iVar = this.f69260a;
        return iVar != null && iVar.q();
    }

    public d9.a<List<OptionAccountInfo>> z(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("symbol", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("trade_partition", str2);
        }
        return new d9.a<>(((OptionService) OptionRetrofit.request(OptionService.class)).getAccountInfo(hashMap).compose(OptionRetrofit.h()));
    }
}
