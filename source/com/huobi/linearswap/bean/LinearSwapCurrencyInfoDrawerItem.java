package com.huobi.linearswap.bean;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.linearswap.viewhandler.LinearSwapLeftDrawerItemHandler;
import s9.a;

public class LinearSwapCurrencyInfoDrawerItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public FutureContractInfo f74961b;

    /* renamed from: c  reason: collision with root package name */
    public SymbolPrice f74962c;

    /* renamed from: d  reason: collision with root package name */
    public int f74963d;

    /* renamed from: e  reason: collision with root package name */
    public String f74964e;

    /* renamed from: f  reason: collision with root package name */
    public String f74965f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f74966g = true;

    /* renamed from: h  reason: collision with root package name */
    public ej.a f74967h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f74968i;

    public boolean a(Object obj) {
        return obj instanceof LinearSwapCurrencyInfoDrawerItem;
    }

    public ej.a c() {
        return this.f74967h;
    }

    public String d() {
        return this.f74965f;
    }

    public FutureContractInfo e() {
        return this.f74961b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapCurrencyInfoDrawerItem)) {
            return false;
        }
        LinearSwapCurrencyInfoDrawerItem linearSwapCurrencyInfoDrawerItem = (LinearSwapCurrencyInfoDrawerItem) obj;
        if (!linearSwapCurrencyInfoDrawerItem.a(this)) {
            return false;
        }
        FutureContractInfo e11 = e();
        FutureContractInfo e12 = linearSwapCurrencyInfoDrawerItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        SymbolPrice symbolPrice = getSymbolPrice();
        SymbolPrice symbolPrice2 = linearSwapCurrencyInfoDrawerItem.getSymbolPrice();
        if (symbolPrice != null ? !symbolPrice.equals(symbolPrice2) : symbolPrice2 != null) {
            return false;
        }
        if (g() != linearSwapCurrencyInfoDrawerItem.g()) {
            return false;
        }
        String f11 = f();
        String f12 = linearSwapCurrencyInfoDrawerItem.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = linearSwapCurrencyInfoDrawerItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        if (i() != linearSwapCurrencyInfoDrawerItem.i()) {
            return false;
        }
        ej.a c11 = c();
        ej.a c12 = linearSwapCurrencyInfoDrawerItem.c();
        if (c11 != null ? c11.equals(c12) : c12 == null) {
            return h() == linearSwapCurrencyInfoDrawerItem.h();
        }
        return false;
    }

    public String f() {
        return this.f74964e;
    }

    public int g() {
        return this.f74963d;
    }

    public SymbolPrice getSymbolPrice() {
        return this.f74962c;
    }

    public String getViewHandlerName() {
        return LinearSwapLeftDrawerItemHandler.class.getName();
    }

    public boolean h() {
        return this.f74968i;
    }

    public int hashCode() {
        FutureContractInfo e11 = e();
        int i11 = 43;
        int hashCode = e11 == null ? 43 : e11.hashCode();
        SymbolPrice symbolPrice = getSymbolPrice();
        int hashCode2 = ((((hashCode + 59) * 59) + (symbolPrice == null ? 43 : symbolPrice.hashCode())) * 59) + g();
        String f11 = f();
        int hashCode3 = (hashCode2 * 59) + (f11 == null ? 43 : f11.hashCode());
        String d11 = d();
        int i12 = 79;
        int hashCode4 = (((hashCode3 * 59) + (d11 == null ? 43 : d11.hashCode())) * 59) + (i() ? 79 : 97);
        ej.a c11 = c();
        int i13 = hashCode4 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        int i14 = (i13 + i11) * 59;
        if (!h()) {
            i12 = 97;
        }
        return i14 + i12;
    }

    public boolean i() {
        return this.f74966g;
    }

    public void j(ej.a aVar) {
        this.f74967h = aVar;
    }

    public void k(String str) {
        this.f74965f = str;
    }

    public void l(FutureContractInfo futureContractInfo) {
        this.f74961b = futureContractInfo;
    }

    public void m(boolean z11) {
        this.f74968i = z11;
    }

    public void n(boolean z11) {
        this.f74966g = z11;
    }

    public void o(String str) {
        this.f74964e = str;
    }

    public void p(SymbolPrice symbolPrice) {
        this.f74962c = symbolPrice;
    }

    public void q(int i11) {
        this.f74963d = i11;
    }

    public String toString() {
        return "LinearSwapCurrencyInfoDrawerItem(info=" + e() + ", symbolPrice=" + getSymbolPrice() + ", typeWeight=" + g() + ", strShowClose=" + f() + ", chartPercent=" + d() + ", isPercentVisible=" + i() + ", callback=" + c() + ", nightMode=" + h() + ")";
    }
}
