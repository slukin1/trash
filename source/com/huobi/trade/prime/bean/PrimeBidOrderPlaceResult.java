package com.huobi.trade.prime.bean;

import java.io.Serializable;
import java.util.List;

public class PrimeBidOrderPlaceResult implements Serializable {
    private static final long serialVersionUID = 762983294180283921L;
    private List<String> bidIds;

    /* renamed from: id  reason: collision with root package name */
    private String f82171id;

    public boolean canEqual(Object obj) {
        return obj instanceof PrimeBidOrderPlaceResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrimeBidOrderPlaceResult)) {
            return false;
        }
        PrimeBidOrderPlaceResult primeBidOrderPlaceResult = (PrimeBidOrderPlaceResult) obj;
        if (!primeBidOrderPlaceResult.canEqual(this)) {
            return false;
        }
        String id2 = getId();
        String id3 = primeBidOrderPlaceResult.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        List<String> bidIds2 = getBidIds();
        List<String> bidIds3 = primeBidOrderPlaceResult.getBidIds();
        return bidIds2 != null ? bidIds2.equals(bidIds3) : bidIds3 == null;
    }

    public List<String> getBidIds() {
        return this.bidIds;
    }

    public String getId() {
        return this.f82171id;
    }

    public int hashCode() {
        String id2 = getId();
        int i11 = 43;
        int hashCode = id2 == null ? 43 : id2.hashCode();
        List<String> bidIds2 = getBidIds();
        int i12 = (hashCode + 59) * 59;
        if (bidIds2 != null) {
            i11 = bidIds2.hashCode();
        }
        return i12 + i11;
    }

    public void setBidIds(List<String> list) {
        this.bidIds = list;
    }

    public void setId(String str) {
        this.f82171id = str;
    }

    public String toString() {
        return "PrimeBidOrderPlaceResult(id=" + getId() + ", bidIds=" + getBidIds() + ")";
    }
}
