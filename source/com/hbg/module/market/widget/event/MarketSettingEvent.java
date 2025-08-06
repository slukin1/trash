package com.hbg.module.market.widget.event;

import com.hbg.lib.data.symbol.TradeType;
import s9.a;

public class MarketSettingEvent {

    /* renamed from: a  reason: collision with root package name */
    public boolean f26707a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f26708b;

    /* renamed from: c  reason: collision with root package name */
    public String f26709c;

    /* renamed from: d  reason: collision with root package name */
    public TradeType f26710d;

    /* renamed from: e  reason: collision with root package name */
    public a f26711e;

    public String a() {
        return this.f26709c;
    }

    public TradeType b() {
        return this.f26710d;
    }

    public boolean c() {
        return this.f26707a;
    }

    public boolean d() {
        return this.f26708b;
    }

    public void e(boolean z11) {
        this.f26707a = z11;
    }

    public void f(boolean z11) {
        this.f26708b = z11;
    }

    public void g(String str) {
        this.f26709c = str;
    }

    public void h(TradeType tradeType) {
        this.f26710d = tradeType;
    }

    public void i(a aVar) {
        this.f26711e = aVar;
    }
}
