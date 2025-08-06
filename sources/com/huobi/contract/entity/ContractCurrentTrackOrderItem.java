package com.huobi.contract.entity;

import com.huobi.contract.viewhandler.ContractCurrentTrackOrderHandler;

public class ContractCurrentTrackOrderItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public transient String f43061b;

    /* renamed from: c  reason: collision with root package name */
    public a f43062c;

    /* renamed from: d  reason: collision with root package name */
    public ContractTrackOrderInfo f43063d;

    public interface a {
        void a(ContractCurrentTrackOrderItem contractCurrentTrackOrderItem);
    }

    public boolean a(Object obj) {
        return obj instanceof ContractCurrentTrackOrderItem;
    }

    public a c() {
        return this.f43062c;
    }

    public String d() {
        return this.f43061b;
    }

    public ContractTrackOrderInfo e() {
        return this.f43063d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractCurrentTrackOrderItem)) {
            return false;
        }
        ContractCurrentTrackOrderItem contractCurrentTrackOrderItem = (ContractCurrentTrackOrderItem) obj;
        if (!contractCurrentTrackOrderItem.a(this)) {
            return false;
        }
        a c11 = c();
        a c12 = contractCurrentTrackOrderItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        ContractTrackOrderInfo e11 = e();
        ContractTrackOrderInfo e12 = contractCurrentTrackOrderItem.e();
        return e11 != null ? e11.equals(e12) : e12 == null;
    }

    public boolean f() {
        return "buy".equals(this.f43063d.getDirection());
    }

    public boolean g() {
        return "settlement".equals(this.f43063d.getOrderSource());
    }

    public String getViewHandlerName() {
        return ContractCurrentTrackOrderHandler.class.getName();
    }

    public boolean h() {
        return "risk".equals(this.f43063d.getOrderSource());
    }

    public int hashCode() {
        a c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        ContractTrackOrderInfo e11 = e();
        int i12 = (hashCode + 59) * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return i12 + i11;
    }

    public boolean i() {
        return "open".equals(this.f43063d.getOffset());
    }

    public void j(a aVar) {
        this.f43062c = aVar;
    }

    public void k(String str) {
        this.f43061b = str;
    }

    public void l(ContractTrackOrderInfo contractTrackOrderInfo) {
        this.f43063d = contractTrackOrderInfo;
    }

    public String toString() {
        return "ContractCurrentTrackOrderItem(contractFace=" + d() + ", callback=" + c() + ", info=" + e() + ")";
    }
}
