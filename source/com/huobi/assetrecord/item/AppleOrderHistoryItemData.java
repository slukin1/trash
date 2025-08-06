package com.huobi.assetrecord.item;

import s9.a;

public class AppleOrderHistoryItemData implements a {

    /* renamed from: b  reason: collision with root package name */
    public Long f42816b;

    /* renamed from: c  reason: collision with root package name */
    public Long f42817c;

    /* renamed from: d  reason: collision with root package name */
    public Long f42818d;

    /* renamed from: e  reason: collision with root package name */
    public String f42819e;

    /* renamed from: f  reason: collision with root package name */
    public int f42820f;

    public String a() {
        return this.f42819e;
    }

    public Long c() {
        return this.f42816b;
    }

    public Long d() {
        return this.f42817c;
    }

    public Long e() {
        return this.f42818d;
    }

    public int f() {
        return this.f42820f;
    }

    public void g(String str) {
        this.f42819e = str;
    }

    public String getViewHandlerName() {
        return AppleOrderHistoryItemDataHandler.class.getName();
    }

    public void h(Long l11) {
        this.f42816b = l11;
    }

    public void i(Long l11) {
        this.f42817c = l11;
    }

    public void j(Long l11) {
        this.f42818d = l11;
    }

    public void k(int i11) {
        this.f42820f = i11;
    }
}
