package com.huobi.finance.bean;

import com.hbg.lib.data.symbol.PrecisionUtil;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import java.math.BigDecimal;

public class LoanInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f45367a;

    /* renamed from: b  reason: collision with root package name */
    public String f45368b;

    /* renamed from: c  reason: collision with root package name */
    public String f45369c;

    /* renamed from: d  reason: collision with root package name */
    public String f45370d;

    /* renamed from: e  reason: collision with root package name */
    public String f45371e;

    /* renamed from: f  reason: collision with root package name */
    public String f45372f;

    /* renamed from: g  reason: collision with root package name */
    public String f45373g = "1";

    public String a() {
        return m.O(m.a(this.f45369c).multiply(m.a(this.f45373g)), PrecisionUtil.l(), 4);
    }

    public String b() {
        if (new BigDecimal(this.f45368b).compareTo(new BigDecimal(this.f45370d)) > 0) {
            return f();
        }
        return c();
    }

    public String c() {
        return m.m(this.f45368b, 3);
    }

    public String d() {
        return this.f45372f;
    }

    public String e() {
        return m.m(this.f45367a, 8).replaceFirst(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public String f() {
        return m.m(this.f45370d, 8);
    }

    public String g() {
        return m.m(this.f45371e, 3);
    }

    public void h(String str) {
        this.f45368b = str;
    }

    public void i(String str) {
        this.f45372f = str;
    }

    public void j(String str) {
        this.f45373g = str;
    }

    public void k(String str) {
        this.f45367a = str;
    }

    public void l(String str) {
        this.f45370d = str;
    }

    public void m(String str) {
        this.f45371e = str;
    }

    public void n(String str) {
        this.f45369c = str;
    }

    public String toString() {
        return "LoanInfo{loaned='" + this.f45367a + '\'' + ", availableLoaned='" + this.f45368b + '\'' + ", rate='" + this.f45369c + '\'' + ", maxLoan='" + this.f45370d + '\'' + ", minxLoan='" + this.f45371e + '\'' + ", currency='" + this.f45372f + '\'' + '}';
    }
}
