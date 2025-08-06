package com.huobi.trade.helper;

public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f82011b;

    /* renamed from: a  reason: collision with root package name */
    public String f82012a = "1";

    public static b a() {
        if (f82011b == null) {
            f82011b = new b();
        }
        return f82011b;
    }

    public boolean b() {
        return "1".equals(this.f82012a);
    }

    public void c(String str) {
        this.f82012a = str;
    }
}
