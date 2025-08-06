package com.huobi.trade.prime.bean;

import com.huobi.trade.prime.viewhandler.PrimeLuckyListOrderItemHandler;
import s9.a;

public class PrimeLuckyListOrderItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f82172b;

    /* renamed from: c  reason: collision with root package name */
    public String f82173c;

    /* renamed from: d  reason: collision with root package name */
    public String f82174d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f82175e;

    public boolean a(Object obj) {
        return obj instanceof PrimeLuckyListOrderItem;
    }

    public String c() {
        return this.f82173c;
    }

    public String d() {
        return this.f82172b;
    }

    public String e() {
        return this.f82174d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrimeLuckyListOrderItem)) {
            return false;
        }
        PrimeLuckyListOrderItem primeLuckyListOrderItem = (PrimeLuckyListOrderItem) obj;
        if (!primeLuckyListOrderItem.a(this)) {
            return false;
        }
        String d11 = d();
        String d12 = primeLuckyListOrderItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = primeLuckyListOrderItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = primeLuckyListOrderItem.e();
        if (e11 != null ? e11.equals(e12) : e12 == null) {
            return f() == primeLuckyListOrderItem.f();
        }
        return false;
    }

    public boolean f() {
        return this.f82175e;
    }

    public void g(String str) {
        this.f82173c = str;
    }

    public String getViewHandlerName() {
        return PrimeLuckyListOrderItemHandler.class.getName();
    }

    public void h(String str) {
        this.f82172b = str;
    }

    public int hashCode() {
        String d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        String c11 = c();
        int hashCode2 = ((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
        String e11 = e();
        int i12 = hashCode2 * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return ((i12 + i11) * 59) + (f() ? 79 : 97);
    }

    public void i(boolean z11) {
        this.f82175e = z11;
    }

    public String toString() {
        return "PrimeLuckyListOrderItem(id=" + d() + ", amount=" + c() + ", symbol=" + e() + ", lucky=" + f() + ")";
    }
}
