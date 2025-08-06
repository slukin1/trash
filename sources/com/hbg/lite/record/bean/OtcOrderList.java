package com.hbg.lite.record.bean;

import com.hbg.lib.network.otc.core.bean.OrderInfoListBean;
import com.hbg.lite.record.viewhandler.OtcOrderViewHandler;
import s9.a;

public class OtcOrderList implements a {

    /* renamed from: b  reason: collision with root package name */
    public OrderInfoListBean f77343b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f77344c;

    /* renamed from: d  reason: collision with root package name */
    public int f77345d;

    public boolean a(Object obj) {
        return obj instanceof OtcOrderList;
    }

    public int c() {
        return this.f77345d;
    }

    public OrderInfoListBean d() {
        return this.f77343b;
    }

    public boolean e() {
        return this.f77343b.getSide().intValue() == 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcOrderList)) {
            return false;
        }
        OtcOrderList otcOrderList = (OtcOrderList) obj;
        if (!otcOrderList.a(this)) {
            return false;
        }
        OrderInfoListBean d11 = d();
        OrderInfoListBean d12 = otcOrderList.d();
        if (d11 != null ? d11.equals(d12) : d12 == null) {
            return f() == otcOrderList.f() && c() == otcOrderList.c();
        }
        return false;
    }

    public boolean f() {
        return this.f77344c;
    }

    public void g(OrderInfoListBean orderInfoListBean) {
        this.f77343b = orderInfoListBean;
    }

    public String getViewHandlerName() {
        return OtcOrderViewHandler.class.getName();
    }

    public void h(boolean z11) {
        this.f77344c = z11;
    }

    public int hashCode() {
        OrderInfoListBean d11 = d();
        return (((((d11 == null ? 43 : d11.hashCode()) + 59) * 59) + (f() ? 79 : 97)) * 59) + c();
    }

    public String toString() {
        return "OtcOrderList(otcOrderBean=" + d() + ", isShowCurrency=" + f() + ", currencyId=" + c() + ")";
    }
}
