package com.huobi.margin.entity;

import com.google.gson.annotations.SerializedName;

public class OrderConfirmResponse {
    @SerializedName("interest-rate")

    /* renamed from: a  reason: collision with root package name */
    public double f77939a;
    @SerializedName("risk-level")

    /* renamed from: b  reason: collision with root package name */
    public String f77940b;
    @SerializedName("risk-rate")

    /* renamed from: c  reason: collision with root package name */
    public String f77941c;

    public boolean a(Object obj) {
        return obj instanceof OrderConfirmResponse;
    }

    public double b() {
        return this.f77939a;
    }

    public String c() {
        return this.f77940b;
    }

    public String d() {
        return this.f77941c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderConfirmResponse)) {
            return false;
        }
        OrderConfirmResponse orderConfirmResponse = (OrderConfirmResponse) obj;
        if (!orderConfirmResponse.a(this) || Double.compare(b(), orderConfirmResponse.b()) != 0) {
            return false;
        }
        String c11 = c();
        String c12 = orderConfirmResponse.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = orderConfirmResponse.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(b());
        String c11 = c();
        int i11 = 43;
        int hashCode = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
        String d11 = d();
        int i12 = hashCode * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "OrderConfirmResponse(interestRate=" + b() + ", riskLevel=" + c() + ", riskRate=" + d() + ")";
    }
}
