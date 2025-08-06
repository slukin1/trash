package com.hbg.lite.record.bean;

import com.hbg.lib.network.otc.core.bean.OrderInfoListBean;
import com.hbg.lite.record.viewhandler.OtcTradingHouseOrderViewHandler;
import s9.a;

public class OtcTradingHouseOrderList implements a {

    /* renamed from: b  reason: collision with root package name */
    public OrderInfoListBean f77346b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f77347c;

    public boolean a(Object obj) {
        return obj instanceof OtcTradingHouseOrderList;
    }

    public String c() {
        return this.f77346b.getQuoteAssetName();
    }

    public OrderInfoListBean d() {
        return this.f77346b;
    }

    public String e() {
        return this.f77346b.getCryptoAssetName();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcTradingHouseOrderList)) {
            return false;
        }
        OtcTradingHouseOrderList otcTradingHouseOrderList = (OtcTradingHouseOrderList) obj;
        if (!otcTradingHouseOrderList.a(this)) {
            return false;
        }
        OrderInfoListBean d11 = d();
        OrderInfoListBean d12 = otcTradingHouseOrderList.d();
        if (d11 != null ? d11.equals(d12) : d12 == null) {
            return g() == otcTradingHouseOrderList.g();
        }
        return false;
    }

    public boolean f() {
        return this.f77346b.getSide().intValue() == 1;
    }

    public boolean g() {
        return this.f77347c;
    }

    public String getViewHandlerName() {
        return OtcTradingHouseOrderViewHandler.class.getName();
    }

    public void h(OrderInfoListBean orderInfoListBean) {
        this.f77346b = orderInfoListBean;
    }

    public int hashCode() {
        OrderInfoListBean d11 = d();
        return (((d11 == null ? 43 : d11.hashCode()) + 59) * 59) + (g() ? 79 : 97);
    }

    public void i(boolean z11) {
        this.f77347c = z11;
    }

    public String toString() {
        return "OtcTradingHouseOrderList(otcOrderBean=" + d() + ", isShowCurrency=" + g() + ")";
    }
}
