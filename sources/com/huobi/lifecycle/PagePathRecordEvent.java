package com.huobi.lifecycle;

public class PagePathRecordEvent {

    /* renamed from: a  reason: collision with root package name */
    public String f74938a;

    /* renamed from: b  reason: collision with root package name */
    public String f74939b;

    /* renamed from: c  reason: collision with root package name */
    public String f74940c;

    /* renamed from: d  reason: collision with root package name */
    public int f74941d;

    /* renamed from: e  reason: collision with root package name */
    public long f74942e;

    public void a(long j11) {
        this.f74942e = j11;
    }

    public void b(String str) {
        this.f74940c = str;
    }

    public void c(String str) {
        this.f74938a = str;
    }

    public void d(int i11) {
        this.f74941d = i11;
    }

    public void e(String str) {
        this.f74939b = str;
    }

    public String toString() {
        return " c=" + this.f74938a + ",t=" + this.f74939b + ",m=" + this.f74940c + ",s=" + this.f74941d + ",bg=" + this.f74942e;
    }
}
