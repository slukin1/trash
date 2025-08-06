package com.huobi.swap.bean;

import com.hbg.lib.network.swap.core.bean.SwapCurrentOrderInfo;
import com.huobi.swap.handler.SwapCurrentOrderHandler;
import s9.a;

public class SwapCurrentOrderItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public SwapCurrentOrderInfo f81502b;

    /* renamed from: c  reason: collision with root package name */
    public SwapCurrentOrderHandler.a f81503c;

    public boolean a(Object obj) {
        return obj instanceof SwapCurrentOrderItem;
    }

    public SwapCurrentOrderHandler.a c() {
        return this.f81503c;
    }

    public SwapCurrentOrderInfo d() {
        return this.f81502b;
    }

    public void e(SwapCurrentOrderHandler.a aVar) {
        this.f81503c = aVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapCurrentOrderItem)) {
            return false;
        }
        SwapCurrentOrderItem swapCurrentOrderItem = (SwapCurrentOrderItem) obj;
        if (!swapCurrentOrderItem.a(this)) {
            return false;
        }
        SwapCurrentOrderInfo d11 = d();
        SwapCurrentOrderInfo d12 = swapCurrentOrderItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        SwapCurrentOrderHandler.a c11 = c();
        SwapCurrentOrderHandler.a c12 = swapCurrentOrderItem.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(SwapCurrentOrderInfo swapCurrentOrderInfo) {
        this.f81502b = swapCurrentOrderInfo;
    }

    public String getViewHandlerName() {
        return SwapCurrentOrderHandler.class.getName();
    }

    public int hashCode() {
        SwapCurrentOrderInfo d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        SwapCurrentOrderHandler.a c11 = c();
        int i12 = (hashCode + 59) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "SwapCurrentOrderItem(info=" + d() + ", callback=" + c() + ")";
    }
}
