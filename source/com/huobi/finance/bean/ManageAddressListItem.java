package com.huobi.finance.bean;

import com.hbg.lib.network.pro.core.bean.DefiChainInfo;
import com.hbg.lib.network.pro.core.bean.UserAddrInfo;
import com.huobi.finance.viewhandler.ManageAddressListItemHandler;

public class ManageAddressListItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public DefiChainInfo f45375b;

    /* renamed from: c  reason: collision with root package name */
    public UserAddrInfo f45376c;

    /* renamed from: d  reason: collision with root package name */
    public a f45377d;

    public interface a {
        void a(ManageAddressListItem manageAddressListItem);

        void b(ManageAddressListItem manageAddressListItem);

        void c(ManageAddressListItem manageAddressListItem);

        boolean d(ManageAddressListItem manageAddressListItem);
    }

    public boolean a(Object obj) {
        return obj instanceof ManageAddressListItem;
    }

    public UserAddrInfo c() {
        return this.f45376c;
    }

    public a d() {
        return this.f45377d;
    }

    public DefiChainInfo e() {
        return this.f45375b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ManageAddressListItem)) {
            return false;
        }
        ManageAddressListItem manageAddressListItem = (ManageAddressListItem) obj;
        if (!manageAddressListItem.a(this)) {
            return false;
        }
        DefiChainInfo e11 = e();
        DefiChainInfo e12 = manageAddressListItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        UserAddrInfo c11 = c();
        UserAddrInfo c12 = manageAddressListItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        a d11 = d();
        a d12 = manageAddressListItem.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public void f(UserAddrInfo userAddrInfo) {
        this.f45376c = userAddrInfo;
    }

    public void g(a aVar) {
        this.f45377d = aVar;
    }

    public String getViewHandlerName() {
        return ManageAddressListItemHandler.class.getName();
    }

    public void h(DefiChainInfo defiChainInfo) {
        this.f45375b = defiChainInfo;
    }

    public int hashCode() {
        DefiChainInfo e11 = e();
        int i11 = 43;
        int hashCode = e11 == null ? 43 : e11.hashCode();
        UserAddrInfo c11 = c();
        int hashCode2 = ((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
        a d11 = d();
        int i12 = hashCode2 * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "ManageAddressListItem(chainInfo=" + e() + ", addrInfo=" + c() + ", callback=" + d() + ")";
    }
}
