package com.hbg.lib.widgets;

import android.view.View;
import s9.a;

public class TopScrollSymbolData implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f71662b;

    /* renamed from: c  reason: collision with root package name */
    public String f71663c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f71664d;

    /* renamed from: e  reason: collision with root package name */
    public HEAD_TYPE f71665e;

    /* renamed from: f  reason: collision with root package name */
    public Object f71666f;

    /* renamed from: g  reason: collision with root package name */
    public int f71667g;

    public enum HEAD_TYPE {
        HOT_SEARCH,
        HOT_BUY,
        HOT_CURRENCY
    }

    public boolean a(Object obj) {
        return obj instanceof TopScrollSymbolData;
    }

    public HEAD_TYPE c() {
        return this.f71665e;
    }

    public int d() {
        return this.f71667g;
    }

    public View.OnClickListener e() {
        return this.f71664d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TopScrollSymbolData)) {
            return false;
        }
        TopScrollSymbolData topScrollSymbolData = (TopScrollSymbolData) obj;
        if (!topScrollSymbolData.a(this)) {
            return false;
        }
        String g11 = g();
        String g12 = topScrollSymbolData.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String h11 = h();
        String h12 = topScrollSymbolData.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        View.OnClickListener e11 = e();
        View.OnClickListener e12 = topScrollSymbolData.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        HEAD_TYPE c11 = c();
        HEAD_TYPE c12 = topScrollSymbolData.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        Object f11 = f();
        Object f12 = topScrollSymbolData.f();
        if (f11 != null ? f11.equals(f12) : f12 == null) {
            return d() == topScrollSymbolData.d();
        }
        return false;
    }

    public Object f() {
        return this.f71666f;
    }

    public String g() {
        return this.f71662b;
    }

    public String getViewHandlerName() {
        return null;
    }

    public String h() {
        return this.f71663c;
    }

    public int hashCode() {
        String g11 = g();
        int i11 = 43;
        int hashCode = g11 == null ? 43 : g11.hashCode();
        String h11 = h();
        int hashCode2 = ((hashCode + 59) * 59) + (h11 == null ? 43 : h11.hashCode());
        View.OnClickListener e11 = e();
        int hashCode3 = (hashCode2 * 59) + (e11 == null ? 43 : e11.hashCode());
        HEAD_TYPE c11 = c();
        int hashCode4 = (hashCode3 * 59) + (c11 == null ? 43 : c11.hashCode());
        Object f11 = f();
        int i12 = hashCode4 * 59;
        if (f11 != null) {
            i11 = f11.hashCode();
        }
        return ((i12 + i11) * 59) + d();
    }

    public void i(int i11) {
        this.f71667g = i11;
    }

    public void j(View.OnClickListener onClickListener) {
        this.f71664d = onClickListener;
    }

    public String toString() {
        return "[" + this.f71662b + " /" + this.f71663c + "]";
    }
}
