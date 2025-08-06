package com.huobi.finance.bean;

import com.hbg.lib.network.pro.core.bean.DefiChainInfo;
import com.huobi.finance.viewhandler.ManageTabListItemHandler;
import java.util.ArrayList;
import java.util.List;

public class ManageTabListItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public a f45378b;

    /* renamed from: c  reason: collision with root package name */
    public DefiChainInfo f45379c;

    /* renamed from: d  reason: collision with root package name */
    public List<ManageAddressListItem> f45380d = new ArrayList();

    public interface a {
        boolean a(ManageTabListItem manageTabListItem);

        void b(ManageTabListItem manageTabListItem);
    }

    public boolean a(Object obj) {
        return obj instanceof ManageTabListItem;
    }

    public a c() {
        return this.f45378b;
    }

    public DefiChainInfo d() {
        return this.f45379c;
    }

    public List<ManageAddressListItem> e() {
        return this.f45380d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ManageTabListItem)) {
            return false;
        }
        ManageTabListItem manageTabListItem = (ManageTabListItem) obj;
        if (!manageTabListItem.a(this)) {
            return false;
        }
        a c11 = c();
        a c12 = manageTabListItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        DefiChainInfo d11 = d();
        DefiChainInfo d12 = manageTabListItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        List<ManageAddressListItem> e11 = e();
        List<ManageAddressListItem> e12 = manageTabListItem.e();
        return e11 != null ? e11.equals(e12) : e12 == null;
    }

    public void f(a aVar) {
        this.f45378b = aVar;
    }

    public void g(DefiChainInfo defiChainInfo) {
        this.f45379c = defiChainInfo;
    }

    public String getViewHandlerName() {
        return ManageTabListItemHandler.class.getName();
    }

    public void h(List<ManageAddressListItem> list) {
        this.f45380d = list;
    }

    public int hashCode() {
        a c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        DefiChainInfo d11 = d();
        int hashCode2 = ((hashCode + 59) * 59) + (d11 == null ? 43 : d11.hashCode());
        List<ManageAddressListItem> e11 = e();
        int i12 = hashCode2 * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "ManageTabListItem(callback=" + c() + ", info=" + d() + ", list=" + e() + ")";
    }
}
