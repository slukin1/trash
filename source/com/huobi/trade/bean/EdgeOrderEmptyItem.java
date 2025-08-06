package com.huobi.trade.bean;

import com.huobi.trade.handler.EdgeOrderEmptyViewHandler;
import s9.a;

public class EdgeOrderEmptyItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f81925b;

    /* renamed from: c  reason: collision with root package name */
    public int f81926c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f81927d;

    public EdgeOrderEmptyItem(String str, int i11) {
        this.f81927d = false;
        this.f81925b = str;
        this.f81926c = i11;
        this.f81927d = true;
    }

    public String getViewHandlerName() {
        return EdgeOrderEmptyViewHandler.class.getName();
    }

    public EdgeOrderEmptyItem() {
        this.f81927d = false;
        this.f81927d = true;
    }
}
