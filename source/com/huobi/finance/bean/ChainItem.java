package com.huobi.finance.bean;

import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.huobi.finance.viewhandler.WithdrawChainViewHandler;

public class ChainItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public ChainInfo f45339b;

    /* renamed from: c  reason: collision with root package name */
    public a f45340c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45341d;

    public interface a {
        boolean a(int i11, ChainInfo chainInfo);

        void b(int i11, ChainInfo chainInfo);
    }

    public boolean a(Object obj) {
        return obj instanceof ChainItem;
    }

    public a c() {
        return this.f45340c;
    }

    public ChainInfo d() {
        return this.f45339b;
    }

    public boolean e() {
        return this.f45341d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChainItem)) {
            return false;
        }
        ChainItem chainItem = (ChainItem) obj;
        if (!chainItem.a(this)) {
            return false;
        }
        ChainInfo d11 = d();
        ChainInfo d12 = chainItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = chainItem.c();
        if (c11 != null ? c11.equals(c12) : c12 == null) {
            return e() == chainItem.e();
        }
        return false;
    }

    public void f(a aVar) {
        this.f45340c = aVar;
    }

    public void g(ChainInfo chainInfo) {
        this.f45339b = chainInfo;
    }

    public String getViewHandlerName() {
        return WithdrawChainViewHandler.class.getName();
    }

    public void h(boolean z11) {
        this.f45341d = z11;
    }

    public int hashCode() {
        ChainInfo d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        a c11 = c();
        int i12 = (hashCode + 59) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return ((i12 + i11) * 59) + (e() ? 79 : 97);
    }

    public String toString() {
        return "ChainItem(chainInfo=" + d() + ", callback=" + c() + ", isSelected=" + e() + ")";
    }
}
