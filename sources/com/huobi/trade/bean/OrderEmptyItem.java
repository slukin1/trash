package com.huobi.trade.bean;

import com.huobi.trade.handler.OrderEmptyViewHandler;
import s9.a;

public class OrderEmptyItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f81957b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f81958c;

    public OrderEmptyItem(String str) {
        this.f81958c = false;
        this.f81957b = str;
    }

    public boolean a() {
        return this.f81958c;
    }

    public String getViewHandlerName() {
        return OrderEmptyViewHandler.class.getName();
    }

    public OrderEmptyItem() {
        this.f81958c = false;
        this.f81958c = true;
    }
}
