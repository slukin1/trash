package com.huobi.swap.bean;

import com.hbg.lib.network.swap.core.bean.SwapTrackOrderInfo;
import com.huobi.swap.handler.SwapCurrentTrackOrderHandler;

public class SwapCurrentTrackOrderItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public transient String f81504b;

    /* renamed from: c  reason: collision with root package name */
    public a f81505c;

    /* renamed from: d  reason: collision with root package name */
    public SwapTrackOrderInfo f81506d;

    public interface a {
        void a(SwapCurrentTrackOrderItem swapCurrentTrackOrderItem);
    }

    public boolean a(Object obj) {
        return obj instanceof SwapCurrentTrackOrderItem;
    }

    public a c() {
        return this.f81505c;
    }

    public String d() {
        return this.f81504b;
    }

    public SwapTrackOrderInfo e() {
        return this.f81506d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapCurrentTrackOrderItem)) {
            return false;
        }
        SwapCurrentTrackOrderItem swapCurrentTrackOrderItem = (SwapCurrentTrackOrderItem) obj;
        if (!swapCurrentTrackOrderItem.a(this)) {
            return false;
        }
        a c11 = c();
        a c12 = swapCurrentTrackOrderItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        SwapTrackOrderInfo e11 = e();
        SwapTrackOrderInfo e12 = swapCurrentTrackOrderItem.e();
        return e11 != null ? e11.equals(e12) : e12 == null;
    }

    public boolean f() {
        return "buy".equals(this.f81506d.getDirection());
    }

    public boolean g() {
        return "settlement".equals(this.f81506d.getOrderSource());
    }

    public String getViewHandlerName() {
        return SwapCurrentTrackOrderHandler.class.getName();
    }

    public boolean h() {
        return "risk".equals(this.f81506d.getOrderSource());
    }

    public int hashCode() {
        a c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        SwapTrackOrderInfo e11 = e();
        int i12 = (hashCode + 59) * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return i12 + i11;
    }

    public boolean i() {
        return "open".equals(this.f81506d.getOffset());
    }

    public void j(a aVar) {
        this.f81505c = aVar;
    }

    public void k(String str) {
        this.f81504b = str;
    }

    public void l(SwapTrackOrderInfo swapTrackOrderInfo) {
        this.f81506d = swapTrackOrderInfo;
    }

    public String toString() {
        return "SwapCurrentTrackOrderItem(contractFace=" + d() + ", callback=" + c() + ", info=" + e() + ")";
    }
}
