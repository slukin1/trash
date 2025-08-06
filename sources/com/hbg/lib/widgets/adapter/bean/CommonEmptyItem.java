package com.hbg.lib.widgets.adapter.bean;

import com.hbg.lib.widgets.adapter.viewhandler.CommonEmptyItemHandler;

public class CommonEmptyItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f71735b;

    /* renamed from: c  reason: collision with root package name */
    public int f71736c;

    /* renamed from: d  reason: collision with root package name */
    public int f71737d;

    /* renamed from: e  reason: collision with root package name */
    public String f71738e;

    /* renamed from: f  reason: collision with root package name */
    public String f71739f;

    /* renamed from: g  reason: collision with root package name */
    public a f71740g;

    public interface a {
        void a();
    }

    public boolean a(Object obj) {
        return obj instanceof CommonEmptyItem;
    }

    public int c() {
        return this.f71737d;
    }

    public String d() {
        return this.f71739f;
    }

    public a e() {
        return this.f71740g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CommonEmptyItem)) {
            return false;
        }
        CommonEmptyItem commonEmptyItem = (CommonEmptyItem) obj;
        if (!commonEmptyItem.a(this) || f() != commonEmptyItem.f() || h() != commonEmptyItem.h() || c() != commonEmptyItem.c()) {
            return false;
        }
        String g11 = g();
        String g12 = commonEmptyItem.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = commonEmptyItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        a e11 = e();
        a e12 = commonEmptyItem.e();
        return e11 != null ? e11.equals(e12) : e12 == null;
    }

    public int f() {
        return this.f71735b;
    }

    public String g() {
        return this.f71738e;
    }

    public String getViewHandlerName() {
        return CommonEmptyItemHandler.class.getName();
    }

    public int h() {
        return this.f71736c;
    }

    public int hashCode() {
        int f11 = ((((f() + 59) * 59) + h()) * 59) + c();
        String g11 = g();
        int i11 = 43;
        int hashCode = (f11 * 59) + (g11 == null ? 43 : g11.hashCode());
        String d11 = d();
        int hashCode2 = (hashCode * 59) + (d11 == null ? 43 : d11.hashCode());
        a e11 = e();
        int i12 = hashCode2 * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return i12 + i11;
    }

    public void i(String str) {
        this.f71739f = str;
    }

    public void j(a aVar) {
        this.f71740g = aVar;
    }

    public void k(int i11) {
        this.f71735b = i11;
    }

    public void l(String str) {
        this.f71738e = str;
    }

    public String toString() {
        return "CommonEmptyItem(imageRes=" + f() + ", topPadding=" + h() + ", bottomPadding=" + c() + ", text=" + g() + ", btnText=" + d() + ", callback=" + e() + ")";
    }
}
