package com.huobi.contract.entity;

import com.huobi.contract.viewhandler.ContractCurrentOrderHandler;
import s9.a;

public class ContractCurrentOrderItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public ContractCurrentOrderInfo f43058b;

    /* renamed from: c  reason: collision with root package name */
    public transient ContractCurrentOrderHandler.a f43059c;

    public ContractCurrentOrderItem() {
    }

    public boolean a(Object obj) {
        return obj instanceof ContractCurrentOrderItem;
    }

    public ContractCurrentOrderHandler.a c() {
        return this.f43059c;
    }

    public ContractCurrentOrderInfo d() {
        return this.f43058b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractCurrentOrderItem)) {
            return false;
        }
        ContractCurrentOrderItem contractCurrentOrderItem = (ContractCurrentOrderItem) obj;
        if (!contractCurrentOrderItem.a(this)) {
            return false;
        }
        ContractCurrentOrderInfo d11 = d();
        ContractCurrentOrderInfo d12 = contractCurrentOrderItem.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public String getViewHandlerName() {
        return ContractCurrentOrderHandler.class.getName();
    }

    public int hashCode() {
        ContractCurrentOrderInfo d11 = d();
        return 59 + (d11 == null ? 43 : d11.hashCode());
    }

    public String toString() {
        return "ContractCurrentOrderItem(info=" + d() + ", callback=" + c() + ")";
    }

    public ContractCurrentOrderItem(ContractCurrentOrderInfo contractCurrentOrderInfo, ContractCurrentOrderHandler.a aVar) {
        this.f43058b = contractCurrentOrderInfo;
        this.f43059c = aVar;
    }
}
