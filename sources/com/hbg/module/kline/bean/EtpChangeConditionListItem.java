package com.hbg.module.kline.bean;

import com.hbg.module.kline.handler.EtpChangeConditionListItemHandler;

public class EtpChangeConditionListItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public String f23504b;

    /* renamed from: c  reason: collision with root package name */
    public String f23505c;

    /* renamed from: d  reason: collision with root package name */
    public a f23506d;

    public interface a {
        String a();
    }

    public boolean a(Object obj) {
        return obj instanceof EtpChangeConditionListItem;
    }

    public a c() {
        return this.f23506d;
    }

    public String d() {
        return this.f23504b;
    }

    public String e() {
        return this.f23505c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EtpChangeConditionListItem)) {
            return false;
        }
        EtpChangeConditionListItem etpChangeConditionListItem = (EtpChangeConditionListItem) obj;
        if (!etpChangeConditionListItem.a(this)) {
            return false;
        }
        String d11 = d();
        String d12 = etpChangeConditionListItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = etpChangeConditionListItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = etpChangeConditionListItem.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(a aVar) {
        this.f23506d = aVar;
    }

    public void g(String str) {
        this.f23504b = str;
    }

    public String getViewHandlerName() {
        return EtpChangeConditionListItemHandler.class.getName();
    }

    public void h(String str) {
        this.f23505c = str;
    }

    public int hashCode() {
        String d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        String e11 = e();
        int hashCode2 = ((hashCode + 59) * 59) + (e11 == null ? 43 : e11.hashCode());
        a c11 = c();
        int i12 = hashCode2 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "EtpChangeConditionListItem(title1=" + d() + ", title2=" + e() + ", callback=" + c() + ")";
    }
}
