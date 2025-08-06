package com.hbg.lib.network.hbg.socket.response;

import java.util.List;

public class C2CMarketDepthResponse extends BaseHbgResponse<List<List<String>>> {
    private String currency;
    private int term;

    public boolean canEqual(Object obj) {
        return obj instanceof C2CMarketDepthResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2CMarketDepthResponse)) {
            return false;
        }
        C2CMarketDepthResponse c2CMarketDepthResponse = (C2CMarketDepthResponse) obj;
        if (!c2CMarketDepthResponse.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = c2CMarketDepthResponse.getCurrency();
        if (currency2 != null ? currency2.equals(currency3) : currency3 == null) {
            return getTerm() == c2CMarketDepthResponse.getTerm();
        }
        return false;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getTerm() {
        return this.term;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String currency2 = getCurrency();
        return (((hashCode * 59) + (currency2 == null ? 43 : currency2.hashCode())) * 59) + getTerm();
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setTerm(int i11) {
        this.term = i11;
    }

    public String toString() {
        return "C2CMarketDepthResponse(currency=" + getCurrency() + ", term=" + getTerm() + ")";
    }
}
