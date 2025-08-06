package com.huobi.main.trade.bean;

import com.huobi.main.trade.enums.SafeguardType;
import com.huobi.main.trade.viewhandler.SingleSafeguardDrawerItemHandler;
import s9.a;

public class SingleSafeguardDrawerItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f77783b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f77784c;

    /* renamed from: d  reason: collision with root package name */
    public SafeguardType f77785d;

    public boolean a(Object obj) {
        return obj instanceof SingleSafeguardDrawerItem;
    }

    public String c() {
        return this.f77783b;
    }

    public SafeguardType d() {
        return this.f77785d;
    }

    public boolean e() {
        return this.f77784c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SingleSafeguardDrawerItem)) {
            return false;
        }
        SingleSafeguardDrawerItem singleSafeguardDrawerItem = (SingleSafeguardDrawerItem) obj;
        if (!singleSafeguardDrawerItem.a(this)) {
            return false;
        }
        String c11 = c();
        String c12 = singleSafeguardDrawerItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        if (e() != singleSafeguardDrawerItem.e()) {
            return false;
        }
        SafeguardType d11 = d();
        SafeguardType d12 = singleSafeguardDrawerItem.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public void f(boolean z11) {
        this.f77784c = z11;
    }

    public void g(String str) {
        this.f77783b = str;
    }

    public String getViewHandlerName() {
        return SingleSafeguardDrawerItemHandler.class.getName();
    }

    public void h(SafeguardType safeguardType) {
        this.f77785d = safeguardType;
    }

    public int hashCode() {
        String c11 = c();
        int i11 = 43;
        int hashCode = (((c11 == null ? 43 : c11.hashCode()) + 59) * 59) + (e() ? 79 : 97);
        SafeguardType d11 = d();
        int i12 = hashCode * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "SingleSafeguardDrawerItem(safeGuard=" + c() + ", isNight=" + e() + ", safeguardType=" + d() + ")";
    }
}
