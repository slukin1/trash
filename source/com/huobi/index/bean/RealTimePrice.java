package com.huobi.index.bean;

import com.google.gson.annotations.Expose;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.homemarket.handler.IndexViewHandler;
import java.util.List;
import s9.a;

public class RealTimePrice implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f73219b;

    /* renamed from: c  reason: collision with root package name */
    public String f73220c;

    /* renamed from: d  reason: collision with root package name */
    public String f73221d;

    /* renamed from: e  reason: collision with root package name */
    public double f73222e;

    /* renamed from: f  reason: collision with root package name */
    public double f73223f;

    /* renamed from: g  reason: collision with root package name */
    public double f73224g;

    /* renamed from: h  reason: collision with root package name */
    public double f73225h;

    /* renamed from: i  reason: collision with root package name */
    public String f73226i;

    /* renamed from: j  reason: collision with root package name */
    public String f73227j;

    /* renamed from: k  reason: collision with root package name */
    public String f73228k;

    /* renamed from: l  reason: collision with root package name */
    public String f73229l;

    /* renamed from: m  reason: collision with root package name */
    public String f73230m;
    @Expose(serialize = false)

    /* renamed from: n  reason: collision with root package name */
    public SymbolBean f73231n;

    /* renamed from: o  reason: collision with root package name */
    public String f73232o;

    /* renamed from: p  reason: collision with root package name */
    public List<String> f73233p;

    /* renamed from: q  reason: collision with root package name */
    public int f73234q;

    /* renamed from: r  reason: collision with root package name */
    public String f73235r;

    /* renamed from: s  reason: collision with root package name */
    public String f73236s;

    /* renamed from: t  reason: collision with root package name */
    public int f73237t;

    public void A(String str) {
        this.f73226i = str;
    }

    public void B(double d11) {
        this.f73223f = d11;
    }

    public void C(String str) {
        this.f73229l = str;
    }

    public void D(double d11) {
        this.f73224g = d11;
    }

    public void E(SymbolBean symbolBean) {
        this.f73231n = symbolBean;
    }

    public void F(String str) {
        this.f73221d = str;
    }

    public void G(int i11) {
        this.f73237t = i11;
    }

    public void H(String str) {
        this.f73232o = str;
    }

    public void I(List<String> list) {
        this.f73233p = list;
    }

    public void J(double d11) {
        this.f73225h = d11;
    }

    public String a() {
        return this.f73228k;
    }

    public String c() {
        return this.f73220c;
    }

    public int d() {
        return this.f73234q;
    }

    public String e() {
        return this.f73235r;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.f73221d;
        String str2 = ((RealTimePrice) obj).f73221d;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public String f() {
        return this.f73236s;
    }

    public double g() {
        return this.f73222e;
    }

    public String getViewHandlerName() {
        return IndexViewHandler.class.getName();
    }

    public String h() {
        return this.f73227j;
    }

    public int hashCode() {
        String str = this.f73221d;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String i() {
        return this.f73226i;
    }

    public double j() {
        return this.f73223f;
    }

    public String k() {
        return this.f73229l;
    }

    public double l() {
        return this.f73224g;
    }

    public int m() {
        return this.f73219b;
    }

    public SymbolBean n() {
        return this.f73231n;
    }

    public String o() {
        return this.f73221d;
    }

    public int p() {
        return this.f73237t;
    }

    public String q() {
        return this.f73232o;
    }

    public List<String> r() {
        return this.f73233p;
    }

    public double s() {
        return this.f73225h;
    }

    public void t(String str) {
        this.f73228k = str;
    }

    public void u(String str) {
        this.f73230m = str;
    }

    public void v(int i11) {
        this.f73234q = i11;
    }

    public void w(String str) {
        this.f73235r = str;
    }

    public void x(String str) {
        this.f73236s = str;
    }

    public void y(double d11) {
        this.f73222e = d11;
    }

    public void z(String str) {
        this.f73227j = str;
    }
}
