package com.huobi.finance.bean;

import com.hbg.lib.network.pro.core.bean.DefiChainInfo;
import com.huobi.finance.viewhandler.AddAddrListItemHandler;

public class AddAddrListItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public DefiChainInfo f45253b;

    /* renamed from: c  reason: collision with root package name */
    public a f45254c;

    public interface a {
        boolean a(int i11, AddAddrListItem addAddrListItem);

        void b(int i11, AddAddrListItem addAddrListItem);
    }

    public boolean a(Object obj) {
        return obj instanceof AddAddrListItem;
    }

    public a c() {
        return this.f45254c;
    }

    public DefiChainInfo d() {
        return this.f45253b;
    }

    public void e(a aVar) {
        this.f45254c = aVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddAddrListItem)) {
            return false;
        }
        AddAddrListItem addAddrListItem = (AddAddrListItem) obj;
        if (!addAddrListItem.a(this)) {
            return false;
        }
        DefiChainInfo d11 = d();
        DefiChainInfo d12 = addAddrListItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = addAddrListItem.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(DefiChainInfo defiChainInfo) {
        this.f45253b = defiChainInfo;
    }

    public String getViewHandlerName() {
        return AddAddrListItemHandler.class.getName();
    }

    public int hashCode() {
        DefiChainInfo d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        a c11 = c();
        int i12 = (hashCode + 59) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "AddAddrListItem(info=" + d() + ", callback=" + c() + ")";
    }
}
