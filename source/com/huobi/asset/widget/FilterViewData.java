package com.huobi.asset.widget;

import s9.a;

public class FilterViewData implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f42491b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42492c;

    public boolean a(Object obj) {
        return obj instanceof FilterViewData;
    }

    public String c() {
        return this.f42491b;
    }

    public boolean d() {
        return this.f42492c;
    }

    public void e(boolean z11) {
        this.f42492c = z11;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FilterViewData)) {
            return false;
        }
        FilterViewData filterViewData = (FilterViewData) obj;
        if (!filterViewData.a(this)) {
            return false;
        }
        String c11 = c();
        String c12 = filterViewData.c();
        if (c11 != null ? c11.equals(c12) : c12 == null) {
            return d() == filterViewData.d();
        }
        return false;
    }

    public void f(String str) {
        this.f42491b = str;
    }

    public String getViewHandlerName() {
        return FilterViewHandler.class.getName();
    }

    public int hashCode() {
        String c11 = c();
        return (((c11 == null ? 43 : c11.hashCode()) + 59) * 59) + (d() ? 79 : 97);
    }

    public String toString() {
        return "FilterViewData(title=" + c() + ", notShowBubble=" + d() + ")";
    }
}
