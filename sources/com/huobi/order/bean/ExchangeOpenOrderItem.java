package com.huobi.order.bean;

import android.content.Context;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.ExchangeOpenOrder;
import com.huobi.trade.bean.TradeOrderType;
import com.huobi.trade.handler.ExchangeOpenOrderItemViewHandler;

public class ExchangeOpenOrderItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public ExchangeOpenOrder f78103b;

    /* renamed from: c  reason: collision with root package name */
    public TradeType f78104c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f78105d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f78106e;

    /* renamed from: f  reason: collision with root package name */
    public a f78107f;

    public interface a {
        void a(ExchangeOpenOrderItem exchangeOpenOrderItem, Context context);
    }

    public boolean a(Object obj) {
        return obj instanceof ExchangeOpenOrderItem;
    }

    public a c() {
        return this.f78107f;
    }

    public ExchangeOpenOrder d() {
        return this.f78103b;
    }

    public TradeType e() {
        return this.f78104c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExchangeOpenOrderItem)) {
            return false;
        }
        ExchangeOpenOrderItem exchangeOpenOrderItem = (ExchangeOpenOrderItem) obj;
        if (!exchangeOpenOrderItem.a(this)) {
            return false;
        }
        ExchangeOpenOrder d11 = d();
        ExchangeOpenOrder d12 = exchangeOpenOrderItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        TradeType e11 = e();
        TradeType e12 = exchangeOpenOrderItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        if (i() != exchangeOpenOrderItem.i() || g() != exchangeOpenOrderItem.g()) {
            return false;
        }
        a c11 = c();
        a c12 = exchangeOpenOrderItem.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public boolean f() {
        return TradeOrderType.b(this.f78103b.getType());
    }

    public boolean g() {
        return this.f78106e;
    }

    public String getViewHandlerName() {
        return ExchangeOpenOrderItemViewHandler.class.getName();
    }

    public boolean h() {
        return TradeOrderType.f(this.f78103b.getType());
    }

    public int hashCode() {
        ExchangeOpenOrder d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        TradeType e11 = e();
        int i12 = 79;
        int hashCode2 = (((((hashCode + 59) * 59) + (e11 == null ? 43 : e11.hashCode())) * 59) + (i() ? 79 : 97)) * 59;
        if (!g()) {
            i12 = 97;
        }
        a c11 = c();
        int i13 = (hashCode2 + i12) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i13 + i11;
    }

    public boolean i() {
        return this.f78105d;
    }

    public void j(boolean z11) {
        this.f78106e = z11;
    }

    public void k(a aVar) {
        this.f78107f = aVar;
    }

    public void l(ExchangeOpenOrder exchangeOpenOrder) {
        this.f78103b = exchangeOpenOrder;
    }

    public void m(boolean z11) {
        this.f78105d = z11;
    }

    public void n(TradeType tradeType) {
        this.f78104c = tradeType;
    }

    public String toString() {
        return "ExchangeOpenOrderItem(exchangeOpenOrder=" + d() + ", tradeType=" + e() + ", isTrade=" + i() + ", isCallAuctionTwo=" + g() + ", callback=" + c() + ")";
    }
}
