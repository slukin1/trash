package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;

public class ContractOrderResult {
    @SerializedName("order_id")

    /* renamed from: a  reason: collision with root package name */
    public String f43095a;

    public boolean a(Object obj) {
        return obj instanceof ContractOrderResult;
    }

    public String b() {
        return this.f43095a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractOrderResult)) {
            return false;
        }
        ContractOrderResult contractOrderResult = (ContractOrderResult) obj;
        if (!contractOrderResult.a(this)) {
            return false;
        }
        String b11 = b();
        String b12 = contractOrderResult.b();
        return b11 != null ? b11.equals(b12) : b12 == null;
    }

    public int hashCode() {
        String b11 = b();
        return 59 + (b11 == null ? 43 : b11.hashCode());
    }

    public String toString() {
        return "ContractOrderResult(orderId=" + b() + ")";
    }
}
