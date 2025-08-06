package com.huobi.contract.entity;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.contract.viewhandler.OptionLeftDrawerItemHandler;
import s9.a;

public class OptionCurrencyInfoDrawerItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public FutureContractInfo f43097b;

    /* renamed from: c  reason: collision with root package name */
    public ej.a f43098c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43099d;

    /* renamed from: e  reason: collision with root package name */
    public SymbolPrice f43100e;

    public boolean a(Object obj) {
        return obj instanceof OptionCurrencyInfoDrawerItem;
    }

    public ej.a c() {
        return this.f43098c;
    }

    public FutureContractInfo d() {
        return this.f43097b;
    }

    public boolean e() {
        return this.f43099d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionCurrencyInfoDrawerItem)) {
            return false;
        }
        OptionCurrencyInfoDrawerItem optionCurrencyInfoDrawerItem = (OptionCurrencyInfoDrawerItem) obj;
        if (!optionCurrencyInfoDrawerItem.a(this)) {
            return false;
        }
        FutureContractInfo d11 = d();
        FutureContractInfo d12 = optionCurrencyInfoDrawerItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        ej.a c11 = c();
        ej.a c12 = optionCurrencyInfoDrawerItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        if (e() != optionCurrencyInfoDrawerItem.e()) {
            return false;
        }
        SymbolPrice symbolPrice = getSymbolPrice();
        SymbolPrice symbolPrice2 = optionCurrencyInfoDrawerItem.getSymbolPrice();
        return symbolPrice != null ? symbolPrice.equals(symbolPrice2) : symbolPrice2 == null;
    }

    public void f(FutureContractInfo futureContractInfo) {
        this.f43097b = futureContractInfo;
    }

    public SymbolPrice getSymbolPrice() {
        return this.f43100e;
    }

    public String getViewHandlerName() {
        return OptionLeftDrawerItemHandler.class.getName();
    }

    public int hashCode() {
        FutureContractInfo d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        ej.a c11 = c();
        int hashCode2 = ((((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode())) * 59) + (e() ? 79 : 97);
        SymbolPrice symbolPrice = getSymbolPrice();
        int i12 = hashCode2 * 59;
        if (symbolPrice != null) {
            i11 = symbolPrice.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "OptionCurrencyInfoDrawerItem(futureContractInfo=" + d() + ", callback=" + c() + ", nightMode=" + e() + ", symbolPrice=" + getSymbolPrice() + ")";
    }
}
