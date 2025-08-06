package com.hbg.lib.network.index.retrofit;

import android.content.Context;
import android.text.TextUtils;
import b8.b;
import com.hbg.lib.network.index.retrofit.service.IndexService;
import com.hbg.lib.network.index.socket.request.IndexKlineRequest;
import com.hbg.lib.network.index.socket.sub.IndexLastKlineSub;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.listener.KLineListener;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.subscribe.MarketOverviewSub;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import g9.a;
import g9.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class IndexApiRetrofitImpl implements b {

    /* renamed from: a  reason: collision with root package name */
    public SimpleDateFormat f70304a = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss", Locale.US);

    /* renamed from: b  reason: collision with root package name */
    public i f70305b;

    /* renamed from: c  reason: collision with root package name */
    public c9.b f70306c;

    /* renamed from: d  reason: collision with root package name */
    public String f70307d;

    public void a(String str, Context context, c9.b bVar) {
        this.f70307d = str;
        RetrofitLogger.a(this.f70307d + "-->init");
        this.f70306c = bVar;
        IndexRetrofit.d().init(str, context, bVar);
    }

    public void b() {
        RetrofitLogger.a(this.f70307d + "-->disconnectWebSocket");
        i iVar = this.f70305b;
        if (iVar != null) {
            iVar.n();
        }
    }

    public void c(a.d dVar) {
        RetrofitLogger.a(this.f70307d + "-->removeReconnectListener-->" + dVar);
        i iVar = this.f70305b;
        if (iVar != null) {
            iVar.r(dVar);
        }
    }

    public void d(a.d dVar) {
        RetrofitLogger.a(this.f70307d + "-->addReconnectListener-->" + dVar);
        i iVar = this.f70305b;
        if (iVar != null) {
            iVar.h(dVar);
        }
    }

    public void e(boolean z11, MarketOverviewListener marketOverviewListener) {
        RetrofitLogger.a(this.f70307d + "-->subscribeMarketOverview--> isSubscribe=" + z11 + " listener=" + marketOverviewListener);
        if (z11 && !j()) {
            i();
        }
        i iVar = this.f70305b;
        if (iVar != null) {
            iVar.u(new MarketOverviewSub(z11), marketOverviewListener);
        }
    }

    public void f(String str, Period period, long j11, long j12, KLineListener kLineListener) {
        Period period2 = period;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f70307d);
        sb2.append("-->requestKLineList--> symbol=");
        String str2 = str;
        sb2.append(str);
        sb2.append(" period=");
        sb2.append(period);
        sb2.append(" from=");
        sb2.append(this.f70304a.format(new Date(j11)));
        sb2.append(" to=");
        sb2.append(this.f70304a.format(new Date(j12)));
        RetrofitLogger.a(sb2.toString());
        if (!j()) {
            i();
        }
        i iVar = this.f70305b;
        if (iVar != null) {
            iVar.u(new IndexKlineRequest(str, period2.value, j11, j12), kLineListener);
        }
    }

    public void g(boolean z11, String str, Period period, LastKlineListener lastKlineListener) {
        RetrofitLogger.a(this.f70307d + "-->subscribeLastKline--> isSubscribe=" + z11 + " symbol=" + str + " period=" + period + " listener=" + lastKlineListener);
        if (z11 && !j()) {
            i();
        }
        i iVar = this.f70305b;
        if (iVar != null) {
            iVar.u(new IndexLastKlineSub(z11, str, period.value), lastKlineListener);
        }
    }

    public d9.a<List<SymbolPrice>> h() {
        return new d9.a<>(((IndexService) IndexRetrofit.request(IndexService.class)).requestIndexOverView(TtmlNode.COMBINE_ALL).compose(IndexRetrofit.h()));
    }

    public void i() {
        RetrofitLogger.a(this.f70307d + "-->connectWebSocket");
        i iVar = this.f70305b;
        if (iVar != null) {
            iVar.n();
        }
        c9.b bVar = this.f70306c;
        if (bVar != null) {
            String webSocketHost = bVar.getWebSocketHost();
            if (!TextUtils.isEmpty(webSocketHost)) {
                if (this.f70305b == null) {
                    this.f70305b = new i(IndexRetrofit.d().getTag(), IndexRetrofit.d().createSocketOkHttpClientBuilder().build(), this.f70306c);
                }
                this.f70305b.m(webSocketHost);
            }
        }
    }

    public final boolean j() {
        i iVar = this.f70305b;
        return iVar != null && iVar.q();
    }
}
