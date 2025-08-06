package com.alibaba.sdk.android.httpdns.b;

import com.alibaba.sdk.android.httpdns.RequestIpType;
import java.util.Arrays;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f14539a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f14540b;

    /* renamed from: c  reason: collision with root package name */
    public String f14541c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f14542d;

    /* renamed from: e  reason: collision with root package name */
    public int f14543e;

    /* renamed from: f  reason: collision with root package name */
    public int f14544f;

    /* renamed from: g  reason: collision with root package name */
    public long f14545g;

    /* renamed from: h  reason: collision with root package name */
    public String f14546h;

    /* renamed from: i  reason: collision with root package name */
    public String f14547i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f14548j = false;

    public static a c(String str, String str2, RequestIpType requestIpType, String str3, String str4, String[] strArr, int i11) {
        a aVar = new a();
        aVar.f14540b = str;
        aVar.f14541c = str2;
        aVar.f14543e = requestIpType.ordinal();
        aVar.f14542d = strArr;
        aVar.f14544f = i11;
        aVar.f14545g = System.currentTimeMillis();
        aVar.f14546h = str3;
        aVar.f14547i = str4;
        return aVar;
    }

    public int a() {
        return this.f14544f;
    }

    public long b() {
        return this.f14545g;
    }

    public String d() {
        return this.f14547i;
    }

    public void e(int i11) {
        this.f14544f = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f14539a == aVar.f14539a && this.f14543e == aVar.f14543e && this.f14544f == aVar.f14544f && this.f14545g == aVar.f14545g && this.f14540b.equals(aVar.f14540b) && this.f14541c.equals(aVar.f14541c) && Arrays.equals(this.f14542d, aVar.f14542d) && w2.a.m(this.f14546h, aVar.f14546h) && w2.a.m(this.f14547i, aVar.f14547i);
    }

    public void f(long j11) {
        this.f14545g = j11;
    }

    public void g(String str) {
        this.f14546h = str;
    }

    public void h(boolean z11) {
        this.f14548j = z11;
    }

    public int hashCode() {
        return (Arrays.hashCode(new Object[]{Long.valueOf(this.f14539a), this.f14540b, this.f14541c, Integer.valueOf(this.f14543e), Integer.valueOf(this.f14544f), Long.valueOf(this.f14545g), this.f14546h, this.f14547i}) * 31) + Arrays.hashCode(this.f14542d);
    }

    public void i(String[] strArr) {
        this.f14542d = strArr;
    }

    public void j(long j11) {
        this.f14539a = j11;
    }

    public void k(String str) {
        this.f14547i = str;
    }

    public String l() {
        return this.f14546h;
    }

    public String m() {
        return this.f14541c;
    }

    public long n() {
        return this.f14539a;
    }

    public String[] o() {
        return this.f14542d;
    }

    public String p() {
        return this.f14540b;
    }

    public int q() {
        return this.f14543e;
    }

    public boolean r() {
        return System.currentTimeMillis() > this.f14545g + ((long) (this.f14544f * 1000));
    }

    public boolean s() {
        return this.f14548j;
    }

    public void t(String str) {
        this.f14541c = str;
    }

    public String toString() {
        return "HostRecord{id=" + this.f14539a + ", region='" + this.f14540b + '\'' + ", host='" + this.f14541c + '\'' + ", ips=" + Arrays.toString(this.f14542d) + ", type=" + this.f14543e + ", ttl=" + this.f14544f + ", queryTime=" + this.f14545g + ", extra='" + this.f14546h + '\'' + ", cacheKey='" + this.f14547i + '\'' + ", fromDB=" + this.f14548j + '}';
    }

    public void u(String str) {
        this.f14540b = str;
    }

    public void v(int i11) {
        this.f14543e = i11;
    }
}
