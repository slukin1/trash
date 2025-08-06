package com.huobi.swap.bean;

public class SwapFundingRateBean {

    /* renamed from: a  reason: collision with root package name */
    public String f81510a;

    /* renamed from: b  reason: collision with root package name */
    public long f81511b;

    public boolean a(Object obj) {
        return obj instanceof SwapFundingRateBean;
    }

    public String b() {
        return this.f81510a;
    }

    public long c() {
        return this.f81511b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapFundingRateBean)) {
            return false;
        }
        SwapFundingRateBean swapFundingRateBean = (SwapFundingRateBean) obj;
        if (!swapFundingRateBean.a(this)) {
            return false;
        }
        String b11 = b();
        String b12 = swapFundingRateBean.b();
        if (b11 != null ? b11.equals(b12) : b12 == null) {
            return c() == swapFundingRateBean.c();
        }
        return false;
    }

    public int hashCode() {
        String b11 = b();
        int hashCode = b11 == null ? 43 : b11.hashCode();
        long c11 = c();
        return ((hashCode + 59) * 59) + ((int) ((c11 >>> 32) ^ c11));
    }

    public String toString() {
        return "SwapFundingRateBean(fundingRate=" + b() + ", fundingTime=" + c() + ")";
    }
}
