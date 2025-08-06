package com.hbg.module.kline.bean;

public class MarketDepthPercentItem {

    /* renamed from: a  reason: collision with root package name */
    public double f23520a;

    /* renamed from: b  reason: collision with root package name */
    public double f23521b;

    /* renamed from: c  reason: collision with root package name */
    public String f23522c;

    public double a() {
        return this.f23521b;
    }

    public double b() {
        return this.f23520a;
    }

    public void c(double d11) {
        this.f23521b = d11;
    }

    public void d(double d11) {
        this.f23520a = d11;
    }

    public void e(String str) {
        this.f23522c = str;
    }

    public String toString() {
        return "MarketDepthPercentItem{price=" + this.f23520a + ", amount=" + this.f23521b + ", symbol='" + this.f23522c + '\'' + '}';
    }
}
