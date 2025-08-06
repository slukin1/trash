package com.huobi.trade.bean;

import com.huobi.trade.handler.DepthViewHandler;
import i6.m;

public class DepthItem implements Comparable<DepthItem>, s9.a {

    /* renamed from: b  reason: collision with root package name */
    public String f81920b;

    /* renamed from: c  reason: collision with root package name */
    public String f81921c;

    /* renamed from: d  reason: collision with root package name */
    public String f81922d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f81923e;

    /* renamed from: f  reason: collision with root package name */
    public a f81924f;

    public interface a {
        void a(String str, String str2, int i11);
    }

    public DepthItem(String str, String str2, String str3) {
        this.f81920b = str;
        this.f81921c = str2;
        this.f81922d = str3;
    }

    /* renamed from: a */
    public int compareTo(DepthItem depthItem) {
        float i02 = m.i0(this.f81921c) - m.i0(depthItem.f81921c);
        if (i02 > 0.0f) {
            return 1;
        }
        return i02 < 0.0f ? -1 : 0;
    }

    public a c() {
        return this.f81924f;
    }

    public String e() {
        return this.f81921c;
    }

    public String f() {
        return this.f81922d;
    }

    public String g() {
        return this.f81920b;
    }

    public String getViewHandlerName() {
        return DepthViewHandler.class.getName();
    }

    public boolean h() {
        return this.f81923e;
    }

    public DepthItem() {
    }
}
