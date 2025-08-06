package com.huobi.finance.bean;

import c6.b;
import com.huobi.finance.viewhandler.GridAssetCurrencyListItemHandler;
import s9.a;

public class GridAssetCurrencyListItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f45356b;

    /* renamed from: c  reason: collision with root package name */
    public String f45357c;

    /* renamed from: d  reason: collision with root package name */
    public String f45358d;

    /* renamed from: e  reason: collision with root package name */
    public b<GridAssetCurrencyListItem> f45359e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45360f;

    public boolean a(Object obj) {
        return obj instanceof GridAssetCurrencyListItem;
    }

    public String c() {
        return this.f45357c;
    }

    public b<GridAssetCurrencyListItem> d() {
        return this.f45359e;
    }

    public String e() {
        return this.f45356b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridAssetCurrencyListItem)) {
            return false;
        }
        GridAssetCurrencyListItem gridAssetCurrencyListItem = (GridAssetCurrencyListItem) obj;
        if (!gridAssetCurrencyListItem.a(this)) {
            return false;
        }
        String e11 = e();
        String e12 = gridAssetCurrencyListItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = gridAssetCurrencyListItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String f11 = f();
        String f12 = gridAssetCurrencyListItem.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        b<GridAssetCurrencyListItem> d11 = d();
        b<GridAssetCurrencyListItem> d12 = gridAssetCurrencyListItem.d();
        if (d11 != null ? d11.equals(d12) : d12 == null) {
            return g() == gridAssetCurrencyListItem.g();
        }
        return false;
    }

    public String f() {
        return this.f45358d;
    }

    public boolean g() {
        return this.f45360f;
    }

    public String getViewHandlerName() {
        return GridAssetCurrencyListItemHandler.class.getName();
    }

    public void h(String str) {
        this.f45357c = str;
    }

    public int hashCode() {
        String e11 = e();
        int i11 = 43;
        int hashCode = e11 == null ? 43 : e11.hashCode();
        String c11 = c();
        int hashCode2 = ((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
        String f11 = f();
        int hashCode3 = (hashCode2 * 59) + (f11 == null ? 43 : f11.hashCode());
        b<GridAssetCurrencyListItem> d11 = d();
        int i12 = hashCode3 * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return ((i12 + i11) * 59) + (g() ? 79 : 97);
    }

    public void i(b<GridAssetCurrencyListItem> bVar) {
        this.f45359e = bVar;
    }

    public void j(String str) {
        this.f45356b = str;
    }

    public void k(boolean z11) {
        this.f45360f = z11;
    }

    public void l(String str) {
        this.f45358d = str;
    }

    public String toString() {
        return "GridAssetCurrencyListItem(currency=" + e() + ", amount=" + c() + ", legal=" + f() + ", callback=" + d() + ", isHide=" + g() + ")";
    }
}
