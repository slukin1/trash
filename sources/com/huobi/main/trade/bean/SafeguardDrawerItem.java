package com.huobi.main.trade.bean;

import com.huobi.main.trade.enums.SafeguardType;
import com.huobi.main.trade.viewhandler.SafeguardDrawerItemHandler;
import s9.a;

public class SafeguardDrawerItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f77779b;

    /* renamed from: c  reason: collision with root package name */
    public String f77780c;

    /* renamed from: d  reason: collision with root package name */
    public SafeguardType f77781d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f77782e;

    public boolean a(Object obj) {
        return obj instanceof SafeguardDrawerItem;
    }

    public String c() {
        return this.f77779b;
    }

    public SafeguardType d() {
        return this.f77781d;
    }

    public String e() {
        return this.f77780c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeguardDrawerItem)) {
            return false;
        }
        SafeguardDrawerItem safeguardDrawerItem = (SafeguardDrawerItem) obj;
        if (!safeguardDrawerItem.a(this)) {
            return false;
        }
        String c11 = c();
        String c12 = safeguardDrawerItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = safeguardDrawerItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        SafeguardType d11 = d();
        SafeguardType d12 = safeguardDrawerItem.d();
        if (d11 != null ? d11.equals(d12) : d12 == null) {
            return f() == safeguardDrawerItem.f();
        }
        return false;
    }

    public boolean f() {
        return this.f77782e;
    }

    public void g(String str) {
        this.f77779b = str;
    }

    public String getViewHandlerName() {
        return SafeguardDrawerItemHandler.class.getName();
    }

    public void h(boolean z11) {
        this.f77782e = z11;
    }

    public int hashCode() {
        String c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        String e11 = e();
        int hashCode2 = ((hashCode + 59) * 59) + (e11 == null ? 43 : e11.hashCode());
        SafeguardType d11 = d();
        int i12 = hashCode2 * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return ((i12 + i11) * 59) + (f() ? 79 : 97);
    }

    public void i(SafeguardType safeguardType) {
        this.f77781d = safeguardType;
    }

    public void j(String str) {
        this.f77780c = str;
    }

    public String toString() {
        return "SafeguardDrawerItem(contractSafeguard=" + c() + ", swapSafeguard=" + e() + ", safeguardType=" + d() + ", isNight=" + f() + ")";
    }
}
