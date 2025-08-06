package com.huobi.swap.bean;

import com.hbg.lib.network.swap.core.bean.SwapTriggerOrderInfo;
import com.huobi.swap.handler.SwapCurrentTriggerOrderHandler;

public class SwapCurrentTriggerOrderItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public transient String f81507b;

    /* renamed from: c  reason: collision with root package name */
    public a f81508c;

    /* renamed from: d  reason: collision with root package name */
    public SwapTriggerOrderInfo f81509d;

    public interface a {
        void a(SwapTriggerOrderInfo swapTriggerOrderInfo);
    }

    public boolean a(Object obj) {
        return obj instanceof SwapCurrentTriggerOrderItem;
    }

    public a c() {
        return this.f81508c;
    }

    public String d() {
        return this.f81507b;
    }

    public SwapTriggerOrderInfo e() {
        return this.f81509d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapCurrentTriggerOrderItem)) {
            return false;
        }
        SwapCurrentTriggerOrderItem swapCurrentTriggerOrderItem = (SwapCurrentTriggerOrderItem) obj;
        if (!swapCurrentTriggerOrderItem.a(this)) {
            return false;
        }
        a c11 = c();
        a c12 = swapCurrentTriggerOrderItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        SwapTriggerOrderInfo e11 = e();
        SwapTriggerOrderInfo e12 = swapCurrentTriggerOrderItem.e();
        return e11 != null ? e11.equals(e12) : e12 == null;
    }

    public void f(a aVar) {
        this.f81508c = aVar;
    }

    public void g(String str) {
        this.f81507b = str;
    }

    public String getViewHandlerName() {
        return SwapCurrentTriggerOrderHandler.class.getName();
    }

    public void h(SwapTriggerOrderInfo swapTriggerOrderInfo) {
        this.f81509d = swapTriggerOrderInfo;
    }

    public int hashCode() {
        a c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        SwapTriggerOrderInfo e11 = e();
        int i12 = (hashCode + 59) * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "SwapCurrentTriggerOrderItem(contractFace=" + d() + ", callback=" + c() + ", info=" + e() + ")";
    }
}
