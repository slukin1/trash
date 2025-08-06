package com.huobi.search.bean;

import com.huobi.search.viewhandler.SearchRecommendItemHandler;
import s9.a;

public class SearchRecommendItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f80752b;

    /* renamed from: c  reason: collision with root package name */
    public String f80753c;

    /* renamed from: d  reason: collision with root package name */
    public String f80754d;

    /* renamed from: e  reason: collision with root package name */
    public String f80755e;

    /* renamed from: f  reason: collision with root package name */
    public String f80756f;

    /* renamed from: g  reason: collision with root package name */
    public String f80757g;

    /* renamed from: h  reason: collision with root package name */
    public String f80758h;

    /* renamed from: i  reason: collision with root package name */
    public String f80759i;

    public boolean a(Object obj) {
        return obj instanceof SearchRecommendItem;
    }

    public String c() {
        return this.f80758h;
    }

    public String d() {
        return this.f80753c;
    }

    public String e() {
        return this.f80754d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchRecommendItem)) {
            return false;
        }
        SearchRecommendItem searchRecommendItem = (SearchRecommendItem) obj;
        if (!searchRecommendItem.a(this)) {
            return false;
        }
        String i11 = i();
        String i12 = searchRecommendItem.i();
        if (i11 != null ? !i11.equals(i12) : i12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = searchRecommendItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = searchRecommendItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        String g11 = g();
        String g12 = searchRecommendItem.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String h11 = h();
        String h12 = searchRecommendItem.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        String j11 = j();
        String j12 = searchRecommendItem.j();
        if (j11 != null ? !j11.equals(j12) : j12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = searchRecommendItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String f11 = f();
        String f12 = searchRecommendItem.f();
        return f11 != null ? f11.equals(f12) : f12 == null;
    }

    public String f() {
        return this.f80759i;
    }

    public String g() {
        return this.f80755e;
    }

    public String getViewHandlerName() {
        return SearchRecommendItemHandler.class.getName();
    }

    public String h() {
        return this.f80756f;
    }

    public int hashCode() {
        String i11 = i();
        int i12 = 43;
        int hashCode = i11 == null ? 43 : i11.hashCode();
        String d11 = d();
        int hashCode2 = ((hashCode + 59) * 59) + (d11 == null ? 43 : d11.hashCode());
        String e11 = e();
        int hashCode3 = (hashCode2 * 59) + (e11 == null ? 43 : e11.hashCode());
        String g11 = g();
        int hashCode4 = (hashCode3 * 59) + (g11 == null ? 43 : g11.hashCode());
        String h11 = h();
        int hashCode5 = (hashCode4 * 59) + (h11 == null ? 43 : h11.hashCode());
        String j11 = j();
        int hashCode6 = (hashCode5 * 59) + (j11 == null ? 43 : j11.hashCode());
        String c11 = c();
        int hashCode7 = (hashCode6 * 59) + (c11 == null ? 43 : c11.hashCode());
        String f11 = f();
        int i13 = hashCode7 * 59;
        if (f11 != null) {
            i12 = f11.hashCode();
        }
        return i13 + i12;
    }

    public String i() {
        return this.f80752b;
    }

    public String j() {
        return this.f80757g;
    }

    public String toString() {
        return "SearchRecommendItem(symbol=" + i() + ", displayName=" + d() + ", labels=" + e() + ", percent=" + g() + ", price=" + h() + ", symbolName=" + j() + ", currency=" + c() + ", multi=" + f() + ")";
    }
}
