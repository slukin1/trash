package com.huobi.swap.bean;

import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.huobi.swap.viewhandler.SwapLeftDrawerItemHandler;
import s9.a;

public class SwapCurrencyInfoDrawerItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public SwapCurrencyInfo f81497b;

    /* renamed from: c  reason: collision with root package name */
    public SymbolPrice f81498c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f81499d = true;

    /* renamed from: e  reason: collision with root package name */
    public ej.a f81500e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f81501f;

    public boolean a(Object obj) {
        return obj instanceof SwapCurrencyInfoDrawerItem;
    }

    public ej.a c() {
        return this.f81500e;
    }

    public SwapCurrencyInfo d() {
        return this.f81497b;
    }

    public boolean e() {
        return this.f81501f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapCurrencyInfoDrawerItem)) {
            return false;
        }
        SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem = (SwapCurrencyInfoDrawerItem) obj;
        if (!swapCurrencyInfoDrawerItem.a(this)) {
            return false;
        }
        SwapCurrencyInfo d11 = d();
        SwapCurrencyInfo d12 = swapCurrencyInfoDrawerItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        SymbolPrice symbolPrice = getSymbolPrice();
        SymbolPrice symbolPrice2 = swapCurrencyInfoDrawerItem.getSymbolPrice();
        if (symbolPrice != null ? !symbolPrice.equals(symbolPrice2) : symbolPrice2 != null) {
            return false;
        }
        if (f() != swapCurrencyInfoDrawerItem.f()) {
            return false;
        }
        ej.a c11 = c();
        ej.a c12 = swapCurrencyInfoDrawerItem.c();
        if (c11 != null ? c11.equals(c12) : c12 == null) {
            return e() == swapCurrencyInfoDrawerItem.e();
        }
        return false;
    }

    public boolean f() {
        return this.f81499d;
    }

    public void g(ej.a aVar) {
        this.f81500e = aVar;
    }

    public SymbolPrice getSymbolPrice() {
        return this.f81498c;
    }

    public String getViewHandlerName() {
        return SwapLeftDrawerItemHandler.class.getName();
    }

    public void h(SwapCurrencyInfo swapCurrencyInfo) {
        this.f81497b = swapCurrencyInfo;
    }

    public int hashCode() {
        SwapCurrencyInfo d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        SymbolPrice symbolPrice = getSymbolPrice();
        int i12 = 79;
        int hashCode2 = ((((hashCode + 59) * 59) + (symbolPrice == null ? 43 : symbolPrice.hashCode())) * 59) + (f() ? 79 : 97);
        ej.a c11 = c();
        int i13 = hashCode2 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        int i14 = (i13 + i11) * 59;
        if (!e()) {
            i12 = 97;
        }
        return i14 + i12;
    }

    public void i(boolean z11) {
        this.f81501f = z11;
    }

    public void j(boolean z11) {
        this.f81499d = z11;
    }

    public void k(SymbolPrice symbolPrice) {
        this.f81498c = symbolPrice;
    }

    public String toString() {
        return "SwapCurrencyInfoDrawerItem(info=" + d() + ", symbolPrice=" + getSymbolPrice() + ", isPercentVisible=" + f() + ", callback=" + c() + ", nightMode=" + e() + ")";
    }
}
