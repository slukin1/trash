package com.huobi.contract.entity;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.huobi.contract.viewhandler.ContractLeftDrawerItemHandler;
import s9.a;

public class ContractCurrencyInfoDrawerItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public ContractCurrencyInfo f43055b;

    /* renamed from: c  reason: collision with root package name */
    public ej.a f43056c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43057d;

    public boolean a(Object obj) {
        return obj instanceof ContractCurrencyInfoDrawerItem;
    }

    public ej.a c() {
        return this.f43056c;
    }

    public ContractCurrencyInfo d() {
        return this.f43055b;
    }

    public boolean e() {
        return this.f43057d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractCurrencyInfoDrawerItem)) {
            return false;
        }
        ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem = (ContractCurrencyInfoDrawerItem) obj;
        if (!contractCurrencyInfoDrawerItem.a(this)) {
            return false;
        }
        ContractCurrencyInfo d11 = d();
        ContractCurrencyInfo d12 = contractCurrencyInfoDrawerItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        ej.a c11 = c();
        ej.a c12 = contractCurrencyInfoDrawerItem.c();
        if (c11 != null ? c11.equals(c12) : c12 == null) {
            return e() == contractCurrencyInfoDrawerItem.e();
        }
        return false;
    }

    public void f(ej.a aVar) {
        this.f43056c = aVar;
    }

    public void g(ContractCurrencyInfo contractCurrencyInfo) {
        this.f43055b = contractCurrencyInfo;
    }

    public String getViewHandlerName() {
        return ContractLeftDrawerItemHandler.class.getName();
    }

    public void h(boolean z11) {
        this.f43057d = z11;
    }

    public int hashCode() {
        ContractCurrencyInfo d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        ej.a c11 = c();
        int i12 = (hashCode + 59) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return ((i12 + i11) * 59) + (e() ? 79 : 97);
    }

    public String toString() {
        return "ContractCurrencyInfoDrawerItem(info=" + d() + ", callback=" + c() + ", nightMode=" + e() + ")";
    }
}
